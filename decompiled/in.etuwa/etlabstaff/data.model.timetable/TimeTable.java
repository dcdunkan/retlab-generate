package in.etuwa.etlabstaff.data.model.timetable;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeTable.kt */
/* JADX INFO: loaded from: classes5.dex */
public final /* data */ class TimeTable {
    private final String date;
    private final String day;
    private final ArrayList<TimeTablePeriod> periods;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimeTable copy$default(TimeTable timeTable, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = timeTable.day;
        }
        if ((i & 2) != 0) {
            str2 = timeTable.date;
        }
        if ((i & 4) != 0) {
            arrayList = timeTable.periods;
        }
        return timeTable.copy(str, str2, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDay() {
        return this.day;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final ArrayList<TimeTablePeriod> component3() {
        return this.periods;
    }

    public final TimeTable copy(String day, String date, ArrayList<TimeTablePeriod> periods) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(periods, "periods");
        return new TimeTable(day, date, periods);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeTable)) {
            return false;
        }
        TimeTable timeTable = (TimeTable) other;
        return Intrinsics.areEqual(this.day, timeTable.day) && Intrinsics.areEqual(this.date, timeTable.date) && Intrinsics.areEqual(this.periods, timeTable.periods);
    }

    public int hashCode() {
        return (((this.day.hashCode() * 31) + this.date.hashCode()) * 31) + this.periods.hashCode();
    }

    public String toString() {
        return "TimeTable(day=" + this.day + ", date=" + this.date + ", periods=" + this.periods + ")";
    }

    public TimeTable(String day, String date, ArrayList<TimeTablePeriod> periods) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(periods, "periods");
        this.day = day;
        this.date = date;
        this.periods = periods;
    }

    public final String getDay() {
        return this.day;
    }

    public final String getDate() {
        return this.date;
    }

    public final ArrayList<TimeTablePeriod> getPeriods() {
        return this.periods;
    }
}