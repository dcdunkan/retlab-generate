package in.etuwa.app.data.model.feearts.payment;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeArts.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006+"}, d2 = {"Lin/etuwa/app/data/model/feearts/payment/FeeArts;", "", "name", "", ExamSubjectDetailDialogKt.ARG_AMOUNT, "scholarship", "", "paid", "balance", "payable", "fee_head_id", "feetype_id", "feegroup_id", "installment_id", "(Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getBalance", "()I", "getFee_head_id", "getFeegroup_id", "getFeetype_id", "getInstallment_id", "getName", "getPaid", "getPayable", "getScholarship", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FeeArts {
    private final String amount;
    private final int balance;
    private final String fee_head_id;
    private final String feegroup_id;
    private final String feetype_id;
    private final String installment_id;
    private final String name;
    private final int paid;
    private final int payable;
    private final int scholarship;

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final String getInstallment_id() {
        return this.installment_id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getScholarship() {
        return this.scholarship;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPaid() {
        return this.paid;
    }

    /* renamed from: component5, reason: from getter */
    public final int getBalance() {
        return this.balance;
    }

    /* renamed from: component6, reason: from getter */
    public final int getPayable() {
        return this.payable;
    }

    /* renamed from: component7, reason: from getter */
    public final String getFee_head_id() {
        return this.fee_head_id;
    }

    /* renamed from: component8, reason: from getter */
    public final String getFeetype_id() {
        return this.feetype_id;
    }

    /* renamed from: component9, reason: from getter */
    public final String getFeegroup_id() {
        return this.feegroup_id;
    }

    public final FeeArts copy(String name, String amount, int scholarship, int paid, int balance, int payable, String fee_head_id, String feetype_id, String feegroup_id, String installment_id) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(fee_head_id, "fee_head_id");
        Intrinsics.checkNotNullParameter(feetype_id, "feetype_id");
        Intrinsics.checkNotNullParameter(feegroup_id, "feegroup_id");
        Intrinsics.checkNotNullParameter(installment_id, "installment_id");
        return new FeeArts(name, amount, scholarship, paid, balance, payable, fee_head_id, feetype_id, feegroup_id, installment_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeeArts)) {
            return false;
        }
        FeeArts feeArts = (FeeArts) other;
        return Intrinsics.areEqual(this.name, feeArts.name) && Intrinsics.areEqual(this.amount, feeArts.amount) && this.scholarship == feeArts.scholarship && this.paid == feeArts.paid && this.balance == feeArts.balance && this.payable == feeArts.payable && Intrinsics.areEqual(this.fee_head_id, feeArts.fee_head_id) && Intrinsics.areEqual(this.feetype_id, feeArts.feetype_id) && Intrinsics.areEqual(this.feegroup_id, feeArts.feegroup_id) && Intrinsics.areEqual(this.installment_id, feeArts.installment_id);
    }

    public int hashCode() {
        return (((((((((((((((((this.name.hashCode() * 31) + this.amount.hashCode()) * 31) + this.scholarship) * 31) + this.paid) * 31) + this.balance) * 31) + this.payable) * 31) + this.fee_head_id.hashCode()) * 31) + this.feetype_id.hashCode()) * 31) + this.feegroup_id.hashCode()) * 31) + this.installment_id.hashCode();
    }

    public String toString() {
        return "FeeArts(name=" + this.name + ", amount=" + this.amount + ", scholarship=" + this.scholarship + ", paid=" + this.paid + ", balance=" + this.balance + ", payable=" + this.payable + ", fee_head_id=" + this.fee_head_id + ", feetype_id=" + this.feetype_id + ", feegroup_id=" + this.feegroup_id + ", installment_id=" + this.installment_id + ")";
    }

    public FeeArts(String name, String amount, int i, int i2, int i3, int i4, String fee_head_id, String feetype_id, String feegroup_id, String installment_id) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(fee_head_id, "fee_head_id");
        Intrinsics.checkNotNullParameter(feetype_id, "feetype_id");
        Intrinsics.checkNotNullParameter(feegroup_id, "feegroup_id");
        Intrinsics.checkNotNullParameter(installment_id, "installment_id");
        this.name = name;
        this.amount = amount;
        this.scholarship = i;
        this.paid = i2;
        this.balance = i3;
        this.payable = i4;
        this.fee_head_id = fee_head_id;
        this.feetype_id = feetype_id;
        this.feegroup_id = feegroup_id;
        this.installment_id = installment_id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final int getScholarship() {
        return this.scholarship;
    }

    public final int getPaid() {
        return this.paid;
    }

    public final int getBalance() {
        return this.balance;
    }

    public final int getPayable() {
        return this.payable;
    }

    public final String getFee_head_id() {
        return this.fee_head_id;
    }

    public final String getFeetype_id() {
        return this.feetype_id;
    }

    public final String getFeegroup_id() {
        return this.feegroup_id;
    }

    public final String getInstallment_id() {
        return this.installment_id;
    }
}