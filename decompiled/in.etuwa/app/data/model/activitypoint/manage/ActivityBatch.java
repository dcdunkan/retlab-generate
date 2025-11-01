package in.etuwa.app.data.model.activitypoint.manage;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.kernel.xmp.PdfConst;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityBatch.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/data/model/activitypoint/manage/ActivityBatch;", "", "activityBatchId", "", "activityName", AttendanceDayDialogKt.ARG_SEM, "maxPoint", PdfConst.Description, NotificationCompat.CATEGORY_STATUS, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityBatchId", "()Ljava/lang/String;", "getActivityName", "getDescription", "getMaxPoint", "getSemester", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ActivityBatch {

    @SerializedName("activity_batch_id")
    private final String activityBatchId;

    @SerializedName("activity_name")
    private final String activityName;
    private final String description;

    @SerializedName("max_point")
    private final String maxPoint;
    private final String semester;
    private final String status;

    public static /* synthetic */ ActivityBatch copy$default(ActivityBatch activityBatch, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = activityBatch.activityBatchId;
        }
        if ((i & 2) != 0) {
            str2 = activityBatch.activityName;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = activityBatch.semester;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = activityBatch.maxPoint;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = activityBatch.description;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = activityBatch.status;
        }
        return activityBatch.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getActivityBatchId() {
        return this.activityBatchId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getActivityName() {
        return this.activityName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMaxPoint() {
        return this.maxPoint;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final ActivityBatch copy(String activityBatchId, String activityName, String semester, String maxPoint, String description, String status) {
        Intrinsics.checkNotNullParameter(activityBatchId, "activityBatchId");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(maxPoint, "maxPoint");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(status, "status");
        return new ActivityBatch(activityBatchId, activityName, semester, maxPoint, description, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityBatch)) {
            return false;
        }
        ActivityBatch activityBatch = (ActivityBatch) other;
        return Intrinsics.areEqual(this.activityBatchId, activityBatch.activityBatchId) && Intrinsics.areEqual(this.activityName, activityBatch.activityName) && Intrinsics.areEqual(this.semester, activityBatch.semester) && Intrinsics.areEqual(this.maxPoint, activityBatch.maxPoint) && Intrinsics.areEqual(this.description, activityBatch.description) && Intrinsics.areEqual(this.status, activityBatch.status);
    }

    public int hashCode() {
        return (((((((((this.activityBatchId.hashCode() * 31) + this.activityName.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.maxPoint.hashCode()) * 31) + this.description.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "ActivityBatch(activityBatchId=" + this.activityBatchId + ", activityName=" + this.activityName + ", semester=" + this.semester + ", maxPoint=" + this.maxPoint + ", description=" + this.description + ", status=" + this.status + ")";
    }

    public ActivityBatch(String activityBatchId, String activityName, String semester, String maxPoint, String description, String status) {
        Intrinsics.checkNotNullParameter(activityBatchId, "activityBatchId");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(maxPoint, "maxPoint");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(status, "status");
        this.activityBatchId = activityBatchId;
        this.activityName = activityName;
        this.semester = semester;
        this.maxPoint = maxPoint;
        this.description = description;
        this.status = status;
    }

    public final String getActivityBatchId() {
        return this.activityBatchId;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getMaxPoint() {
        return this.maxPoint;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getStatus() {
        return this.status;
    }
}