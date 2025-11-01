package in.etuwa.app.data.model.leave.duty;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DutyLeaveHour.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/data/model/leave/duty/DutyLeaveHour;", "", "hour", "", NotificationCompat.CATEGORY_STATUS, "", "(ILjava/lang/String;)V", "getHour", "()I", "getStatus", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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