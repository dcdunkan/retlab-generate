package in.etuwa.app.data.model.tutorial;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: Tutorial.kt */
/* loaded from: classes3.dex */
public final /* data */ class Tutorial {

    @SerializedName("can_download")
    @Expose
    private final boolean canDownload;

    @SerializedName("can_submit")
    @Expose
    private final boolean canSubmit;
    private final String details;

    @SerializedName("finish_time")
    @Expose
    private final String finishTime;
    private final String id;

    @SerializedName("issued_on")
    @Expose
    private final String issuedOn;

    @SerializedName("last_date")
    @Expose
    private final String max_mark;
    private final String semester;
    private final String status;
    private final String subject;
    private final String title;
    private final String type;

    @SerializedName("uploaded_file")
    @Expose
    private final String uploadedFile;
    private final String url;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component11, reason: from getter */
    public final String getUploadedFile() {
        return this.uploadedFile;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getCanDownload() {
        return this.canDownload;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getCanSubmit() {
        return this.canSubmit;
    }

    /* renamed from: component14, reason: from getter */
    public final String getType() {
        return this.type;
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
    public final String getMax_mark() {
        return this.max_mark;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    /* renamed from: component7, reason: from getter */
    public final String getIssuedOn() {
        return this.issuedOn;
    }

    /* renamed from: component8, reason: from getter */
    public final String getFinishTime() {
        return this.finishTime;
    }

    /* renamed from: component9, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final Tutorial copy(String id, String subject, String semester, String title, String max_mark, String details, String issuedOn, String finishTime, String status, String url, String uploadedFile, boolean canDownload, boolean canSubmit, String type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(max_mark, "max_mark");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(issuedOn, "issuedOn");
        Intrinsics.checkNotNullParameter(finishTime, "finishTime");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(uploadedFile, "uploadedFile");
        Intrinsics.checkNotNullParameter(type, "type");
        return new Tutorial(id, subject, semester, title, max_mark, details, issuedOn, finishTime, status, url, uploadedFile, canDownload, canSubmit, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tutorial)) {
            return false;
        }
        Tutorial tutorial = (Tutorial) other;
        return Intrinsics.areEqual(this.id, tutorial.id) && Intrinsics.areEqual(this.subject, tutorial.subject) && Intrinsics.areEqual(this.semester, tutorial.semester) && Intrinsics.areEqual(this.title, tutorial.title) && Intrinsics.areEqual(this.max_mark, tutorial.max_mark) && Intrinsics.areEqual(this.details, tutorial.details) && Intrinsics.areEqual(this.issuedOn, tutorial.issuedOn) && Intrinsics.areEqual(this.finishTime, tutorial.finishTime) && Intrinsics.areEqual(this.status, tutorial.status) && Intrinsics.areEqual(this.url, tutorial.url) && Intrinsics.areEqual(this.uploadedFile, tutorial.uploadedFile) && this.canDownload == tutorial.canDownload && this.canSubmit == tutorial.canSubmit && Intrinsics.areEqual(this.type, tutorial.type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((((((((this.id.hashCode() * 31) + this.subject.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.title.hashCode()) * 31) + this.max_mark.hashCode()) * 31) + this.details.hashCode()) * 31) + this.issuedOn.hashCode()) * 31) + this.finishTime.hashCode()) * 31) + this.status.hashCode()) * 31) + this.url.hashCode()) * 31) + this.uploadedFile.hashCode()) * 31;
        boolean z = this.canDownload;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.canSubmit;
        return ((i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "Tutorial(id=" + this.id + ", subject=" + this.subject + ", semester=" + this.semester + ", title=" + this.title + ", max_mark=" + this.max_mark + ", details=" + this.details + ", issuedOn=" + this.issuedOn + ", finishTime=" + this.finishTime + ", status=" + this.status + ", url=" + this.url + ", uploadedFile=" + this.uploadedFile + ", canDownload=" + this.canDownload + ", canSubmit=" + this.canSubmit + ", type=" + this.type + ")";
    }

    public Tutorial(String id, String subject, String semester, String title, String max_mark, String details, String issuedOn, String finishTime, String status, String url, String uploadedFile, boolean z, boolean z2, String type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(max_mark, "max_mark");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(issuedOn, "issuedOn");
        Intrinsics.checkNotNullParameter(finishTime, "finishTime");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(uploadedFile, "uploadedFile");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.subject = subject;
        this.semester = semester;
        this.title = title;
        this.max_mark = max_mark;
        this.details = details;
        this.issuedOn = issuedOn;
        this.finishTime = finishTime;
        this.status = status;
        this.url = url;
        this.uploadedFile = uploadedFile;
        this.canDownload = z;
        this.canSubmit = z2;
        this.type = type;
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

    public final String getMax_mark() {
        return this.max_mark;
    }

    public final String getDetails() {
        return this.details;
    }

    public final String getIssuedOn() {
        return this.issuedOn;
    }

    public final String getFinishTime() {
        return this.finishTime;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getUrl() {
        return this.url;
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

    public final String getType() {
        return this.type;
    }
}