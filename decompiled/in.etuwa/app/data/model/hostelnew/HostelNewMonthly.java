package in.etuwa.app.data.model.hostelnew;

import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.hostel.HostelFee;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelNewMonthly.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class HostelNewMonthly {
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInstallment() {
        return this.installment;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getFine() {
        return this.fine;
    }

    public final ArrayList<HostelFee> component11() {
        return this.payment;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPaid() {
        return this.paid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBalance() {
        return this.balance;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMonth() {
        return this.month;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getM() {
        return this.m;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getY() {
        return this.y;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIs_selected() {
        return this.is_selected;
    }

    public final HostelNewMonthly copy(String installment, int amount, int paid, int balance, String month, String year, String m, String y, boolean is_selected, int fine, ArrayList<HostelFee> payment) {
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(y, "y");
        Intrinsics.checkNotNullParameter(payment, "payment");
        return new HostelNewMonthly(installment, amount, paid, balance, month, year, m, y, is_selected, fine, payment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelNewMonthly)) {
            return false;
        }
        HostelNewMonthly hostelNewMonthly = (HostelNewMonthly) other;
        return Intrinsics.areEqual(this.installment, hostelNewMonthly.installment) && this.amount == hostelNewMonthly.amount && this.paid == hostelNewMonthly.paid && this.balance == hostelNewMonthly.balance && Intrinsics.areEqual(this.month, hostelNewMonthly.month) && Intrinsics.areEqual(this.year, hostelNewMonthly.year) && Intrinsics.areEqual(this.m, hostelNewMonthly.m) && Intrinsics.areEqual(this.y, hostelNewMonthly.y) && this.is_selected == hostelNewMonthly.is_selected && this.fine == hostelNewMonthly.fine && Intrinsics.areEqual(this.payment, hostelNewMonthly.payment);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    public int hashCode() {
        int iHashCode = ((((((((((((((this.installment.hashCode() * 31) + this.amount) * 31) + this.paid) * 31) + this.balance) * 31) + this.month.hashCode()) * 31) + this.year.hashCode()) * 31) + this.m.hashCode()) * 31) + this.y.hashCode()) * 31;
        boolean z = this.is_selected;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((iHashCode + r1) * 31) + this.fine) * 31) + this.payment.hashCode();
    }

    public String toString() {
        return "HostelNewMonthly(installment=" + this.installment + ", amount=" + this.amount + ", paid=" + this.paid + ", balance=" + this.balance + ", month=" + this.month + ", year=" + this.year + ", m=" + this.m + ", y=" + this.y + ", is_selected=" + this.is_selected + ", fine=" + this.fine + ", payment=" + this.payment + ")";
    }

    public HostelNewMonthly(String installment, int i, int i2, int i3, String month, String year, String m, String y, boolean z, int i4, ArrayList<HostelFee> payment) {
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
        this.is_selected = z;
        this.fine = i4;
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

    public final boolean is_selected() {
        return this.is_selected;
    }

    public final void set_selected(boolean z) {
        this.is_selected = z;
    }

    public final int getFine() {
        return this.fine;
    }

    public final ArrayList<HostelFee> getPayment() {
        return this.payment;
    }
}