package in.etuwa.app.ui.dashboard.maintenance;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ExceptionClass.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\u0007"}, d2 = {"handleMaintenanceResponse", "", "responseCode", "", "responseBody", "", "main", "app_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
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