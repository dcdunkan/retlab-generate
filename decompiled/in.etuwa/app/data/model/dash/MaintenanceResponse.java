package in.etuwa.app.data.model.dash;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaintenanceResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/data/model/dash/MaintenanceResponse;", "", "success", "", "message", "", "(ZLjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
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