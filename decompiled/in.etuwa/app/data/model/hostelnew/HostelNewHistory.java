package in.etuwa.app.data.model.hostelnew;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelNewHistory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lin/etuwa/app/data/model/hostelnew/HostelNewHistory;", "", "installment", "", ExamSubjectDetailDialogKt.ARG_AMOUNT, "", "adjustment", "paid", "wallet", "balance", "(Ljava/lang/String;IIIII)V", "getAdjustment", "()I", "getAmount", "getBalance", "getInstallment", "()Ljava/lang/String;", "getPaid", "getWallet", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class HostelNewHistory {
    private final int adjustment;
    private final int amount;
    private final int balance;
    private final String installment;
    private final int paid;
    private final int wallet;

    public static /* synthetic */ HostelNewHistory copy$default(HostelNewHistory hostelNewHistory, String str, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = hostelNewHistory.installment;
        }
        if ((i6 & 2) != 0) {
            i = hostelNewHistory.amount;
        }
        int i7 = i;
        if ((i6 & 4) != 0) {
            i2 = hostelNewHistory.adjustment;
        }
        int i8 = i2;
        if ((i6 & 8) != 0) {
            i3 = hostelNewHistory.paid;
        }
        int i9 = i3;
        if ((i6 & 16) != 0) {
            i4 = hostelNewHistory.wallet;
        }
        int i10 = i4;
        if ((i6 & 32) != 0) {
            i5 = hostelNewHistory.balance;
        }
        return hostelNewHistory.copy(str, i7, i8, i9, i10, i5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getInstallment() {
        return this.installment;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getAdjustment() {
        return this.adjustment;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPaid() {
        return this.paid;
    }

    /* renamed from: component5, reason: from getter */
    public final int getWallet() {
        return this.wallet;
    }

    /* renamed from: component6, reason: from getter */
    public final int getBalance() {
        return this.balance;
    }

    public final HostelNewHistory copy(String installment, int amount, int adjustment, int paid, int wallet, int balance) {
        Intrinsics.checkNotNullParameter(installment, "installment");
        return new HostelNewHistory(installment, amount, adjustment, paid, wallet, balance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelNewHistory)) {
            return false;
        }
        HostelNewHistory hostelNewHistory = (HostelNewHistory) other;
        return Intrinsics.areEqual(this.installment, hostelNewHistory.installment) && this.amount == hostelNewHistory.amount && this.adjustment == hostelNewHistory.adjustment && this.paid == hostelNewHistory.paid && this.wallet == hostelNewHistory.wallet && this.balance == hostelNewHistory.balance;
    }

    public int hashCode() {
        return (((((((((this.installment.hashCode() * 31) + this.amount) * 31) + this.adjustment) * 31) + this.paid) * 31) + this.wallet) * 31) + this.balance;
    }

    public String toString() {
        return "HostelNewHistory(installment=" + this.installment + ", amount=" + this.amount + ", adjustment=" + this.adjustment + ", paid=" + this.paid + ", wallet=" + this.wallet + ", balance=" + this.balance + ")";
    }

    public HostelNewHistory(String installment, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(installment, "installment");
        this.installment = installment;
        this.amount = i;
        this.adjustment = i2;
        this.paid = i3;
        this.wallet = i4;
        this.balance = i5;
    }

    public final String getInstallment() {
        return this.installment;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final int getAdjustment() {
        return this.adjustment;
    }

    public final int getPaid() {
        return this.paid;
    }

    public final int getWallet() {
        return this.wallet;
    }

    public final int getBalance() {
        return this.balance;
    }
}