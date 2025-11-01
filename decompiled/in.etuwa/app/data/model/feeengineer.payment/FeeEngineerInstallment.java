package in.etuwa.app.data.model.feeengineer.payment;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeEngineerInstallment.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lin/etuwa/app/data/model/feeengineer/payment/FeeEngineerInstallment;", "", "feehead", "", "fees", "scholarship", FirebaseAnalytics.Param.DISCOUNT, "payable", "paid", "balance", "feeheadgroup_id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBalance", "()Ljava/lang/String;", "getDiscount", "getFeehead", "getFeeheadgroup_id", "getFees", "getPaid", "getPayable", "getScholarship", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FeeEngineerInstallment {
    private final String balance;
    private final String discount;
    private final String feehead;
    private final String feeheadgroup_id;
    private final String fees;
    private final String paid;
    private final String payable;
    private final String scholarship;

    /* renamed from: component1, reason: from getter */
    public final String getFeehead() {
        return this.feehead;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFees() {
        return this.fees;
    }

    /* renamed from: component3, reason: from getter */
    public final String getScholarship() {
        return this.scholarship;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDiscount() {
        return this.discount;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPayable() {
        return this.payable;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPaid() {
        return this.paid;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    /* renamed from: component8, reason: from getter */
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