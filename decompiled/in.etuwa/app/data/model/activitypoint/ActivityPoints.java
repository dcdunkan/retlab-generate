package in.etuwa.app.data.model.activitypoint;

import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityPoints.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/activitypoint/ActivityPoints;", "", "activityName", "", AttendanceDayDialogKt.ARG_SEM, "point", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityName", "()Ljava/lang/String;", "getPoint", "getSemester", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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