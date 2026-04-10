package in.etuwa.app.data.model.survey;

import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubmitResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SubmitTeacherResponse {
    private final String error;
    private final boolean status;

    public static /* synthetic */ SubmitTeacherResponse copy$default(SubmitTeacherResponse submitTeacherResponse, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = submitTeacherResponse.status;
        }
        if ((i & 2) != 0) {
            str = submitTeacherResponse.error;
        }
        return submitTeacherResponse.copy(z, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final SubmitTeacherResponse copy(boolean status, String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return new SubmitTeacherResponse(status, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubmitTeacherResponse)) {
            return false;
        }
        SubmitTeacherResponse submitTeacherResponse = (SubmitTeacherResponse) other;
        return this.status == submitTeacherResponse.status && Intrinsics.areEqual(this.error, submitTeacherResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.status;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.error.hashCode();
    }

    public String toString() {
        return "SubmitTeacherResponse(status=" + this.status + ", error=" + this.error + ")";
    }

    public SubmitTeacherResponse(boolean z, String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.status = z;
        this.error = error;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final String getError() {
        return this.error;
    }
}