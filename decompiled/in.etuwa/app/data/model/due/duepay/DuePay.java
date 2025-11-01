package in.etuwa.app.data.model.due.duepay;

import androidx.core.app.NotificationCompat;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DuePay.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u00060"}, d2 = {"Lin/etuwa/app/data/model/due/duepay/DuePay;", "", "installment", "", ExamSubjectDetailDialogKt.ARG_AMOUNT, "paid", "balance", "student_id", "admission_no", "due_id", "head_id", "department_id", NotificationCompat.CATEGORY_STATUS, "date", "year_id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdmission_no", "()Ljava/lang/String;", "getAmount", "getBalance", "getDate", "getDepartment_id", "getDue_id", "getHead_id", "getInstallment", "getPaid", "getStatus", "getStudent_id", "getYear_id", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getInstallment() {
        return this.installment;
    }

    /* renamed from: component10, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component11, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component12, reason: from getter */
    public final String getYear_id() {
        return this.year_id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPaid() {
        return this.paid;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    /* renamed from: component5, reason: from getter */
    public final String getStudent_id() {
        return this.student_id;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAdmission_no() {
        return this.admission_no;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDue_id() {
        return this.due_id;
    }

    /* renamed from: component8, reason: from getter */
    public final String getHead_id() {
        return this.head_id;
    }

    /* renamed from: component9, reason: from getter */
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