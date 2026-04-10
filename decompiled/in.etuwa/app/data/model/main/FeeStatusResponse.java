package in.etuwa.app.data.model.main;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeeStatusResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class FeeStatusResponse {

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    @Expose
    private final boolean status;

    public static /* synthetic */ FeeStatusResponse copy$default(FeeStatusResponse feeStatusResponse, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = feeStatusResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = feeStatusResponse.status;
        }
        if ((i & 4) != 0) {
            str = feeStatusResponse.error;
        }
        return feeStatusResponse.copy(z, z2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final FeeStatusResponse copy(boolean login, boolean status, String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return new FeeStatusResponse(login, status, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeeStatusResponse)) {
            return false;
        }
        FeeStatusResponse feeStatusResponse = (FeeStatusResponse) other;
        return this.login == feeStatusResponse.login && this.status == feeStatusResponse.status && Intrinsics.areEqual(this.error, feeStatusResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.status;
        return ((i + (z2 ? 1 : z2)) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "FeeStatusResponse(login=" + this.login + ", status=" + this.status + ", error=" + this.error + ")";
    }

    public FeeStatusResponse(boolean z, boolean z2, String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.status = z2;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final String getError() {
        return this.error;
    }
}