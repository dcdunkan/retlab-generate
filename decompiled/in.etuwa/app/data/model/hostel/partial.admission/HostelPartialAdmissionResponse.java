package in.etuwa.app.data.model.hostel.partial.admission;

import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.data.model.hostel.HostelFeeTypes;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelPartialAdmissionResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class HostelPartialAdmissionResponse {
    private final String date;
    private final String fine;
    private final ArrayList<HostelPartialAdmission> hostel;
    private final boolean login;
    private final String method;
    private final ArrayList<HostelFeeTypes> types;

    public static /* synthetic */ HostelPartialAdmissionResponse copy$default(HostelPartialAdmissionResponse hostelPartialAdmissionResponse, boolean z, ArrayList arrayList, ArrayList arrayList2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hostelPartialAdmissionResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = hostelPartialAdmissionResponse.types;
        }
        ArrayList arrayList3 = arrayList;
        if ((i & 4) != 0) {
            arrayList2 = hostelPartialAdmissionResponse.hostel;
        }
        ArrayList arrayList4 = arrayList2;
        if ((i & 8) != 0) {
            str = hostelPartialAdmissionResponse.fine;
        }
        String str4 = str;
        if ((i & 16) != 0) {
            str2 = hostelPartialAdmissionResponse.method;
        }
        String str5 = str2;
        if ((i & 32) != 0) {
            str3 = hostelPartialAdmissionResponse.date;
        }
        return hostelPartialAdmissionResponse.copy(z, arrayList3, arrayList4, str4, str5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelFeeTypes> component2() {
        return this.types;
    }

    public final ArrayList<HostelPartialAdmission> component3() {
        return this.hostel;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFine() {
        return this.fine;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final HostelPartialAdmissionResponse copy(boolean login, ArrayList<HostelFeeTypes> types, ArrayList<HostelPartialAdmission> hostel, String fine, String method, String date) {
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(date, "date");
        return new HostelPartialAdmissionResponse(login, types, hostel, fine, method, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelPartialAdmissionResponse)) {
            return false;
        }
        HostelPartialAdmissionResponse hostelPartialAdmissionResponse = (HostelPartialAdmissionResponse) other;
        return this.login == hostelPartialAdmissionResponse.login && Intrinsics.areEqual(this.types, hostelPartialAdmissionResponse.types) && Intrinsics.areEqual(this.hostel, hostelPartialAdmissionResponse.hostel) && Intrinsics.areEqual(this.fine, hostelPartialAdmissionResponse.fine) && Intrinsics.areEqual(this.method, hostelPartialAdmissionResponse.method) && Intrinsics.areEqual(this.date, hostelPartialAdmissionResponse.date);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((r0 * 31) + this.types.hashCode()) * 31) + this.hostel.hashCode()) * 31) + this.fine.hashCode()) * 31) + this.method.hashCode()) * 31) + this.date.hashCode();
    }

    public String toString() {
        return "HostelPartialAdmissionResponse(login=" + this.login + ", types=" + this.types + ", hostel=" + this.hostel + ", fine=" + this.fine + ", method=" + this.method + ", date=" + this.date + ")";
    }

    public HostelPartialAdmissionResponse(boolean z, ArrayList<HostelFeeTypes> types, ArrayList<HostelPartialAdmission> hostel, String fine, String method, String date) {
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(date, "date");
        this.login = z;
        this.types = types;
        this.hostel = hostel;
        this.fine = fine;
        this.method = method;
        this.date = date;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelFeeTypes> getTypes() {
        return this.types;
    }

    public final ArrayList<HostelPartialAdmission> getHostel() {
        return this.hostel;
    }

    public final String getFine() {
        return this.fine;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getDate() {
        return this.date;
    }
}