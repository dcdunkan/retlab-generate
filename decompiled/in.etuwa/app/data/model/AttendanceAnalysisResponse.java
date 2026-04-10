package in.etuwa.app.data.model;

import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalysisModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AttendanceAnalysisResponse {

    @SerializedName(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)
    private final AttendanceAnalysisData data;

    @SerializedName("message")
    private final String message;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private final boolean status;

    public static /* synthetic */ AttendanceAnalysisResponse copy$default(AttendanceAnalysisResponse attendanceAnalysisResponse, boolean z, String str, AttendanceAnalysisData attendanceAnalysisData, int i, Object obj) {
        if ((i & 1) != 0) {
            z = attendanceAnalysisResponse.status;
        }
        if ((i & 2) != 0) {
            str = attendanceAnalysisResponse.message;
        }
        if ((i & 4) != 0) {
            attendanceAnalysisData = attendanceAnalysisResponse.data;
        }
        return attendanceAnalysisResponse.copy(z, str, attendanceAnalysisData);
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
    public final AttendanceAnalysisData getData() {
        return this.data;
    }

    public final AttendanceAnalysisResponse copy(boolean status, String message, AttendanceAnalysisData data) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new AttendanceAnalysisResponse(status, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendanceAnalysisResponse)) {
            return false;
        }
        AttendanceAnalysisResponse attendanceAnalysisResponse = (AttendanceAnalysisResponse) other;
        return this.status == attendanceAnalysisResponse.status && Intrinsics.areEqual(this.message, attendanceAnalysisResponse.message) && Intrinsics.areEqual(this.data, attendanceAnalysisResponse.data);
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
        AttendanceAnalysisData attendanceAnalysisData = this.data;
        return iHashCode + (attendanceAnalysisData == null ? 0 : attendanceAnalysisData.hashCode());
    }

    public String toString() {
        return "AttendanceAnalysisResponse(status=" + this.status + ", message=" + this.message + ", data=" + this.data + ")";
    }

    public AttendanceAnalysisResponse(boolean z, String message, AttendanceAnalysisData attendanceAnalysisData) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.status = z;
        this.message = message;
        this.data = attendanceAnalysisData;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final AttendanceAnalysisData getData() {
        return this.data;
    }
}