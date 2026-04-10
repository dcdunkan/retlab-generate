package in.etuwa.app.data.model.counselling;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CounsellingResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class CounsellingResponse {
    private final boolean login;
    private final ArrayList<Counselling> requests;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CounsellingResponse copy$default(CounsellingResponse counsellingResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = counsellingResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = counsellingResponse.requests;
        }
        return counsellingResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Counselling> component2() {
        return this.requests;
    }

    public final CounsellingResponse copy(boolean login, ArrayList<Counselling> requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        return new CounsellingResponse(login, requests);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CounsellingResponse)) {
            return false;
        }
        CounsellingResponse counsellingResponse = (CounsellingResponse) other;
        return this.login == counsellingResponse.login && Intrinsics.areEqual(this.requests, counsellingResponse.requests);
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
        return (r0 * 31) + this.requests.hashCode();
    }

    public String toString() {
        return "CounsellingResponse(login=" + this.login + ", requests=" + this.requests + ")";
    }

    public CounsellingResponse(boolean z, ArrayList<Counselling> requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        this.login = z;
        this.requests = requests;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Counselling> getRequests() {
        return this.requests;
    }
}