package in.etuwa.app.data.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemRegSuccessResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/data/model/SemRegSuccessResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "success", "message", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "(ZZLjava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getLogin", "()Z", "getMessage", "getSuccess", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SemRegSuccessResponse {
    private final String error;
    private final boolean login;
    private final String message;
    private final boolean success;

    public static /* synthetic */ SemRegSuccessResponse copy$default(SemRegSuccessResponse semRegSuccessResponse, boolean z, boolean z2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = semRegSuccessResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = semRegSuccessResponse.success;
        }
        if ((i & 4) != 0) {
            str = semRegSuccessResponse.message;
        }
        if ((i & 8) != 0) {
            str2 = semRegSuccessResponse.error;
        }
        return semRegSuccessResponse.copy(z, z2, str, str2);
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

    public final SemRegSuccessResponse copy(boolean login, boolean success, String message, String error) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(error, "error");
        return new SemRegSuccessResponse(login, success, message, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemRegSuccessResponse)) {
            return false;
        }
        SemRegSuccessResponse semRegSuccessResponse = (SemRegSuccessResponse) other;
        return this.login == semRegSuccessResponse.login && this.success == semRegSuccessResponse.success && Intrinsics.areEqual(this.message, semRegSuccessResponse.message) && Intrinsics.areEqual(this.error, semRegSuccessResponse.error);
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
        return "SemRegSuccessResponse(login=" + this.login + ", success=" + this.success + ", message=" + this.message + ", error=" + this.error + ")";
    }

    public SemRegSuccessResponse(boolean z, boolean z2, String message, String error) {
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