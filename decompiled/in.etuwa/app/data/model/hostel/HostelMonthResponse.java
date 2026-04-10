package in.etuwa.app.data.model.hostel;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelMonthResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class HostelMonthResponse {
    private final String date;
    private final ArrayList<HostelMonth> hostel;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostelMonthResponse copy$default(HostelMonthResponse hostelMonthResponse, boolean z, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hostelMonthResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = hostelMonthResponse.hostel;
        }
        if ((i & 4) != 0) {
            str = hostelMonthResponse.date;
        }
        return hostelMonthResponse.copy(z, arrayList, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelMonth> component2() {
        return this.hostel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final HostelMonthResponse copy(boolean login, ArrayList<HostelMonth> hostel, String date) {
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(date, "date");
        return new HostelMonthResponse(login, hostel, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelMonthResponse)) {
            return false;
        }
        HostelMonthResponse hostelMonthResponse = (HostelMonthResponse) other;
        return this.login == hostelMonthResponse.login && Intrinsics.areEqual(this.hostel, hostelMonthResponse.hostel) && Intrinsics.areEqual(this.date, hostelMonthResponse.date);
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
        return (((r0 * 31) + this.hostel.hashCode()) * 31) + this.date.hashCode();
    }

    public String toString() {
        return "HostelMonthResponse(login=" + this.login + ", hostel=" + this.hostel + ", date=" + this.date + ")";
    }

    public HostelMonthResponse(boolean z, ArrayList<HostelMonth> hostel, String date) {
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(date, "date");
        this.login = z;
        this.hostel = hostel;
        this.date = date;
    }

    public final String getDate() {
        return this.date;
    }

    public final ArrayList<HostelMonth> getHostel() {
        return this.hostel;
    }

    public final boolean getLogin() {
        return this.login;
    }
}