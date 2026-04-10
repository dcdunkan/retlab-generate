package in.etuwa.app.data.model.hostelnew;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelNewHistoryResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
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