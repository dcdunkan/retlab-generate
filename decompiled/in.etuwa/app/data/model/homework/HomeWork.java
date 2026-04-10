package in.etuwa.app.data.model.homework;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.data.model.exam.ExamFiles;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* JADX INFO: compiled from: HomeWork.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class HomeWork {

    @SerializedName("can_submit")
    private final boolean canSubmit;
    private final String details;
    private final ArrayList<ExamFiles> files;
    private final String id;

    @SerializedName("issued_date")
    private final String issuedDate;

    @SerializedName("last_date")
    private final String lastDate;

    @SerializedName("late_submission_date")
    private final String lateSubmissionDate;

    @SerializedName("late_submission_status")
    private final String lateSubmissionStatus;
    private final String semester;
    private final String status;
    private final String subject;

    @SerializedName("teacher_feedback")
    private final String teacherFeedback;
    private final String title;
    private final String type;

    @SerializedName("uploaded_file")
    private final String uploadedFile;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getLateSubmissionStatus() {
        return this.lateSubmissionStatus;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getLateSubmissionDate() {
        return this.lateSubmissionDate;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getCanSubmit() {
        return this.canSubmit;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getUploadedFile() {
        return this.uploadedFile;
    }

    public final ArrayList<ExamFiles> component15() {
        return this.files;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getIssuedDate() {
        return this.issuedDate;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLastDate() {
        return this.lastDate;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTeacherFeedback() {
        return this.teacherFeedback;
    }

    public final HomeWork copy(String id, String subject, String semester, String title, String type, String issuedDate, String lastDate, String status, String teacherFeedback, String lateSubmissionStatus, String lateSubmissionDate, String details, boolean canSubmit, String uploadedFile, ArrayList<ExamFiles> files) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(issuedDate, "issuedDate");
        Intrinsics.checkNotNullParameter(lastDate, "lastDate");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(teacherFeedback, "teacherFeedback");
        Intrinsics.checkNotNullParameter(lateSubmissionStatus, "lateSubmissionStatus");
        Intrinsics.checkNotNullParameter(lateSubmissionDate, "lateSubmissionDate");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(uploadedFile, "uploadedFile");
        Intrinsics.checkNotNullParameter(files, "files");
        return new HomeWork(id, subject, semester, title, type, issuedDate, lastDate, status, teacherFeedback, lateSubmissionStatus, lateSubmissionDate, details, canSubmit, uploadedFile, files);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeWork)) {
            return false;
        }
        HomeWork homeWork = (HomeWork) other;
        return Intrinsics.areEqual(this.id, homeWork.id) && Intrinsics.areEqual(this.subject, homeWork.subject) && Intrinsics.areEqual(this.semester, homeWork.semester) && Intrinsics.areEqual(this.title, homeWork.title) && Intrinsics.areEqual(this.type, homeWork.type) && Intrinsics.areEqual(this.issuedDate, homeWork.issuedDate) && Intrinsics.areEqual(this.lastDate, homeWork.lastDate) && Intrinsics.areEqual(this.status, homeWork.status) && Intrinsics.areEqual(this.teacherFeedback, homeWork.teacherFeedback) && Intrinsics.areEqual(this.lateSubmissionStatus, homeWork.lateSubmissionStatus) && Intrinsics.areEqual(this.lateSubmissionDate, homeWork.lateSubmissionDate) && Intrinsics.areEqual(this.details, homeWork.details) && this.canSubmit == homeWork.canSubmit && Intrinsics.areEqual(this.uploadedFile, homeWork.uploadedFile) && Intrinsics.areEqual(this.files, homeWork.files);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((this.id.hashCode() * 31) + this.subject.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.title.hashCode()) * 31) + this.type.hashCode()) * 31) + this.issuedDate.hashCode()) * 31) + this.lastDate.hashCode()) * 31) + this.status.hashCode()) * 31) + this.teacherFeedback.hashCode()) * 31) + this.lateSubmissionStatus.hashCode()) * 31) + this.lateSubmissionDate.hashCode()) * 31) + this.details.hashCode()) * 31;
        boolean z = this.canSubmit;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((iHashCode + r1) * 31) + this.uploadedFile.hashCode()) * 31) + this.files.hashCode();
    }

    public String toString() {
        return "HomeWork(id=" + this.id + ", subject=" + this.subject + ", semester=" + this.semester + ", title=" + this.title + ", type=" + this.type + ", issuedDate=" + this.issuedDate + ", lastDate=" + this.lastDate + ", status=" + this.status + ", teacherFeedback=" + this.teacherFeedback + ", lateSubmissionStatus=" + this.lateSubmissionStatus + ", lateSubmissionDate=" + this.lateSubmissionDate + ", details=" + this.details + ", canSubmit=" + this.canSubmit + ", uploadedFile=" + this.uploadedFile + ", files=" + this.files + ")";
    }

    public HomeWork(String id, String subject, String semester, String title, String type, String issuedDate, String lastDate, String status, String teacherFeedback, String lateSubmissionStatus, String lateSubmissionDate, String details, boolean z, String uploadedFile, ArrayList<ExamFiles> files) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(issuedDate, "issuedDate");
        Intrinsics.checkNotNullParameter(lastDate, "lastDate");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(teacherFeedback, "teacherFeedback");
        Intrinsics.checkNotNullParameter(lateSubmissionStatus, "lateSubmissionStatus");
        Intrinsics.checkNotNullParameter(lateSubmissionDate, "lateSubmissionDate");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(uploadedFile, "uploadedFile");
        Intrinsics.checkNotNullParameter(files, "files");
        this.id = id;
        this.subject = subject;
        this.semester = semester;
        this.title = title;
        this.type = type;
        this.issuedDate = issuedDate;
        this.lastDate = lastDate;
        this.status = status;
        this.teacherFeedback = teacherFeedback;
        this.lateSubmissionStatus = lateSubmissionStatus;
        this.lateSubmissionDate = lateSubmissionDate;
        this.details = details;
        this.canSubmit = z;
        this.uploadedFile = uploadedFile;
        this.files = files;
    }

    public final String getId() {
        return this.id;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final String getIssuedDate() {
        return this.issuedDate;
    }

    public final String getLastDate() {
        return this.lastDate;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTeacherFeedback() {
        return this.teacherFeedback;
    }

    public final String getLateSubmissionStatus() {
        return this.lateSubmissionStatus;
    }

    public final String getLateSubmissionDate() {
        return this.lateSubmissionDate;
    }

    public final String getDetails() {
        return this.details;
    }

    public final boolean getCanSubmit() {
        return this.canSubmit;
    }

    public final String getUploadedFile() {
        return this.uploadedFile;
    }

    public final ArrayList<ExamFiles> getFiles() {
        return this.files;
    }
}