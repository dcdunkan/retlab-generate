package in.etuwa.app.data.model.examregister;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* compiled from: RevaluationStatusResponse.kt */
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