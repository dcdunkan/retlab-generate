package in.etuwa.app.data.model.exam;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exam.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0002\u0010\u0013J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u000bHÆ\u0003J\u0091\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000bHÆ\u0001J\u0013\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u0012\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001a¨\u00064"}, d2 = {"Lin/etuwa/app/data/model/exam/Exam;", "", "id", "", "subject", AttendanceDayDialogKt.ARG_SEM, "title", "startTime", "finishTime", NotificationCompat.CATEGORY_STATUS, "canDownload", "", "canSubmit", "files", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/exam/ExamFiles;", "Lkotlin/collections/ArrayList;", "uploadedFile", "isDelete", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/ArrayList;Ljava/lang/String;Z)V", "getCanDownload", "()Z", "getCanSubmit", "getFiles", "()Ljava/util/ArrayList;", "getFinishTime", "()Ljava/lang/String;", "getId", "getSemester", "getStartTime", "getStatus", "getSubject", "getTitle", "getUploadedFile", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final ArrayList<ExamFiles> component10() {
        return this.files;
    }

    /* renamed from: component11, reason: from getter */
    public final String getUploadedFile() {
        return this.uploadedFile;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsDelete() {
        return this.isDelete;
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
    public final String getStartTime() {
        return this.startTime;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFinishTime() {
        return this.finishTime;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getCanDownload() {
        return this.canDownload;
    }

    /* renamed from: component9, reason: from getter */
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
    public int hashCode() {
        int hashCode = ((((((((((((this.id.hashCode() * 31) + this.subject.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.title.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.finishTime.hashCode()) * 31) + this.status.hashCode()) * 31;
        boolean z = this.canDownload;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.canSubmit;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int hashCode2 = (((((i2 + i3) * 31) + this.files.hashCode()) * 31) + this.uploadedFile.hashCode()) * 31;
        boolean z3 = this.isDelete;
        return hashCode2 + (z3 ? 1 : z3 ? 1 : 0);
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