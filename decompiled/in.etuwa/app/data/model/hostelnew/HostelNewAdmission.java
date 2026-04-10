package in.etuwa.app.data.model.hostelnew;

import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.DownloadModel$$ExternalSyntheticBackport0;
import in.etuwa.app.data.model.hostel.HostelFee;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelNewAdmission.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class HostelNewAdmission {
    private final double amount;
    private final double balance;
    private final int fine;
    private final String installment;
    private boolean is_selected;
    private final String m;
    private final double paid;
    private final ArrayList<HostelFee> payment;
    private final String y;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInstallment() {
        return this.installment;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getPaid() {
        return this.paid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getBalance() {
        return this.balance;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getM() {
        return this.m;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getY() {
        return this.y;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getFine() {
        return this.fine;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIs_selected() {
        return this.is_selected;
    }

    public final ArrayList<HostelFee> component9() {
        return this.payment;
    }

    public final HostelNewAdmission copy(String installment, double amount, double paid, double balance, String m, String y, int fine, boolean is_selected, ArrayList<HostelFee> payment) {
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(y, "y");
        Intrinsics.checkNotNullParameter(payment, "payment");
        return new HostelNewAdmission(installment, amount, paid, balance, m, y, fine, is_selected, payment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelNewAdmission)) {
            return false;
        }
        HostelNewAdmission hostelNewAdmission = (HostelNewAdmission) other;
        return Intrinsics.areEqual(this.installment, hostelNewAdmission.installment) && Double.compare(this.amount, hostelNewAdmission.amount) == 0 && Double.compare(this.paid, hostelNewAdmission.paid) == 0 && Double.compare(this.balance, hostelNewAdmission.balance) == 0 && Intrinsics.areEqual(this.m, hostelNewAdmission.m) && Intrinsics.areEqual(this.y, hostelNewAdmission.y) && this.fine == hostelNewAdmission.fine && this.is_selected == hostelNewAdmission.is_selected && Intrinsics.areEqual(this.payment, hostelNewAdmission.payment);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    public int hashCode() {
        int iHashCode = ((((((((((((this.installment.hashCode() * 31) + DownloadModel$$ExternalSyntheticBackport0.m(this.amount)) * 31) + DownloadModel$$ExternalSyntheticBackport0.m(this.paid)) * 31) + DownloadModel$$ExternalSyntheticBackport0.m(this.balance)) * 31) + this.m.hashCode()) * 31) + this.y.hashCode()) * 31) + this.fine) * 31;
        boolean z = this.is_selected;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + this.payment.hashCode();
    }

    public String toString() {
        return "HostelNewAdmission(installment=" + this.installment + ", amount=" + this.amount + ", paid=" + this.paid + ", balance=" + this.balance + ", m=" + this.m + ", y=" + this.y + ", fine=" + this.fine + ", is_selected=" + this.is_selected + ", payment=" + this.payment + ")";
    }

    public HostelNewAdmission(String installment, double d, double d2, double d3, String m, String y, int i, boolean z, ArrayList<HostelFee> payment) {
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(y, "y");
        Intrinsics.checkNotNullParameter(payment, "payment");
        this.installment = installment;
        this.amount = d;
        this.paid = d2;
        this.balance = d3;
        this.m = m;
        this.y = y;
        this.fine = i;
        this.is_selected = z;
        this.payment = payment;
    }

    public final String getInstallment() {
        return this.installment;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final double getPaid() {
        return this.paid;
    }

    public final double getBalance() {
        return this.balance;
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