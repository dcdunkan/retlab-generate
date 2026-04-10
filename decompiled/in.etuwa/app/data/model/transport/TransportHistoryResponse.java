package in.etuwa.app.data.model.transport;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransportHistoryResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class TransportHistoryResponse {
    private final ArrayList<TransportHistory> history;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransportHistoryResponse copy$default(TransportHistoryResponse transportHistoryResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = transportHistoryResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = transportHistoryResponse.history;
        }
        return transportHistoryResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<TransportHistory> component2() {
        return this.history;
    }

    public final TransportHistoryResponse copy(boolean login, ArrayList<TransportHistory> history) {
        Intrinsics.checkNotNullParameter(history, "history");
        return new TransportHistoryResponse(login, history);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportHistoryResponse)) {
            return false;
        }
        TransportHistoryResponse transportHistoryResponse = (TransportHistoryResponse) other;
        return this.login == transportHistoryResponse.login && Intrinsics.areEqual(this.history, transportHistoryResponse.history);
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
        return (r0 * 31) + this.history.hashCode();
    }

    public String toString() {
        return "TransportHistoryResponse(login=" + this.login + ", history=" + this.history + ")";
    }

    public TransportHistoryResponse(boolean z, ArrayList<TransportHistory> history) {
        Intrinsics.checkNotNullParameter(history, "history");
        this.login = z;
        this.history = history;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<TransportHistory> getHistory() {
        return this.history;
    }
}