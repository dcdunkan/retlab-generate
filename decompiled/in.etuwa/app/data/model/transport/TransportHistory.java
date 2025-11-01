package in.etuwa.app.data.model.transport;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TransportHistory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/data/model/transport/TransportHistory;", "", "particular", "", ExamSubjectDetailDialogKt.ARG_AMOUNT, "paid", "adjustment", "balance", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAdjustment", "()Ljava/lang/String;", "getAmount", "getBalance", "()I", "getPaid", "getParticular", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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