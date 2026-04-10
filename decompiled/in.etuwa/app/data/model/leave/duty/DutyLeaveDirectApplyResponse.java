package in.etuwa.app.data.model.leave.duty;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DutyLeaveDirectApplyResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class DutyLeaveDirectApplyResponse {
    private final ArrayList<DutyLeaveDirectApply> data;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DutyLeaveDirectApplyResponse copy$default(DutyLeaveDirectApplyResponse dutyLeaveDirectApplyResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dutyLeaveDirectApplyResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = dutyLeaveDirectApplyResponse.data;
        }
        return dutyLeaveDirectApplyResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<DutyLeaveDirectApply> component2() {
        return this.data;
    }

    public final DutyLeaveDirectApplyResponse copy(boolean login, ArrayList<DutyLeaveDirectApply> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new DutyLeaveDirectApplyResponse(login, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DutyLeaveDirectApplyResponse)) {
            return false;
        }
        DutyLeaveDirectApplyResponse dutyLeaveDirectApplyResponse = (DutyLeaveDirectApplyResponse) other;
        return this.login == dutyLeaveDirectApplyResponse.login && Intrinsics.areEqual(this.data, dutyLeaveDirectApplyResponse.data);
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
        return "DutyLeaveDirectApplyResponse(login=" + this.login + ", data=" + this.data + ")";
    }

    public DutyLeaveDirectApplyResponse(boolean z, ArrayList<DutyLeaveDirectApply> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.login = z;
        this.data = data;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<DutyLeaveDirectApply> getData() {
        return this.data;
    }
}