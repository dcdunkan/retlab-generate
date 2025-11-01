package in.etuwa.app.data.model.feemedical;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InstallmentsMed.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jw\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006-"}, d2 = {"Lin/etuwa/app/data/model/feemedical/InstallmentsMed;", "", "date", "", "feeheadgroup_id", "feegroup_id", "feehead_id", "feehead", "fees", "scholarship", FirebaseAnalytics.Param.DISCOUNT, "payable", "paid", "balance", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBalance", "()Ljava/lang/String;", "getDate", "getDiscount", "getFeegroup_id", "getFeehead", "getFeehead_id", "getFeeheadgroup_id", "getFees", "getPaid", "getPayable", "getScholarship", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component10, reason: from getter */
    public final String getPaid() {
        return this.paid;
    }

    /* renamed from: component11, reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFeeheadgroup_id() {
        return this.feeheadgroup_id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFeegroup_id() {
        return this.feegroup_id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFeehead_id() {
        return this.feehead_id;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFeehead() {
        return this.feehead;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFees() {
        return this.fees;
    }

    /* renamed from: component7, reason: from getter */
    public final String getScholarship() {
        return this.scholarship;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDiscount() {
        return this.discount;
    }

    /* renamed from: component9, reason: from getter */
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