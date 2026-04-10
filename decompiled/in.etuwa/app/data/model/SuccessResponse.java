package in.etuwa.app.data.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SuccessResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class SuccessResponse {
    private final String error;
    private final boolean login;
    private final String message;
    private final boolean success;

    public static /* synthetic */ SuccessResponse copy$default(SuccessResponse successResponse, boolean z, boolean z2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = successResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = successResponse.success;
        }
        if ((i & 4) != 0) {
            str = successResponse.message;
        }
        if ((i & 8) != 0) {
            str2 = successResponse.error;
        }
        return successResponse.copy(z, z2, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component4, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final SuccessResponse copy(boolean login, boolean success, String message, String error) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(error, "error");
        return new SuccessResponse(login, success, message, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuccessResponse)) {
            return false;
        }
        SuccessResponse successResponse = (SuccessResponse) other;
        return this.login == successResponse.login && this.success == successResponse.success && Intrinsics.areEqual(this.message, successResponse.message) && Intrinsics.areEqual(this.error, successResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.message.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "SuccessResponse(login=" + this.login + ", success=" + this.success + ", message=" + this.message + ", error=" + this.error + ")";
    }

    public SuccessResponse(boolean z, boolean z2, String message, String error) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.success = z2;
        this.message = message;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getError() {
        return this.error;
    }
}