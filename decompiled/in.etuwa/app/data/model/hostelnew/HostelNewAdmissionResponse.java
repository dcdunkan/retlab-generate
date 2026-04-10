package in.etuwa.app.data.model.hostelnew;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelNewAdmissionResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class HostelNewAdmissionResponse {
    private final String date;
    private final String fine;
    private final ArrayList<HostelNewAdmission> hostel;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostelNewAdmissionResponse copy$default(HostelNewAdmissionResponse hostelNewAdmissionResponse, boolean z, ArrayList arrayList, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hostelNewAdmissionResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = hostelNewAdmissionResponse.hostel;
        }
        if ((i & 4) != 0) {
            str = hostelNewAdmissionResponse.fine;
        }
        if ((i & 8) != 0) {
            str2 = hostelNewAdmissionResponse.date;
        }
        return hostelNewAdmissionResponse.copy(z, arrayList, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelNewAdmission> component2() {
        return this.hostel;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFine() {
        return this.fine;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final HostelNewAdmissionResponse copy(boolean login, ArrayList<HostelNewAdmission> hostel, String fine, String date) {
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(date, "date");
        return new HostelNewAdmissionResponse(login, hostel, fine, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelNewAdmissionResponse)) {
            return false;
        }
        HostelNewAdmissionResponse hostelNewAdmissionResponse = (HostelNewAdmissionResponse) other;
        return this.login == hostelNewAdmissionResponse.login && Intrinsics.areEqual(this.hostel, hostelNewAdmissionResponse.hostel) && Intrinsics.areEqual(this.fine, hostelNewAdmissionResponse.fine) && Intrinsics.areEqual(this.date, hostelNewAdmissionResponse.date);
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
        return (((((r0 * 31) + this.hostel.hashCode()) * 31) + this.fine.hashCode()) * 31) + this.date.hashCode();
    }

    public String toString() {
        return "HostelNewAdmissionResponse(login=" + this.login + ", hostel=" + this.hostel + ", fine=" + this.fine + ", date=" + this.date + ")";
    }

    public HostelNewAdmissionResponse(boolean z, ArrayList<HostelNewAdmission> hostel, String fine, String date) {
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(date, "date");
        this.login = z;
        this.hostel = hostel;
        this.fine = fine;
        this.date = date;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelNewAdmission> getHostel() {
        return this.hostel;
    }

    public final String getFine() {
        return this.fine;
    }

    public final String getDate() {
        return this.date;
    }
}