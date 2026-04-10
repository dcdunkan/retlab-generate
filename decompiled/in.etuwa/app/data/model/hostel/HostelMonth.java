package in.etuwa.app.data.model.hostel;

import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelMonth.kt */
/* loaded from: classes3.dex */
public final /* data */ class HostelMonth {
    private final int amount;
    private final int balance;
    private final String diff;
    private final String fine;
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
    public final String getDiff() {
        return this.diff;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIs_selected() {
        return this.is_selected;
    }

    public final ArrayList<HostelFee> component12() {
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
    public final String getFine() {
        return this.fine;
    }

    /* renamed from: component8, reason: from getter */
    public final String getM() {
        return this.m;
    }

    /* renamed from: component9, reason: from getter */
    public final String getY() {
        return this.y;
    }

    public final HostelMonth copy(String installment, int amount, int paid, int balance, String month, String year, String fine, String m, String y, String diff, boolean is_selected, ArrayList<HostelFee> payment) {
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(y, "y");
        Intrinsics.checkNotNullParameter(diff, "diff");
        Intrinsics.checkNotNullParameter(payment, "payment");
        return new HostelMonth(installment, amount, paid, balance, month, year, fine, m, y, diff, is_selected, payment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelMonth)) {
            return false;
        }
        HostelMonth hostelMonth = (HostelMonth) other;
        return Intrinsics.areEqual(this.installment, hostelMonth.installment) && this.amount == hostelMonth.amount && this.paid == hostelMonth.paid && this.balance == hostelMonth.balance && Intrinsics.areEqual(this.month, hostelMonth.month) && Intrinsics.areEqual(this.year, hostelMonth.year) && Intrinsics.areEqual(this.fine, hostelMonth.fine) && Intrinsics.areEqual(this.m, hostelMonth.m) && Intrinsics.areEqual(this.y, hostelMonth.y) && Intrinsics.areEqual(this.diff, hostelMonth.diff) && this.is_selected == hostelMonth.is_selected && Intrinsics.areEqual(this.payment, hostelMonth.payment);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((((((this.installment.hashCode() * 31) + this.amount) * 31) + this.paid) * 31) + this.balance) * 31) + this.month.hashCode()) * 31) + this.year.hashCode()) * 31) + this.fine.hashCode()) * 31) + this.m.hashCode()) * 31) + this.y.hashCode()) * 31) + this.diff.hashCode()) * 31;
        boolean z = this.is_selected;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + this.payment.hashCode();
    }

    public String toString() {
        return "HostelMonth(installment=" + this.installment + ", amount=" + this.amount + ", paid=" + this.paid + ", balance=" + this.balance + ", month=" + this.month + ", year=" + this.year + ", fine=" + this.fine + ", m=" + this.m + ", y=" + this.y + ", diff=" + this.diff + ", is_selected=" + this.is_selected + ", payment=" + this.payment + ")";
    }

    public HostelMonth(String installment, int i, int i2, int i3, String month, String year, String fine, String m, String y, String diff, boolean z, ArrayList<HostelFee> payment) {
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(y, "y");
        Intrinsics.checkNotNullParameter(diff, "diff");
        Intrinsics.checkNotNullParameter(payment, "payment");
        this.installment = installment;
        this.amount = i;
        this.paid = i2;
        this.balance = i3;
        this.month = month;
        this.year = year;
        this.fine = fine;
        this.m = m;
        this.y = y;
        this.diff = diff;
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

    public final String getFine() {
        return this.fine;
    }

    public final String getM() {
        return this.m;
    }

    public final String getY() {
        return this.y;
    }

    public final String getDiff() {
        return this.diff;
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