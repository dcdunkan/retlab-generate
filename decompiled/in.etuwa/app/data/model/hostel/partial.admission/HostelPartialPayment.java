package in.etuwa.app.data.model.hostel.partial.admission;

import androidx.core.app.NotificationCompat;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelPartialPayment.kt */
/* loaded from: classes3.dex */
public final /* data */ class HostelPartialPayment {
    private final String amount;
    private final int balance;
    private final String feehead_id;
    private final String feeheadgroup_id;
    private final String feetype;
    private final String hostel_id;
    private final int installment;
    private boolean is_selected;
    private final String m;
    private final String name;
    private final int paid;
    private int payable;
    private final int scholarship;
    private final int status;
    private final String tenant_id;
    private final String user_id;
    private final String y;

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final int getBalance() {
        return this.balance;
    }

    /* renamed from: component11, reason: from getter */
    public final int getPayable() {
        return this.payable;
    }

    /* renamed from: component12, reason: from getter */
    public final int getScholarship() {
        return this.scholarship;
    }

    /* renamed from: component13, reason: from getter */
    public final String getUser_id() {
        return this.user_id;
    }

    /* renamed from: component14, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component15, reason: from getter */
    public final String getM() {
        return this.m;
    }

    /* renamed from: component16, reason: from getter */
    public final String getY() {
        return this.y;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getIs_selected() {
        return this.is_selected;
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
    public final String getFeehead_id() {
        return this.feehead_id;
    }

    /* renamed from: component8, reason: from getter */
    public final int getInstallment() {
        return this.installment;
    }

    /* renamed from: component9, reason: from getter */
    public final int getPaid() {
        return this.paid;
    }

    public final HostelPartialPayment copy(String name, String amount, String hostel_id, String tenant_id, String feetype, String feeheadgroup_id, String feehead_id, int installment, int paid, int balance, int payable, int scholarship, String user_id, int status, String m, String y, boolean is_selected) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(hostel_id, "hostel_id");
        Intrinsics.checkNotNullParameter(tenant_id, "tenant_id");
        Intrinsics.checkNotNullParameter(feetype, "feetype");
        Intrinsics.checkNotNullParameter(feeheadgroup_id, "feeheadgroup_id");
        Intrinsics.checkNotNullParameter(feehead_id, "feehead_id");
        Intrinsics.checkNotNullParameter(user_id, "user_id");
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(y, "y");
        return new HostelPartialPayment(name, amount, hostel_id, tenant_id, feetype, feeheadgroup_id, feehead_id, installment, paid, balance, payable, scholarship, user_id, status, m, y, is_selected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelPartialPayment)) {
            return false;
        }
        HostelPartialPayment hostelPartialPayment = (HostelPartialPayment) other;
        return Intrinsics.areEqual(this.name, hostelPartialPayment.name) && Intrinsics.areEqual(this.amount, hostelPartialPayment.amount) && Intrinsics.areEqual(this.hostel_id, hostelPartialPayment.hostel_id) && Intrinsics.areEqual(this.tenant_id, hostelPartialPayment.tenant_id) && Intrinsics.areEqual(this.feetype, hostelPartialPayment.feetype) && Intrinsics.areEqual(this.feeheadgroup_id, hostelPartialPayment.feeheadgroup_id) && Intrinsics.areEqual(this.feehead_id, hostelPartialPayment.feehead_id) && this.installment == hostelPartialPayment.installment && this.paid == hostelPartialPayment.paid && this.balance == hostelPartialPayment.balance && this.payable == hostelPartialPayment.payable && this.scholarship == hostelPartialPayment.scholarship && Intrinsics.areEqual(this.user_id, hostelPartialPayment.user_id) && this.status == hostelPartialPayment.status && Intrinsics.areEqual(this.m, hostelPartialPayment.m) && Intrinsics.areEqual(this.y, hostelPartialPayment.y) && this.is_selected == hostelPartialPayment.is_selected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((this.name.hashCode() * 31) + this.amount.hashCode()) * 31) + this.hostel_id.hashCode()) * 31) + this.tenant_id.hashCode()) * 31) + this.feetype.hashCode()) * 31) + this.feeheadgroup_id.hashCode()) * 31) + this.feehead_id.hashCode()) * 31) + this.installment) * 31) + this.paid) * 31) + this.balance) * 31) + this.payable) * 31) + this.scholarship) * 31) + this.user_id.hashCode()) * 31) + this.status) * 31) + this.m.hashCode()) * 31) + this.y.hashCode()) * 31;
        boolean z = this.is_selected;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "HostelPartialPayment(name=" + this.name + ", amount=" + this.amount + ", hostel_id=" + this.hostel_id + ", tenant_id=" + this.tenant_id + ", feetype=" + this.feetype + ", feeheadgroup_id=" + this.feeheadgroup_id + ", feehead_id=" + this.feehead_id + ", installment=" + this.installment + ", paid=" + this.paid + ", balance=" + this.balance + ", payable=" + this.payable + ", scholarship=" + this.scholarship + ", user_id=" + this.user_id + ", status=" + this.status + ", m=" + this.m + ", y=" + this.y + ", is_selected=" + this.is_selected + ")";
    }

    public HostelPartialPayment(String name, String amount, String hostel_id, String tenant_id, String feetype, String feeheadgroup_id, String feehead_id, int i, int i2, int i3, int i4, int i5, String user_id, int i6, String m, String y, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(hostel_id, "hostel_id");
        Intrinsics.checkNotNullParameter(tenant_id, "tenant_id");
        Intrinsics.checkNotNullParameter(feetype, "feetype");
        Intrinsics.checkNotNullParameter(feeheadgroup_id, "feeheadgroup_id");
        Intrinsics.checkNotNullParameter(feehead_id, "feehead_id");
        Intrinsics.checkNotNullParameter(user_id, "user_id");
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(y, "y");
        this.name = name;
        this.amount = amount;
        this.hostel_id = hostel_id;
        this.tenant_id = tenant_id;
        this.feetype = feetype;
        this.feeheadgroup_id = feeheadgroup_id;
        this.feehead_id = feehead_id;
        this.installment = i;
        this.paid = i2;
        this.balance = i3;
        this.payable = i4;
        this.scholarship = i5;
        this.user_id = user_id;
        this.status = i6;
        this.m = m;
        this.y = y;
        this.is_selected = z;
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

    public final void setPayable(int i) {
        this.payable = i;
    }

    public final int getScholarship() {
        return this.scholarship;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getM() {
        return this.m;
    }

    public final String getY() {
        return this.y;
    }

    public final boolean is_selected() {
        return this.is_selected;
    }

    public final void set_selected(boolean z) {
        this.is_selected = z;
    }
}