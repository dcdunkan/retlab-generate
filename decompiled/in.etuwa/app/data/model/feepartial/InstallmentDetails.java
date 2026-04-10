package in.etuwa.app.data.model.feepartial;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InstallmentDetails.kt */
/* loaded from: classes3.dex */
public final /* data */ class InstallmentDetails {
    private final String balance;
    private final String date;
    private final String discount;
    private String editable_bal;
    private final String feegroup_id;
    private final String feehead;
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
    public final String getFeegroup_id() {
        return this.feegroup_id;
    }

    /* renamed from: component11, reason: from getter */
    public final String getEditable_bal() {
        return this.editable_bal;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFeehead() {
        return this.feehead;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFees() {
        return this.fees;
    }

    /* renamed from: component4, reason: from getter */
    public final String getScholarship() {
        return this.scholarship;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDiscount() {
        return this.discount;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPayable() {
        return this.payable;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPaid() {
        return this.paid;
    }

    /* renamed from: component8, reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    /* renamed from: component9, reason: from getter */
    public final String getFeeheadgroup_id() {
        return this.feeheadgroup_id;
    }

    public final InstallmentDetails copy(String date, String feehead, String fees, String scholarship, String discount, String payable, String paid, String balance, String feeheadgroup_id, String feegroup_id, String editable_bal) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(feehead, "feehead");
        Intrinsics.checkNotNullParameter(fees, "fees");
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        Intrinsics.checkNotNullParameter(discount, "discount");
        Intrinsics.checkNotNullParameter(payable, "payable");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(feeheadgroup_id, "feeheadgroup_id");
        Intrinsics.checkNotNullParameter(feegroup_id, "feegroup_id");
        Intrinsics.checkNotNullParameter(editable_bal, "editable_bal");
        return new InstallmentDetails(date, feehead, fees, scholarship, discount, payable, paid, balance, feeheadgroup_id, feegroup_id, editable_bal);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstallmentDetails)) {
            return false;
        }
        InstallmentDetails installmentDetails = (InstallmentDetails) other;
        return Intrinsics.areEqual(this.date, installmentDetails.date) && Intrinsics.areEqual(this.feehead, installmentDetails.feehead) && Intrinsics.areEqual(this.fees, installmentDetails.fees) && Intrinsics.areEqual(this.scholarship, installmentDetails.scholarship) && Intrinsics.areEqual(this.discount, installmentDetails.discount) && Intrinsics.areEqual(this.payable, installmentDetails.payable) && Intrinsics.areEqual(this.paid, installmentDetails.paid) && Intrinsics.areEqual(this.balance, installmentDetails.balance) && Intrinsics.areEqual(this.feeheadgroup_id, installmentDetails.feeheadgroup_id) && Intrinsics.areEqual(this.feegroup_id, installmentDetails.feegroup_id) && Intrinsics.areEqual(this.editable_bal, installmentDetails.editable_bal);
    }

    public int hashCode() {
        return (((((((((((((((((((this.date.hashCode() * 31) + this.feehead.hashCode()) * 31) + this.fees.hashCode()) * 31) + this.scholarship.hashCode()) * 31) + this.discount.hashCode()) * 31) + this.payable.hashCode()) * 31) + this.paid.hashCode()) * 31) + this.balance.hashCode()) * 31) + this.feeheadgroup_id.hashCode()) * 31) + this.feegroup_id.hashCode()) * 31) + this.editable_bal.hashCode();
    }

    public String toString() {
        return "InstallmentDetails(date=" + this.date + ", feehead=" + this.feehead + ", fees=" + this.fees + ", scholarship=" + this.scholarship + ", discount=" + this.discount + ", payable=" + this.payable + ", paid=" + this.paid + ", balance=" + this.balance + ", feeheadgroup_id=" + this.feeheadgroup_id + ", feegroup_id=" + this.feegroup_id + ", editable_bal=" + this.editable_bal + ")";
    }

    public InstallmentDetails(String date, String feehead, String fees, String scholarship, String discount, String payable, String paid, String balance, String feeheadgroup_id, String feegroup_id, String editable_bal) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(feehead, "feehead");
        Intrinsics.checkNotNullParameter(fees, "fees");
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        Intrinsics.checkNotNullParameter(discount, "discount");
        Intrinsics.checkNotNullParameter(payable, "payable");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(feeheadgroup_id, "feeheadgroup_id");
        Intrinsics.checkNotNullParameter(feegroup_id, "feegroup_id");
        Intrinsics.checkNotNullParameter(editable_bal, "editable_bal");
        this.date = date;
        this.feehead = feehead;
        this.fees = fees;
        this.scholarship = scholarship;
        this.discount = discount;
        this.payable = payable;
        this.paid = paid;
        this.balance = balance;
        this.feeheadgroup_id = feeheadgroup_id;
        this.feegroup_id = feegroup_id;
        this.editable_bal = editable_bal;
    }

    public final String getDate() {
        return this.date;
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

    public final String getFeegroup_id() {
        return this.feegroup_id;
    }

    public final String getEditable_bal() {
        return this.editable_bal;
    }

    public final void setEditable_bal(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.editable_bal = str;
    }
}