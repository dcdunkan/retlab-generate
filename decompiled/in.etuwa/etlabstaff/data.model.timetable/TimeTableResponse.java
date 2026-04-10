package in.etuwa.etlabstaff.data.model.timetable;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeTableResponse.kt */
/* JADX INFO: loaded from: classes5.dex */
public final /* data */ class TimeTableResponse {
    private final String error;
    private final boolean login;
    private final ArrayList<TimeTable> timetable;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimeTableResponse copy$default(TimeTableResponse timeTableResponse, boolean z, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = timeTableResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = timeTableResponse.timetable;
        }
        if ((i & 4) != 0) {
            str = timeTableResponse.error;
        }
        return timeTableResponse.copy(z, arrayList, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<TimeTable> component2() {
        return this.timetable;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final TimeTableResponse copy(boolean login, ArrayList<TimeTable> timetable, String error) {
        Intrinsics.checkNotNullParameter(timetable, "timetable");
        Intrinsics.checkNotNullParameter(error, "error");
        return new TimeTableResponse(login, timetable, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeTableResponse)) {
            return false;
        }
        TimeTableResponse timeTableResponse = (TimeTableResponse) other;
        return this.login == timeTableResponse.login && Intrinsics.areEqual(this.timetable, timeTableResponse.timetable) && Intrinsics.areEqual(this.error, timeTableResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.timetable.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "TimeTableResponse(login=" + this.login + ", timetable=" + this.timetable + ", error=" + this.error + ")";
    }

    public TimeTableResponse(boolean z, ArrayList<TimeTable> timetable, String error) {
        Intrinsics.checkNotNullParameter(timetable, "timetable");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.timetable = timetable;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<TimeTable> getTimetable() {
        return this.timetable;
    }

    public final String getError() {
        return this.error;
    }
}