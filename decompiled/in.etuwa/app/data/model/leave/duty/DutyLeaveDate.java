package in.etuwa.app.data.model.leave.duty;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DutyLeaveDate.kt */
/* loaded from: classes3.dex */
public final /* data */ class DutyLeaveDate {
    private final String date;
    private final ArrayList<DutyLeaveHour> hours;
    private boolean selected;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DutyLeaveDate copy$default(DutyLeaveDate dutyLeaveDate, String str, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dutyLeaveDate.date;
        }
        if ((i & 2) != 0) {
            z = dutyLeaveDate.selected;
        }
        if ((i & 4) != 0) {
            arrayList = dutyLeaveDate.hours;
        }
        return dutyLeaveDate.copy(str, z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final ArrayList<DutyLeaveHour> component3() {
        return this.hours;
    }

    public final DutyLeaveDate copy(String date, boolean selected, ArrayList<DutyLeaveHour> hours) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(hours, "hours");
        return new DutyLeaveDate(date, selected, hours);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DutyLeaveDate)) {
            return false;
        }
        DutyLeaveDate dutyLeaveDate = (DutyLeaveDate) other;
        return Intrinsics.areEqual(this.date, dutyLeaveDate.date) && this.selected == dutyLeaveDate.selected && Intrinsics.areEqual(this.hours, dutyLeaveDate.hours);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.date.hashCode() * 31;
        boolean z = this.selected;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + this.hours.hashCode();
    }

    public String toString() {
        return "DutyLeaveDate(date=" + this.date + ", selected=" + this.selected + ", hours=" + this.hours + ")";
    }

    public DutyLeaveDate(String date, boolean z, ArrayList<DutyLeaveHour> hours) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(hours, "hours");
        this.date = date;
        this.selected = z;
        this.hours = hours;
    }

    public final String getDate() {
        return this.date;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    public final ArrayList<DutyLeaveHour> getHours() {
        return this.hours;
    }
}