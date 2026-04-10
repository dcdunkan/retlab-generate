package in.etuwa.app.data.model.attendance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AttendanceRequestNew.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AttendanceRequestNew {

    @SerializedName("month")
    @Expose
    private final String month;

    @SerializedName(AttendanceDayDialogKt.ARG_SEM)
    @Expose
    private final String semester;

    @SerializedName("year")
    @Expose
    private final String year;

    public static /* synthetic */ AttendanceRequestNew copy$default(AttendanceRequestNew attendanceRequestNew, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attendanceRequestNew.semester;
        }
        if ((i & 2) != 0) {
            str2 = attendanceRequestNew.year;
        }
        if ((i & 4) != 0) {
            str3 = attendanceRequestNew.month;
        }
        return attendanceRequestNew.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMonth() {
        return this.month;
    }

    public final AttendanceRequestNew copy(String semester, String year, String month) {
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(month, "month");
        return new AttendanceRequestNew(semester, year, month);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendanceRequestNew)) {
            return false;
        }
        AttendanceRequestNew attendanceRequestNew = (AttendanceRequestNew) other;
        return Intrinsics.areEqual(this.semester, attendanceRequestNew.semester) && Intrinsics.areEqual(this.year, attendanceRequestNew.year) && Intrinsics.areEqual(this.month, attendanceRequestNew.month);
    }

    public int hashCode() {
        return (((this.semester.hashCode() * 31) + this.year.hashCode()) * 31) + this.month.hashCode();
    }

    public String toString() {
        return "AttendanceRequestNew(semester=" + this.semester + ", year=" + this.year + ", month=" + this.month + ")";
    }

    public AttendanceRequestNew(String semester, String year, String month) {
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(month, "month");
        this.semester = semester;
        this.year = year;
        this.month = month;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getYear() {
        return this.year;
    }

    public final String getMonth() {
        return this.month;
    }
}