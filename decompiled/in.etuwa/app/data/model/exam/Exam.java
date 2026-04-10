package in.etuwa.app.data.model.exam;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Exam.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Exam {

    @SerializedName("can_download")
    @Expose
    private final boolean canDownload;

    @SerializedName("can_submit")
    @Expose
    private final boolean canSubmit;
    private final ArrayList<ExamFiles> files;

    @SerializedName("finish_time")
    @Expose
    private final String finishTime;
    private final String id;

    @SerializedName("is_delete")
    @Expose
    private final boolean isDelete;
    private final String semester;

    @SerializedName("start_time")
    @Expose
    private final String startTime;
    private final String status;
    private final String subject;
    private final String title;

    @SerializedName("uploaded_file")
    @Expose
    private final String uploadedFile;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final ArrayList<ExamFiles> component10() {
        return this.files;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getUploadedFile() {
        return this.uploadedFile;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsDelete() {
        return this.isDelete;
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
    public final String getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFinishTime() {
        return this.finishTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getCanDownload() {
        return this.canDownload;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getCanSubmit() {
        return this.canSubmit;
    }

    public final Exam copy(String id, String subject, String semester, String title, String startTime, String finishTime, String status, boolean canDownload, boolean canSubmit, ArrayList<ExamFiles> files, String uploadedFile, boolean isDelete) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(finishTime, "finishTime");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(files, "files");
        Intrinsics.checkNotNullParameter(uploadedFile, "uploadedFile");
        return new Exam(id, subject, semester, title, startTime, finishTime, status, canDownload, canSubmit, files, uploadedFile, isDelete);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Exam)) {
            return false;
        }
        Exam exam = (Exam) other;
        return Intrinsics.areEqual(this.id, exam.id) && Intrinsics.areEqual(this.subject, exam.subject) && Intrinsics.areEqual(this.semester, exam.semester) && Intrinsics.areEqual(this.title, exam.title) && Intrinsics.areEqual(this.startTime, exam.startTime) && Intrinsics.areEqual(this.finishTime, exam.finishTime) && Intrinsics.areEqual(this.status, exam.status) && this.canDownload == exam.canDownload && this.canSubmit == exam.canSubmit && Intrinsics.areEqual(this.files, exam.files) && Intrinsics.areEqual(this.uploadedFile, exam.uploadedFile) && this.isDelete == exam.isDelete;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((this.id.hashCode() * 31) + this.subject.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.title.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.finishTime.hashCode()) * 31) + this.status.hashCode()) * 31;
        boolean z = this.canDownload;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.canSubmit;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        int iHashCode2 = (((((i + r12) * 31) + this.files.hashCode()) * 31) + this.uploadedFile.hashCode()) * 31;
        boolean z3 = this.isDelete;
        return iHashCode2 + (z3 ? 1 : z3);
    }

    public String toString() {
        return "Exam(id=" + this.id + ", subject=" + this.subject + ", semester=" + this.semester + ", title=" + this.title + ", startTime=" + this.startTime + ", finishTime=" + this.finishTime + ", status=" + this.status + ", canDownload=" + this.canDownload + ", canSubmit=" + this.canSubmit + ", files=" + this.files + ", uploadedFile=" + this.uploadedFile + ", isDelete=" + this.isDelete + ")";
    }

    public Exam(String id, String subject, String semester, String title, String startTime, String finishTime, String status, boolean z, boolean z2, ArrayList<ExamFiles> files, String uploadedFile, boolean z3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(finishTime, "finishTime");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(files, "files");
        Intrinsics.checkNotNullParameter(uploadedFile, "uploadedFile");
        this.id = id;
        this.subject = subject;
        this.semester = semester;
        this.title = title;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.status = status;
        this.canDownload = z;
        this.canSubmit = z2;
        this.files = files;
        this.uploadedFile = uploadedFile;
        this.isDelete = z3;
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

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getFinishTime() {
        return this.finishTime;
    }

    public final String getStatus() {
        return this.status;
    }

    public final boolean getCanDownload() {
        return this.canDownload;
    }

    public final boolean getCanSubmit() {
        return this.canSubmit;
    }

    public final ArrayList<ExamFiles> getFiles() {
        return this.files;
    }

    public final String getUploadedFile() {
        return this.uploadedFile;
    }

    public final boolean isDelete() {
        return this.isDelete;
    }
}