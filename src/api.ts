import CodeBlockWriter from "code-block-writer";
import fs from "node:fs/promises";
import path, { extname } from "node:path";
import Parser from "tree-sitter";
import JavaGrammar from "tree-sitter-java";
import {
    getImports,
    nodePosition,
    parseModifiers,
    parseParameterAnnotationModiifer,
    resolveTypeIdentifier,
    typeEquivalency,
} from "./helpers.js";
import { structure } from "./models.js";

process.on("exit", (code) => {
    console.log(`\x1b[34mprocess complete: ${code === 0 ? "success" : "failed"}\x1b[0m`);
});

const parser = new Parser();
parser.setLanguage(JavaGrammar as Parser.Language);

const DATA_DIR = path.join("decompiled", "in.etuwa", "app", "data");

const API_ENDPOINTS_FILE = path.join(DATA_DIR, "network", "ApiEndPoints.java");
const apiEndpointsContent = await fs.readFile(API_ENDPOINTS_FILE, "utf-8");
const apiEndpointsTree = parser.parse(apiEndpointsContent);

const classBody = apiEndpointsTree.rootNode.descendantsOfType("class_declaration")[0]
    ?.childForFieldName("body")!;

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

const apiEndpointsFileWriter = new CodeBlockWriter();
apiEndpointsFileWriter.write("export enum ApiEndPoints").block(() => {
    for (const name in apiEndpoints) {
        apiEndpointsFileWriter.write(name).write(" = ").write(`"${apiEndpoints[name]}",`).newLine();
    }
});
await fs.writeFile("./generated/api-endpoints.ts", apiEndpointsFileWriter.toString());

const API_SERVICE_FILE = path.join(DATA_DIR, "network", "ApiService.java");
const apiServiceContent = await fs.readFile(API_SERVICE_FILE, "utf-8");
const apiServiceTree = parser.parse(apiServiceContent);
const apiServiceFileImports = getImports(apiServiceTree);
const API_SERVICE_FILE_SAME_SCOPE_IDENTIFIERS = ["ApiClient", "ApiHelper", "ApiEndpoints"];

const interfaceBody = apiServiceTree.rootNode
    .descendantsOfType("interface_declaration")[0]
    ?.childForFieldName("body")!;

const apiServiceMethods: Record<string, ApiMethodCall[]> = {};

for (const methodDecl of interfaceBody.descendantsOfType("method_declaration")) {
    const modifiersNode = methodDecl.child(0)!;
    if (modifiersNode.type !== "modifiers") {
        throw new Error("expected method to have modifier");
    }
    const modifiers = parseModifiers(modifiersNode, { currentPath: API_SERVICE_FILE, ignoreList: [] });
    if (modifiers.filter((mod) => mod.type === "marker_annotation").length > 1) {
        console.log(nodePosition(methodDecl, API_SERVICE_FILE));
        throw new Error("too many marker annotations");
    }
    if (modifiers.filter((mod) => mod.type === "annotation").length !== 1) {
        console.log(nodePosition(methodDecl, API_SERVICE_FILE));
        throw new Error("mismatch in number of annotations");
    }

    const typeNode = methodDecl.childForFieldName("type");
    const nameNode = methodDecl.childForFieldName("name");
    const parametersNode = methodDecl.childForFieldName("parameters");
    if (typeNode == null || nameNode == null || parametersNode == null) {
        throw new Error("expected each method to have a type, name, and parameters");
    }

    const methodName = nameNode.text.trim();

    const methodReturnType = resolveTypeIdentifier(typeNode, {
        currentPath: API_SERVICE_FILE,
        imports: apiServiceFileImports,
        sameScopeTypeDeclarations: API_SERVICE_FILE_SAME_SCOPE_IDENTIFIERS,
    });

    const methodFields: ApiMethodField[] = [];

    for (const parameterNode of parametersNode.children) {
        if (
            parameterNode.type === "(" || parameterNode.type === ")"
            || parameterNode.type === ","
        ) {
            // ignore
        } else if (parameterNode.type === "formal_parameter") {
            if (parameterNode.firstChild?.type === "modifiers") {
                const parameterTypeNode = parameterNode.childForFieldName("type")!;
                const parameterIdentiferNode = parameterNode.childForFieldName("name")!;
                const parameterModifiers = parseModifiers(parameterNode.firstChild, {
                    currentPath: API_SERVICE_FILE,
                    ignoreList: [],
                });
                if (parameterModifiers.length !== 1) {
                    throw new Error("expected only one annotation modifier for parameter");
                }
                const parameterAnnotationModifier = parseParameterAnnotationModiifer(parameterModifiers[0]!);

                methodFields.push({
                    name: parameterIdentiferNode.text,
                    type: resolveTypeIdentifier(parameterTypeNode, {
                        currentPath: API_SERVICE_FILE,
                        imports: apiServiceFileImports,
                        sameScopeTypeDeclarations: API_SERVICE_FILE_SAME_SCOPE_IDENTIFIERS,
                    }),
                    annotation: parameterAnnotationModifier,
                    required: false,
                });
            } else {
                console.log(nodePosition(parameterNode, API_SERVICE_FILE));
                throw new Error("expected api method parameter to have a modifier");
            }
        } else {
            console.log(nodePosition(parameterNode, API_SERVICE_FILE));
            throw new Error("unhandled parameter type");
        }
    }

    // some custom validation i wrote to ensure this stuff is actually structured as i figured out:
    if (modifiers.length === 1) {
        if (
            modifiers[0]?.type === "annotation" && ["POST", "GET"].includes(modifiers[0].name)
            && modifiers[0].arguments.length === 1
        ) {
            if (methodFields.length === 0) {
                // it's alright.
            } else if (methodFields.length === 1) {
                const type = methodFields[0]?.annotation?.type!;
                if (type !== "body" && type !== "path") {
                    throw new Error("cool");
                }
            } else if (methodFields.length === 2) {
                const types = new Set(methodFields.map((x) => x.annotation?.type!));
                if (types.symmetricDifference(new Set(["body", "path"])).size !== 0) {
                    throw new Error("what");
                }
            } else {
                console.log(modifiers[0], methodFields);
                throw new Error("eb");
            }
        } else {
            console.log(modifiers[0]);
            throw new Error("kek");
        }
    }

    apiServiceMethods[methodName] ??= [];
    const apiMethodCall: ApiMethodCall = {
        name: methodName,
        type: methodReturnType,
        fields: methodFields,
        annotations: modifiers,
    };
    for (const call of apiServiceMethods[methodName]) {
        if (!typeEquivalency(call.type, apiMethodCall.type)) {
            console.warn("warn:", "mismatch in return types", methodName, call.type, apiMethodCall.type);
            // throw new Error("the return type should be same for all signatures"); // should they?
        }
        // const annotations = apiMethodCall.annotations
        //     .filter((annotation) => annotation.type === "annotation");
        // const callAnnotations = call.annotations.filter((annotation) => annotation.type === "annotation");
        // if (annotations.length !== 1 || callAnnotations.length !== 1) {
        //     throw new Error("annotations");
        // }
        // if (annotations[0]?.name !== callAnnotations[0]?.name) {
        //     console.log(call.name);
        //     console.log(annotations, callAnnotations);
        //     // throw new Error("annotation good bye");
        // }
    }
    apiServiceMethods[methodName].push(apiMethodCall);
}

const API_HELPER_FILE = path.join(DATA_DIR, "network", "ApiHelper.java");
const apiHelperFileContent = await fs.readFile(API_HELPER_FILE, "utf-8");
const apiHelperFileTree = parser.parse(apiHelperFileContent);
const apiHelperFileImports = getImports(apiHelperFileTree);
const API_HELPER_FILE_SAME_SCOPE_IDENTIFIERS = ["ApiClient", "ApiService", "ApiEndpoints"];

const apiHelperClassBody = apiHelperFileTree.rootNode
    .descendantsOfType("class_declaration")[0]
    ?.childForFieldName("body")!;

const EXPECTED_METHOD_MODIFIERS = new Set(["public", "final"]);

const apiHelperMethods: Record<string, (ApiMethodCall & { serviceMethod: ApiMethodCall })[]> = {};

for (const methodDecl of apiHelperClassBody.descendantsOfType("method_declaration")) {
    const modifiersNode = methodDecl.child(0)!;
    if (modifiersNode.type !== "modifiers") {
        throw new Error("expected method to have modifier");
    }
    const modifiers = parseModifiers(modifiersNode, { currentPath: API_HELPER_FILE, ignoreList: [] });
    if (modifiers.length !== 2) {
        console.log(nodePosition(methodDecl, API_HELPER_FILE));
        throw new Error("mismatch in number of modifiers");
    }
    const methodRawModifiers = new Set(
        modifiers.filter((modifier) => modifier.type === "raw")
            .map((modifier) => modifier.value),
    );
    if (methodRawModifiers.symmetricDifference(EXPECTED_METHOD_MODIFIERS).size !== 0) {
        throw new Error("mismatch in modifiers");
    }

    const typeNode = methodDecl.childForFieldName("type");
    const nameNode = methodDecl.childForFieldName("name");
    const parametersNode = methodDecl.childForFieldName("parameters");
    const bodyNode = methodDecl.childForFieldName("body");
    if (typeNode == null || nameNode == null || parametersNode == null || bodyNode == null) {
        throw new Error("expected each method to have a type, name, parameters and body");
    }

    const methodName = nameNode.text.trim();

    const methodReturnType = resolveTypeIdentifier(typeNode, {
        currentPath: API_HELPER_FILE,
        imports: apiHelperFileImports,
        sameScopeTypeDeclarations: API_HELPER_FILE_SAME_SCOPE_IDENTIFIERS,
    });

    const methodFields: ApiMethodField[] = [];
    for (const parameterNode of parametersNode.children) {
        if (
            parameterNode.type === "(" || parameterNode.type === ")"
            || parameterNode.type === ","
        ) {
            // ignore
        } else if (parameterNode.type === "formal_parameter") {
            if (parameterNode.firstChild?.type !== "modifiers") {
                const parameterTypeNode = parameterNode.childForFieldName("type")!;
                const parameterIdentiferNode = parameterNode.childForFieldName("name")!;

                if (parameterIdentiferNode.text in methodFields) {
                    throw new Error("impossible");
                }

                methodFields.push({
                    name: parameterIdentiferNode.text,
                    type: resolveTypeIdentifier(parameterTypeNode, {
                        currentPath: API_HELPER_FILE,
                        imports: apiHelperFileImports,
                        sameScopeTypeDeclarations: API_HELPER_FILE_SAME_SCOPE_IDENTIFIERS,
                    }),
                    required: false,
                });
            } else {
                console.log(parameterNode.firstChild?.type, parameterNode.toString());
                console.log(nodePosition(parameterNode, API_HELPER_FILE));
                throw new Error("expected api method parameter to have no modifiers");
            }
        } else {
            console.log(nodePosition(parameterNode, API_HELPER_FILE));
            throw new Error("unhandled parameter type");
        }
    }

    // resolve body
    if (bodyNode.type !== "block") {
        throw new Error("body is supposed to be a block");
    }

    const returnStatements = bodyNode.descendantsOfType("return_statement");
    if (returnStatements.length !== 1) {
        throw new Error("expected one return statement");
    }
    const returnStatement = returnStatements[0]!;
    if (returnStatement.childCount !== 3) {
        throw new Error("expected only one child");
    }
    const returnMethod = returnStatement.child(1)!;
    if (returnMethod.type !== "method_invocation") {
        throw new Error("what");
    }
    if (returnMethod.childForFieldName("object")?.text !== "this.apiService") {
        throw new Error("kek");
    }
    const apiServiceMethodName = returnMethod.childForFieldName("name")?.text!;
    if (!(apiServiceMethodName in apiServiceMethods)) {
        throw new Error("should be impossible");
    }
    const args = returnMethod.childForFieldName("arguments")!.children
        .filter((arg) => !["(", ",", ")"].includes(arg.type));
    if (args.some((arg) => arg.type !== "identifier")) {
        throw new Error("non identiifiers?");
    }

    const apiServiceMethodDefs = apiServiceMethods[apiServiceMethodName]!;

    let matchingApiServiceMethodDef: ApiMethodCall | null = null;
    for (const methodDef of apiServiceMethodDefs) {
        if (methodDef.fields.length !== args.length)
            continue;

        for (let i = 0; i < methodDef.fields.length; i++) {
            const methodDefField = methodDef.fields[i];
            const methodField = methodFields[i]!;
            if (methodDefField == null || methodField == null)
                throw new Error("meh");

            if (methodDefField.name !== methodField.name) {
                // pure sadness, they could've just used the same name
                // console.log("what", methodName, methodDefField.name, methodField.name);
            }

            if (!typeEquivalency(methodField.type, methodDefField.type)) {
                throw new Error("mismatch in types");
            }
        }

        if (matchingApiServiceMethodDef != null) {
            throw new Error("shouldn't match twice");
        }
        matchingApiServiceMethodDef = methodDef;
    }

    if (matchingApiServiceMethodDef == null) {
        throw new Error("should match at least once");
    }

    for (const child of bodyNode.children) {
        if (child.type === "{" || child.type === "}") {
            continue;
        } else if (child.type === "expression_statement") {
            if (child.firstChild?.type === "method_invocation") {
                const methodObject = child.firstChild.childForFieldName("object")!,
                    methodName = child.firstChild.childForFieldName("name")!,
                    methodArguments = child.firstChild.childForFieldName("arguments")!;
                if (
                    methodObject.text === "Intrinsics"
                    && methodName.text === "checkNotNullParameter"
                ) {
                    const identifier = methodArguments.child(1)!;
                    if (identifier.type !== "identifier") throw new Error("k");

                    const fieldIndex = methodFields.findIndex((field) => identifier.text === field.name);
                    if (fieldIndex == -1) {
                        throw new Error("the field must be present in the method fields");
                    }
                    const methodDefField = matchingApiServiceMethodDef.fields[fieldIndex];
                    if (methodDefField == null) {
                        throw new Error("there should be a field in the matching method");
                    }
                    methodDefField.required = true;
                } else {
                    throw new Error("should be handled");
                }
            } else {
                throw new Error("unhandled type of expression statement");
            }
        } else if (child.type === "return_statement") {
        } else {
            console.log(nodePosition(child, API_HELPER_FILE));
            throw new Error("unhandled type of body child");
        }
    }

    if (typeEquivalency(matchingApiServiceMethodDef.type, methodReturnType) == false) {
        console.log(methodName, matchingApiServiceMethodDef.type, methodReturnType);
        throw new Error("the return types should match");
    }

    apiHelperMethods[methodName] ??= [];
    for (const call of apiHelperMethods[methodName]) {
        if (!typeEquivalency(call.type, methodReturnType)) {
            console.warn("warn:", "mismatch in return types", methodName, call.type, methodReturnType);
            // throw new Error("the return type should be same for all signatures");
        }
    }
    apiHelperMethods[methodName].push({
        name: methodName,
        type: methodReturnType,
        fields: methodFields,
        annotations: modifiers,
        serviceMethod: matchingApiServiceMethodDef,
    });
}

const REPOSITORIES_DIR = path.join(DATA_DIR, "repository");
const REPOSITORY_FILE_SUFFIX = "Repository.java";

interface Repository {
    name: string;
    methods: typeof apiHelperMethods;
}

const repositories: Repository[] = [];

for (const entry of await fs.readdir(REPOSITORIES_DIR, { withFileTypes: true })) {
    if (!entry.isFile() || extname(entry.name) !== ".java") {
        throw new Error("unexpected");
    }
    const currentFilePath = path.join(REPOSITORIES_DIR, entry.name);
    const content = await fs.readFile(currentFilePath, "utf-8");
    if (content.length === 0) {
        continue;
    }
    if (!entry.name.endsWith(REPOSITORY_FILE_SUFFIX)) {
        throw new Error("unexpected again");
    }

    const repository: Repository = {
        name: entry.name.slice(0, -REPOSITORY_FILE_SUFFIX.length),
        methods: {},
    };

    const tree = parser.parse(content);
    const imports = getImports(tree);

    const classBody = tree.rootNode
        .descendantsOfType("class_declaration")[0]
        ?.childForFieldName("body")!;

    for (const methodDecl of classBody.children.filter((child) => child.type === "method_declaration")) {
        const modifiersNode = methodDecl.child(0)!;
        if (modifiersNode.type !== "modifiers") {
            throw new Error("expected method to have modifier");
        }
        const modifiers = parseModifiers(modifiersNode, {
            currentPath: currentFilePath,
            ignoreList: ["line_comment"],
        });
        if (modifiers.some((modifier) => modifier.type !== "raw")) {
            continue;
        }
        const methodRawModifiers = new Set(
            modifiers.filter((modifier) => modifier.type === "raw")
                .map((modifier) => modifier.value),
        );
        if (methodRawModifiers.symmetricDifference(EXPECTED_METHOD_MODIFIERS).size !== 0) {
            // console.log(nodePosition(modifiersNode, currentFilePath));
            // throw new Error("mismatch in modifiers");
            continue;
        }

        const typeNode = methodDecl.childForFieldName("type");
        const nameNode = methodDecl.childForFieldName("name");
        const parametersNode = methodDecl.childForFieldName("parameters");
        const bodyNode = methodDecl.childForFieldName("body");
        if (typeNode == null || nameNode == null || parametersNode == null || bodyNode == null) {
            throw new Error("expected each method to have a type, name, parameters and body");
        }

        const methodName = nameNode.text.trim();

        const methodReturnType = resolveTypeIdentifier(typeNode, {
            currentPath: currentFilePath,
            imports: imports,
            sameScopeTypeDeclarations: [],
        });

        if (methodReturnType === "void") continue;

        const methodFields: ApiMethodField[] = [];
        for (const parameterNode of parametersNode.children) {
            if (
                parameterNode.type === "(" || parameterNode.type === ")"
                || parameterNode.type === ","
            ) {
                // ignore
            } else if (parameterNode.type === "formal_parameter") {
                if (parameterNode.firstChild?.type !== "modifiers") {
                    const parameterTypeNode = parameterNode.childForFieldName("type")!;
                    const parameterIdentiferNode = parameterNode.childForFieldName("name")!;

                    if (parameterIdentiferNode.text in methodFields) {
                        throw new Error("impossible");
                    }

                    methodFields.push({
                        name: parameterIdentiferNode.text,
                        type: resolveTypeIdentifier(parameterTypeNode, {
                            currentPath: currentFilePath,
                            imports: imports,
                            sameScopeTypeDeclarations: [],
                        }),
                        required: false,
                    });
                } else {
                    console.log(parameterNode.firstChild?.type, parameterNode.toString());
                    console.log(nodePosition(parameterNode, currentFilePath));
                    throw new Error("expected api method parameter to have no modifiers");
                }
            } else {
                console.log(nodePosition(parameterNode, currentFilePath));
                throw new Error("unhandled parameter type");
            }
        }

        if (bodyNode.type !== "block") {
            throw new Error("body is supposed to be a block");
        }

        const returnStatements = bodyNode.descendantsOfType("return_statement");
        if (returnStatements.length !== 1) {
            throw new Error("expected one return statement");
        }
        const returnStatement = returnStatements[0]!;
        if (returnStatement.childCount !== 3) {
            throw new Error("expected only one child");
        }
        const returnMethod = returnStatement.child(1)!;
        if (returnMethod.type !== "method_invocation") {
            continue;
        }
        if (returnMethod.childForFieldName("object")?.text !== "this.apiHelper") {
            throw new Error("kek");
        }
        const apiHelperMethodName = returnMethod.childForFieldName("name")?.text!;
        if (!(apiHelperMethodName in apiHelperMethods)) {
            throw new Error("should be impossible");
        }
        const args = returnMethod.childForFieldName("arguments")!.children
            .filter((arg) => !["(", ",", ")"].includes(arg.type));
        if (args.some((arg) => arg.type !== "identifier")) {
            throw new Error("non identiifiers?");
        }

        let matchingApiHelperMethodDef:
            | ApiMethodCall & {
                serviceMethod: ApiMethodCall;
            }
            | null = null;

        matching_method_search_loop:
        for (const methodDef of apiHelperMethods[apiHelperMethodName]!) {
            if (methodDef.fields.length !== args.length)
                continue;

            for (let i = 0; i < methodDef.fields.length; i++) {
                const methodDefField = methodDef.fields[i];
                const methodField = methodFields[i]!;
                if (methodDefField == null || methodField == null)
                    throw new Error("meh");

                if (methodDefField.name !== methodField.name) {
                    // pure sadness, they could've just used the same name
                    // console.log("what", methodName, methodDefField.name, methodField.name);
                }

                if (!typeEquivalency(methodField.type, methodDefField.type)) {
                    continue matching_method_search_loop;
                    // throw new Error("mismatch in types");
                }
            }

            if (matchingApiHelperMethodDef != null) {
                throw new Error("shouldn't match twice");
            }

            matchingApiHelperMethodDef = methodDef;
        }

        if (matchingApiHelperMethodDef == null) {
            throw new Error("should match at least once");
        }

        for (const child of bodyNode.children) {
            if (child.type === "{" || child.type === "}") {
                continue;
            } else if (child.type === "expression_statement") {
                if (child.firstChild?.type === "method_invocation") {
                    const methodObject = child.firstChild.childForFieldName("object")!,
                        methodName = child.firstChild.childForFieldName("name")!,
                        methodArguments = child.firstChild.childForFieldName("arguments")!;
                    if (
                        methodObject.text === "Intrinsics"
                        && methodName.text === "checkNotNullParameter"
                    ) {
                        const identifier = methodArguments.child(1)!;
                        if (identifier.type !== "identifier") throw new Error("k");

                        const fieldIndex = methodFields.findIndex((field) => identifier.text === field.name);
                        if (fieldIndex == -1) {
                            throw new Error("the field must be present in the method fields");
                        }
                        const methodDefField = matchingApiHelperMethodDef.fields[fieldIndex];
                        if (methodDefField == null) {
                            throw new Error("there should be a field in the matching method");
                        }
                        methodDefField.required = true;
                    } else {
                        throw new Error("should be handled");
                    }
                } else {
                    throw new Error("unhandled type of expression statement");
                }
            } else if (child.type === "return_statement") {
            } else {
                console.log(nodePosition(child, currentFilePath));
                throw new Error("unhandled type of body child");
            }
        }

        repository.methods[methodName] ??= [];
        repository.methods[methodName].push(matchingApiHelperMethodDef);
    }

    repositories.push(repository);
}

// await fs.writeFile("./generated/methods.json", JSON.stringify(repositories), "utf-8");

interface HoppscotchRequestHeader {
    key: string;
    value: string;
    active: boolean;
    description: string;
}

type HoppscotchAuth = {
    authType: "inherit";
    authActive: boolean;
} | {
    authType: "bearer";
    authActive: boolean;
    token: string;
};

interface HoppscotchRequestVariable {
    key: string;
    value: string;
    active: boolean;
}

interface HoppscotchRequestV16 {
    v: "16";
    name: string;
    method: string;
    endpoint: string;
    params: {
        key: string;
        value: string;
        active: boolean;
        description: string;
    }[];
    headers: HoppscotchRequestHeader[];
    preRequestScript: string;
    testScript: string;
    auth: HoppscotchAuth;
    body: {
        contentType: string | null;
        body: string | null;
    };
    requestVariables: HoppscotchRequestVariable[];
    responses: {};
    _ref_id: string;
}

interface HoppscotchFolderV10 {
    v: 10;
    name: string;
    folders: [];
    requests: HoppscotchRequestV16[];
    auth: HoppscotchAuth;
    headers: HoppscotchRequestHeader[];
    variables: [];
    _ref_id: string;
}

interface HoppscotchCollectionV10 {
    v: 10;
    name: string;
    folders: HoppscotchFolderV10[];
    requests: HoppscotchRequestV16[];
    auth: HoppscotchAuth;
    headers: HoppscotchRequestHeader[];
    variables: {
        secret: boolean;
        key: string;
        initialValue: string;
        currentValue: string;
    }[];
    _ref_id: string;
}

const hoppscotchCollection: HoppscotchCollectionV10 = {
    v: 10,
    name: "Etlab Students",
    auth: {
        authType: "inherit",
        authActive: true,
    },
    requests: [],
    folders: [],
    headers: [],
    variables: [
        {
            secret: true,
            key: "BASE_URL",
            initialValue: "",
            currentValue: "",
        },
    ],
    _ref_id: "",
};

const NON_AUTHORIZED_ROUTES = ["doLogin"];
const VALID_METHODS = ["GET", "POST"];

for (const repository of repositories) {
    const hoppscotchFolder: HoppscotchFolderV10 = {
        v: 10,
        name: repository.name.replaceAll(/([a-z])([A-Z])/g, "$1 $2"),
        variables: [],
        auth: {
            authType: "inherit",
            authActive: true,
        },
        folders: [],
        headers: [],
        requests: [],
        _ref_id: "",
    };

    for (const methodName in repository.methods) {
        for (const [index, method] of repository.methods[methodName]!.entries()) {
            const annotation = method.serviceMethod.annotations.find((a) => a.type === "annotation");
            if (annotation == null || annotation.arguments.length !== 1) throw new Error("kek");
            if (!VALID_METHODS.includes(annotation.name)) {
                throw new Error("invalid method");
            }

            let endpoint = annotationArgumentToString(annotation.arguments[0]!, {
                fieldNamespaces: { "ApiEndPoints": apiEndpoints },
            });

            let body: HoppscotchRequestV16["body"] = {
                contentType: null,
                body: null,
            };
            const headers: HoppscotchRequestHeader[] = [];
            const requestVariables: HoppscotchRequestVariable[] = [];

            if (method.fields.length > 0) {
                let contentType:
                    | "application/json"
                    | "application/x-www-form-urlencoded"
                    | "multipart/form-data"
                    | null;

                const markerAnnotation = method.serviceMethod.annotations.find((a) => a.type === "marker_annotation");
                if (markerAnnotation == null) {
                    const bodyFields = method.serviceMethod.fields.filter((f) => f.annotation?.type === "body");
                    if (bodyFields.length === 0) {
                        contentType = null;
                    } else if (bodyFields.length === 1) {
                        contentType = "application/json";
                        body = {
                            contentType: contentType,
                            body: resolvedTypeToJSONString(bodyFields[0]!.type),
                        };
                    } else {
                        console.log(method.serviceMethod);
                        throw new Error("kek");
                    }
                } else if (markerAnnotation.name === "FormUrlEncoded") {
                    contentType = "application/x-www-form-urlencoded";

                    // console.log(method.name, method.serviceMethod.fields.map((f) => f.annotation?.type));
                } else if (markerAnnotation.name === "Multipart") {
                    contentType = "multipart/form-data";

                    // console.log(method.name, method.serviceMethod.fields.map((f) => f.annotation?.type));
                } else {
                    throw new Error("what");
                }

                if (contentType != null) {
                    headers.push({
                        key: "Content-Type",
                        value: contentType,
                        description: "",
                        active: true,
                    });
                }

                // substitute path params in endpoint
                for (const field of method.serviceMethod.fields) {
                    if (field.annotation && field.annotation.type === "path") {
                        const paramString = "{" + field.annotation.param + "}";
                        if (!endpoint.includes(paramString)) {
                            throw new Error("expected param to be present in endpoint");
                        }
                        endpoint = endpoint.replaceAll(paramString, `<<${field.annotation.param}>>`);
                        requestVariables.push({
                            key: field.annotation.param,
                            value: "",
                            active: true,
                        });
                    }
                }
            }

            const hoppscotchRequest: HoppscotchRequestV16 = {
                v: "16",
                name: methodNameToName(methodName) + (index > 0 ? ` ${index + 1}` : ""),
                method: annotation.name,
                endpoint: `<<BASE_URL>>/${endpoint}`,
                auth: {
                    authType: "inherit",
                    authActive: true,
                },
                headers: headers,
                requestVariables: requestVariables,
                params: [],
                preRequestScript: "",
                testScript: "",
                body: body,
                responses: {},
                _ref_id: "",
            };

            hoppscotchFolder.requests.push(hoppscotchRequest);
        }
    }

    hoppscotchCollection.folders.push(hoppscotchFolder);
}

await fs.writeFile(
    "./generated/hoppscotch-collection.json",
    JSON.stringify(hoppscotchCollection, null, 2),
    "utf-8",
);

function resolvedTypeToJSONString(type: ResolvedType): string {
    if (type.length == 1 && typeof type[0] === "string") {
        const segments = type[0].split(".");
        const className = segments.pop()!;
        let parent = structure;
        for (const segment of segments) {
            const child = parent.find((child) => child.name === segment);
            if (child == null || child.type !== "namespace") {
                throw new Error("cannot find the namespace");
            }
            parent = child.children;
        }
        const classModel = parent.find((c) => c.name === className);
        if (classModel == null || classModel.type !== "class") {
            throw new Error("cannot find the class in namespace");
        }

        const {
            required,
            optional,
        } = Object.groupBy(
            Object.values(classModel.fields),
            (f) => f.required ? "required" : "optional",
        );

        let out: string[] = [];

        const c = (fields: Field[]) =>
            JSON.stringify(
                fields.reduce((p, c) => {
                    const defaultValue = c.type === "string"
                        ? ""
                        : c.type === "boolean"
                        ? false
                        : null;

                    if (defaultValue == null) {
                        throw new Error("unhandled type");
                    }

                    p[c.serialisedName || c.name] = defaultValue;
                    return p;
                }, {} as Record<string, "" | false>),
                null,
                "\t",
            ).split("\n").slice(1, -1);

        if (required != null) {
            out.push("\t// required");
            out.push(...c(required));
            if (optional != null) {
                out[out.length - 1] += ",";
            }
        }
        if (optional != null) {
            out.push("\t// optional");
            out.push(...c(optional));
        }
        return ["{", ...out, "}"].join("\n");
    }
    throw new Error("kek");
}

function annotationArgumentToString(arg: AnnotationArgument, options: {
    fieldNamespaces: Record<string, Record<string, string>>;
}): string {
    if (arg.type === "field_access") {
        if (arg.object in options.fieldNamespaces) {
            return options.fieldNamespaces[arg.object]![arg.field]!;
        }
        throw new Error("unknown object, make sure to pass in as namespace");
    } else if (arg.type === "string_literal") {
        return arg.value;
    } else {
        throw new Error("should not be converted to string, or unhandled conversion case: " + arg.type);
    }
}

function methodNameToName(methodName: string): string {
    if (methodName.endsWith("ApiCall"))
        methodName = methodName.slice(0, -"ApiCall".length);

    methodName = methodName[0]!.toUpperCase() + methodName.slice(1).replaceAll(/([A-Z])/g, " $1");

    return methodName.split(" ").map((part) => ["Url", "Po"].includes(part) ? part.toUpperCase() : part).join(" ");
}

// const grouped = Object.values(apiServiceMethods).flat()
//     .reduce((p, call) => {
//         const annotation = call.annotations
//             .filter((a) => a.type === "annotation")[0]!;
//         const method = annotation.name;
//         if (annotation.arguments.length !== 1) {
//             throw new Error("kek");
//         }
//         const argument = annotation.arguments[0]!;
//         const argumentStringValue = argument.type === "string_literal"
//             ? argument.value
//             : argument.type === "field_access"
//             ? argument.object === "ApiEndPoints"
//                 ? apiEndpoints[argument.field]
//                 : null
//             : null;
//         if (argumentStringValue == null) {
//             throw new Error("kek");
//         }
//         p[argumentStringValue] ??= {};
//         p[argumentStringValue][method] ??= [];
//         p[argumentStringValue][method].push(call);
//         return p;
//     }, {} as Record<string, Record<string, ApiMethodCall[]>>);

// const writer = new CodeBlockWriter();
// writer
//     .writeLine("import express from \"express\";")
//     .writeLine("import { ApiEndPoints } from \"./api-endpoints.js\";")
//     .blankLine()
//     .writeLine("const app = express();")
//     .writeLine("app.use(express.json());")
//     .writeLine("app.use(express.urlencoded());")
//     .blankLine();

// for (const apiPath of Object.keys(grouped).toSorted()) {
//     for (const apiMethod in grouped[apiPath]!) {
//         const calls = grouped[apiPath][apiMethod]!;

//         if (calls.length === 0) {
//             throw new Error("expected at least one call to be grouped");
//         }

//         const firstCall = calls[0]!;

//         const annotation = firstCall.annotations
//             .filter((a) => a.type === "annotation")[0]!;

//         writer.write("app.").write(annotation.name.toLowerCase())
//             .write("(");

//         const argument = annotation.arguments[0]!;
//         const path = argument.type === "string_literal"
//             ? "/" + argument.value
//             : argument.type === "field_access"
//             ? argument.object === "ApiEndPoints"
//                 ? +argument.field
//                 : null
//             : null;

//         if (path == null) {
//             throw new Error("path should never be null");
//         }

//         if (argument.type === "string_literal") {
//             writer
//                 .write("\"")
//                 .write("/" + argument.value)
//                 .write("\""); // todo: resolve path params
//         } else if (argument.type === "field_access") {
//             writer
//                 .write("\"")
//                 .write("/")
//                 .write("\"")
//                 .write(" + ")
//                 .write(argument.object + "." + argument.field);
//         } else {
//             throw new Error("unhandled");
//         }

//         writer.write(", async (req, res) => ").inlineBlock();

//         for (const call of calls) {
//             let contentType: "application/json" | "application/x-www-form-urlencoded" | "multipart/form-data";
//             const markerAnnotation = call.annotations.find((a) => a.type === "marker_annotation");
//             if (markerAnnotation == null) {
//                 contentType = "application/json";
//             } else if (markerAnnotation.name === "FormUrlEncoded") {
//                 contentType = "application/x-www-form-urlencoded";
//             } else if (markerAnnotation.name === "Multipart") {
//                 contentType = "multipart/form-data";
//             }
//         }

//         writer.write(");").blankLine();
//     }
// }

// await fs.writeFile("./generated/server.ts", writer.toString());
