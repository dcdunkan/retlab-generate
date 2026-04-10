package in.etuwa.app.data.model.dash.daywisetimetaable;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DayWiseResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class DayWiseResponse {
    private final boolean login;
    private final ArrayList<DayWise> timetable;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DayWiseResponse copy$default(DayWiseResponse dayWiseResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dayWiseResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = dayWiseResponse.timetable;
        }
        return dayWiseResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<DayWise> component2() {
        return this.timetable;
    }

    public final DayWiseResponse copy(boolean login, ArrayList<DayWise> timetable) {
        Intrinsics.checkNotNullParameter(timetable, "timetable");
        return new DayWiseResponse(login, timetable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DayWiseResponse)) {
            return false;
        }
        DayWiseResponse dayWiseResponse = (DayWiseResponse) other;
        return this.login == dayWiseResponse.login && Intrinsics.areEqual(this.timetable, dayWiseResponse.timetable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.timetable.hashCode();
    }

    public String toString() {
        return "DayWiseResponse(login=" + this.login + ", timetable=" + this.timetable + ")";
    }

    public DayWiseResponse(boolean z, ArrayList<DayWise> timetable) {
        Intrinsics.checkNotNullParameter(timetable, "timetable");
        this.login = z;
        this.timetable = timetable;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<DayWise> getTimetable() {
        return this.timetable;
    }
}