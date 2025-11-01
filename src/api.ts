import CodeBlockWriter from "code-block-writer";
import fs from "node:fs/promises";
import path from "node:path";
import Parser from "tree-sitter";
import JavaGrammar, { nodeTypeInfo } from "tree-sitter-java";

const parser = new Parser();
parser.setLanguage(JavaGrammar as Parser.Language);

const DATA_DIR = path.join("decompiled", "in.etuwa", "app", "data");
const API_ENDPOINTS_FILE = path.join(DATA_DIR, "network", "ApiEndPoints.java");

const content = await fs.readFile(API_ENDPOINTS_FILE, "utf-8");
const tree = parser.parse(content);

const classBody = tree.rootNode.descendantsOfType("class_declaration")[0]
    ?.childForFieldName("body");

if (classBody == null) {
    throw new Error("Expected to have a class body");
}

const API_ENDPOINTS_CLASS_FIELD_MODIFIERS = new Set(["public", "static", "final"]);

const apiEndpoints: Record<string, string> = {};

for (const fieldDecl of classBody.descendantsOfType("field_declaration")) {
    const fieldType = fieldDecl.childForFieldName("type")!.text;
    if (fieldType === "String") {
        const fieldModifiers = fieldDecl.child(0);
        if (fieldModifiers == null) {
            throw new Error("expected modifiers");
        }
        const modifierTypes = fieldModifiers.children.map((modifier) => modifier.type);
        if (new Set(modifierTypes).symmetricDifference(API_ENDPOINTS_CLASS_FIELD_MODIFIERS).size !== 0) {
            throw new Error("expected to match all modifiers");
        }
        const fieldDeclarator = fieldDecl.childForFieldName("declarator")!;
        const name = fieldDeclarator.childForFieldName("name")!,
            value = fieldDeclarator.childForFieldName("value")!;
        if (value.type === "string_literal") {
            if (value.childCount === 3) {
                const fragment = value.child(1)!;
                const endpointName = name.text.trim();
                if (endpointName in apiEndpoints) {
                    throw new Error("endpoint with the same name already exists?");
                }
                apiEndpoints[endpointName] = fragment.text.trim();
            } else {
                throw new Error("unhandled string case");
            }
        } else {
            throw new Error("Unhandled typeof value, maybe constant reference? or a concat?");
        }
    } else if (fieldType === "ApiEndPoints") {
        // do nothing
    } else {
        throw new Error("unknown and unhandled type of field");
    }
}

const writer = new CodeBlockWriter();
writer.write("enum ApiEndpoints").block(() => {
    for (const name in apiEndpoints) {
        writer.write(name).write(" = ").write(`"${apiEndpoints[name]}",`).newLine();
    }
});

await fs.writeFile("./generated/api.ts", writer.toString());
