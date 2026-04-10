package in.etuwa.app.data.model.feemedical;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InstallmentsMed.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class InstallmentsMed {
    private final String balance;
    private final String date;
    private final String discount;
    private final String feegroup_id;
    private final String feehead;
    private final String feehead_id;
    private final String feeheadgroup_id;
    private final String fees;
    private final String paid;
    private final String payable;
    private final String scholarship;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPaid() {
        return this.paid;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFeeheadgroup_id() {
        return this.feeheadgroup_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFeegroup_id() {
        return this.feegroup_id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFeehead_id() {
        return this.feehead_id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFeehead() {
        return this.feehead;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFees() {
        return this.fees;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getScholarship() {
        return this.scholarship;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDiscount() {
        return this.discount;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPayable() {
        return this.payable;
    }

    public final InstallmentsMed copy(String date, String feeheadgroup_id, String feegroup_id, String feehead_id, String feehead, String fees, String scholarship, String discount, String payable, String paid, String balance) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(feeheadgroup_id, "feeheadgroup_id");
        Intrinsics.checkNotNullParameter(feegroup_id, "feegroup_id");
        Intrinsics.checkNotNullParameter(feehead_id, "feehead_id");
        Intrinsics.checkNotNullParameter(feehead, "feehead");
        Intrinsics.checkNotNullParameter(fees, "fees");
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        Intrinsics.checkNotNullParameter(discount, "discount");
        Intrinsics.checkNotNullParameter(payable, "payable");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        return new InstallmentsMed(date, feeheadgroup_id, feegroup_id, feehead_id, feehead, fees, scholarship, discount, payable, paid, balance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstallmentsMed)) {
            return false;
        }
        InstallmentsMed installmentsMed = (InstallmentsMed) other;
        return Intrinsics.areEqual(this.date, installmentsMed.date) && Intrinsics.areEqual(this.feeheadgroup_id, installmentsMed.feeheadgroup_id) && Intrinsics.areEqual(this.feegroup_id, installmentsMed.feegroup_id) && Intrinsics.areEqual(this.feehead_id, installmentsMed.feehead_id) && Intrinsics.areEqual(this.feehead, installmentsMed.feehead) && Intrinsics.areEqual(this.fees, installmentsMed.fees) && Intrinsics.areEqual(this.scholarship, installmentsMed.scholarship) && Intrinsics.areEqual(this.discount, installmentsMed.discount) && Intrinsics.areEqual(this.payable, installmentsMed.payable) && Intrinsics.areEqual(this.paid, installmentsMed.paid) && Intrinsics.areEqual(this.balance, installmentsMed.balance);
    }

    public int hashCode() {
        return (((((((((((((((((((this.date.hashCode() * 31) + this.feeheadgroup_id.hashCode()) * 31) + this.feegroup_id.hashCode()) * 31) + this.feehead_id.hashCode()) * 31) + this.feehead.hashCode()) * 31) + this.fees.hashCode()) * 31) + this.scholarship.hashCode()) * 31) + this.discount.hashCode()) * 31) + this.payable.hashCode()) * 31) + this.paid.hashCode()) * 31) + this.balance.hashCode();
    }

    public String toString() {
        return "InstallmentsMed(date=" + this.date + ", feeheadgroup_id=" + this.feeheadgroup_id + ", feegroup_id=" + this.feegroup_id + ", feehead_id=" + this.feehead_id + ", feehead=" + this.feehead + ", fees=" + this.fees + ", scholarship=" + this.scholarship + ", discount=" + this.discount + ", payable=" + this.payable + ", paid=" + this.paid + ", balance=" + this.balance + ")";
    }

    public InstallmentsMed(String date, String feeheadgroup_id, String feegroup_id, String feehead_id, String feehead, String fees, String scholarship, String discount, String payable, String paid, String balance) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(feeheadgroup_id, "feeheadgroup_id");
        Intrinsics.checkNotNullParameter(feegroup_id, "feegroup_id");
        Intrinsics.checkNotNullParameter(feehead_id, "feehead_id");
        Intrinsics.checkNotNullParameter(feehead, "feehead");
        Intrinsics.checkNotNullParameter(fees, "fees");
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        Intrinsics.checkNotNullParameter(discount, "discount");
        Intrinsics.checkNotNullParameter(payable, "payable");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        this.date = date;
        this.feeheadgroup_id = feeheadgroup_id;
        this.feegroup_id = feegroup_id;
        this.feehead_id = feehead_id;
        this.feehead = feehead;
        this.fees = fees;
        this.scholarship = scholarship;
        this.discount = discount;
        this.payable = payable;
        this.paid = paid;
        this.balance = balance;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getFeeheadgroup_id() {
        return this.feeheadgroup_id;
    }

    public final String getFeegroup_id() {
        return this.feegroup_id;
    }

    public final String getFeehead_id() {
        return this.feehead_id;
    }

    public final String getFeehead() {
        return this.feehead;
    }

    public final String getFees() {
        return this.fees;
    }

    public final String getScholarship() {
        return this.scholarship;
    }

    public final String getDiscount() {
        return this.discount;
    }

    public final String getPayable() {
        return this.payable;
    }

    public final String getPaid() {
        return this.paid;
    }

    public final String getBalance() {
        return this.balance;
    }
}