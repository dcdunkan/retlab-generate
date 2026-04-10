package in.etuwa.app.data.model.leave.duty;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DutyLeaveDateResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class DutyLeaveDateResponse {
    private final ArrayList<DutyLeaveDate> data;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DutyLeaveDateResponse copy$default(DutyLeaveDateResponse dutyLeaveDateResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dutyLeaveDateResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = dutyLeaveDateResponse.data;
        }
        return dutyLeaveDateResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<DutyLeaveDate> component2() {
        return this.data;
    }

    public final DutyLeaveDateResponse copy(boolean login, ArrayList<DutyLeaveDate> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new DutyLeaveDateResponse(login, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DutyLeaveDateResponse)) {
            return false;
        }
        DutyLeaveDateResponse dutyLeaveDateResponse = (DutyLeaveDateResponse) other;
        return this.login == dutyLeaveDateResponse.login && Intrinsics.areEqual(this.data, dutyLeaveDateResponse.data);
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
        return "DutyLeaveDateResponse(login=" + this.login + ", data=" + this.data + ")";
    }

    public DutyLeaveDateResponse(boolean z, ArrayList<DutyLeaveDate> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.login = z;
        this.data = data;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<DutyLeaveDate> getData() {
        return this.data;
    }
}