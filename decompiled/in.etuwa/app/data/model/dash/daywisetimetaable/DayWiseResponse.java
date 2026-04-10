package in.etuwa.app.data.model.dash.daywisetimetaable;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DayWiseResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class DayWiseResponse {
    private final boolean login;
    private final String semester_end_date;
    private final String semester_start_date;
    private final ArrayList<DayWise> timetable;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DayWiseResponse copy$default(DayWiseResponse dayWiseResponse, boolean z, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dayWiseResponse.login;
        }
        if ((i & 2) != 0) {
            str = dayWiseResponse.semester_start_date;
        }
        if ((i & 4) != 0) {
            str2 = dayWiseResponse.semester_end_date;
        }
        if ((i & 8) != 0) {
            arrayList = dayWiseResponse.timetable;
        }
        return dayWiseResponse.copy(z, str, str2, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSemester_start_date() {
        return this.semester_start_date;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSemester_end_date() {
        return this.semester_end_date;
    }

    public final ArrayList<DayWise> component4() {
        return this.timetable;
    }

    public final DayWiseResponse copy(boolean login, String semester_start_date, String semester_end_date, ArrayList<DayWise> timetable) {
        Intrinsics.checkNotNullParameter(semester_start_date, "semester_start_date");
        Intrinsics.checkNotNullParameter(semester_end_date, "semester_end_date");
        Intrinsics.checkNotNullParameter(timetable, "timetable");
        return new DayWiseResponse(login, semester_start_date, semester_end_date, timetable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DayWiseResponse)) {
            return false;
        }
        DayWiseResponse dayWiseResponse = (DayWiseResponse) other;
        return this.login == dayWiseResponse.login && Intrinsics.areEqual(this.semester_start_date, dayWiseResponse.semester_start_date) && Intrinsics.areEqual(this.semester_end_date, dayWiseResponse.semester_end_date) && Intrinsics.areEqual(this.timetable, dayWiseResponse.timetable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + this.semester_start_date.hashCode()) * 31) + this.semester_end_date.hashCode()) * 31) + this.timetable.hashCode();
    }

    public String toString() {
        return "DayWiseResponse(login=" + this.login + ", semester_start_date=" + this.semester_start_date + ", semester_end_date=" + this.semester_end_date + ", timetable=" + this.timetable + ")";
    }

    public DayWiseResponse(boolean z, String semester_start_date, String semester_end_date, ArrayList<DayWise> timetable) {
        Intrinsics.checkNotNullParameter(semester_start_date, "semester_start_date");
        Intrinsics.checkNotNullParameter(semester_end_date, "semester_end_date");
        Intrinsics.checkNotNullParameter(timetable, "timetable");
        this.login = z;
        this.semester_start_date = semester_start_date;
        this.semester_end_date = semester_end_date;
        this.timetable = timetable;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getSemester_start_date() {
        return this.semester_start_date;
    }

    public final String getSemester_end_date() {
        return this.semester_end_date;
    }

    public final ArrayList<DayWise> getTimetable() {
        return this.timetable;
    }
}