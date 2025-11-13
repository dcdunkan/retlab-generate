import CodeBlockWriter from "code-block-writer";
import fs from "node:fs/promises";
import path from "node:path";
import Parser from "tree-sitter";
import JavaGrammar from "tree-sitter-java";
import { FIELD_ACCESS_TABLE_CONSTANTS, IDENTIFIER_REGEX, MODELS_DIR } from "./constants.js";
import { getImports, nodePosition, resolvedTypeToString, resolveTypeIdentifier } from "./helpers.js";

const modelFiles: ModelFile[] = [];

for (
    const entry of await fs.readdir(
        MODELS_DIR.join(path.sep),
        { withFileTypes: true, recursive: true },
    )
) {
    if (!entry.isFile()) continue;

    const extension = path.extname(entry.name);
    if (extension !== ".java") {
        console.log("non-java file detected in models");
        continue;
    }

    const scope = entry.parentPath.split(path.sep)
        .slice(MODELS_DIR.length)
        .map((part) => part.split("."))
        .flat();

    modelFiles.push({
        name: entry.name.slice(0, -extension.length),
        filename: entry.name,
        path: path.join(entry.parentPath, entry.name),
        parentClasses: scope,
        scope: scope.join("."),
    });
}

const parser = new Parser();
parser.setLanguage(JavaGrammar as Parser.Language);

const structure: Namespace["children"] = [];

for (const modelFile of modelFiles) {
    console.log("reading", modelFile.path);
    const content = await fs.readFile(modelFile.path, "utf-8");
    const tree = parser.parse(content);

    const classDecls = tree.rootNode.descendantsOfType("class_declaration");
    if (classDecls.length < 1)
        throw new Error("expected at least one class per model file");

    const classDecl = classDecls[0]!;
    const classIdentifier = classDecl.childForFieldName("name");
    if (classIdentifier == null)
        throw new Error("Expected class identifier");
    const className = classIdentifier.text.trim();
    if (className !== modelFile.name)
        throw new Error("mistmatch in expected and actual class identifer");

    const classBody = classDecl.childForFieldName("body")!;

    // find all fields
    const fields: Record<string, Field> = {};

    for (const fieldDecl of classBody.descendantsOfType("field_declaration")) {
        const modifiersNode = fieldDecl.descendantsOfType("modifiers");
        if (modifiersNode.length != 1 || modifiersNode[0] == null)
            throw new Error("what");
        const modifiers = modifiersNode[0];
        const modifierTypes = modifiers.children.map((modifier) => modifier.type);
        if (modifierTypes.includes("static")) // static fields wouldn't be belonging to the actual model
            continue;

        const declarator = fieldDecl.childForFieldName("declarator");
        if (declarator == null)
            throw new Error("field without declarator");
        const identifier = declarator.childForFieldName("name");
        if (identifier == null || typeof identifier.text !== "string" || identifier.text.trim().length === 0)
            throw new Error("declarator without identifier??");

        const fieldName = identifier.text.trim();
        if (fieldName in fields) {
            throw new Error("duplicate field name???");
        }

        let serialisedName: string | null = null;

        if (modifierTypes.includes("annotation")) {
            for (const annotation of modifiers.descendantsOfType("annotation")) {
                const name = annotation.childForFieldName("name");
                if (name == null) throw new Error("annotation without a name? doi");

                if (name.text === "SerializedName") {
                    const argumentsNode = annotation.childForFieldName("arguments");

                    if (argumentsNode == null || argumentsNode.childCount !== 3) // 3 because two parantheses and and the actual value
                        throw new Error("SerializedName annotation expects one argument");
                    const argument = argumentsNode.child(1);
                    if (argument == null)
                        throw new Error("SerializedName annotation expects one argument");

                    if (argument.type === "string_literal") {
                        const fragments = argument.descendantsOfType("string_fragment");

                        if (fragments.length !== 1 || fragments[0] == null)
                            throw new Error("expected one and only one string_fragment, need to modify this stuff");
                        if (fragments[0].text.trim().length === 0)
                            throw new Error("invalid format for a field name stirng");

                        serialisedName = fragments[0].text.trim();
                    } else if (argument.type === "field_access") {
                        if (
                            argument.text in FIELD_ACCESS_TABLE_CONSTANTS
                            && typeof FIELD_ACCESS_TABLE_CONSTANTS[argument.text] === "string"
                        ) {
                            serialisedName = FIELD_ACCESS_TABLE_CONSTANTS[argument.text]!;
                        } else {
                            console.log(nodePosition(argument, modelFile.path));
                            throw new Error("unknown field access constant, add it to the table");
                        }
                    }
                }
            }
        }

        const typeIdentifierNode = fieldDecl.childForFieldName("type");
        if (typeIdentifierNode == null)
            throw new Error("field identifier without a type is imposissble");

        fields[fieldName] = {
            name: fieldName,
            serialisedName: serialisedName,
            type: resolveTypeIdentifier(typeIdentifierNode, {
                currentPath: modelFile.path,
                sameScopeTypeDeclarations: modelFiles
                    .filter((file) => file.scope === modelFile.scope)
                    .map((model) => model.name),
                imports: getImports(tree),
            }),
            required: false, // to be filled in later
        };
    }

    // let's find optionals
    const classConstructors = classBody.descendantsOfType("constructor_declaration");
    if (classConstructors.length === 0) {
        continue;
    }

    const filteredClassConstructors = classConstructors.filter((constructor) => {
        const identifier = constructor.childForFieldName("name");
        if (identifier == null)
            throw new Error("constructors should have identifiers right?");
        return identifier.text.trim() === className;
    }).filter((constructor) => {
        // is it a self-referential constructor? (calls "this()")
        if (constructor.descendantsOfType("explicit_constructor_invocation").length != 0) {
            return false;
        }

        const formalParameters = constructor.childForFieldName("parameters");
        if (formalParameters == null)
            throw new Error("constructors will have a parameter section for sure");

        const parameters = formalParameters.descendantsOfType("formal_parameter");
        if (parameters.length === 1) {
            const parameter = parameters[0]!;
            const parameterType = parameter.childForFieldName("type");
            if (parameterType == null)
                throw new Error("parameter with no type? what?");
            if (parameterType.text.includes("Parcel")) { // special case since Parcel comes up very often
                return false;
            }
        }
        return true;
    });

    if (filteredClassConstructors.length !== 1)
        throw new Error("should not be happening!");

    const classConstructor = filteredClassConstructors[0];
    if (classConstructor == null)
        throw new Error("never will be");

    const formalParameters = classConstructor.childForFieldName("parameters");
    if (formalParameters == null)
        throw new Error("constructors will have a parameter section for sure");
    const parameters = formalParameters.descendantsOfType("formal_parameter");
    if (parameters.length !== Object.keys(fields).length) {
        throw new Error("mismatch in the number of fields");
    }

    const constructorBody = classConstructor.childForFieldName("body");
    if (constructorBody == null)
        throw new Error("of course there is a constructor body");

    for (const statement of constructorBody.children) {
        if (statement.type !== "expression_statement") continue;
        if (statement.firstChild == null)
            throw new Error("no first child, what?");
        if (statement.firstChild.type === "method_invocation") {
            const methodObject = statement.firstChild.childForFieldName("object")!,
                methodName = statement.firstChild.childForFieldName("name")!,
                methodArguments = statement.firstChild.childForFieldName("arguments")!;
            if (
                methodObject.text === "Intrinsics"
                && methodName.text === "checkNotNullParameter"
                && methodArguments.childCount === 5
            ) {
                const identifier = methodArguments.child(1),
                    fieldName = methodArguments.child(3)!.child(1)!;
                if (fieldName.text in fields && fields[fieldName.text] != null) {
                    fields[fieldName.text]!.required = true;
                } else {
                    throw new Error("field name not registered?");
                }
            } else {
                throw new Error("should be handled");
            }
        } else if (statement.firstChild.type === "assignment_expression") {
            const left = statement.firstChild.childForFieldName("left")!,
                right = statement.firstChild.childForFieldName("right")!;
            if (
                left.type === "field_access"
                && left.childForFieldName("object")?.text === "this"
                && left.childForFieldName("field")!.text in fields
            ) {
                if (right.type === "identifier") {
                    // console.log(right.text);
                } else {
                    throw new Error("what is this? it should be an identifier");
                }
            } else {
                throw new Error("unhandled assignment in constructor");
            }
        } else {
            throw new Error("unhandled or unchecked case!");
        }
    }

    let parent = structure;
    for (const namepsaceName of modelFile.parentClasses) {
        let namespace = parent.find((value) => value.type === "namespace" && value.name === namepsaceName);
        if (namespace == null || namespace.type !== "namespace") {
            namespace = {
                type: "namespace",
                name: namepsaceName,
                children: [],
            };
            parent.push(namespace);
        }
        parent = namespace.children;
    }
    parent.push({
        type: "class",
        name: className,
        fields: fields,
    });
}

const writer = new CodeBlockWriter();

function writeNodes(parent: Namespace["children"]) {
    for (const node of parent) {
        if (node.type === "class") {
            writer.write(`export interface ${node.name}`).block(() => {
                for (const fieldName in node.fields) {
                    const field = node.fields[fieldName]!;
                    const key = field.serialisedName ?? field.name;
                    const isDirty = !IDENTIFIER_REGEX.test(key);
                    writer.conditionalWrite(isDirty, "\"").write(key).conditionalWrite(isDirty, "\"")
                        .conditionalWrite(!field.required, "?")
                        .write(": ")
                        .write(resolvedTypeToString(field.type))
                        .write(";")
                        .newLine();
                }
            });
        } else if (node.type === "namespace") {
            writer.write(`export namespace ${node.name}`).block(() => {
                writeNodes(node.children);
            });
        } else {
            throw new Error("unwanted stuff");
        }
    }
}

writeNodes(structure);

await fs.writeFile("./generated/models.d.ts", writer.toString());

process.on("exit", (code) => {
    console.log(`\x1b[34mprocess complete: ${code === 0 ? "success" : "failed"}\x1b[0m`);
});

export { structure };
