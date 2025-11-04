export const IDENTIFIER_REGEX = /^[a-zA-Z_$][a-zA-Z_$0-9]*$/;

export const MODELS_DIR = ["decompiled", "in.etuwa", "app", "data", "model"];
export const MODEL_SCOPE = "in.etuwa.app.data.model";
export const MODEL_SCOPE_PARTS = MODEL_SCOPE.split(".");

export const JAVA_WRAPPER_CLASSES_TYPES_TABLE: Record<string, string> = {
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

export const UNWRAPPABLE_CLASSES = ["Awaited"];

export const JAVA_GENERIC_CLASSES_TABLE: Record<string, string> = {
    "ArrayList": "Array",
    "List": "Array",
    "Map": "Map",
    "HashMap": "Map",

    // todo: revisit these:
    "Single": "Awaited",
    "Observable": "Awaited",
    "Response": "Awaited",
};

export const FIELD_ACCESS_TABLE_CONSTANTS: Record<string, string> = {
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

type ScopeDeclarations = { [scope: string]: ScopeDeclarations };

export const SCOPE_DECLARATIONS: ScopeDeclarations = {
    "okhttp3": {
        "MultipartBody": {
            "Part": {},
        },
    },
};
