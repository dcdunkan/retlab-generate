package in.etuwa.app.data.model.feemedical;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeesMed.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class FeesMed {
    private final String installment_id;
    private final String installment_name;
    private final ArrayList<InstallmentsMed> installments;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeesMed copy$default(FeesMed feesMed, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = feesMed.installment_id;
        }
        if ((i & 2) != 0) {
            str2 = feesMed.installment_name;
        }
        if ((i & 4) != 0) {
            arrayList = feesMed.installments;
        }
        return feesMed.copy(str, str2, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInstallment_id() {
        return this.installment_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getInstallment_name() {
        return this.installment_name;
    }

    public final ArrayList<InstallmentsMed> component3() {
        return this.installments;
    }

    public final FeesMed copy(String installment_id, String installment_name, ArrayList<InstallmentsMed> installments) {
        Intrinsics.checkNotNullParameter(installment_id, "installment_id");
        Intrinsics.checkNotNullParameter(installment_name, "installment_name");
        Intrinsics.checkNotNullParameter(installments, "installments");
        return new FeesMed(installment_id, installment_name, installments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeesMed)) {
            return false;
        }
        FeesMed feesMed = (FeesMed) other;
        return Intrinsics.areEqual(this.installment_id, feesMed.installment_id) && Intrinsics.areEqual(this.installment_name, feesMed.installment_name) && Intrinsics.areEqual(this.installments, feesMed.installments);
    }

    public int hashCode() {
        return (((this.installment_id.hashCode() * 31) + this.installment_name.hashCode()) * 31) + this.installments.hashCode();
    }

    public String toString() {
        return "FeesMed(installment_id=" + this.installment_id + ", installment_name=" + this.installment_name + ", installments=" + this.installments + ")";
    }

    public FeesMed(String installment_id, String installment_name, ArrayList<InstallmentsMed> installments) {
        Intrinsics.checkNotNullParameter(installment_id, "installment_id");
        Intrinsics.checkNotNullParameter(installment_name, "installment_name");
        Intrinsics.checkNotNullParameter(installments, "installments");
        this.installment_id = installment_id;
        this.installment_name = installment_name;
        this.installments = installments;
    }

    public final String getInstallment_id() {
        return this.installment_id;
    }

    public final String getInstallment_name() {
        return this.installment_name;
    }

    public final ArrayList<InstallmentsMed> getInstallments() {
        return this.installments;
    }
}