package in.etuwa.app.data.model.assignment;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* JADX INFO: compiled from: Assignment.kt */
/* JADX INFO: loaded from: classes3.dex */
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
    private final String link;
    private final String semester;
    private final String status;
    private final String subject;
    private final String title;
    private final boolean upload;

    @SerializedName("uploaded_file")
    @Expose
    private final String uploadedFile;
    private final String url;

    public Assignment() {
        this(null, null, null, null, null, null, null, null, null, false, null, false, false, null, 16383, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getUpload() {
        return this.upload;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getUploadedFile() {
        return this.uploadedFile;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getCanDownload() {
        return this.canDownload;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getCanSubmit() {
        return this.canSubmit;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getIssueDate() {
        return this.issueDate;
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
    public final String getDetails() {
        return this.details;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLastDate() {
        return this.lastDate;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    public final Assignment copy(String id, String subject, String semester, String title, String details, String lastDate, String status, String url, String link, boolean upload, String uploadedFile, boolean canDownload, boolean canSubmit, String issueDate) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(status, "status");
        return new Assignment(id, subject, semester, title, details, lastDate, status, url, link, upload, uploadedFile, canDownload, canSubmit, issueDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Assignment)) {
            return false;
        }
        Assignment assignment = (Assignment) other;
        return Intrinsics.areEqual(this.id, assignment.id) && Intrinsics.areEqual(this.subject, assignment.subject) && Intrinsics.areEqual(this.semester, assignment.semester) && Intrinsics.areEqual(this.title, assignment.title) && Intrinsics.areEqual(this.details, assignment.details) && Intrinsics.areEqual(this.lastDate, assignment.lastDate) && Intrinsics.areEqual(this.status, assignment.status) && Intrinsics.areEqual(this.url, assignment.url) && Intrinsics.areEqual(this.link, assignment.link) && this.upload == assignment.upload && Intrinsics.areEqual(this.uploadedFile, assignment.uploadedFile) && this.canDownload == assignment.canDownload && this.canSubmit == assignment.canSubmit && Intrinsics.areEqual(this.issueDate, assignment.issueDate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iHashCode = ((((((((this.id.hashCode() * 31) + this.subject.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.title.hashCode()) * 31) + this.details.hashCode()) * 31;
        String str = this.lastDate;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.status.hashCode()) * 31;
        String str2 = this.url;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.link;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z = this.upload;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode4 + r1) * 31;
        String str4 = this.uploadedFile;
        int iHashCode5 = (i + (str4 == null ? 0 : str4.hashCode())) * 31;
        boolean z2 = this.canDownload;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        int i2 = (iHashCode5 + r12) * 31;
        boolean z3 = this.canSubmit;
        int i3 = (i2 + (z3 ? 1 : z3)) * 31;
        String str5 = this.issueDate;
        return i3 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "Assignment(id=" + this.id + ", subject=" + this.subject + ", semester=" + this.semester + ", title=" + this.title + ", details=" + this.details + ", lastDate=" + this.lastDate + ", status=" + this.status + ", url=" + this.url + ", link=" + this.link + ", upload=" + this.upload + ", uploadedFile=" + this.uploadedFile + ", canDownload=" + this.canDownload + ", canSubmit=" + this.canSubmit + ", issueDate=" + this.issueDate + ")";
    }

    public Assignment(String id, String subject, String semester, String title, String details, String str, String status, String str2, String str3, boolean z, String str4, boolean z2, boolean z3, String str5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(status, "status");
        this.id = id;
        this.subject = subject;
        this.semester = semester;
        this.title = title;
        this.details = details;
        this.lastDate = str;
        this.status = status;
        this.url = str2;
        this.link = str3;
        this.upload = z;
        this.uploadedFile = str4;
        this.canDownload = z2;
        this.canSubmit = z3;
        this.issueDate = str5;
    }

    public /* synthetic */ Assignment(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10, boolean z2, boolean z3, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? "" : str10, (i & 2048) != 0 ? false : z2, (i & 4096) == 0 ? z3 : false, (i & 8192) == 0 ? str11 : "");
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

    public final String getLink() {
        return this.link;
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