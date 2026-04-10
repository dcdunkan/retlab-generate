package in.etuwa.app.data.model.feemedical;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeesMedResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class FeesMedResponse {
    private final ArrayList<FeesMed> fees;
    private final boolean login;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeesMedResponse copy$default(FeesMedResponse feesMedResponse, boolean z, boolean z2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = feesMedResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = feesMedResponse.success;
        }
        if ((i & 4) != 0) {
            arrayList = feesMedResponse.fees;
        }
        return feesMedResponse.copy(z, z2, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<FeesMed> component3() {
        return this.fees;
    }

    public final FeesMedResponse copy(boolean login, boolean success, ArrayList<FeesMed> fees) {
        Intrinsics.checkNotNullParameter(fees, "fees");
        return new FeesMedResponse(login, success, fees);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeesMedResponse)) {
            return false;
        }
        FeesMedResponse feesMedResponse = (FeesMedResponse) other;
        return this.login == feesMedResponse.login && this.success == feesMedResponse.success && Intrinsics.areEqual(this.fees, feesMedResponse.fees);
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
        return ((i + (z2 ? 1 : z2)) * 31) + this.fees.hashCode();
    }

    public String toString() {
        return "FeesMedResponse(login=" + this.login + ", success=" + this.success + ", fees=" + this.fees + ")";
    }

    public FeesMedResponse(boolean z, boolean z2, ArrayList<FeesMed> fees) {
        Intrinsics.checkNotNullParameter(fees, "fees");
        this.login = z;
        this.success = z2;
        this.fees = fees;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<FeesMed> getFees() {
        return this.fees;
    }
}