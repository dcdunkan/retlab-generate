package in.etuwa.app.data.model.leavemanagement;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LeaveManagementResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class LeaveManagementResponse {
    private final ArrayList<LeaveManagement> leave_data;
    private final boolean login;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LeaveManagementResponse copy$default(LeaveManagementResponse leaveManagementResponse, boolean z, boolean z2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = leaveManagementResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = leaveManagementResponse.success;
        }
        if ((i & 4) != 0) {
            arrayList = leaveManagementResponse.leave_data;
        }
        return leaveManagementResponse.copy(z, z2, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<LeaveManagement> component3() {
        return this.leave_data;
    }

    public final LeaveManagementResponse copy(boolean login, boolean success, ArrayList<LeaveManagement> leave_data) {
        Intrinsics.checkNotNullParameter(leave_data, "leave_data");
        return new LeaveManagementResponse(login, success, leave_data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveManagementResponse)) {
            return false;
        }
        LeaveManagementResponse leaveManagementResponse = (LeaveManagementResponse) other;
        return this.login == leaveManagementResponse.login && this.success == leaveManagementResponse.success && Intrinsics.areEqual(this.leave_data, leaveManagementResponse.leave_data);
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
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.leave_data.hashCode();
    }

    public String toString() {
        return "LeaveManagementResponse(login=" + this.login + ", success=" + this.success + ", leave_data=" + this.leave_data + ")";
    }

    public LeaveManagementResponse(boolean z, boolean z2, ArrayList<LeaveManagement> leave_data) {
        Intrinsics.checkNotNullParameter(leave_data, "leave_data");
        this.login = z;
        this.success = z2;
        this.leave_data = leave_data;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<LeaveManagement> getLeave_data() {
        return this.leave_data;
    }
}