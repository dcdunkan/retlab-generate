package in.etuwa.etlabstaff.data.model.timetable.period;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeTableHourResponse.kt */
/* JADX INFO: loaded from: classes5.dex */
public final /* data */ class TimeTableHourResponse {
    private final boolean login;
    private final ArrayList<TimeTableHour> subjects;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimeTableHourResponse copy$default(TimeTableHourResponse timeTableHourResponse, boolean z, boolean z2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = timeTableHourResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = timeTableHourResponse.success;
        }
        if ((i & 4) != 0) {
            arrayList = timeTableHourResponse.subjects;
        }
        return timeTableHourResponse.copy(z, z2, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<TimeTableHour> component3() {
        return this.subjects;
    }

    public final TimeTableHourResponse copy(boolean login, boolean success, ArrayList<TimeTableHour> subjects) {
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        return new TimeTableHourResponse(login, success, subjects);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeTableHourResponse)) {
            return false;
        }
        TimeTableHourResponse timeTableHourResponse = (TimeTableHourResponse) other;
        return this.login == timeTableHourResponse.login && this.success == timeTableHourResponse.success && Intrinsics.areEqual(this.subjects, timeTableHourResponse.subjects);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((i + (z2 ? 1 : z2)) * 31) + this.subjects.hashCode();
    }

    public String toString() {
        return "TimeTableHourResponse(login=" + this.login + ", success=" + this.success + ", subjects=" + this.subjects + ")";
    }

    public TimeTableHourResponse(boolean z, boolean z2, ArrayList<TimeTableHour> subjects) {
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        this.login = z;
        this.success = z2;
        this.subjects = subjects;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<TimeTableHour> getSubjects() {
        return this.subjects;
    }
}