package in.etuwa.app.data.model.leave.duty;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DutyLeaveDate.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/data/model/leave/duty/DutyLeaveDate;", "", "date", "", "selected", "", "hours", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/leave/duty/DutyLeaveHour;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;ZLjava/util/ArrayList;)V", "getDate", "()Ljava/lang/String;", "getHours", "()Ljava/util/ArrayList;", "getSelected", "()Z", "setSelected", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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