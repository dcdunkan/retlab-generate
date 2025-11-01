package in.etuwa.app.data.model.hostel.attendance;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelAttCalResponse.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0007\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0007\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0007\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0007HÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0007HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0007HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0007HÆ\u0003J\u0095\u0001\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00072\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00072\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00072\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006!"}, d2 = {"Lin/etuwa/app/data/model/hostel/attendance/HostelAttCalResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "monthdate", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "present", "absent", "leaves", "rejects", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getAbsent", "()Ljava/util/ArrayList;", "getLeaves", "getLogin", "()Z", "getMonthdate", "getPresent", "getRejects", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class HostelAttCalResponse {
    private final ArrayList<Boolean> absent;
    private final ArrayList<Boolean> leaves;
    private final boolean login;
    private final ArrayList<String> monthdate;
    private final ArrayList<Boolean> present;
    private final ArrayList<Boolean> rejects;

    public static /* synthetic */ HostelAttCalResponse copy$default(HostelAttCalResponse hostelAttCalResponse, boolean z, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hostelAttCalResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = hostelAttCalResponse.monthdate;
        }
        ArrayList arrayList6 = arrayList;
        if ((i & 4) != 0) {
            arrayList2 = hostelAttCalResponse.present;
        }
        ArrayList arrayList7 = arrayList2;
        if ((i & 8) != 0) {
            arrayList3 = hostelAttCalResponse.absent;
        }
        ArrayList arrayList8 = arrayList3;
        if ((i & 16) != 0) {
            arrayList4 = hostelAttCalResponse.leaves;
        }
        ArrayList arrayList9 = arrayList4;
        if ((i & 32) != 0) {
            arrayList5 = hostelAttCalResponse.rejects;
        }
        return hostelAttCalResponse.copy(z, arrayList6, arrayList7, arrayList8, arrayList9, arrayList5);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<String> component2() {
        return this.monthdate;
    }

    public final ArrayList<Boolean> component3() {
        return this.present;
    }

    public final ArrayList<Boolean> component4() {
        return this.absent;
    }

    public final ArrayList<Boolean> component5() {
        return this.leaves;
    }

    public final ArrayList<Boolean> component6() {
        return this.rejects;
    }

    public final HostelAttCalResponse copy(boolean login, ArrayList<String> monthdate, ArrayList<Boolean> present, ArrayList<Boolean> absent, ArrayList<Boolean> leaves, ArrayList<Boolean> rejects) {
        Intrinsics.checkNotNullParameter(monthdate, "monthdate");
        Intrinsics.checkNotNullParameter(present, "present");
        Intrinsics.checkNotNullParameter(absent, "absent");
        Intrinsics.checkNotNullParameter(leaves, "leaves");
        Intrinsics.checkNotNullParameter(rejects, "rejects");
        return new HostelAttCalResponse(login, monthdate, present, absent, leaves, rejects);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelAttCalResponse)) {
            return false;
        }
        HostelAttCalResponse hostelAttCalResponse = (HostelAttCalResponse) other;
        return this.login == hostelAttCalResponse.login && Intrinsics.areEqual(this.monthdate, hostelAttCalResponse.monthdate) && Intrinsics.areEqual(this.present, hostelAttCalResponse.present) && Intrinsics.areEqual(this.absent, hostelAttCalResponse.absent) && Intrinsics.areEqual(this.leaves, hostelAttCalResponse.leaves) && Intrinsics.areEqual(this.rejects, hostelAttCalResponse.rejects);
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
        return (((((((((r0 * 31) + this.monthdate.hashCode()) * 31) + this.present.hashCode()) * 31) + this.absent.hashCode()) * 31) + this.leaves.hashCode()) * 31) + this.rejects.hashCode();
    }

    public String toString() {
        return "HostelAttCalResponse(login=" + this.login + ", monthdate=" + this.monthdate + ", present=" + this.present + ", absent=" + this.absent + ", leaves=" + this.leaves + ", rejects=" + this.rejects + ")";
    }

    public HostelAttCalResponse(boolean z, ArrayList<String> monthdate, ArrayList<Boolean> present, ArrayList<Boolean> absent, ArrayList<Boolean> leaves, ArrayList<Boolean> rejects) {
        Intrinsics.checkNotNullParameter(monthdate, "monthdate");
        Intrinsics.checkNotNullParameter(present, "present");
        Intrinsics.checkNotNullParameter(absent, "absent");
        Intrinsics.checkNotNullParameter(leaves, "leaves");
        Intrinsics.checkNotNullParameter(rejects, "rejects");
        this.login = z;
        this.monthdate = monthdate;
        this.present = present;
        this.absent = absent;
        this.leaves = leaves;
        this.rejects = rejects;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<String> getMonthdate() {
        return this.monthdate;
    }

    public final ArrayList<Boolean> getPresent() {
        return this.present;
    }

    public final ArrayList<Boolean> getAbsent() {
        return this.absent;
    }

    public final ArrayList<Boolean> getLeaves() {
        return this.leaves;
    }

    public final ArrayList<Boolean> getRejects() {
        return this.rejects;
    }
}