package in.etuwa.app.ui.leave.duty.fullday;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DutyStatusBeanFull.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lin/etuwa/app/ui/leave/duty/fullday/DutyStatusBeanFull;", "", "day", "", NotificationCompat.CATEGORY_STATUS, "(Ljava/lang/String;Ljava/lang/String;)V", "getDay", "()Ljava/lang/String;", "setDay", "(Ljava/lang/String;)V", "getStatus", "setStatus", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DutyStatusBeanFull {
    private String day;
    private String status;

    public DutyStatusBeanFull(String day, String status) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(status, "status");
        this.day = day;
        this.status = status;
    }

    public final String getDay() {
        return this.day;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setDay(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.day = str;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }
}