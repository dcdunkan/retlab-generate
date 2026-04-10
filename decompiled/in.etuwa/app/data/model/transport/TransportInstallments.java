package in.etuwa.app.data.model.transport;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransportInstallments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class TransportInstallments {
    private final String adjustment;
    private final String amount;
    private final int balance;
    private final boolean fullpaid;
    private final String head_id;
    private final String installment_id;
    private final String paid;
    private final String particular;
    private final int totalAmount;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getParticular() {
        return this.particular;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPaid() {
        return this.paid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAdjustment() {
        return this.adjustment;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getBalance() {
        return this.balance;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getFullpaid() {
        return this.fullpaid;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getTotalAmount() {
        return this.totalAmount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getInstallment_id() {
        return this.installment_id;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getHead_id() {
        return this.head_id;
    }

    public final TransportInstallments copy(String particular, String amount, String paid, String adjustment, int balance, boolean fullpaid, int totalAmount, String installment_id, String head_id) {
        Intrinsics.checkNotNullParameter(particular, "particular");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        Intrinsics.checkNotNullParameter(installment_id, "installment_id");
        Intrinsics.checkNotNullParameter(head_id, "head_id");
        return new TransportInstallments(particular, amount, paid, adjustment, balance, fullpaid, totalAmount, installment_id, head_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportInstallments)) {
            return false;
        }
        TransportInstallments transportInstallments = (TransportInstallments) other;
        return Intrinsics.areEqual(this.particular, transportInstallments.particular) && Intrinsics.areEqual(this.amount, transportInstallments.amount) && Intrinsics.areEqual(this.paid, transportInstallments.paid) && Intrinsics.areEqual(this.adjustment, transportInstallments.adjustment) && this.balance == transportInstallments.balance && this.fullpaid == transportInstallments.fullpaid && this.totalAmount == transportInstallments.totalAmount && Intrinsics.areEqual(this.installment_id, transportInstallments.installment_id) && Intrinsics.areEqual(this.head_id, transportInstallments.head_id);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    public int hashCode() {
        int iHashCode = ((((((((this.particular.hashCode() * 31) + this.amount.hashCode()) * 31) + this.paid.hashCode()) * 31) + this.adjustment.hashCode()) * 31) + this.balance) * 31;
        boolean z = this.fullpaid;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((iHashCode + r1) * 31) + this.totalAmount) * 31) + this.installment_id.hashCode()) * 31) + this.head_id.hashCode();
    }

    public String toString() {
        return "TransportInstallments(particular=" + this.particular + ", amount=" + this.amount + ", paid=" + this.paid + ", adjustment=" + this.adjustment + ", balance=" + this.balance + ", fullpaid=" + this.fullpaid + ", totalAmount=" + this.totalAmount + ", installment_id=" + this.installment_id + ", head_id=" + this.head_id + ")";
    }

    public TransportInstallments(String particular, String amount, String paid, String adjustment, int i, boolean z, int i2, String installment_id, String head_id) {
        Intrinsics.checkNotNullParameter(particular, "particular");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        Intrinsics.checkNotNullParameter(installment_id, "installment_id");
        Intrinsics.checkNotNullParameter(head_id, "head_id");
        this.particular = particular;
        this.amount = amount;
        this.paid = paid;
        this.adjustment = adjustment;
        this.balance = i;
        this.fullpaid = z;
        this.totalAmount = i2;
        this.installment_id = installment_id;
        this.head_id = head_id;
    }

    public final String getParticular() {
        return this.particular;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getPaid() {
        return this.paid;
    }

    public final String getAdjustment() {
        return this.adjustment;
    }

    public final int getBalance() {
        return this.balance;
    }

    public final boolean getFullpaid() {
        return this.fullpaid;
    }

    public final int getTotalAmount() {
        return this.totalAmount;
    }

    public final String getInstallment_id() {
        return this.installment_id;
    }

    public final String getHead_id() {
        return this.head_id;
    }
}