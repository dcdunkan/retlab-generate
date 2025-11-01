package in.etuwa.app.data.model.main;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeStatusResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/data/model/main/FeeStatusResponse;", "", FirebaseAnalytics.Event.LOGIN, "", NotificationCompat.CATEGORY_STATUS, Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "(ZZLjava/lang/String;)V", "getError", "()Ljava/lang/String;", "getLogin", "()Z", "getStatus", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    /* renamed from: component3, reason: from getter */
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
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.status;
        return ((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.error.hashCode();
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