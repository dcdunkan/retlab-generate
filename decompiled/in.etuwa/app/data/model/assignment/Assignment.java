package in.etuwa.app.data.model.assignment;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: Assignment.kt */
/* loaded from: classes3.dex */
public final /* data */ class Assignment {

    @SerializedName("can_download")
    @Expose
    private final boolean canDownload;

    @SerializedName("can_submit")
    @Expose
    private final boolean canSubmit;
    private final String details;
    private final String id;

    @SerializedName("issue_date")
    @Expose
    private final String issueDate;

    @SerializedName("last_date")
    @Expose
    private final String lastDate;
    private final String semester;
    private final String status;
    private final String subject;
    private final String title;
    private final boolean upload;

    @SerializedName("uploaded_file")
    @Expose
    private final String uploadedFile;
    private final String url;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getUploadedFile() {
        return this.uploadedFile;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getCanDownload() {
        return this.canDownload;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getCanSubmit() {
        return this.canSubmit;
    }

    /* renamed from: component13, reason: from getter */
    public final String getIssueDate() {
        return this.issueDate;
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
    public final String getDetails() {
        return this.details;
    }

    /* renamed from: component6, reason: from getter */
    public final String getLastDate() {
        return this.lastDate;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component8, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getUpload() {
        return this.upload;
    }

    public final Assignment copy(String id, String subject, String semester, String title, String details, String lastDate, String status, String url, boolean upload, String uploadedFile, boolean canDownload, boolean canSubmit, String issueDate) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(lastDate, "lastDate");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(uploadedFile, "uploadedFile");
        Intrinsics.checkNotNullParameter(issueDate, "issueDate");
        return new Assignment(id, subject, semester, title, details, lastDate, status, url, upload, uploadedFile, canDownload, canSubmit, issueDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Assignment)) {
            return false;
        }
        Assignment assignment = (Assignment) other;
        return Intrinsics.areEqual(this.id, assignment.id) && Intrinsics.areEqual(this.subject, assignment.subject) && Intrinsics.areEqual(this.semester, assignment.semester) && Intrinsics.areEqual(this.title, assignment.title) && Intrinsics.areEqual(this.details, assignment.details) && Intrinsics.areEqual(this.lastDate, assignment.lastDate) && Intrinsics.areEqual(this.status, assignment.status) && Intrinsics.areEqual(this.url, assignment.url) && this.upload == assignment.upload && Intrinsics.areEqual(this.uploadedFile, assignment.uploadedFile) && this.canDownload == assignment.canDownload && this.canSubmit == assignment.canSubmit && Intrinsics.areEqual(this.issueDate, assignment.issueDate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((this.id.hashCode() * 31) + this.subject.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.title.hashCode()) * 31) + this.details.hashCode()) * 31) + this.lastDate.hashCode()) * 31) + this.status.hashCode()) * 31) + this.url.hashCode()) * 31;
        boolean z = this.upload;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode2 = (((hashCode + i) * 31) + this.uploadedFile.hashCode()) * 31;
        boolean z2 = this.canDownload;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z3 = this.canSubmit;
        return ((i3 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.issueDate.hashCode();
    }

    public String toString() {
        return "Assignment(id=" + this.id + ", subject=" + this.subject + ", semester=" + this.semester + ", title=" + this.title + ", details=" + this.details + ", lastDate=" + this.lastDate + ", status=" + this.status + ", url=" + this.url + ", upload=" + this.upload + ", uploadedFile=" + this.uploadedFile + ", canDownload=" + this.canDownload + ", canSubmit=" + this.canSubmit + ", issueDate=" + this.issueDate + ")";
    }

    public Assignment(String id, String subject, String semester, String title, String details, String lastDate, String status, String url, boolean z, String uploadedFile, boolean z2, boolean z3, String issueDate) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(lastDate, "lastDate");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(uploadedFile, "uploadedFile");
        Intrinsics.checkNotNullParameter(issueDate, "issueDate");
        this.id = id;
        this.subject = subject;
        this.semester = semester;
        this.title = title;
        this.details = details;
        this.lastDate = lastDate;
        this.status = status;
        this.url = url;
        this.upload = z;
        this.uploadedFile = uploadedFile;
        this.canDownload = z2;
        this.canSubmit = z3;
        this.issueDate = issueDate;
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

    public final String getDetails() {
        return this.details;
    }

    public final String getLastDate() {
        return this.lastDate;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getUpload() {
        return this.upload;
    }

    public final String getUploadedFile() {
        return this.uploadedFile;
    }

    public final boolean getCanDownload() {
        return this.canDownload;
    }

    public final boolean getCanSubmit() {
        return this.canSubmit;
    }

    public final String getIssueDate() {
        return this.issueDate;
    }
}