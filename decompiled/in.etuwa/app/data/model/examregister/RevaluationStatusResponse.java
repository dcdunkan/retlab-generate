package in.etuwa.app.data.model.examregister;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* compiled from: RevaluationStatusResponse.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/data/model/examregister/RevaluationStatusResponse;", "", NotificationCompat.CATEGORY_STATUS, "", "(Z)V", "getStatus", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RevaluationStatusResponse {
    private final boolean status;

    public static /* synthetic */ RevaluationStatusResponse copy$default(RevaluationStatusResponse revaluationStatusResponse, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = revaluationStatusResponse.status;
        }
        return revaluationStatusResponse.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    public final RevaluationStatusResponse copy(boolean status) {
        return new RevaluationStatusResponse(status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RevaluationStatusResponse) && this.status == ((RevaluationStatusResponse) other).status;
    }

    public int hashCode() {
        boolean z = this.status;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "RevaluationStatusResponse(status=" + this.status + ")";
    }

    public RevaluationStatusResponse(boolean z) {
        this.status = z;
    }

    public final boolean getStatus() {
        return this.status;
    }
}