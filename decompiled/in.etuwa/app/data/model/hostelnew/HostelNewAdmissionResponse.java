package in.etuwa.app.data.model.hostelnew;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelNewAdmissionResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\tHÖ\u0001R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/data/model/hostelnew/HostelNewAdmissionResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "hostel", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostelnew/HostelNewAdmission;", "Lkotlin/collections/ArrayList;", "fine", "", "date", "(ZLjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getFine", "getHostel", "()Ljava/util/ArrayList;", "getLogin", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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