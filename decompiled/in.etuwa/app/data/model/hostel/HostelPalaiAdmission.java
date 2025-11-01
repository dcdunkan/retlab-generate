package in.etuwa.app.data.model.hostel;

import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelPalaiAdmission.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014¢\u0006\u0002\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0010HÆ\u0003J\u0019\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u009b\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014HÆ\u0001J\u0013\u00106\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0005HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R!\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001a¨\u0006:"}, d2 = {"Lin/etuwa/app/data/model/hostel/HostelPalaiAdmission;", "", "installment", "", ExamSubjectDetailDialogKt.ARG_AMOUNT, "", "paid", "balance", "fine", SvgConstants.Attributes.PATH_DATA_REL_MOVE_TO, SvgConstants.Attributes.Y, "diff", "month", "year", "scholarship", "is_selected", "", "payment", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/HostelFee;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/ArrayList;)V", "getAmount", "()I", "getBalance", "getDiff", "()Ljava/lang/String;", "getFine", "getInstallment", "()Z", "set_selected", "(Z)V", "getM", "getMonth", "getPaid", "getPayment", "()Ljava/util/ArrayList;", "getScholarship", "getY", "getYear", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class HostelPalaiAdmission {
    private final int amount;
    private final int balance;
    private final String diff;
    private final int fine;
    private final String installment;
    private boolean is_selected;
    private final String m;
    private final String month;
    private final int paid;
    private final ArrayList<HostelFee> payment;
    private final String scholarship;
    private final String y;
    private final String year;

    /* renamed from: component1, reason: from getter */
    public final String getInstallment() {
        return this.installment;
    }

    /* renamed from: component10, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* renamed from: component11, reason: from getter */
    public final String getScholarship() {
        return this.scholarship;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIs_selected() {
        return this.is_selected;
    }

    public final ArrayList<HostelFee> component13() {
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
    public final int getFine() {
        return this.fine;
    }

    /* renamed from: component6, reason: from getter */
    public final String getM() {
        return this.m;
    }

    /* renamed from: component7, reason: from getter */
    public final String getY() {
        return this.y;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDiff() {
        return this.diff;
    }

    /* renamed from: component9, reason: from getter */
    public final String getMonth() {
        return this.month;
    }

    public final HostelPalaiAdmission copy(String installment, int amount, int paid, int balance, int fine, String m, String y, String diff, String month, String year, String scholarship, boolean is_selected, ArrayList<HostelFee> payment) {
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(y, "y");
        Intrinsics.checkNotNullParameter(diff, "diff");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        Intrinsics.checkNotNullParameter(payment, "payment");
        return new HostelPalaiAdmission(installment, amount, paid, balance, fine, m, y, diff, month, year, scholarship, is_selected, payment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelPalaiAdmission)) {
            return false;
        }
        HostelPalaiAdmission hostelPalaiAdmission = (HostelPalaiAdmission) other;
        return Intrinsics.areEqual(this.installment, hostelPalaiAdmission.installment) && this.amount == hostelPalaiAdmission.amount && this.paid == hostelPalaiAdmission.paid && this.balance == hostelPalaiAdmission.balance && this.fine == hostelPalaiAdmission.fine && Intrinsics.areEqual(this.m, hostelPalaiAdmission.m) && Intrinsics.areEqual(this.y, hostelPalaiAdmission.y) && Intrinsics.areEqual(this.diff, hostelPalaiAdmission.diff) && Intrinsics.areEqual(this.month, hostelPalaiAdmission.month) && Intrinsics.areEqual(this.year, hostelPalaiAdmission.year) && Intrinsics.areEqual(this.scholarship, hostelPalaiAdmission.scholarship) && this.is_selected == hostelPalaiAdmission.is_selected && Intrinsics.areEqual(this.payment, hostelPalaiAdmission.payment);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((((((((this.installment.hashCode() * 31) + this.amount) * 31) + this.paid) * 31) + this.balance) * 31) + this.fine) * 31) + this.m.hashCode()) * 31) + this.y.hashCode()) * 31) + this.diff.hashCode()) * 31) + this.month.hashCode()) * 31) + this.year.hashCode()) * 31) + this.scholarship.hashCode()) * 31;
        boolean z = this.is_selected;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + this.payment.hashCode();
    }

    public String toString() {
        return "HostelPalaiAdmission(installment=" + this.installment + ", amount=" + this.amount + ", paid=" + this.paid + ", balance=" + this.balance + ", fine=" + this.fine + ", m=" + this.m + ", y=" + this.y + ", diff=" + this.diff + ", month=" + this.month + ", year=" + this.year + ", scholarship=" + this.scholarship + ", is_selected=" + this.is_selected + ", payment=" + this.payment + ")";
    }

    public HostelPalaiAdmission(String installment, int i, int i2, int i3, int i4, String m, String y, String diff, String month, String year, String scholarship, boolean z, ArrayList<HostelFee> payment) {
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(y, "y");
        Intrinsics.checkNotNullParameter(diff, "diff");
        Intrinsics.checkNotNullParameter(month, "month");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        Intrinsics.checkNotNullParameter(payment, "payment");
        this.installment = installment;
        this.amount = i;
        this.paid = i2;
        this.balance = i3;
        this.fine = i4;
        this.m = m;
        this.y = y;
        this.diff = diff;
        this.month = month;
        this.year = year;
        this.scholarship = scholarship;
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

    public final int getFine() {
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

    public final String getMonth() {
        return this.month;
    }

    public final String getYear() {
        return this.year;
    }

    public final String getScholarship() {
        return this.scholarship;
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