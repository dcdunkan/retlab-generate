package in.etuwa.app.data.model.due.duepaynew;

import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DuePayNew.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0095\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u00102\u001a\u00020\u000f2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00067"}, d2 = {"Lin/etuwa/app/data/model/due/duepaynew/DuePayNew;", "", "admission_no", "", "student_id", "due_id", "head_id", "sem_id", "department_id", NotificationCompat.CATEGORY_STATUS, "date", ExamSubjectDetailDialogKt.ARG_AMOUNT, "paid", "balance", "fullpaid", "", "year_id", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getAdmission_no", "()Ljava/lang/String;", "getAmount", "getBalance", "getDate", "getDepartment_id", "getDue_id", "getError", "getFullpaid", "()Z", "getHead_id", "getPaid", "getSem_id", "getStatus", "getStudent_id", "getYear_id", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getAdmission_no() {
        return this.admission_no;
    }

    /* renamed from: component10, reason: from getter */
    public final String getPaid() {
        return this.paid;
    }

    /* renamed from: component11, reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getFullpaid() {
        return this.fullpaid;
    }

    /* renamed from: component13, reason: from getter */
    public final String getYear_id() {
        return this.year_id;
    }

    /* renamed from: component14, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStudent_id() {
        return this.student_id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDue_id() {
        return this.due_id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getHead_id() {
        return this.head_id;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSem_id() {
        return this.sem_id;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDepartment_id() {
        return this.department_id;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component9, reason: from getter */
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
    public int hashCode() {
        int hashCode = ((((((((((((((((((((this.admission_no.hashCode() * 31) + this.student_id.hashCode()) * 31) + this.due_id.hashCode()) * 31) + this.head_id.hashCode()) * 31) + this.sem_id.hashCode()) * 31) + this.department_id.hashCode()) * 31) + this.status.hashCode()) * 31) + this.date.hashCode()) * 31) + this.amount.hashCode()) * 31) + this.paid.hashCode()) * 31) + this.balance.hashCode()) * 31;
        boolean z = this.fullpaid;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((((hashCode + i) * 31) + this.year_id.hashCode()) * 31) + this.error.hashCode();
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