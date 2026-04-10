package in.etuwa.app.data.model.timetable;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimetableResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class TimetableResponse {

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("timetable")
    @Expose
    private final ArrayList<TimeTablePeriod> timetable;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimetableResponse copy$default(TimetableResponse timetableResponse, boolean z, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = timetableResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = timetableResponse.timetable;
        }
        if ((i & 4) != 0) {
            str = timetableResponse.error;
        }
        return timetableResponse.copy(z, arrayList, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<TimeTablePeriod> component2() {
        return this.timetable;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final TimetableResponse copy(boolean login, ArrayList<TimeTablePeriod> timetable, String error) {
        Intrinsics.checkNotNullParameter(timetable, "timetable");
        Intrinsics.checkNotNullParameter(error, "error");
        return new TimetableResponse(login, timetable, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimetableResponse)) {
            return false;
        }
        TimetableResponse timetableResponse = (TimetableResponse) other;
        return this.login == timetableResponse.login && Intrinsics.areEqual(this.timetable, timetableResponse.timetable) && Intrinsics.areEqual(this.error, timetableResponse.error);
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
        return "TimetableResponse(login=" + this.login + ", timetable=" + this.timetable + ", error=" + this.error + ")";
    }

    public TimetableResponse(boolean z, ArrayList<TimeTablePeriod> timetable, String error) {
        Intrinsics.checkNotNullParameter(timetable, "timetable");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.timetable = timetable;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<TimeTablePeriod> getTimetable() {
        return this.timetable;
    }

    public final String getError() {
        return this.error;
    }
}