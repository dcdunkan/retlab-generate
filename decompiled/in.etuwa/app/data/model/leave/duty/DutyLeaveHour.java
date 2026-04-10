package in.etuwa.app.data.model.leave.duty;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DutyLeaveHour.kt */
/* loaded from: classes3.dex */
public final /* data */ class DutyLeaveHour {
    private final int hour;
    private final String status;

    public static /* synthetic */ DutyLeaveHour copy$default(DutyLeaveHour dutyLeaveHour, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dutyLeaveHour.hour;
        }
        if ((i2 & 2) != 0) {
            str = dutyLeaveHour.status;
        }
        return dutyLeaveHour.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getHour() {
        return this.hour;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final DutyLeaveHour copy(int hour, String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new DutyLeaveHour(hour, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DutyLeaveHour)) {
            return false;
        }
        DutyLeaveHour dutyLeaveHour = (DutyLeaveHour) other;
        return this.hour == dutyLeaveHour.hour && Intrinsics.areEqual(this.status, dutyLeaveHour.status);
    }

    public int hashCode() {
        return (this.hour * 31) + this.status.hashCode();
    }

    public String toString() {
        return "DutyLeaveHour(hour=" + this.hour + ", status=" + this.status + ")";
    }

    public DutyLeaveHour(int i, String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.hour = i;
        this.status = status;
    }

    public final int getHour() {
        return this.hour;
    }

    public final String getStatus() {
        return this.status;
    }
}