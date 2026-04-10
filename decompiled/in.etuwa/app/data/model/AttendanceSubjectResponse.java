package in.etuwa.app.data.model;

import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalysisModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AttendanceSubjectResponse {

    @SerializedName(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)
    private final List<List<AttendanceSubjectData>> data;

    @SerializedName("message")
    private final String message;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private final boolean status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AttendanceSubjectResponse copy$default(AttendanceSubjectResponse attendanceSubjectResponse, boolean z, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = attendanceSubjectResponse.status;
        }
        if ((i & 2) != 0) {
            str = attendanceSubjectResponse.message;
        }
        if ((i & 4) != 0) {
            list = attendanceSubjectResponse.data;
        }
        return attendanceSubjectResponse.copy(z, str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final List<List<AttendanceSubjectData>> component3() {
        return this.data;
    }

    public final AttendanceSubjectResponse copy(boolean status, String message, List<? extends List<AttendanceSubjectData>> data) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new AttendanceSubjectResponse(status, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendanceSubjectResponse)) {
            return false;
        }
        AttendanceSubjectResponse attendanceSubjectResponse = (AttendanceSubjectResponse) other;
        return this.status == attendanceSubjectResponse.status && Intrinsics.areEqual(this.message, attendanceSubjectResponse.message) && Intrinsics.areEqual(this.data, attendanceSubjectResponse.data);
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
        List<List<AttendanceSubjectData>> list = this.data;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "AttendanceSubjectResponse(status=" + this.status + ", message=" + this.message + ", data=" + this.data + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AttendanceSubjectResponse(boolean z, String message, List<? extends List<AttendanceSubjectData>> list) {
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

    public final List<List<AttendanceSubjectData>> getData() {
        return this.data;
    }
}