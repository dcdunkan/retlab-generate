package in.etuwa.app.data.model.attendance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttendanceDayRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/attendance/AttendanceDayRequest;", "", AttendanceDayDialogKt.ARG_SEM, "", "date", "(Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getSemester", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    /* renamed from: component2, reason: from getter */
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