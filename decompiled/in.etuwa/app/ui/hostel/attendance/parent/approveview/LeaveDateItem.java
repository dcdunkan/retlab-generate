package in.etuwa.app.ui.hostel.attendance.parent.approveview;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParentApproveAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final /* data */ class LeaveDateItem {
    private final String date;
    private final String id;

    public static /* synthetic */ LeaveDateItem copy$default(LeaveDateItem leaveDateItem, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = leaveDateItem.id;
        }
        if ((i & 2) != 0) {
            str2 = leaveDateItem.date;
        }
        return leaveDateItem.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final LeaveDateItem copy(String id, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        return new LeaveDateItem(id, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveDateItem)) {
            return false;
        }
        LeaveDateItem leaveDateItem = (LeaveDateItem) other;
        return Intrinsics.areEqual(this.id, leaveDateItem.id) && Intrinsics.areEqual(this.date, leaveDateItem.date);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.date.hashCode();
    }

    public String toString() {
        return "LeaveDateItem(id=" + this.id + ", date=" + this.date + ")";
    }

    public LeaveDateItem(String id, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        this.id = id;
        this.date = date;
    }

    public final String getId() {
        return this.id;
    }

    public final String getDate() {
        return this.date;
    }
}