package in.etuwa.app.data.model.calendar;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CalendarResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CalendarResponse {
    private final ArrayList<Birthday> birthday;

    @SerializedName(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)
    @Expose
    private final ArrayList<Calendar> data;

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CalendarResponse copy$default(CalendarResponse calendarResponse, boolean z, ArrayList arrayList, ArrayList arrayList2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = calendarResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = calendarResponse.data;
        }
        if ((i & 4) != 0) {
            arrayList2 = calendarResponse.birthday;
        }
        if ((i & 8) != 0) {
            str = calendarResponse.error;
        }
        return calendarResponse.copy(z, arrayList, arrayList2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Calendar> component2() {
        return this.data;
    }

    public final ArrayList<Birthday> component3() {
        return this.birthday;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final CalendarResponse copy(boolean login, ArrayList<Calendar> data, ArrayList<Birthday> birthday, String error) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(birthday, "birthday");
        Intrinsics.checkNotNullParameter(error, "error");
        return new CalendarResponse(login, data, birthday, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarResponse)) {
            return false;
        }
        CalendarResponse calendarResponse = (CalendarResponse) other;
        return this.login == calendarResponse.login && Intrinsics.areEqual(this.data, calendarResponse.data) && Intrinsics.areEqual(this.birthday, calendarResponse.birthday) && Intrinsics.areEqual(this.error, calendarResponse.error);
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
        return (((((r0 * 31) + this.data.hashCode()) * 31) + this.birthday.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "CalendarResponse(login=" + this.login + ", data=" + this.data + ", birthday=" + this.birthday + ", error=" + this.error + ")";
    }

    public CalendarResponse(boolean z, ArrayList<Calendar> data, ArrayList<Birthday> birthday, String error) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(birthday, "birthday");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.data = data;
        this.birthday = birthday;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Calendar> getData() {
        return this.data;
    }

    public final ArrayList<Birthday> getBirthday() {
        return this.birthday;
    }

    public final String getError() {
        return this.error;
    }
}