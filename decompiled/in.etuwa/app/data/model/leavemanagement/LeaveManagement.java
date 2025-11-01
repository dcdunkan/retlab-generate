package in.etuwa.app.data.model.leavemanagement;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LeaveManagement.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, d2 = {"Lin/etuwa/app/data/model/leavemanagement/LeaveManagement;", "", "id", "", "staff_id", "", "leave_type", "allocated_leave", "balance", "taken", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAllocated_leave", "()Ljava/lang/String;", "getBalance", "()I", "getId", "getLeave_type", "getStaff_id", "getTaken", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStaff_id() {
        return this.staff_id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLeave_type() {
        return this.leave_type;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAllocated_leave() {
        return this.allocated_leave;
    }

    /* renamed from: component5, reason: from getter */
    public final int getBalance() {
        return this.balance;
    }

    /* renamed from: component6, reason: from getter */
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