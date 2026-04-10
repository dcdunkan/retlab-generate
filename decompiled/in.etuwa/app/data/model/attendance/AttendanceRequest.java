package in.etuwa.app.data.model.attendance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttendanceRequest.kt */
/* loaded from: classes3.dex */
public final /* data */ class AttendanceRequest {

    @SerializedName("sem_id")
    @Expose
    private final String semId;

    public static /* synthetic */ AttendanceRequest copy$default(AttendanceRequest attendanceRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attendanceRequest.semId;
        }
        return attendanceRequest.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSemId() {
        return this.semId;
    }

    public final AttendanceRequest copy(String semId) {
        Intrinsics.checkNotNullParameter(semId, "semId");
        return new AttendanceRequest(semId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AttendanceRequest) && Intrinsics.areEqual(this.semId, ((AttendanceRequest) other).semId);
    }

    public int hashCode() {
        return this.semId.hashCode();
    }

    public String toString() {
        return "AttendanceRequest(semId=" + this.semId + ")";
    }

    public AttendanceRequest(String semId) {
        Intrinsics.checkNotNullParameter(semId, "semId");
        this.semId = semId;
    }

    public final String getSemId() {
        return this.semId;
    }
}