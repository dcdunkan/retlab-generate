package in.etuwa.app.ui.leave.duty.hour;

import androidx.core.app.NotificationCompat;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DutyStatusBeanHour.kt */
/* loaded from: classes5.dex */
public final class DutyStatusBeanHour {
    private String status;
    private String valid;

    public DutyStatusBeanHour(String status, String valid) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(valid, "valid");
        this.status = status;
        this.valid = valid;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getValid() {
        return this.valid;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final void setValid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.valid = str;
    }
}