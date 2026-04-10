package in.etuwa.app.data.model.hostelnew;

import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.hostel.HostelFee;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelNewAdmission.kt */
/* loaded from: classes3.dex */
public final /* data */ class HostelNewAdmission {
    private final int amount;
    private final int balance;
    private final int fine;
    private final String installment;
    private boolean is_selected;
    private final String m;
    private final String month;
    private final int paid;
    private final ArrayList<HostelFee> payment;
    private final String y;
    private final String year;

    /* renamed from: component1, reason: from getter */
    public final String getInstallment() {
        return this.installment;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIs_selected() {
        return this.is_selected;
    }

    public final ArrayList<HostelFee> component11() {
        return this.payment;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPaid() {
        return this.paid;
    }

    /* renamed from: component4, reason: from getter */
    public final int getBalance() {
        return this.balance;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMonth() {
        return this.month;
    }

    /* renamed from: component6, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* renamed from: component7, reason: from getter */
    public final String getM() {
        return this.m;
    }

    /* renamed from: component8, reason: from getter */
    public final String getY() {
        return this.y;
    }

    /* renamed from: component9, reason: from getter */
    public final int getFine() {
        return this.fine;
    }

    public final HostelNewAdmission copy(String installment, int amount, int paid, int balance, String month, String year, String m, String y, int fine, boolean is_selected, ArrayList<HostelFee> payment) {
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(y, "y");
        Intrinsics.checkNotNullParameter(payment, "payment");
        return new HostelNewAdmission(installment, amount, paid, balance, month, year, m, y, fine, is_selected, payment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelNewAdmission)) {
            return false;
        }
        HostelNewAdmission hostelNewAdmission = (HostelNewAdmission) other;
        return Intrinsics.areEqual(this.installment, hostelNewAdmission.installment) && this.amount == hostelNewAdmission.amount && this.paid == hostelNewAdmission.paid && this.balance == hostelNewAdmission.balance && Intrinsics.areEqual(this.month, hostelNewAdmission.month) && Intrinsics.areEqual(this.year, hostelNewAdmission.year) && Intrinsics.areEqual(this.m, hostelNewAdmission.m) && Intrinsics.areEqual(this.y, hostelNewAdmission.y) && this.fine == hostelNewAdmission.fine && this.is_selected == hostelNewAdmission.is_selected && Intrinsics.areEqual(this.payment, hostelNewAdmission.payment);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((((this.installment.hashCode() * 31) + this.amount) * 31) + this.paid) * 31) + this.balance) * 31) + this.month.hashCode()) * 31) + this.year.hashCode()) * 31) + this.m.hashCode()) * 31) + this.y.hashCode()) * 31) + this.fine) * 31;
        boolean z = this.is_selected;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + this.payment.hashCode();
    }

    public String toString() {
        return "HostelNewAdmission(installment=" + this.installment + ", amount=" + this.amount + ", paid=" + this.paid + ", balance=" + this.balance + ", month=" + this.month + ", year=" + this.year + ", m=" + this.m + ", y=" + this.y + ", fine=" + this.fine + ", is_selected=" + this.is_selected + ", payment=" + this.payment + ")";
    }

    public HostelNewAdmission(String installment, int i, int i2, int i3, String month, String year, String m, String y, int i4, boolean z, ArrayList<HostelFee> payment) {
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(y, "y");
        Intrinsics.checkNotNullParameter(payment, "payment");
        this.installment = installment;
        this.amount = i;
        this.paid = i2;
        this.balance = i3;
        this.month = month;
        this.year = year;
        this.m = m;
        this.y = y;
        this.fine = i4;
        this.is_selected = z;
        this.payment = payment;
    }

    public final String getInstallment() {
        return this.installment;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final int getPaid() {
        return this.paid;
    }

    public final int getBalance() {
        return this.balance;
    }

    public final String getMonth() {
        return this.month;
    }

    public final String getYear() {
        return this.year;
    }

    public final String getM() {
        return this.m;
    }

    public final String getY() {
        return this.y;
    }

    public final int getFine() {
        return this.fine;
    }

    public final boolean is_selected() {
        return this.is_selected;
    }

    public final void set_selected(boolean z) {
        this.is_selected = z;
    }

    public final ArrayList<HostelFee> getPayment() {
        return this.payment;
    }
}