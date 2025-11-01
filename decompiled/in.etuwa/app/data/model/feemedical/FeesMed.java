package in.etuwa.app.data.model.feemedical;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeesMed.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/data/model/feemedical/FeesMed;", "", "installment_id", "", "installment_name", "installments", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/feemedical/InstallmentsMed;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getInstallment_id", "()Ljava/lang/String;", "getInstallment_name", "getInstallments", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getInstallment_id() {
        return this.installment_id;
    }

    /* renamed from: component2, reason: from getter */
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