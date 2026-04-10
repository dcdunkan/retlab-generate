package in.etuwa.app.data.model.hostelnew;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelNewHistory.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInstallment() {
        return this.installment;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getAdjustment() {
        return this.adjustment;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPaid() {
        return this.paid;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getWallet() {
        return this.wallet;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
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