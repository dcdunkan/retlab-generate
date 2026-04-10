package in.etuwa.etlabstaff.data.model.timetable;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeTableRequest.kt */
/* JADX INFO: loaded from: classes5.dex */
public final /* data */ class TimeTableRequest {
    private final String date;

    public static /* synthetic */ TimeTableRequest copy$default(TimeTableRequest timeTableRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = timeTableRequest.date;
        }
        return timeTableRequest.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final TimeTableRequest copy(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return new TimeTableRequest(date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TimeTableRequest) && Intrinsics.areEqual(this.date, ((TimeTableRequest) other).date);
    }

    public int hashCode() {
        return this.date.hashCode();
    }

    public String toString() {
        return "TimeTableRequest(date=" + this.date + ")";
    }

    public TimeTableRequest(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.date = date;
    }

    public final String getDate() {
        return this.date;
    }
}