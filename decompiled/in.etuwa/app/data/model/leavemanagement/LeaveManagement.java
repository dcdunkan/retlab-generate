package in.etuwa.app.data.model.leavemanagement;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LeaveManagement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class LeaveManagement {
    private final String allocated_leave;
    private final int balance;
    private final int id;
    private final String leave_type;
    private final String staff_id;
    private final int taken;

    public static /* synthetic */ LeaveManagement copy$default(LeaveManagement leaveManagement, int i, String str, String str2, String str3, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = leaveManagement.id;
        }
        if ((i4 & 2) != 0) {
            str = leaveManagement.staff_id;
        }
        String str4 = str;
        if ((i4 & 4) != 0) {
            str2 = leaveManagement.leave_type;
        }
        String str5 = str2;
        if ((i4 & 8) != 0) {
            str3 = leaveManagement.allocated_leave;
        }
        String str6 = str3;
        if ((i4 & 16) != 0) {
            i2 = leaveManagement.balance;
        }
        int i5 = i2;
        if ((i4 & 32) != 0) {
            i3 = leaveManagement.taken;
        }
        return leaveManagement.copy(i, str4, str5, str6, i5, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStaff_id() {
        return this.staff_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLeave_type() {
        return this.leave_type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAllocated_leave() {
        return this.allocated_leave;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getBalance() {
        return this.balance;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getTaken() {
        return this.taken;
    }

    public final LeaveManagement copy(int id, String staff_id, String leave_type, String allocated_leave, int balance, int taken) {
        Intrinsics.checkNotNullParameter(staff_id, "staff_id");
        Intrinsics.checkNotNullParameter(leave_type, "leave_type");
        Intrinsics.checkNotNullParameter(allocated_leave, "allocated_leave");
        return new LeaveManagement(id, staff_id, leave_type, allocated_leave, balance, taken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveManagement)) {
            return false;
        }
        LeaveManagement leaveManagement = (LeaveManagement) other;
        return this.id == leaveManagement.id && Intrinsics.areEqual(this.staff_id, leaveManagement.staff_id) && Intrinsics.areEqual(this.leave_type, leaveManagement.leave_type) && Intrinsics.areEqual(this.allocated_leave, leaveManagement.allocated_leave) && this.balance == leaveManagement.balance && this.taken == leaveManagement.taken;
    }

    public int hashCode() {
        return (((((((((this.id * 31) + this.staff_id.hashCode()) * 31) + this.leave_type.hashCode()) * 31) + this.allocated_leave.hashCode()) * 31) + this.balance) * 31) + this.taken;
    }

    public String toString() {
        return "LeaveManagement(id=" + this.id + ", staff_id=" + this.staff_id + ", leave_type=" + this.leave_type + ", allocated_leave=" + this.allocated_leave + ", balance=" + this.balance + ", taken=" + this.taken + ")";
    }

    public LeaveManagement(int i, String staff_id, String leave_type, String allocated_leave, int i2, int i3) {
        Intrinsics.checkNotNullParameter(staff_id, "staff_id");
        Intrinsics.checkNotNullParameter(leave_type, "leave_type");
        Intrinsics.checkNotNullParameter(allocated_leave, "allocated_leave");
        this.id = i;
        this.staff_id = staff_id;
        this.leave_type = leave_type;
        this.allocated_leave = allocated_leave;
        this.balance = i2;
        this.taken = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final String getStaff_id() {
        return this.staff_id;
    }

    public final String getLeave_type() {
        return this.leave_type;
    }

    public final String getAllocated_leave() {
        return this.allocated_leave;
    }

    public final int getBalance() {
        return this.balance;
    }

    public final int getTaken() {
        return this.taken;
    }
}