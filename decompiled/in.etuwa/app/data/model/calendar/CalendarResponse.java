package in.etuwa.app.data.model.calendar;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CalendarResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class CalendarResponse {

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
    public static /* synthetic */ CalendarResponse copy$default(CalendarResponse calendarResponse, boolean z, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = calendarResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = calendarResponse.data;
        }
        if ((i & 4) != 0) {
            str = calendarResponse.error;
        }
        return calendarResponse.copy(z, arrayList, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Calendar> component2() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final CalendarResponse copy(boolean login, ArrayList<Calendar> data, String error) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(error, "error");
        return new CalendarResponse(login, data, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarResponse)) {
            return false;
        }
        CalendarResponse calendarResponse = (CalendarResponse) other;
        return this.login == calendarResponse.login && Intrinsics.areEqual(this.data, calendarResponse.data) && Intrinsics.areEqual(this.error, calendarResponse.error);
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
        return (((r0 * 31) + this.data.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "CalendarResponse(login=" + this.login + ", data=" + this.data + ", error=" + this.error + ")";
    }

    public CalendarResponse(boolean z, ArrayList<Calendar> data, String error) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.data = data;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Calendar> getData() {
        return this.data;
    }

    public final String getError() {
        return this.error;
    }
}