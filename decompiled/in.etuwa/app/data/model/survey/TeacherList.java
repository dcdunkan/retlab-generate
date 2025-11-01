package in.etuwa.app.data.model.survey;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TeacherList.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lin/etuwa/app/data/model/survey/TeacherList;", "", "subjectId", "", "teacherId", "subject", "teacher", NotificationCompat.CATEGORY_STATUS, SvgConstants.Tags.IMAGE, AttendanceDayDialogKt.ARG_SEM, "btnMsg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBtnMsg", "()Ljava/lang/String;", "getImage", "getSemester", "getStatus", "getSubject", "getSubjectId", "getTeacher", "getTeacherId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTeacherId() {
        return this.teacherId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTeacher() {
        return this.teacher;
    }

    /* renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component6, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* renamed from: component8, reason: from getter */
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