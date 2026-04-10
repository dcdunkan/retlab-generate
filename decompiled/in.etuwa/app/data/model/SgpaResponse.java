package in.etuwa.app.data.model;

import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalysisModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SgpaResponse {

    @SerializedName(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)
    private final List<String> data;

    @SerializedName("message")
    private final String message;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private final boolean status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SgpaResponse copy$default(SgpaResponse sgpaResponse, boolean z, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = sgpaResponse.status;
        }
        if ((i & 2) != 0) {
            str = sgpaResponse.message;
        }
        if ((i & 4) != 0) {
            list = sgpaResponse.data;
        }
        return sgpaResponse.copy(z, str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final List<String> component3() {
        return this.data;
    }

    public final SgpaResponse copy(boolean status, String message, List<String> data) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new SgpaResponse(status, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SgpaResponse)) {
            return false;
        }
        SgpaResponse sgpaResponse = (SgpaResponse) other;
        return this.status == sgpaResponse.status && Intrinsics.areEqual(this.message, sgpaResponse.message) && Intrinsics.areEqual(this.data, sgpaResponse.data);
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
        List<String> list = this.data;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "SgpaResponse(status=" + this.status + ", message=" + this.message + ", data=" + this.data + ")";
    }

    public SgpaResponse(boolean z, String message, List<String> list) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.status = z;
        this.message = message;
        this.data = list;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<String> getData() {
        return this.data;
    }
}