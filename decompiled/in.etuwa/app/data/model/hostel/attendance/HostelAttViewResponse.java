package in.etuwa.app.data.model.hostel.attendance;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelAttViewResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class HostelAttViewResponse {
    private final ArrayList<HostelAttView> data;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostelAttViewResponse copy$default(HostelAttViewResponse hostelAttViewResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hostelAttViewResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = hostelAttViewResponse.data;
        }
        return hostelAttViewResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelAttView> component2() {
        return this.data;
    }

    public final HostelAttViewResponse copy(boolean login, ArrayList<HostelAttView> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new HostelAttViewResponse(login, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelAttViewResponse)) {
            return false;
        }
        HostelAttViewResponse hostelAttViewResponse = (HostelAttViewResponse) other;
        return this.login == hostelAttViewResponse.login && Intrinsics.areEqual(this.data, hostelAttViewResponse.data);
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
        return (r0 * 31) + this.data.hashCode();
    }

    public String toString() {
        return "HostelAttViewResponse(login=" + this.login + ", data=" + this.data + ")";
    }

    public HostelAttViewResponse(boolean z, ArrayList<HostelAttView> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.login = z;
        this.data = data;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelAttView> getData() {
        return this.data;
    }
}