package in.etuwa.app.ui.dashboard.dashtable;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.forms.xfdf.XfdfConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeTableMonthlyNewResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final /* data */ class TimeTableMonthlyNewResponse implements Parcelable {
    public static final Parcelable.Creator<TimeTableMonthlyNewResponse> CREATOR = new Creator();
    private final boolean login;
    private final String semester_end_date;
    private final String semester_start_date;
    private final ArrayList<TimeTableNewResponse> timetable;

    /* JADX INFO: compiled from: TimeTableMonthlyNewResponse.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TimeTableMonthlyNewResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TimeTableMonthlyNewResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z = parcel.readInt() != 0;
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(TimeTableNewResponse.CREATOR.createFromParcel(parcel));
            }
            return new TimeTableMonthlyNewResponse(z, string, string2, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TimeTableMonthlyNewResponse[] newArray(int i) {
            return new TimeTableMonthlyNewResponse[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TimeTableMonthlyNewResponse copy$default(TimeTableMonthlyNewResponse timeTableMonthlyNewResponse, boolean z, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = timeTableMonthlyNewResponse.login;
        }
        if ((i & 2) != 0) {
            str = timeTableMonthlyNewResponse.semester_start_date;
        }
        if ((i & 4) != 0) {
            str2 = timeTableMonthlyNewResponse.semester_end_date;
        }
        if ((i & 8) != 0) {
            arrayList = timeTableMonthlyNewResponse.timetable;
        }
        return timeTableMonthlyNewResponse.copy(z, str, str2, arrayList);
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

    public final ArrayList<TimeTableNewResponse> component4() {
        return this.timetable;
    }

    public final TimeTableMonthlyNewResponse copy(boolean login, String semester_start_date, String semester_end_date, ArrayList<TimeTableNewResponse> timetable) {
        Intrinsics.checkNotNullParameter(semester_start_date, "semester_start_date");
        Intrinsics.checkNotNullParameter(semester_end_date, "semester_end_date");
        Intrinsics.checkNotNullParameter(timetable, "timetable");
        return new TimeTableMonthlyNewResponse(login, semester_start_date, semester_end_date, timetable);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeTableMonthlyNewResponse)) {
            return false;
        }
        TimeTableMonthlyNewResponse timeTableMonthlyNewResponse = (TimeTableMonthlyNewResponse) other;
        return this.login == timeTableMonthlyNewResponse.login && Intrinsics.areEqual(this.semester_start_date, timeTableMonthlyNewResponse.semester_start_date) && Intrinsics.areEqual(this.semester_end_date, timeTableMonthlyNewResponse.semester_end_date) && Intrinsics.areEqual(this.timetable, timeTableMonthlyNewResponse.timetable);
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
        return "TimeTableMonthlyNewResponse(login=" + this.login + ", semester_start_date=" + this.semester_start_date + ", semester_end_date=" + this.semester_end_date + ", timetable=" + this.timetable + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.login ? 1 : 0);
        parcel.writeString(this.semester_start_date);
        parcel.writeString(this.semester_end_date);
        ArrayList<TimeTableNewResponse> arrayList = this.timetable;
        parcel.writeInt(arrayList.size());
        Iterator<TimeTableNewResponse> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public TimeTableMonthlyNewResponse(boolean z, String semester_start_date, String semester_end_date, ArrayList<TimeTableNewResponse> timetable) {
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

    public final ArrayList<TimeTableNewResponse> getTimetable() {
        return this.timetable;
    }
}