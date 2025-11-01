package in.etuwa.app.data.model.main;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApplyHostelResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/data/model/main/ApplyHostelResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "success", "hostel", "", "hostelStatus", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "(ZZILjava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getHostel", "()I", "getHostelStatus", "getLogin", "()Z", "getSuccess", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ApplyHostelResponse {

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName("hostel")
    @Expose
    private final int hostel;

    @SerializedName("hostel_status")
    @Expose
    private final String hostelStatus;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("success")
    @Expose
    private final boolean success;

    public static /* synthetic */ ApplyHostelResponse copy$default(ApplyHostelResponse applyHostelResponse, boolean z, boolean z2, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = applyHostelResponse.login;
        }
        if ((i2 & 2) != 0) {
            z2 = applyHostelResponse.success;
        }
        boolean z3 = z2;
        if ((i2 & 4) != 0) {
            i = applyHostelResponse.hostel;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str = applyHostelResponse.hostelStatus;
        }
        String str3 = str;
        if ((i2 & 16) != 0) {
            str2 = applyHostelResponse.error;
        }
        return applyHostelResponse.copy(z, z3, i3, str3, str2);
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
    public final int getHostel() {
        return this.hostel;
    }

    /* renamed from: component4, reason: from getter */
    public final String getHostelStatus() {
        return this.hostelStatus;
    }

    /* renamed from: component5, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final ApplyHostelResponse copy(boolean login, boolean success, int hostel, String hostelStatus, String error) {
        Intrinsics.checkNotNullParameter(hostelStatus, "hostelStatus");
        Intrinsics.checkNotNullParameter(error, "error");
        return new ApplyHostelResponse(login, success, hostel, hostelStatus, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplyHostelResponse)) {
            return false;
        }
        ApplyHostelResponse applyHostelResponse = (ApplyHostelResponse) other;
        return this.login == applyHostelResponse.login && this.success == applyHostelResponse.success && this.hostel == applyHostelResponse.hostel && Intrinsics.areEqual(this.hostelStatus, applyHostelResponse.hostelStatus) && Intrinsics.areEqual(this.error, applyHostelResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((((((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.hostel) * 31) + this.hostelStatus.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "ApplyHostelResponse(login=" + this.login + ", success=" + this.success + ", hostel=" + this.hostel + ", hostelStatus=" + this.hostelStatus + ", error=" + this.error + ")";
    }

    public ApplyHostelResponse(boolean z, boolean z2, int i, String hostelStatus, String error) {
        Intrinsics.checkNotNullParameter(hostelStatus, "hostelStatus");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.success = z2;
        this.hostel = i;
        this.hostelStatus = hostelStatus;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final int getHostel() {
        return this.hostel;
    }

    public final String getHostelStatus() {
        return this.hostelStatus;
    }

    public final String getError() {
        return this.error;
    }
}