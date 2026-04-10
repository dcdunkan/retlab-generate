package in.etuwa.app.data.model.calendar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CalendarResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AttendanceDetails {

    @SerializedName("attendance_forthemonth")
    @Expose
    private final String attendance_forthemonth;

    @SerializedName("attendance_forthesem")
    @Expose
    private final String attendance_forthesem;

    public static /* synthetic */ AttendanceDetails copy$default(AttendanceDetails attendanceDetails, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attendanceDetails.attendance_forthemonth;
        }
        if ((i & 2) != 0) {
            str2 = attendanceDetails.attendance_forthesem;
        }
        return attendanceDetails.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAttendance_forthemonth() {
        return this.attendance_forthemonth;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAttendance_forthesem() {
        return this.attendance_forthesem;
    }

    public final AttendanceDetails copy(String attendance_forthemonth, String attendance_forthesem) {
        Intrinsics.checkNotNullParameter(attendance_forthemonth, "attendance_forthemonth");
        Intrinsics.checkNotNullParameter(attendance_forthesem, "attendance_forthesem");
        return new AttendanceDetails(attendance_forthemonth, attendance_forthesem);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendanceDetails)) {
            return false;
        }
        AttendanceDetails attendanceDetails = (AttendanceDetails) other;
        return Intrinsics.areEqual(this.attendance_forthemonth, attendanceDetails.attendance_forthemonth) && Intrinsics.areEqual(this.attendance_forthesem, attendanceDetails.attendance_forthesem);
    }

    public int hashCode() {
        return (this.attendance_forthemonth.hashCode() * 31) + this.attendance_forthesem.hashCode();
    }

    public String toString() {
        return "AttendanceDetails(attendance_forthemonth=" + this.attendance_forthemonth + ", attendance_forthesem=" + this.attendance_forthesem + ")";
    }

    public AttendanceDetails(String attendance_forthemonth, String attendance_forthesem) {
        Intrinsics.checkNotNullParameter(attendance_forthemonth, "attendance_forthemonth");
        Intrinsics.checkNotNullParameter(attendance_forthesem, "attendance_forthesem");
        this.attendance_forthemonth = attendance_forthemonth;
        this.attendance_forthesem = attendance_forthesem;
    }

    public final String getAttendance_forthemonth() {
        return this.attendance_forthemonth;
    }

    public final String getAttendance_forthesem() {
        return this.attendance_forthesem;
    }
}