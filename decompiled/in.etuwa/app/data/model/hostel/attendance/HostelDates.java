package in.etuwa.app.data.model.hostel.attendance;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelAttParentView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class HostelDates {
    private final boolean checkedStates;
    private final String date;
    private final String id;

    public static /* synthetic */ HostelDates copy$default(HostelDates hostelDates, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hostelDates.id;
        }
        if ((i & 2) != 0) {
            str2 = hostelDates.date;
        }
        if ((i & 4) != 0) {
            z = hostelDates.checkedStates;
        }
        return hostelDates.copy(str, str2, z);
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
    public final boolean getCheckedStates() {
        return this.checkedStates;
    }

    public final HostelDates copy(String id, String date, boolean checkedStates) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        return new HostelDates(id, date, checkedStates);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelDates)) {
            return false;
        }
        HostelDates hostelDates = (HostelDates) other;
        return Intrinsics.areEqual(this.id, hostelDates.id) && Intrinsics.areEqual(this.date, hostelDates.date) && this.checkedStates == hostelDates.checkedStates;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.date.hashCode()) * 31;
        boolean z = this.checkedStates;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "HostelDates(id=" + this.id + ", date=" + this.date + ", checkedStates=" + this.checkedStates + ")";
    }

    public HostelDates(String id, String date, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        this.id = id;
        this.date = date;
        this.checkedStates = z;
    }

    public final String getId() {
        return this.id;
    }

    public final String getDate() {
        return this.date;
    }

    public final boolean getCheckedStates() {
        return this.checkedStates;
    }
}