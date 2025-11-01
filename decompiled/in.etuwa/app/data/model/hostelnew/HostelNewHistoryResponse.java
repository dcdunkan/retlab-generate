package in.etuwa.app.data.model.hostelnew;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelNewHistoryResponse.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003JG\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/data/model/hostelnew/HostelNewHistoryResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "admission_history", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostelnew/HostelNewHistory;", "Lkotlin/collections/ArrayList;", "monthly_history", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;)V", "getAdmission_history", "()Ljava/util/ArrayList;", "getLogin", "()Z", "getMonthly_history", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class HostelNewHistoryResponse {
    private final ArrayList<HostelNewHistory> admission_history;
    private final boolean login;
    private final ArrayList<HostelNewHistory> monthly_history;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostelNewHistoryResponse copy$default(HostelNewHistoryResponse hostelNewHistoryResponse, boolean z, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hostelNewHistoryResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = hostelNewHistoryResponse.admission_history;
        }
        if ((i & 4) != 0) {
            arrayList2 = hostelNewHistoryResponse.monthly_history;
        }
        return hostelNewHistoryResponse.copy(z, arrayList, arrayList2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelNewHistory> component2() {
        return this.admission_history;
    }

    public final ArrayList<HostelNewHistory> component3() {
        return this.monthly_history;
    }

    public final HostelNewHistoryResponse copy(boolean login, ArrayList<HostelNewHistory> admission_history, ArrayList<HostelNewHistory> monthly_history) {
        Intrinsics.checkNotNullParameter(admission_history, "admission_history");
        Intrinsics.checkNotNullParameter(monthly_history, "monthly_history");
        return new HostelNewHistoryResponse(login, admission_history, monthly_history);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelNewHistoryResponse)) {
            return false;
        }
        HostelNewHistoryResponse hostelNewHistoryResponse = (HostelNewHistoryResponse) other;
        return this.login == hostelNewHistoryResponse.login && Intrinsics.areEqual(this.admission_history, hostelNewHistoryResponse.admission_history) && Intrinsics.areEqual(this.monthly_history, hostelNewHistoryResponse.monthly_history);
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
        return (((r0 * 31) + this.admission_history.hashCode()) * 31) + this.monthly_history.hashCode();
    }

    public String toString() {
        return "HostelNewHistoryResponse(login=" + this.login + ", admission_history=" + this.admission_history + ", monthly_history=" + this.monthly_history + ")";
    }

    public HostelNewHistoryResponse(boolean z, ArrayList<HostelNewHistory> admission_history, ArrayList<HostelNewHistory> monthly_history) {
        Intrinsics.checkNotNullParameter(admission_history, "admission_history");
        Intrinsics.checkNotNullParameter(monthly_history, "monthly_history");
        this.login = z;
        this.admission_history = admission_history;
        this.monthly_history = monthly_history;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelNewHistory> getAdmission_history() {
        return this.admission_history;
    }

    public final ArrayList<HostelNewHistory> getMonthly_history() {
        return this.monthly_history;
    }
}