package in.etuwa.app.data.model.dash;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaintenanceResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class MaintenanceResponse {
    private final String message;
    private final boolean success;

    public static /* synthetic */ MaintenanceResponse copy$default(MaintenanceResponse maintenanceResponse, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = maintenanceResponse.success;
        }
        if ((i & 2) != 0) {
            str = maintenanceResponse.message;
        }
        return maintenanceResponse.copy(z, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final MaintenanceResponse copy(boolean success, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new MaintenanceResponse(success, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MaintenanceResponse)) {
            return false;
        }
        MaintenanceResponse maintenanceResponse = (MaintenanceResponse) other;
        return this.success == maintenanceResponse.success && Intrinsics.areEqual(this.message, maintenanceResponse.message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.message.hashCode();
    }

    public String toString() {
        return "MaintenanceResponse(success=" + this.success + ", message=" + this.message + ")";
    }

    public MaintenanceResponse(boolean z, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.success = z;
        this.message = message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getMessage() {
        return this.message;
    }
}