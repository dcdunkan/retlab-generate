package in.etuwa.app.data.model.transport;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TransportInstallments.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jc\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\bHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u0006)"}, d2 = {"Lin/etuwa/app/data/model/transport/TransportInstallments;", "", "particular", "", ExamSubjectDetailDialogKt.ARG_AMOUNT, "paid", "adjustment", "balance", "", "fullpaid", "", "totalAmount", "installment_id", "head_id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZILjava/lang/String;Ljava/lang/String;)V", "getAdjustment", "()Ljava/lang/String;", "getAmount", "getBalance", "()I", "getFullpaid", "()Z", "getHead_id", "getInstallment_id", "getPaid", "getParticular", "getTotalAmount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getParticular() {
        return this.particular;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPaid() {
        return this.paid;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAdjustment() {
        return this.adjustment;
    }

    /* renamed from: component5, reason: from getter */
    public final int getBalance() {
        return this.balance;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getFullpaid() {
        return this.fullpaid;
    }

    /* renamed from: component7, reason: from getter */
    public final int getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component8, reason: from getter */
    public final String getInstallment_id() {
        return this.installment_id;
    }

    /* renamed from: component9, reason: from getter */
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
    public int hashCode() {
        int hashCode = ((((((((this.particular.hashCode() * 31) + this.amount.hashCode()) * 31) + this.paid.hashCode()) * 31) + this.adjustment.hashCode()) * 31) + this.balance) * 31;
        boolean z = this.fullpaid;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((((((hashCode + i) * 31) + this.totalAmount) * 31) + this.installment_id.hashCode()) * 31) + this.head_id.hashCode();
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