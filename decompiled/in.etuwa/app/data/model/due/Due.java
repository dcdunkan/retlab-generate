package in.etuwa.app.data.model.due;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Due.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Due {

    @SerializedName("admission_no")
    private final String admissionNo;
    private final String batch;

    @SerializedName("due_amount")
    private final String dueAmount;

    @SerializedName("due_head")
    private final String dueHead;

    @SerializedName("has_due")
    private final String hasDue;

    @SerializedName("is_paid")
    private final String isPaid;

    @SerializedName("student_name")
    private final String studentName;

    public static /* synthetic */ Due copy$default(Due due, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = due.admissionNo;
        }
        if ((i & 2) != 0) {
            str2 = due.studentName;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = due.batch;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = due.dueHead;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = due.hasDue;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = due.dueAmount;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = due.isPaid;
        }
        return due.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAdmissionNo() {
        return this.admissionNo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStudentName() {
        return this.studentName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBatch() {
        return this.batch;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDueHead() {
        return this.dueHead;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getHasDue() {
        return this.hasDue;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDueAmount() {
        return this.dueAmount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getIsPaid() {
        return this.isPaid;
    }

    public final Due copy(String admissionNo, String studentName, String batch, String dueHead, String hasDue, String dueAmount, String isPaid) {
        Intrinsics.checkNotNullParameter(admissionNo, "admissionNo");
        Intrinsics.checkNotNullParameter(studentName, "studentName");
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(dueHead, "dueHead");
        Intrinsics.checkNotNullParameter(hasDue, "hasDue");
        Intrinsics.checkNotNullParameter(dueAmount, "dueAmount");
        Intrinsics.checkNotNullParameter(isPaid, "isPaid");
        return new Due(admissionNo, studentName, batch, dueHead, hasDue, dueAmount, isPaid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Due)) {
            return false;
        }
        Due due = (Due) other;
        return Intrinsics.areEqual(this.admissionNo, due.admissionNo) && Intrinsics.areEqual(this.studentName, due.studentName) && Intrinsics.areEqual(this.batch, due.batch) && Intrinsics.areEqual(this.dueHead, due.dueHead) && Intrinsics.areEqual(this.hasDue, due.hasDue) && Intrinsics.areEqual(this.dueAmount, due.dueAmount) && Intrinsics.areEqual(this.isPaid, due.isPaid);
    }

    public int hashCode() {
        return (((((((((((this.admissionNo.hashCode() * 31) + this.studentName.hashCode()) * 31) + this.batch.hashCode()) * 31) + this.dueHead.hashCode()) * 31) + this.hasDue.hashCode()) * 31) + this.dueAmount.hashCode()) * 31) + this.isPaid.hashCode();
    }

    public String toString() {
        return "Due(admissionNo=" + this.admissionNo + ", studentName=" + this.studentName + ", batch=" + this.batch + ", dueHead=" + this.dueHead + ", hasDue=" + this.hasDue + ", dueAmount=" + this.dueAmount + ", isPaid=" + this.isPaid + ")";
    }

    public Due(String admissionNo, String studentName, String batch, String dueHead, String hasDue, String dueAmount, String isPaid) {
        Intrinsics.checkNotNullParameter(admissionNo, "admissionNo");
        Intrinsics.checkNotNullParameter(studentName, "studentName");
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(dueHead, "dueHead");
        Intrinsics.checkNotNullParameter(hasDue, "hasDue");
        Intrinsics.checkNotNullParameter(dueAmount, "dueAmount");
        Intrinsics.checkNotNullParameter(isPaid, "isPaid");
        this.admissionNo = admissionNo;
        this.studentName = studentName;
        this.batch = batch;
        this.dueHead = dueHead;
        this.hasDue = hasDue;
        this.dueAmount = dueAmount;
        this.isPaid = isPaid;
    }

    public final String getAdmissionNo() {
        return this.admissionNo;
    }

    public final String getStudentName() {
        return this.studentName;
    }

    public final String getBatch() {
        return this.batch;
    }

    public final String getDueHead() {
        return this.dueHead;
    }

    public final String getHasDue() {
        return this.hasDue;
    }

    public final String getDueAmount() {
        return this.dueAmount;
    }

    public final String isPaid() {
        return this.isPaid;
    }
}