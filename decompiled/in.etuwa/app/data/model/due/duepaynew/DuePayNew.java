package in.etuwa.app.data.model.due.duepaynew;

import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DuePayNew.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class DuePayNew {
    private final String admission_no;
    private final String amount;
    private final String balance;
    private final String date;
    private final String department_id;
    private final String due_id;
    private final String error;
    private final boolean fullpaid;
    private final String head_id;
    private final String paid;
    private final String sem_id;
    private final String status;
    private final String student_id;
    private final String year_id;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAdmission_no() {
        return this.admission_no;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPaid() {
        return this.paid;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getFullpaid() {
        return this.fullpaid;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getYear_id() {
        return this.year_id;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStudent_id() {
        return this.student_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDue_id() {
        return this.due_id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getHead_id() {
        return this.head_id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSem_id() {
        return this.sem_id;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDepartment_id() {
        return this.department_id;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    public final DuePayNew copy(String admission_no, String student_id, String due_id, String head_id, String sem_id, String department_id, String status, String date, String amount, String paid, String balance, boolean fullpaid, String year_id, String error) {
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(student_id, "student_id");
        Intrinsics.checkNotNullParameter(due_id, "due_id");
        Intrinsics.checkNotNullParameter(head_id, "head_id");
        Intrinsics.checkNotNullParameter(sem_id, "sem_id");
        Intrinsics.checkNotNullParameter(department_id, "department_id");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(year_id, "year_id");
        Intrinsics.checkNotNullParameter(error, "error");
        return new DuePayNew(admission_no, student_id, due_id, head_id, sem_id, department_id, status, date, amount, paid, balance, fullpaid, year_id, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DuePayNew)) {
            return false;
        }
        DuePayNew duePayNew = (DuePayNew) other;
        return Intrinsics.areEqual(this.admission_no, duePayNew.admission_no) && Intrinsics.areEqual(this.student_id, duePayNew.student_id) && Intrinsics.areEqual(this.due_id, duePayNew.due_id) && Intrinsics.areEqual(this.head_id, duePayNew.head_id) && Intrinsics.areEqual(this.sem_id, duePayNew.sem_id) && Intrinsics.areEqual(this.department_id, duePayNew.department_id) && Intrinsics.areEqual(this.status, duePayNew.status) && Intrinsics.areEqual(this.date, duePayNew.date) && Intrinsics.areEqual(this.amount, duePayNew.amount) && Intrinsics.areEqual(this.paid, duePayNew.paid) && Intrinsics.areEqual(this.balance, duePayNew.balance) && this.fullpaid == duePayNew.fullpaid && Intrinsics.areEqual(this.year_id, duePayNew.year_id) && Intrinsics.areEqual(this.error, duePayNew.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((this.admission_no.hashCode() * 31) + this.student_id.hashCode()) * 31) + this.due_id.hashCode()) * 31) + this.head_id.hashCode()) * 31) + this.sem_id.hashCode()) * 31) + this.department_id.hashCode()) * 31) + this.status.hashCode()) * 31) + this.date.hashCode()) * 31) + this.amount.hashCode()) * 31) + this.paid.hashCode()) * 31) + this.balance.hashCode()) * 31;
        boolean z = this.fullpaid;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((iHashCode + r1) * 31) + this.year_id.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "DuePayNew(admission_no=" + this.admission_no + ", student_id=" + this.student_id + ", due_id=" + this.due_id + ", head_id=" + this.head_id + ", sem_id=" + this.sem_id + ", department_id=" + this.department_id + ", status=" + this.status + ", date=" + this.date + ", amount=" + this.amount + ", paid=" + this.paid + ", balance=" + this.balance + ", fullpaid=" + this.fullpaid + ", year_id=" + this.year_id + ", error=" + this.error + ")";
    }

    public DuePayNew(String admission_no, String student_id, String due_id, String head_id, String sem_id, String department_id, String status, String date, String amount, String paid, String balance, boolean z, String year_id, String error) {
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(student_id, "student_id");
        Intrinsics.checkNotNullParameter(due_id, "due_id");
        Intrinsics.checkNotNullParameter(head_id, "head_id");
        Intrinsics.checkNotNullParameter(sem_id, "sem_id");
        Intrinsics.checkNotNullParameter(department_id, "department_id");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(year_id, "year_id");
        Intrinsics.checkNotNullParameter(error, "error");
        this.admission_no = admission_no;
        this.student_id = student_id;
        this.due_id = due_id;
        this.head_id = head_id;
        this.sem_id = sem_id;
        this.department_id = department_id;
        this.status = status;
        this.date = date;
        this.amount = amount;
        this.paid = paid;
        this.balance = balance;
        this.fullpaid = z;
        this.year_id = year_id;
        this.error = error;
    }

    public final String getAdmission_no() {
        return this.admission_no;
    }

    public final String getStudent_id() {
        return this.student_id;
    }

    public final String getDue_id() {
        return this.due_id;
    }

    public final String getHead_id() {
        return this.head_id;
    }

    public final String getSem_id() {
        return this.sem_id;
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

    public final String getAmount() {
        return this.amount;
    }

    public final String getPaid() {
        return this.paid;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final boolean getFullpaid() {
        return this.fullpaid;
    }

    public final String getYear_id() {
        return this.year_id;
    }

    public final String getError() {
        return this.error;
    }
}