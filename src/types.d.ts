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

interface Import {
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

type AnnotationArgument = {
    type: "string_literal" | "boolean_literal";
    value: string;
} | {
    type: "field_access";
    object: string;
    field: string;
};

type Annotation =
    | {
        type: "raw";
        value: "public" | "private" | "protected" | "final" | "static";
    }
    | {
        type: "marker_annotation";
        name: string;
    }
    | {
        type: "annotation";
        name: string;
        arguments: AnnotationArgument[];
    };

// https://square.github.io/retrofit/3.x/retrofit/
type ParameterAnnotationModifier =
    | { type: "field"; name: string }
    | { type: "part"; name: string; isMultibodyPart: boolean }
    | { type: "field_map"; encoded: boolean }
    | { type: "part_map" }
    | { type: "body" }
    | { type: "path"; param: string };

interface ApiMethodField {
    name: string;
    type: ResolvedType;
    required: boolean;
    annotation?: ParameterAnnotationModifier;
}

interface ApiMethodCall {
    name: string;
    type: ResolvedType;
    fields: ApiMethodField[];
    annotations: Annotation[];
}
