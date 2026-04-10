package in.etuwa.app.ui.hostel.attendance.parent.approveview;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParentApproveDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final /* data */ class LeaveDateState {
    private final String date;
    private final String id;
    private final boolean isChecked;

    public static /* synthetic */ LeaveDateState copy$default(LeaveDateState leaveDateState, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = leaveDateState.id;
        }
        if ((i & 2) != 0) {
            str2 = leaveDateState.date;
        }
        if ((i & 4) != 0) {
            z = leaveDateState.isChecked;
        }
        return leaveDateState.copy(str, str2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final LeaveDateState copy(String id, String date, boolean isChecked) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        return new LeaveDateState(id, date, isChecked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveDateState)) {
            return false;
        }
        LeaveDateState leaveDateState = (LeaveDateState) other;
        return Intrinsics.areEqual(this.id, leaveDateState.id) && Intrinsics.areEqual(this.date, leaveDateState.date) && this.isChecked == leaveDateState.isChecked;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.date.hashCode()) * 31;
        boolean z = this.isChecked;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "LeaveDateState(id=" + this.id + ", date=" + this.date + ", isChecked=" + this.isChecked + ")";
    }

    public LeaveDateState(String id, String date, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        this.id = id;
        this.date = date;
        this.isChecked = z;
    }

    public final String getId() {
        return this.id;
    }

    public final String getDate() {
        return this.date;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }
}