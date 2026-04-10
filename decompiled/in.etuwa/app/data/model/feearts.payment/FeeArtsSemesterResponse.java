package in.etuwa.app.data.model.feearts.payment;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeeArtsSemesterResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class FeeArtsSemesterResponse {
    private final ArrayList<FeeArtsSemester> installments;
    private final boolean login;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeeArtsSemesterResponse copy$default(FeeArtsSemesterResponse feeArtsSemesterResponse, boolean z, boolean z2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = feeArtsSemesterResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = feeArtsSemesterResponse.success;
        }
        if ((i & 4) != 0) {
            arrayList = feeArtsSemesterResponse.installments;
        }
        return feeArtsSemesterResponse.copy(z, z2, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<FeeArtsSemester> component3() {
        return this.installments;
    }

    public final FeeArtsSemesterResponse copy(boolean login, boolean success, ArrayList<FeeArtsSemester> installments) {
        Intrinsics.checkNotNullParameter(installments, "installments");
        return new FeeArtsSemesterResponse(login, success, installments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeeArtsSemesterResponse)) {
            return false;
        }
        FeeArtsSemesterResponse feeArtsSemesterResponse = (FeeArtsSemesterResponse) other;
        return this.login == feeArtsSemesterResponse.login && this.success == feeArtsSemesterResponse.success && Intrinsics.areEqual(this.installments, feeArtsSemesterResponse.installments);
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
        boolean z2 = this.success;
        return ((i + (z2 ? 1 : z2)) * 31) + this.installments.hashCode();
    }

    public String toString() {
        return "FeeArtsSemesterResponse(login=" + this.login + ", success=" + this.success + ", installments=" + this.installments + ")";
    }

    public FeeArtsSemesterResponse(boolean z, boolean z2, ArrayList<FeeArtsSemester> installments) {
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

    public final ArrayList<FeeArtsSemester> getInstallments() {
        return this.installments;
    }
}