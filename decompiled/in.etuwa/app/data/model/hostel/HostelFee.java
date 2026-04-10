package in.etuwa.app.data.model.hostel;

import androidx.core.app.NotificationCompat;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelFee.kt */
/* loaded from: classes3.dex */
public final /* data */ class HostelFee {
    private final int adjustment;
    private final String amount;
    private final int balance;
    private final String feegroup_id;
    private final String feehead_id;
    private final String feeheadgroup_id;
    private final String feetype;
    private final int fine;
    private final String hostel_id;
    private final int installment;
    private final String name;
    private final int paid;
    private final int payable;
    private final String scholarship;
    private final int status;
    private final String tenant_id;
    private final String user_id;

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final int getPaid() {
        return this.paid;
    }

    /* renamed from: component11, reason: from getter */
    public final int getBalance() {
        return this.balance;
    }

    /* renamed from: component12, reason: from getter */
    public final int getPayable() {
        return this.payable;
    }

    /* renamed from: component13, reason: from getter */
    public final String getScholarship() {
        return this.scholarship;
    }

    /* renamed from: component14, reason: from getter */
    public final String getUser_id() {
        return this.user_id;
    }

    /* renamed from: component15, reason: from getter */
    public final int getAdjustment() {
        return this.adjustment;
    }

    /* renamed from: component16, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component17, reason: from getter */
    public final int getFine() {
        return this.fine;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHostel_id() {
        return this.hostel_id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTenant_id() {
        return this.tenant_id;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFeetype() {
        return this.feetype;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFeeheadgroup_id() {
        return this.feeheadgroup_id;
    }

    /* renamed from: component7, reason: from getter */
    public final String getFeegroup_id() {
        return this.feegroup_id;
    }

    /* renamed from: component8, reason: from getter */
    public final String getFeehead_id() {
        return this.feehead_id;
    }

    /* renamed from: component9, reason: from getter */
    public final int getInstallment() {
        return this.installment;
    }

    public final HostelFee copy(String name, String amount, String hostel_id, String tenant_id, String feetype, String feeheadgroup_id, String feegroup_id, String feehead_id, int installment, int paid, int balance, int payable, String scholarship, String user_id, int adjustment, int status, int fine) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(hostel_id, "hostel_id");
        Intrinsics.checkNotNullParameter(tenant_id, "tenant_id");
        Intrinsics.checkNotNullParameter(feetype, "feetype");
        Intrinsics.checkNotNullParameter(feeheadgroup_id, "feeheadgroup_id");
        Intrinsics.checkNotNullParameter(feegroup_id, "feegroup_id");
        Intrinsics.checkNotNullParameter(feehead_id, "feehead_id");
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        Intrinsics.checkNotNullParameter(user_id, "user_id");
        return new HostelFee(name, amount, hostel_id, tenant_id, feetype, feeheadgroup_id, feegroup_id, feehead_id, installment, paid, balance, payable, scholarship, user_id, adjustment, status, fine);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelFee)) {
            return false;
        }
        HostelFee hostelFee = (HostelFee) other;
        return Intrinsics.areEqual(this.name, hostelFee.name) && Intrinsics.areEqual(this.amount, hostelFee.amount) && Intrinsics.areEqual(this.hostel_id, hostelFee.hostel_id) && Intrinsics.areEqual(this.tenant_id, hostelFee.tenant_id) && Intrinsics.areEqual(this.feetype, hostelFee.feetype) && Intrinsics.areEqual(this.feeheadgroup_id, hostelFee.feeheadgroup_id) && Intrinsics.areEqual(this.feegroup_id, hostelFee.feegroup_id) && Intrinsics.areEqual(this.feehead_id, hostelFee.feehead_id) && this.installment == hostelFee.installment && this.paid == hostelFee.paid && this.balance == hostelFee.balance && this.payable == hostelFee.payable && Intrinsics.areEqual(this.scholarship, hostelFee.scholarship) && Intrinsics.areEqual(this.user_id, hostelFee.user_id) && this.adjustment == hostelFee.adjustment && this.status == hostelFee.status && this.fine == hostelFee.fine;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.name.hashCode() * 31) + this.amount.hashCode()) * 31) + this.hostel_id.hashCode()) * 31) + this.tenant_id.hashCode()) * 31) + this.feetype.hashCode()) * 31) + this.feeheadgroup_id.hashCode()) * 31) + this.feegroup_id.hashCode()) * 31) + this.feehead_id.hashCode()) * 31) + this.installment) * 31) + this.paid) * 31) + this.balance) * 31) + this.payable) * 31) + this.scholarship.hashCode()) * 31) + this.user_id.hashCode()) * 31) + this.adjustment) * 31) + this.status) * 31) + this.fine;
    }

    public String toString() {
        return "HostelFee(name=" + this.name + ", amount=" + this.amount + ", hostel_id=" + this.hostel_id + ", tenant_id=" + this.tenant_id + ", feetype=" + this.feetype + ", feeheadgroup_id=" + this.feeheadgroup_id + ", feegroup_id=" + this.feegroup_id + ", feehead_id=" + this.feehead_id + ", installment=" + this.installment + ", paid=" + this.paid + ", balance=" + this.balance + ", payable=" + this.payable + ", scholarship=" + this.scholarship + ", user_id=" + this.user_id + ", adjustment=" + this.adjustment + ", status=" + this.status + ", fine=" + this.fine + ")";
    }

    public HostelFee(String name, String amount, String hostel_id, String tenant_id, String feetype, String feeheadgroup_id, String feegroup_id, String feehead_id, int i, int i2, int i3, int i4, String scholarship, String user_id, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(hostel_id, "hostel_id");
        Intrinsics.checkNotNullParameter(tenant_id, "tenant_id");
        Intrinsics.checkNotNullParameter(feetype, "feetype");
        Intrinsics.checkNotNullParameter(feeheadgroup_id, "feeheadgroup_id");
        Intrinsics.checkNotNullParameter(feegroup_id, "feegroup_id");
        Intrinsics.checkNotNullParameter(feehead_id, "feehead_id");
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        Intrinsics.checkNotNullParameter(user_id, "user_id");
        this.name = name;
        this.amount = amount;
        this.hostel_id = hostel_id;
        this.tenant_id = tenant_id;
        this.feetype = feetype;
        this.feeheadgroup_id = feeheadgroup_id;
        this.feegroup_id = feegroup_id;
        this.feehead_id = feehead_id;
        this.installment = i;
        this.paid = i2;
        this.balance = i3;
        this.payable = i4;
        this.scholarship = scholarship;
        this.user_id = user_id;
        this.adjustment = i5;
        this.status = i6;
        this.fine = i7;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getHostel_id() {
        return this.hostel_id;
    }

    public final String getTenant_id() {
        return this.tenant_id;
    }

    public final String getFeetype() {
        return this.feetype;
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

    public final int getInstallment() {
        return this.installment;
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

    public final String getScholarship() {
        return this.scholarship;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final int getAdjustment() {
        return this.adjustment;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getFine() {
        return this.fine;
    }
}