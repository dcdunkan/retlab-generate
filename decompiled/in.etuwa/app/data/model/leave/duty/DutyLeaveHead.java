package in.etuwa.app.data.model.leave.duty;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DutyLeaveHead.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class DutyLeaveHead {
    private final int id;
    private final String name;

    public static /* synthetic */ DutyLeaveHead copy$default(DutyLeaveHead dutyLeaveHead, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dutyLeaveHead.id;
        }
        if ((i2 & 2) != 0) {
            str = dutyLeaveHead.name;
        }
        return dutyLeaveHead.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final DutyLeaveHead copy(int id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new DutyLeaveHead(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DutyLeaveHead)) {
            return false;
        }
        DutyLeaveHead dutyLeaveHead = (DutyLeaveHead) other;
        return this.id == dutyLeaveHead.id && Intrinsics.areEqual(this.name, dutyLeaveHead.name);
    }

    public int hashCode() {
        return (this.id * 31) + this.name.hashCode();
    }

    public String toString() {
        return "DutyLeaveHead(id=" + this.id + ", name=" + this.name + ")";
    }

    public DutyLeaveHead(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}