package in.etuwa.app.data.model.attendance;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AttendanceNew.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AttendanceNew {
    private final String date;
    private final boolean holiday;
    private final ArrayList<AttendancePeriod> periods;
    private final int totalperiod;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AttendanceNew copy$default(AttendanceNew attendanceNew, String str, boolean z, int i, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = attendanceNew.date;
        }
        if ((i2 & 2) != 0) {
            z = attendanceNew.holiday;
        }
        if ((i2 & 4) != 0) {
            i = attendanceNew.totalperiod;
        }
        if ((i2 & 8) != 0) {
            arrayList = attendanceNew.periods;
        }
        return attendanceNew.copy(str, z, i, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHoliday() {
        return this.holiday;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTotalperiod() {
        return this.totalperiod;
    }

    public final ArrayList<AttendancePeriod> component4() {
        return this.periods;
    }

    public final AttendanceNew copy(String date, boolean holiday, int totalperiod, ArrayList<AttendancePeriod> periods) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(periods, "periods");
        return new AttendanceNew(date, holiday, totalperiod, periods);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendanceNew)) {
            return false;
        }
        AttendanceNew attendanceNew = (AttendanceNew) other;
        return Intrinsics.areEqual(this.date, attendanceNew.date) && this.holiday == attendanceNew.holiday && this.totalperiod == attendanceNew.totalperiod && Intrinsics.areEqual(this.periods, attendanceNew.periods);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        int iHashCode = this.date.hashCode() * 31;
        boolean z = this.holiday;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((iHashCode + r1) * 31) + this.totalperiod) * 31) + this.periods.hashCode();
    }

    public String toString() {
        return "AttendanceNew(date=" + this.date + ", holiday=" + this.holiday + ", totalperiod=" + this.totalperiod + ", periods=" + this.periods + ")";
    }

    public AttendanceNew(String date, boolean z, int i, ArrayList<AttendancePeriod> periods) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(periods, "periods");
        this.date = date;
        this.holiday = z;
        this.totalperiod = i;
        this.periods = periods;
    }

    public final String getDate() {
        return this.date;
    }

    public final boolean getHoliday() {
        return this.holiday;
    }

    public final ArrayList<AttendancePeriod> getPeriods() {
        return this.periods;
    }

    public final int getTotalperiod() {
        return this.totalperiod;
    }
}