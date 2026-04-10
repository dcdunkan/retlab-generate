package in.etuwa.app.data.model.activitypoint.manage;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.kernel.xmp.PdfConst;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityBatch.kt */
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