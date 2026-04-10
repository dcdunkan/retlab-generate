package in.etuwa.app.data.model.due.duepay;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DuePayResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class DuePayResponse {
    private final ArrayList<DuePay> dues;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DuePayResponse copy$default(DuePayResponse duePayResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = duePayResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = duePayResponse.dues;
        }
        return duePayResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<DuePay> component2() {
        return this.dues;
    }

    public final DuePayResponse copy(boolean login, ArrayList<DuePay> dues) {
        Intrinsics.checkNotNullParameter(dues, "dues");
        return new DuePayResponse(login, dues);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DuePayResponse)) {
            return false;
        }
        DuePayResponse duePayResponse = (DuePayResponse) other;
        return this.login == duePayResponse.login && Intrinsics.areEqual(this.dues, duePayResponse.dues);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.dues.hashCode();
    }

    public String toString() {
        return "DuePayResponse(login=" + this.login + ", dues=" + this.dues + ")";
    }

    public DuePayResponse(boolean z, ArrayList<DuePay> dues) {
        Intrinsics.checkNotNullParameter(dues, "dues");
        this.login = z;
        this.dues = dues;
    }

    public final ArrayList<DuePay> getDues() {
        return this.dues;
    }

    public final boolean getLogin() {
        return this.login;
    }
}