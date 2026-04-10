package in.etuwa.app.data.model.feeengineer.payment;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeeEngineerInstallment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class FeeEngineerInstallment {
    private final String balance;
    private final String discount;
    private final String feehead;
    private final String feeheadgroup_id;
    private final String fees;
    private final String paid;
    private final String payable;
    private final String scholarship;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFeehead() {
        return this.feehead;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFees() {
        return this.fees;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getScholarship() {
        return this.scholarship;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDiscount() {
        return this.discount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPayable() {
        return this.payable;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPaid() {
        return this.paid;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getFeeheadgroup_id() {
        return this.feeheadgroup_id;
    }

    public final FeeEngineerInstallment copy(String feehead, String fees, String scholarship, String discount, String payable, String paid, String balance, String feeheadgroup_id) {
        Intrinsics.checkNotNullParameter(feehead, "feehead");
        Intrinsics.checkNotNullParameter(fees, "fees");
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        Intrinsics.checkNotNullParameter(discount, "discount");
        Intrinsics.checkNotNullParameter(payable, "payable");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(feeheadgroup_id, "feeheadgroup_id");
        return new FeeEngineerInstallment(feehead, fees, scholarship, discount, payable, paid, balance, feeheadgroup_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeeEngineerInstallment)) {
            return false;
        }
        FeeEngineerInstallment feeEngineerInstallment = (FeeEngineerInstallment) other;
        return Intrinsics.areEqual(this.feehead, feeEngineerInstallment.feehead) && Intrinsics.areEqual(this.fees, feeEngineerInstallment.fees) && Intrinsics.areEqual(this.scholarship, feeEngineerInstallment.scholarship) && Intrinsics.areEqual(this.discount, feeEngineerInstallment.discount) && Intrinsics.areEqual(this.payable, feeEngineerInstallment.payable) && Intrinsics.areEqual(this.paid, feeEngineerInstallment.paid) && Intrinsics.areEqual(this.balance, feeEngineerInstallment.balance) && Intrinsics.areEqual(this.feeheadgroup_id, feeEngineerInstallment.feeheadgroup_id);
    }

    public int hashCode() {
        return (((((((((((((this.feehead.hashCode() * 31) + this.fees.hashCode()) * 31) + this.scholarship.hashCode()) * 31) + this.discount.hashCode()) * 31) + this.payable.hashCode()) * 31) + this.paid.hashCode()) * 31) + this.balance.hashCode()) * 31) + this.feeheadgroup_id.hashCode();
    }

    public String toString() {
        return "FeeEngineerInstallment(feehead=" + this.feehead + ", fees=" + this.fees + ", scholarship=" + this.scholarship + ", discount=" + this.discount + ", payable=" + this.payable + ", paid=" + this.paid + ", balance=" + this.balance + ", feeheadgroup_id=" + this.feeheadgroup_id + ")";
    }

    public FeeEngineerInstallment(String feehead, String fees, String scholarship, String discount, String payable, String paid, String balance, String feeheadgroup_id) {
        Intrinsics.checkNotNullParameter(feehead, "feehead");
        Intrinsics.checkNotNullParameter(fees, "fees");
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        Intrinsics.checkNotNullParameter(discount, "discount");
        Intrinsics.checkNotNullParameter(payable, "payable");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(feeheadgroup_id, "feeheadgroup_id");
        this.feehead = feehead;
        this.fees = fees;
        this.scholarship = scholarship;
        this.discount = discount;
        this.payable = payable;
        this.paid = paid;
        this.balance = balance;
        this.feeheadgroup_id = feeheadgroup_id;
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

    public final String getFeeheadgroup_id() {
        return this.feeheadgroup_id;
    }
}