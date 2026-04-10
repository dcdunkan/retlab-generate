package in.etuwa.app.data.model.timetable.newtimetable;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeTableNew.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class TimeTableNew {
    private final String date;
    private final String day;
    private final ArrayList<TimeTableSub> sub;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimeTableNew copy$default(TimeTableNew timeTableNew, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = timeTableNew.date;
        }
        if ((i & 2) != 0) {
            str2 = timeTableNew.day;
        }
        if ((i & 4) != 0) {
            arrayList = timeTableNew.sub;
        }
        return timeTableNew.copy(str, str2, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDay() {
        return this.day;
    }

    public final ArrayList<TimeTableSub> component3() {
        return this.sub;
    }

    public final TimeTableNew copy(String date, String day, ArrayList<TimeTableSub> sub) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(sub, "sub");
        return new TimeTableNew(date, day, sub);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeTableNew)) {
            return false;
        }
        TimeTableNew timeTableNew = (TimeTableNew) other;
        return Intrinsics.areEqual(this.date, timeTableNew.date) && Intrinsics.areEqual(this.day, timeTableNew.day) && Intrinsics.areEqual(this.sub, timeTableNew.sub);
    }

    public int hashCode() {
        return (((this.date.hashCode() * 31) + this.day.hashCode()) * 31) + this.sub.hashCode();
    }

    public String toString() {
        return "TimeTableNew(date=" + this.date + ", day=" + this.day + ", sub=" + this.sub + ")";
    }

    public TimeTableNew(String date, String day, ArrayList<TimeTableSub> sub) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(sub, "sub");
        this.date = date;
        this.day = day;
        this.sub = sub;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getDay() {
        return this.day;
    }

    public final ArrayList<TimeTableSub> getSub() {
        return this.sub;
    }
}