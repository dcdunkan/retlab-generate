package in.etuwa.app.data.model.hostel.attendance;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LeaveType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class LeaveType {
    private final int id;
    private final String type;

    public static /* synthetic */ LeaveType copy$default(LeaveType leaveType, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = leaveType.id;
        }
        if ((i2 & 2) != 0) {
            str = leaveType.type;
        }
        return leaveType.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final LeaveType copy(int id, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new LeaveType(id, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveType)) {
            return false;
        }
        LeaveType leaveType = (LeaveType) other;
        return this.id == leaveType.id && Intrinsics.areEqual(this.type, leaveType.type);
    }

    public int hashCode() {
        return (this.id * 31) + this.type.hashCode();
    }

    public String toString() {
        return "LeaveType(id=" + this.id + ", type=" + this.type + ")";
    }

    public LeaveType(int i, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = i;
        this.type = type;
    }

    public final int getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }
}