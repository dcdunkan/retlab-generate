package in.etuwa.app.data.model.transport;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransportHistory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class TransportHistory {
    private final String adjustment;
    private final String amount;
    private final int balance;
    private final String paid;
    private final String particular;

    public static /* synthetic */ TransportHistory copy$default(TransportHistory transportHistory, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = transportHistory.particular;
        }
        if ((i2 & 2) != 0) {
            str2 = transportHistory.amount;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = transportHistory.paid;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = transportHistory.adjustment;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            i = transportHistory.balance;
        }
        return transportHistory.copy(str, str5, str6, str7, i);
    }

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

    public final TransportHistory copy(String particular, String amount, String paid, String adjustment, int balance) {
        Intrinsics.checkNotNullParameter(particular, "particular");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        return new TransportHistory(particular, amount, paid, adjustment, balance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportHistory)) {
            return false;
        }
        TransportHistory transportHistory = (TransportHistory) other;
        return Intrinsics.areEqual(this.particular, transportHistory.particular) && Intrinsics.areEqual(this.amount, transportHistory.amount) && Intrinsics.areEqual(this.paid, transportHistory.paid) && Intrinsics.areEqual(this.adjustment, transportHistory.adjustment) && this.balance == transportHistory.balance;
    }

    public int hashCode() {
        return (((((((this.particular.hashCode() * 31) + this.amount.hashCode()) * 31) + this.paid.hashCode()) * 31) + this.adjustment.hashCode()) * 31) + this.balance;
    }

    public String toString() {
        return "TransportHistory(particular=" + this.particular + ", amount=" + this.amount + ", paid=" + this.paid + ", adjustment=" + this.adjustment + ", balance=" + this.balance + ")";
    }

    public TransportHistory(String particular, String amount, String paid, String adjustment, int i) {
        Intrinsics.checkNotNullParameter(particular, "particular");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        this.particular = particular;
        this.amount = amount;
        this.paid = paid;
        this.adjustment = adjustment;
        this.balance = i;
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
}