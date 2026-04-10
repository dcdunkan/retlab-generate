package in.etuwa.app.ui.leave.duty.fullday;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DutyStatusBeanFull.kt */
/* JADX INFO: loaded from: classes5.dex */
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