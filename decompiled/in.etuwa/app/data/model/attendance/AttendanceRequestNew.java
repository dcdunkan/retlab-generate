package in.etuwa.app.data.model.attendance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttendanceRequestNew.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/attendance/AttendanceRequestNew;", "", AttendanceDayDialogKt.ARG_SEM, "", "year", "month", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMonth", "()Ljava/lang/String;", "getSemester", "getYear", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* renamed from: component2, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* renamed from: component3, reason: from getter */
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