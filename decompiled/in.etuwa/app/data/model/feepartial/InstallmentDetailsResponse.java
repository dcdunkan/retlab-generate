package in.etuwa.app.data.model.feepartial;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InstallmentDetailsResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class InstallmentDetailsResponse {
    private final ArrayList<InstallmentDetails> installments;
    private final boolean login;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InstallmentDetailsResponse copy$default(InstallmentDetailsResponse installmentDetailsResponse, boolean z, boolean z2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = installmentDetailsResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = installmentDetailsResponse.success;
        }
        if ((i & 4) != 0) {
            arrayList = installmentDetailsResponse.installments;
        }
        return installmentDetailsResponse.copy(z, z2, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<InstallmentDetails> component3() {
        return this.installments;
    }

    public final InstallmentDetailsResponse copy(boolean login, boolean success, ArrayList<InstallmentDetails> installments) {
        Intrinsics.checkNotNullParameter(installments, "installments");
        return new InstallmentDetailsResponse(login, success, installments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstallmentDetailsResponse)) {
            return false;
        }
        InstallmentDetailsResponse installmentDetailsResponse = (InstallmentDetailsResponse) other;
        return this.login == installmentDetailsResponse.login && this.success == installmentDetailsResponse.success && Intrinsics.areEqual(this.installments, installmentDetailsResponse.installments);
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
        return ((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.installments.hashCode();
    }

    public String toString() {
        return "InstallmentDetailsResponse(login=" + this.login + ", success=" + this.success + ", installments=" + this.installments + ")";
    }

    public InstallmentDetailsResponse(boolean z, boolean z2, ArrayList<InstallmentDetails> installments) {
        Intrinsics.checkNotNullParameter(installments, "installments");
        this.login = z;
        this.success = z2;
        this.installments = installments;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<InstallmentDetails> getInstallments() {
        return this.installments;
    }
}