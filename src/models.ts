import CodeBlockWriter from "code-block-writer";
import fs from "node:fs/promises";
import path from "node:path";
import Parser from "tree-sitter";
import JavaGrammar from "tree-sitter-java";

const IDENTIFIER_REGEX = /^[a-zA-Z_$][a-zA-Z_$0-9]*$/;

const MODELS_DIR = ["decompiled", "in.etuwa", "app", "data", "model"];
const MODEL_SCOPE = "in.etuwa.app.data.model";
const MODEL_SCOPE_PARTS = MODEL_SCOPE.split(".");

interface ModelFile {
    name: string;
    filename: string;
    path: string;
    parentClasses: string[];
    scope: string;
}

interface Field {
    name: string;
    serialisedName: string | null;
    type: ResolvedType;
    required: boolean;
}

interface ModelFileImport {
    identifier: string;
    scope: string;
    isModelScope: boolean;
}

type ResolvedType = string | string[] | ResolvedType[];

interface Namespace {
    type: "namespace";
    name: string;
    children: (Class | Namespace)[];
}

interface Class {
    type: "class";
    name: string;
    fields: Record<string, Field>;
}

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

const finalLogs: unknown[] = [];

const FIELD_ACCESS_TABLE_CONSTANTS: Record<string, string> = {
    "Constants.IPC_BUNDLE_KEY_SEND_ERROR": "error", // https://github.com/firebase/firebase-android-sdk/blob/72908db40c8606715a11f7ca2b2f75599e3280fe/firebase-messaging/src/main/java/com/google/firebase/messaging/Constants.java#L37
    "FirebaseAnalytics.Event.LOGIN": "login",
    "PdfConst.Description": "description",
    "NotificationCompat.CATEGORY_STATUS": "status",
    "FontsContractCompat.Columns.FILE_ID": "file_id",
    "AttendanceDayDialogKt.ARG_SEM": "semester", // todo: make constants table by traversing all files
    "ReplyDialogKt.ARG_SENDER_ID": "sender_id",
    "TypedValues.TransitionType.S_TO": "to",
    "FeeConfirmDialogKt.ARG_TOTAL": "total",
    "Constants.ScionAnalytics.MessageType.DATA_MESSAGE": "data", // https://github.com/firebase/firebase-android-sdk/blob/72908db40c8606715a11f7ca2b2f75599e3280fe/firebase-messaging/src/main/java/com/google/firebase/messaging/Constants.java#L317
};

const JAVA_WRAPPER_CLASSES_TYPES_TABLE: Record<string, string> = {
    "Byte": "number",
    "Short": "number",
    "Integer": "number",
    "Long": "number",
    "Float": "number",
    "Double": "number",
    "Boolean": "boolean",
    "Character": "string",
    "String": "string",
};

const JAVA_GENERIC_CLASSES_TABLE: Record<string, string> = {
    "ArrayList": "Array",
    "List": "Array",
};

const structure: Namespace["children"] = [];

for (const modelFile of modelFiles) {
    console.log("reading", modelFile.path);
    const content = await fs.readFile(modelFile.path, "utf-8");
    const tree = parser.parse(content);

    // resolve imports
    const modelImports: Record<string, ModelFileImport> = {};
    for (const decl of tree.rootNode.descendantsOfType("import_declaration")) {
        const scopedIdentifierNode = decl.child(1);
        if (
            decl.childCount !== 3
            || scopedIdentifierNode == null
            || scopedIdentifierNode.type !== "scoped_identifier"
        ) {
            throw new Error("should be scoped identifier");
        }
        const scopedIdentifier = scopedIdentifierNode.text.trim();
        const scopeParts = scopedIdentifier.split(".");
        const identifier = scopeParts.pop();

        if (identifier == null)
            throw new Error("unwanted identifier");

        const isModelIdentifier = scopedIdentifier.startsWith(MODEL_SCOPE);

        if (identifier in modelImports) {
            throw new Error("two same identifiers?");
        }

        modelImports[identifier] = {
            identifier: identifier,
            scope: isModelIdentifier
                ? scopeParts.slice(MODEL_SCOPE_PARTS.length).join(".")
                : scopeParts.join("."),
            isModelScope: isModelIdentifier,
        };
    }

    function resolveTypeIdentifier(typeIdentifier: Parser.SyntaxNode): ResolvedType {
        switch (typeIdentifier.type) {
            case "integral_type":
                return "number";

            case "floating_point_type":
                return "number";

            case "boolean_type":
                return "boolean";

            case "type_identifier":
                if (
                    typeIdentifier.text in JAVA_WRAPPER_CLASSES_TYPES_TABLE
                    && typeof JAVA_WRAPPER_CLASSES_TYPES_TABLE[typeIdentifier.text] === "string"
                ) {
                    return JAVA_WRAPPER_CLASSES_TYPES_TABLE[typeIdentifier.text]!;
                } else {
                    // since its not a scoped identifier, the type identifier must be in
                    // the same package. so...
                    const samePackageModels = modelFiles.filter((file) => {
                        return file.scope === modelFile.scope;
                    }).map((model) => model.name);
                    if (!samePackageModels.includes(typeIdentifier.text)) { // or imported?
                        if (typeIdentifier.text in modelImports && modelImports[typeIdentifier.text] != null) {
                            const { identifier, scope } = modelImports[typeIdentifier.text]!;
                            if (scope === "") return [identifier];
                            return [[scope, identifier].join(".")];
                        } else {
                            console.log(nodePosition(typeIdentifier, modelFile));
                            console.log(typeIdentifier.text);
                            throw new Error("Expected the type identifier to be a class in the same package scope");
                        }
                    }
                    return typeIdentifier.text;
                }

            case "generic_type":
                if (typeIdentifier.childCount !== 2)
                    throw new Error("Expected two parts for generic type");

                const type = typeIdentifier.child(0)!.text;

                if (
                    type in JAVA_GENERIC_CLASSES_TABLE
                    && typeof JAVA_GENERIC_CLASSES_TABLE[type] === "string"
                ) {
                    const typeArgumentsNode = typeIdentifier.child(1)!;

                    if (typeArgumentsNode.childCount % 2 !== 1)
                        throw new Error("expected odd number of children count");

                    const typeArguments = typeIdentifier.child(1)!.children
                        .filter((_, i) => i % 2 === 1)
                        .map((child) => resolveTypeIdentifier(child))
                        .flat();

                    return [JAVA_GENERIC_CLASSES_TABLE[type], typeArguments];
                } else {
                    console.log(nodePosition(typeIdentifier, modelFile));
                    console.log(type, typeIdentifier.text);
                    throw new Error("Unhandled generic type in generic classes, must add");
                }

            default:
                console.log(typeIdentifier.toString());
                throw new Error("unhandled type identifier type");
        }
    }

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
                            console.log(nodePosition(argument, modelFile));
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
            type: resolveTypeIdentifier(typeIdentifierNode),
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

function resolvedTypeToString(type: ResolvedType): string {
    if (typeof type === "string") {
        return type;
    } else if (Array.isArray(type)) {
        if (Array.isArray(type[1])) {
            return type[0] + "<" + resolvedTypeToString(type[1]) + ">";
        } else {
            return type.join(", ");
        }
    } else {
        throw new Error("should never occur");
    }
}

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

await fs.writeFile("./generated/models.ts", writer.toString());

function nodePosition(node: Parser.SyntaxNode, { path }: ModelFile) {
    return `${path}:${node.startPosition.row + 1}:${node.startPosition.column + 1}`;
}

process.on("exit", (code) => {
    console.log(`\x1b[34mCOLLECTED LOGS\x1b[0m`);
    for (const log of finalLogs) {
        if (Array.isArray(log)) console.log(...log);
        else console.log(log);
    }
    console.log(`\x1b[34mprocess complete: ${code === 0 ? "success" : "failed"}\x1b[0m`);
});
