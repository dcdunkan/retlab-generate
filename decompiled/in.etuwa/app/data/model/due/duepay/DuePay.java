package in.etuwa.app.data.model.due.duepay;

import androidx.core.app.NotificationCompat;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DuePay.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class DuePay {
    private final String admission_no;
    private final String amount;
    private final String balance;
    private final String date;
    private final String department_id;
    private final String due_id;
    private final String head_id;
    private final String installment;
    private final String paid;
    private final String status;
    private final String student_id;
    private final String year_id;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInstallment() {
        return this.installment;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getYear_id() {
        return this.year_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPaid() {
        return this.paid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStudent_id() {
        return this.student_id;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAdmission_no() {
        return this.admission_no;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDue_id() {
        return this.due_id;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getHead_id() {
        return this.head_id;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDepartment_id() {
        return this.department_id;
    }

    public final DuePay copy(String installment, String amount, String paid, String balance, String student_id, String admission_no, String due_id, String head_id, String department_id, String status, String date, String year_id) {
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(student_id, "student_id");
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(due_id, "due_id");
        Intrinsics.checkNotNullParameter(head_id, "head_id");
        Intrinsics.checkNotNullParameter(department_id, "department_id");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(year_id, "year_id");
        return new DuePay(installment, amount, paid, balance, student_id, admission_no, due_id, head_id, department_id, status, date, year_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DuePay)) {
            return false;
        }
        DuePay duePay = (DuePay) other;
        return Intrinsics.areEqual(this.installment, duePay.installment) && Intrinsics.areEqual(this.amount, duePay.amount) && Intrinsics.areEqual(this.paid, duePay.paid) && Intrinsics.areEqual(this.balance, duePay.balance) && Intrinsics.areEqual(this.student_id, duePay.student_id) && Intrinsics.areEqual(this.admission_no, duePay.admission_no) && Intrinsics.areEqual(this.due_id, duePay.due_id) && Intrinsics.areEqual(this.head_id, duePay.head_id) && Intrinsics.areEqual(this.department_id, duePay.department_id) && Intrinsics.areEqual(this.status, duePay.status) && Intrinsics.areEqual(this.date, duePay.date) && Intrinsics.areEqual(this.year_id, duePay.year_id);
    }

    public int hashCode() {
        return (((((((((((((((((((((this.installment.hashCode() * 31) + this.amount.hashCode()) * 31) + this.paid.hashCode()) * 31) + this.balance.hashCode()) * 31) + this.student_id.hashCode()) * 31) + this.admission_no.hashCode()) * 31) + this.due_id.hashCode()) * 31) + this.head_id.hashCode()) * 31) + this.department_id.hashCode()) * 31) + this.status.hashCode()) * 31) + this.date.hashCode()) * 31) + this.year_id.hashCode();
    }

    public String toString() {
        return "DuePay(installment=" + this.installment + ", amount=" + this.amount + ", paid=" + this.paid + ", balance=" + this.balance + ", student_id=" + this.student_id + ", admission_no=" + this.admission_no + ", due_id=" + this.due_id + ", head_id=" + this.head_id + ", department_id=" + this.department_id + ", status=" + this.status + ", date=" + this.date + ", year_id=" + this.year_id + ")";
    }

    public DuePay(String installment, String amount, String paid, String balance, String student_id, String admission_no, String due_id, String head_id, String department_id, String status, String date, String year_id) {
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(student_id, "student_id");
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(due_id, "due_id");
        Intrinsics.checkNotNullParameter(head_id, "head_id");
        Intrinsics.checkNotNullParameter(department_id, "department_id");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(year_id, "year_id");
        this.installment = installment;
        this.amount = amount;
        this.paid = paid;
        this.balance = balance;
        this.student_id = student_id;
        this.admission_no = admission_no;
        this.due_id = due_id;
        this.head_id = head_id;
        this.department_id = department_id;
        this.status = status;
        this.date = date;
        this.year_id = year_id;
    }

    public final String getInstallment() {
        return this.installment;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getPaid() {
        return this.paid;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final String getStudent_id() {
        return this.student_id;
    }

    public final String getAdmission_no() {
        return this.admission_no;
    }

    public final String getDue_id() {
        return this.due_id;
    }

    public final String getHead_id() {
        return this.head_id;
    }

    public final String getDepartment_id() {
        return this.department_id;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getYear_id() {
        return this.year_id;
    }
}