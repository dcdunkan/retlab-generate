package in.etuwa.app.data.model;

import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalysisModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AnalysisResponse {

    @SerializedName(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)
    private final Object data;

    @SerializedName("message")
    private final String message;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private final boolean status;

    public static /* synthetic */ AnalysisResponse copy$default(AnalysisResponse analysisResponse, boolean z, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            z = analysisResponse.status;
        }
        if ((i & 2) != 0) {
            str = analysisResponse.message;
        }
        if ((i & 4) != 0) {
            obj = analysisResponse.data;
        }
        return analysisResponse.copy(z, str, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    public final AnalysisResponse copy(boolean status, String message, Object data) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new AnalysisResponse(status, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalysisResponse)) {
            return false;
        }
        AnalysisResponse analysisResponse = (AnalysisResponse) other;
        return this.status == analysisResponse.status && Intrinsics.areEqual(this.message, analysisResponse.message) && Intrinsics.areEqual(this.data, analysisResponse.data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.status;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int iHashCode = ((r0 * 31) + this.message.hashCode()) * 31;
        Object obj = this.data;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "AnalysisResponse(status=" + this.status + ", message=" + this.message + ", data=" + this.data + ")";
    }

    public AnalysisResponse(boolean z, String message, Object obj) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.status = z;
        this.message = message;
        this.data = obj;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Object getData() {
        return this.data;
    }
}