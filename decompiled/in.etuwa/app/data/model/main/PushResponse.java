package in.etuwa.app.data.model.main;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class PushResponse {

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("success")
    @Expose
    private final boolean success;

    public static /* synthetic */ PushResponse copy$default(PushResponse pushResponse, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pushResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = pushResponse.success;
        }
        if ((i & 4) != 0) {
            str = pushResponse.error;
        }
        return pushResponse.copy(z, z2, str);
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
    public final String getError() {
        return this.error;
    }

    public final PushResponse copy(boolean login, boolean success, String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return new PushResponse(login, success, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PushResponse)) {
            return false;
        }
        PushResponse pushResponse = (PushResponse) other;
        return this.login == pushResponse.login && this.success == pushResponse.success && Intrinsics.areEqual(this.error, pushResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "PushResponse(login=" + this.login + ", success=" + this.success + ", error=" + this.error + ")";
    }

    public PushResponse(boolean z, boolean z2, String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.success = z2;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getError() {
        return this.error;
    }
}