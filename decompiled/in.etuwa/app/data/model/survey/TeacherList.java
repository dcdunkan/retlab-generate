package in.etuwa.app.data.model.survey;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TeacherList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class TeacherList {

    @SerializedName("btn_msg")
    @Expose
    private final String btnMsg;
    private final String image;
    private final String semester;
    private final String status;
    private final String subject;

    @SerializedName("subject_id")
    @Expose
    private final String subjectId;
    private final String teacher;

    @SerializedName("teacher_id")
    @Expose
    private final String teacherId;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTeacherId() {
        return this.teacherId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTeacher() {
        return this.teacher;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBtnMsg() {
        return this.btnMsg;
    }

    public final TeacherList copy(String subjectId, String teacherId, String subject, String teacher, String status, String image, String semester, String btnMsg) {
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(teacherId, "teacherId");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(btnMsg, "btnMsg");
        return new TeacherList(subjectId, teacherId, subject, teacher, status, image, semester, btnMsg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TeacherList)) {
            return false;
        }
        TeacherList teacherList = (TeacherList) other;
        return Intrinsics.areEqual(this.subjectId, teacherList.subjectId) && Intrinsics.areEqual(this.teacherId, teacherList.teacherId) && Intrinsics.areEqual(this.subject, teacherList.subject) && Intrinsics.areEqual(this.teacher, teacherList.teacher) && Intrinsics.areEqual(this.status, teacherList.status) && Intrinsics.areEqual(this.image, teacherList.image) && Intrinsics.areEqual(this.semester, teacherList.semester) && Intrinsics.areEqual(this.btnMsg, teacherList.btnMsg);
    }

    public int hashCode() {
        return (((((((((((((this.subjectId.hashCode() * 31) + this.teacherId.hashCode()) * 31) + this.subject.hashCode()) * 31) + this.teacher.hashCode()) * 31) + this.status.hashCode()) * 31) + this.image.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.btnMsg.hashCode();
    }

    public String toString() {
        return "TeacherList(subjectId=" + this.subjectId + ", teacherId=" + this.teacherId + ", subject=" + this.subject + ", teacher=" + this.teacher + ", status=" + this.status + ", image=" + this.image + ", semester=" + this.semester + ", btnMsg=" + this.btnMsg + ")";
    }

    public TeacherList(String subjectId, String teacherId, String subject, String teacher, String status, String image, String semester, String btnMsg) {
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(teacherId, "teacherId");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(btnMsg, "btnMsg");
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.subject = subject;
        this.teacher = teacher;
        this.status = status;
        this.image = image;
        this.semester = semester;
        this.btnMsg = btnMsg;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getTeacherId() {
        return this.teacherId;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getTeacher() {
        return this.teacher;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getBtnMsg() {
        return this.btnMsg;
    }
}