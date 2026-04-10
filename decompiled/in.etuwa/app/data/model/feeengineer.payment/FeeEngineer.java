package in.etuwa.app.data.model.feeengineer.payment;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeEngineer.kt */
/* loaded from: classes3.dex */
public final /* data */ class FeeEngineer {
    private final String installment_id;
    private final String installment_name;
    private final ArrayList<FeeEngineerInstallment> installments;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeeEngineer copy$default(FeeEngineer feeEngineer, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = feeEngineer.installment_id;
        }
        if ((i & 2) != 0) {
            str2 = feeEngineer.installment_name;
        }
        if ((i & 4) != 0) {
            arrayList = feeEngineer.installments;
        }
        return feeEngineer.copy(str, str2, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final String getInstallment_id() {
        return this.installment_id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getInstallment_name() {
        return this.installment_name;
    }

    public final ArrayList<FeeEngineerInstallment> component3() {
        return this.installments;
    }

    public final FeeEngineer copy(String installment_id, String installment_name, ArrayList<FeeEngineerInstallment> installments) {
        Intrinsics.checkNotNullParameter(installment_id, "installment_id");
        Intrinsics.checkNotNullParameter(installment_name, "installment_name");
        Intrinsics.checkNotNullParameter(installments, "installments");
        return new FeeEngineer(installment_id, installment_name, installments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeeEngineer)) {
            return false;
        }
        FeeEngineer feeEngineer = (FeeEngineer) other;
        return Intrinsics.areEqual(this.installment_id, feeEngineer.installment_id) && Intrinsics.areEqual(this.installment_name, feeEngineer.installment_name) && Intrinsics.areEqual(this.installments, feeEngineer.installments);
    }

    public int hashCode() {
        return (((this.installment_id.hashCode() * 31) + this.installment_name.hashCode()) * 31) + this.installments.hashCode();
    }

    public String toString() {
        return "FeeEngineer(installment_id=" + this.installment_id + ", installment_name=" + this.installment_name + ", installments=" + this.installments + ")";
    }

    public FeeEngineer(String installment_id, String installment_name, ArrayList<FeeEngineerInstallment> installments) {
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

    public final ArrayList<FeeEngineerInstallment> getInstallments() {
        return this.installments;
    }
}