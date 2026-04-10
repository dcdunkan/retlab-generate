package in.etuwa.app.data.model.hostel.attendance;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelAttParentViewResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class HostelAttParentViewResponse {
    private final ArrayList<HostelAttParentView> data;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostelAttParentViewResponse copy$default(HostelAttParentViewResponse hostelAttParentViewResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hostelAttParentViewResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = hostelAttParentViewResponse.data;
        }
        return hostelAttParentViewResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelAttParentView> component2() {
        return this.data;
    }

    public final HostelAttParentViewResponse copy(boolean login, ArrayList<HostelAttParentView> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new HostelAttParentViewResponse(login, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelAttParentViewResponse)) {
            return false;
        }
        HostelAttParentViewResponse hostelAttParentViewResponse = (HostelAttParentViewResponse) other;
        return this.login == hostelAttParentViewResponse.login && Intrinsics.areEqual(this.data, hostelAttParentViewResponse.data);
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
        return "HostelAttParentViewResponse(login=" + this.login + ", data=" + this.data + ")";
    }

    public HostelAttParentViewResponse(boolean z, ArrayList<HostelAttParentView> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.login = z;
        this.data = data;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelAttParentView> getData() {
        return this.data;
    }
}