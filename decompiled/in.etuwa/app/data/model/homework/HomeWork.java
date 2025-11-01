package in.etuwa.app.data.model.homework;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.data.model.exam.ExamFiles;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: HomeWork.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015¢\u0006\u0002\u0010\u0016J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u0019\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J¯\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015HÆ\u0001J\u0013\u00109\u001a\u00020\u00102\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001a¨\u0006>"}, d2 = {"Lin/etuwa/app/data/model/homework/HomeWork;", "", "id", "", "subject", AttendanceDayDialogKt.ARG_SEM, "title", "type", "issuedDate", "lastDate", NotificationCompat.CATEGORY_STATUS, "teacherFeedback", "lateSubmissionStatus", "lateSubmissionDate", ErrorBundle.DETAIL_ENTRY, "canSubmit", "", "uploadedFile", "files", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/exam/ExamFiles;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/ArrayList;)V", "getCanSubmit", "()Z", "getDetails", "()Ljava/lang/String;", "getFiles", "()Ljava/util/ArrayList;", "getId", "getIssuedDate", "getLastDate", "getLateSubmissionDate", "getLateSubmissionStatus", "getSemester", "getStatus", "getSubject", "getTeacherFeedback", "getTitle", "getType", "getUploadedFile", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getLateSubmissionStatus() {
        return this.lateSubmissionStatus;
    }

    /* renamed from: component11, reason: from getter */
    public final String getLateSubmissionDate() {
        return this.lateSubmissionDate;
    }

    /* renamed from: component12, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getCanSubmit() {
        return this.canSubmit;
    }

    /* renamed from: component14, reason: from getter */
    public final String getUploadedFile() {
        return this.uploadedFile;
    }

    public final ArrayList<ExamFiles> component15() {
        return this.files;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIssuedDate() {
        return this.issuedDate;
    }

    /* renamed from: component7, reason: from getter */
    public final String getLastDate() {
        return this.lastDate;
    }

    /* renamed from: component8, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component9, reason: from getter */
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
    public int hashCode() {
        int hashCode = ((((((((((((((((((((((this.id.hashCode() * 31) + this.subject.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.title.hashCode()) * 31) + this.type.hashCode()) * 31) + this.issuedDate.hashCode()) * 31) + this.lastDate.hashCode()) * 31) + this.status.hashCode()) * 31) + this.teacherFeedback.hashCode()) * 31) + this.lateSubmissionStatus.hashCode()) * 31) + this.lateSubmissionDate.hashCode()) * 31) + this.details.hashCode()) * 31;
        boolean z = this.canSubmit;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((((hashCode + i) * 31) + this.uploadedFile.hashCode()) * 31) + this.files.hashCode();
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