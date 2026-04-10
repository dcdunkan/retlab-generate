package in.etuwa.app.data.model.due;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DueResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class DueResponse {
    private final ArrayList<Due> due;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DueResponse copy$default(DueResponse dueResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dueResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = dueResponse.due;
        }
        return dueResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Due> component2() {
        return this.due;
    }

    public final DueResponse copy(boolean login, ArrayList<Due> due) {
        Intrinsics.checkNotNullParameter(due, "due");
        return new DueResponse(login, due);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DueResponse)) {
            return false;
        }
        DueResponse dueResponse = (DueResponse) other;
        return this.login == dueResponse.login && Intrinsics.areEqual(this.due, dueResponse.due);
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
        return (r0 * 31) + this.due.hashCode();
    }

    public String toString() {
        return "DueResponse(login=" + this.login + ", due=" + this.due + ")";
    }

    public DueResponse(boolean z, ArrayList<Due> due) {
        Intrinsics.checkNotNullParameter(due, "due");
        this.login = z;
        this.due = due;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Due> getDue() {
        return this.due;
    }
}