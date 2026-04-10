package in.etuwa.app.data.model.transportpalai.registration;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RegisterSucessResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class RegisterSucessResponse {
    private final String error;
    private final boolean login;
    private final String message;
    private final boolean success;

    public static /* synthetic */ RegisterSucessResponse copy$default(RegisterSucessResponse registerSucessResponse, boolean z, boolean z2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = registerSucessResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = registerSucessResponse.success;
        }
        if ((i & 4) != 0) {
            str = registerSucessResponse.message;
        }
        if ((i & 8) != 0) {
            str2 = registerSucessResponse.error;
        }
        return registerSucessResponse.copy(z, z2, str, str2);
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

    public final RegisterSucessResponse copy(boolean login, boolean success, String message, String error) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(error, "error");
        return new RegisterSucessResponse(login, success, message, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisterSucessResponse)) {
            return false;
        }
        RegisterSucessResponse registerSucessResponse = (RegisterSucessResponse) other;
        return this.login == registerSucessResponse.login && this.success == registerSucessResponse.success && Intrinsics.areEqual(this.message, registerSucessResponse.message) && Intrinsics.areEqual(this.error, registerSucessResponse.error);
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
        return "RegisterSucessResponse(login=" + this.login + ", success=" + this.success + ", message=" + this.message + ", error=" + this.error + ")";
    }

    public RegisterSucessResponse(boolean z, boolean z2, String message, String error) {
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