package in.etuwa.app.data.model.main;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApplyHostelResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHostel() {
        return this.hostel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getHostelStatus() {
        return this.hostelStatus;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
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
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((((((i + (z2 ? 1 : z2)) * 31) + this.hostel) * 31) + this.hostelStatus.hashCode()) * 31) + this.error.hashCode();
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