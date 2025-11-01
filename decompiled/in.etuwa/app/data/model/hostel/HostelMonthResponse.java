package in.etuwa.app.data.model.hostel;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelMonthResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\tHÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lin/etuwa/app/data/model/hostel/HostelMonthResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "hostel", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/HostelMonth;", "Lkotlin/collections/ArrayList;", "date", "", "(ZLjava/util/ArrayList;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getHostel", "()Ljava/util/ArrayList;", "getLogin", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelMonth> component2() {
        return this.hostel;
    }

    /* renamed from: component3, reason: from getter */
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