package in.etuwa.app.data.model.activitypoint;

import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityPoints.kt */
/* loaded from: classes3.dex */
public final /* data */ class ActivityPoints {

    @SerializedName("activity_name")
    private final String activityName;
    private final String point;
    private final String semester;

    public static /* synthetic */ ActivityPoints copy$default(ActivityPoints activityPoints, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = activityPoints.activityName;
        }
        if ((i & 2) != 0) {
            str2 = activityPoints.semester;
        }
        if ((i & 4) != 0) {
            str3 = activityPoints.point;
        }
        return activityPoints.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getActivityName() {
        return this.activityName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPoint() {
        return this.point;
    }

    public final ActivityPoints copy(String activityName, String semester, String point) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(point, "point");
        return new ActivityPoints(activityName, semester, point);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityPoints)) {
            return false;
        }
        ActivityPoints activityPoints = (ActivityPoints) other;
        return Intrinsics.areEqual(this.activityName, activityPoints.activityName) && Intrinsics.areEqual(this.semester, activityPoints.semester) && Intrinsics.areEqual(this.point, activityPoints.point);
    }

    public int hashCode() {
        return (((this.activityName.hashCode() * 31) + this.semester.hashCode()) * 31) + this.point.hashCode();
    }

    public String toString() {
        return "ActivityPoints(activityName=" + this.activityName + ", semester=" + this.semester + ", point=" + this.point + ")";
    }

    public ActivityPoints(String activityName, String semester, String point) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(point, "point");
        this.activityName = activityName;
        this.semester = semester;
        this.point = point;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getPoint() {
        return this.point;
    }
}