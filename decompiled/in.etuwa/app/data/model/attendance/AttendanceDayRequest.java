package in.etuwa.app.data.model.attendance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AttendanceDayRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AttendanceDayRequest {

    @SerializedName("date")
    @Expose
    private final String date;

    @SerializedName(AttendanceDayDialogKt.ARG_SEM)
    @Expose
    private final String semester;

    public static /* synthetic */ AttendanceDayRequest copy$default(AttendanceDayRequest attendanceDayRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attendanceDayRequest.semester;
        }
        if ((i & 2) != 0) {
            str2 = attendanceDayRequest.date;
        }
        return attendanceDayRequest.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final AttendanceDayRequest copy(String semester, String date) {
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(date, "date");
        return new AttendanceDayRequest(semester, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendanceDayRequest)) {
            return false;
        }
        AttendanceDayRequest attendanceDayRequest = (AttendanceDayRequest) other;
        return Intrinsics.areEqual(this.semester, attendanceDayRequest.semester) && Intrinsics.areEqual(this.date, attendanceDayRequest.date);
    }

    public int hashCode() {
        return (this.semester.hashCode() * 31) + this.date.hashCode();
    }

    public String toString() {
        return "AttendanceDayRequest(semester=" + this.semester + ", date=" + this.date + ")";
    }

    public AttendanceDayRequest(String semester, String date) {
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(date, "date");
        this.semester = semester;
        this.date = date;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getDate() {
        return this.date;
    }
}