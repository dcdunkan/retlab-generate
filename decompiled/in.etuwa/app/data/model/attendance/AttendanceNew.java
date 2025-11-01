package in.etuwa.app.data.model.attendance;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttendanceNew.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/data/model/attendance/AttendanceNew;", "", "date", "", "holiday", "", "totalperiod", "", "periods", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/attendance/AttendancePeriod;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;ZILjava/util/ArrayList;)V", "getDate", "()Ljava/lang/String;", "getHoliday", "()Z", "getPeriods", "()Ljava/util/ArrayList;", "getTotalperiod", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHoliday() {
        return this.holiday;
    }

    /* renamed from: component3, reason: from getter */
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
    public int hashCode() {
        int hashCode = this.date.hashCode() * 31;
        boolean z = this.holiday;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((((hashCode + i) * 31) + this.totalperiod) * 31) + this.periods.hashCode();
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