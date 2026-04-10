package in.etuwa.app.data.model.leave.duty;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DutyLeaveHeadResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class DutyLeaveHeadResponse {
    private final ArrayList<DutyLeaveHead> data;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DutyLeaveHeadResponse copy$default(DutyLeaveHeadResponse dutyLeaveHeadResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dutyLeaveHeadResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = dutyLeaveHeadResponse.data;
        }
        return dutyLeaveHeadResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<DutyLeaveHead> component2() {
        return this.data;
    }

    public final DutyLeaveHeadResponse copy(boolean login, ArrayList<DutyLeaveHead> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new DutyLeaveHeadResponse(login, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DutyLeaveHeadResponse)) {
            return false;
        }
        DutyLeaveHeadResponse dutyLeaveHeadResponse = (DutyLeaveHeadResponse) other;
        return this.login == dutyLeaveHeadResponse.login && Intrinsics.areEqual(this.data, dutyLeaveHeadResponse.data);
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
        return "DutyLeaveHeadResponse(login=" + this.login + ", data=" + this.data + ")";
    }

    public DutyLeaveHeadResponse(boolean z, ArrayList<DutyLeaveHead> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.login = z;
        this.data = data;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<DutyLeaveHead> getData() {
        return this.data;
    }
}