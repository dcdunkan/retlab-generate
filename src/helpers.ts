import type Parser from "tree-sitter";
import {
    JAVA_GENERIC_CLASSES_TABLE,
    JAVA_WRAPPER_CLASSES_TYPES_TABLE,
    MODEL_SCOPE,
    MODEL_SCOPE_PARTS,
    SCOPE_DECLARATIONS,
    UNWRAPPABLE_CLASSES,
} from "./constants.js";

export function resolveTypeIdentifier(typeIdentifier: Parser.SyntaxNode, options: {
    currentPath: string;
    sameScopeTypeDeclarations: string[];
    imports: Record<string, Import>;
}): ResolvedType {
    switch (typeIdentifier.type) {
        case "integral_type":
            return "number";

        case "floating_point_type":
            return "number";

        case "boolean_type":
            return "boolean";

        case "void_type":
            return "void";

        case "type_identifier":
            if (
                typeIdentifier.text in JAVA_WRAPPER_CLASSES_TYPES_TABLE
                && typeof JAVA_WRAPPER_CLASSES_TYPES_TABLE[typeIdentifier.text] === "string"
            ) {
                return JAVA_WRAPPER_CLASSES_TYPES_TABLE[typeIdentifier.text]!;
            } else {
                // since its not a scoped identifier, the type identifier must be in
                // the same package. so...
                if (!options.sameScopeTypeDeclarations.includes(typeIdentifier.text)) { // or imported?
                    if (typeIdentifier.text in options.imports && options.imports[typeIdentifier.text] != null) {
                        const { identifier, scope } = options.imports[typeIdentifier.text]!;
                        if (scope === "") return [identifier];
                        return [[scope, identifier].join(".")];
                    } else {
                        console.log(nodePosition(typeIdentifier, options.currentPath));
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
                    .map((child) => resolveTypeIdentifier(child, options))
                    .flat();

                if (UNWRAPPABLE_CLASSES.includes(JAVA_GENERIC_CLASSES_TABLE[type])) {
                    return typeArguments;
                } else {
                    return [JAVA_GENERIC_CLASSES_TABLE[type], typeArguments];
                }
            } else if (options.sameScopeTypeDeclarations.includes(type)) {
                throw new Error("should add to scope");
            } else {
                console.log(nodePosition(typeIdentifier, options.currentPath));
                console.log(type, typeIdentifier.text);
                throw new Error("Unhandled generic type in generic classes, must add");
            }

        case "scoped_type_identifier":
            const [scope, ...subTypes] = typeIdentifier.children.filter((t) => t.type !== ".");
            const scopeText = scope!.text;

            if (scopeText in options.imports && options.imports[scopeText] != null) {
                const scopeImport = options.imports[scopeText];

                if (scopeImport.scope in SCOPE_DECLARATIONS) {
                    const resolved: ResolvedType[] = [];
                    let parent = SCOPE_DECLARATIONS[scopeImport.scope]!;

                    for (const scopeSegment of [scope!, ...subTypes]) {
                        if (scopeSegment.text in parent && parent[scopeSegment.text] != null) {
                            resolved.push(resolveTypeIdentifier(scopeSegment, {
                                currentPath: options.currentPath,
                                imports: options.imports,
                                sameScopeTypeDeclarations: Object.keys(parent),
                            }));
                            parent = parent[scopeSegment.text]!;
                        } else {
                            console.log(nodePosition(typeIdentifier, options.currentPath));
                            throw new Error("unknown scope segment");
                        }
                    }

                    return [resolved];
                } else {
                    throw new Error("scope not declared");
                }
            } else {
                throw new Error("Should register the import in scope");
            }

        default:
            console.log(nodePosition(typeIdentifier, options.currentPath), typeIdentifier.toString());
            throw new Error("unhandled type identifier type");
    }
}

export function resolvedTypeToString(type: ResolvedType): string {
    if (typeof type === "string") {
        return type;
    } else if (Array.isArray(type)) {
        if (type.length === 1 && Array.isArray(type[0])) {
            return type[0].join(".");
        } else if (Array.isArray(type[1])) {
            return type[0] + "<" + resolvedTypeToString(type[1]) + ">";
        } else {
            return type.join(", ");
        }
    } else {
        throw new Error("should never occur");
    }
}

export function typeEquivalency(a: ResolvedType, b: ResolvedType) {
    if (typeof a === "string") {
        if (typeof b === "string") {
            return a === b;
        } else {
            return false;
        }
    }

    if (Array.isArray(a)) {
        if (Array.isArray(b)) {
            if (a.length !== b.length) {
                return false;
            }

            for (let i = 0; i < a.length; i++) {
                if (typeEquivalency(a[i]!, b[i]!) == false) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    return false;
}

export function nodePosition(node: Parser.SyntaxNode, path: string) {
    return `${path}:${node.startPosition.row + 1}:${node.startPosition.column + 1}`;
}

export function getImports(tree: Parser.Tree) {
    const imports: Record<string, Import> = {};
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

        if (identifier in imports) {
            throw new Error("two same identifiers?");
        }

        imports[identifier] = {
            identifier: identifier,
            scope: isModelIdentifier
                ? scopeParts.slice(MODEL_SCOPE_PARTS.length).join(".")
                : scopeParts.join("."),
            isModelScope: isModelIdentifier,
        };
    }
    return imports;
}

export function parseModifiers(modifiers: Parser.SyntaxNode, options: {
    currentPath: string;
    ignoreList: string[];
}): Annotation[] {
    return modifiers.children
        .filter((modifier) => !options.ignoreList.includes(modifier.type))
        .map((modifier) => {
            if (
                modifier.type === "public" || modifier.type === "private" || modifier.type === "protected"
                || modifier.type === "final" || modifier.type === "static"
            ) {
                return { type: "raw", value: modifier.type };
            } else if (modifier.type === "marker_annotation") {
                const identifier = modifier.childForFieldName("name")!;
                return {
                    type: "marker_annotation",
                    name: identifier.text,
                };
            } else if (modifier.type === "annotation") {
                const identifier = modifier.childForFieldName("name")!;
                const args = modifier.childForFieldName("arguments")!;

                const annotation: Annotation = {
                    type: "annotation",
                    name: identifier.text.trim(),
                    arguments: [],
                };

                for (const argument of args.children) {
                    if (argument.type === "(" || argument.type === ")") {
                        // ignore
                    } else if (argument.type === "field_access") {
                        const object = argument.childForFieldName("object")!;
                        const field = argument.childForFieldName("field")!;
                        if (object.text === "ApiEndPoints") {
                            annotation.arguments.push({
                                type: "field_access",
                                object: object.text,
                                field: field.text,
                            });
                        } else {
                            console.log(nodePosition(object, options.currentPath));
                            throw new Error("unhandled constant object");
                        }
                    } else if (argument.type === "string_literal") {
                        if (argument.childCount !== 3) {
                            throw new Error("invalid string_literal?");
                        }
                        annotation.arguments.push({
                            type: "string_literal",
                            value: argument.child(1)?.text!,
                        });
                    } else if (argument.type === "true" || argument.type === "false") {
                        annotation.arguments.push({
                            type: "boolean_literal",
                            value: argument.type,
                        });
                    } else {
                        throw new Error("unhandled argument type");
                    }
                }

                return annotation;
            } else {
                console.log(modifier, modifier.toString());
                console.log(nodePosition(modifier, options.currentPath));
                throw new Error("unhandled type of modifiers");
            }
        });
}

export function parseParameterAnnotationModiifer(modifier: Annotation): ParameterAnnotationModifier {
    if (modifier.type === "annotation") {
        if (modifier.arguments.length !== 1) {
            throw new Error("unhandled number of arguments");
        }
        const arg = modifier.arguments[0];
        if (arg == null) {
            throw new Error("should have at least one argument right");
        }
        if (arg.type === "string_literal") {
            if (modifier.name === "Field") {
                return { type: "field", name: arg.value };
            } else if (modifier.name === "Part") {
                return { type: "part", name: arg.value, isMultibodyPart: false };
            } else if (modifier.name === "Path") {
                return { type: "path", param: arg.value };
            } else {
                console.log(modifier);
                throw new Error("unhandled annotation modifier type (string_literal)");
            }
        } else if (arg.type === "boolean_literal") {
            if (modifier.name === "FieldMap") {
                return { type: "field_map", encoded: arg.value === "true" };
            } else {
                console.log(modifier);
                throw new Error("unhandled annotation modifier type (boolean_literal)");
            }
        } else {
            throw new Error("unhandled type of argument");
        }
    } else if (modifier.type === "marker_annotation") {
        if (modifier.name === "Part") {
            return { type: "part", isMultibodyPart: true, name: "" };
        } else if (modifier.name === "PartMap") {
            return { type: "part_map" };
        } else if (modifier.name === "FieldMap") {
            return { type: "field_map", encoded: false };
        } else if (modifier.name === "Body") {
            return { type: "body" };
        } else {
            console.log(modifier);
            throw new Error("unhandled marker_annotation modifier type");
        }
    } else {
        throw new Error("unhandled modifier type");
    }
}
