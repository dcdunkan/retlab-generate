package in.etuwa.app.data.model.timetable;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeTablePeriod.kt */
/* loaded from: classes3.dex */
public final class TimeTablePeriod {
    private final String day;
    private final ArrayList<TimeTable> sub;

    public TimeTablePeriod(String day, ArrayList<TimeTable> sub) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(sub, "sub");
        this.day = day;
        this.sub = sub;
    }

    public final String getDay() {
        return this.day;
    }

    public final ArrayList<TimeTable> getSub() {
        return this.sub;
    }
}