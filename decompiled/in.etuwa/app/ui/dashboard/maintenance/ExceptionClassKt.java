package in.etuwa.app.ui.dashboard.maintenance;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExceptionClass.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ExceptionClassKt {
    public static final void handleMaintenanceResponse(int i, String responseBody) {
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        if (i == 403) {
            ExceptionClass exceptionClass = new ExceptionClass(403, new JSONObject(responseBody).optString("message", "Unknown error"), null, 4, null);
            System.out.println((Object) ("Custom error occurred: " + exceptionClass.getErrorCode() + " - " + exceptionClass.getMessage()));
            return;
        }
        System.out.println((Object) ("Unhandled response code: " + i));
    }

    public static final void main() {
        handleMaintenanceResponse(403, "{\"success\":false,\"message\":\"Under Maintenance\"}");
    }
}