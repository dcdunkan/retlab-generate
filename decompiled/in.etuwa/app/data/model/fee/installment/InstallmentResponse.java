package in.etuwa.app.data.model.fee.installment;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InstallmentResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class InstallmentResponse {

    @SerializedName("installments")
    @Expose
    private final ArrayList<Installments> installments;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("message")
    @Expose
    private final String message;

    @SerializedName("success")
    @Expose
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InstallmentResponse copy$default(InstallmentResponse installmentResponse, boolean z, boolean z2, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = installmentResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = installmentResponse.success;
        }
        if ((i & 4) != 0) {
            arrayList = installmentResponse.installments;
        }
        if ((i & 8) != 0) {
            str = installmentResponse.message;
        }
        return installmentResponse.copy(z, z2, arrayList, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<Installments> component3() {
        return this.installments;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final InstallmentResponse copy(boolean login, boolean success, ArrayList<Installments> installments, String message) {
        Intrinsics.checkNotNullParameter(installments, "installments");
        Intrinsics.checkNotNullParameter(message, "message");
        return new InstallmentResponse(login, success, installments, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstallmentResponse)) {
            return false;
        }
        InstallmentResponse installmentResponse = (InstallmentResponse) other;
        return this.login == installmentResponse.login && this.success == installmentResponse.success && Intrinsics.areEqual(this.installments, installmentResponse.installments) && Intrinsics.areEqual(this.message, installmentResponse.message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((((i + (z2 ? 1 : z2)) * 31) + this.installments.hashCode()) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "InstallmentResponse(login=" + this.login + ", success=" + this.success + ", installments=" + this.installments + ", message=" + this.message + ")";
    }

    public InstallmentResponse(boolean z, boolean z2, ArrayList<Installments> installments, String message) {
        Intrinsics.checkNotNullParameter(installments, "installments");
        Intrinsics.checkNotNullParameter(message, "message");
        this.login = z;
        this.success = z2;
        this.installments = installments;
        this.message = message;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<Installments> getInstallments() {
        return this.installments;
    }

    public final String getMessage() {
        return this.message;
    }
}