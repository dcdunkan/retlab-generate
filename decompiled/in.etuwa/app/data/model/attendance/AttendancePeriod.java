package in.etuwa.app.data.model.attendance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttendancePeriod.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/data/model/attendance/AttendancePeriod;", "", "hour", "", "subject", "", "attendance", "(ILjava/lang/String;Ljava/lang/String;)V", "getAttendance", "()Ljava/lang/String;", "getHour", "()I", "getSubject", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AttendancePeriod {

    @SerializedName("attendance")
    @Expose
    private final String attendance;

    @SerializedName("hour")
    @Expose
    private final int hour;

    @SerializedName("subject")
    @Expose
    private final String subject;

    public static /* synthetic */ AttendancePeriod copy$default(AttendancePeriod attendancePeriod, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = attendancePeriod.hour;
        }
        if ((i2 & 2) != 0) {
            str = attendancePeriod.subject;
        }
        if ((i2 & 4) != 0) {
            str2 = attendancePeriod.attendance;
        }
        return attendancePeriod.copy(i, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getHour() {
        return this.hour;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAttendance() {
        return this.attendance;
    }

    public final AttendancePeriod copy(int hour, String subject, String attendance) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(attendance, "attendance");
        return new AttendancePeriod(hour, subject, attendance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendancePeriod)) {
            return false;
        }
        AttendancePeriod attendancePeriod = (AttendancePeriod) other;
        return this.hour == attendancePeriod.hour && Intrinsics.areEqual(this.subject, attendancePeriod.subject) && Intrinsics.areEqual(this.attendance, attendancePeriod.attendance);
    }

    public int hashCode() {
        return (((this.hour * 31) + this.subject.hashCode()) * 31) + this.attendance.hashCode();
    }

    public String toString() {
        return "AttendancePeriod(hour=" + this.hour + ", subject=" + this.subject + ", attendance=" + this.attendance + ")";
    }

    public AttendancePeriod(int i, String subject, String attendance) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(attendance, "attendance");
        this.hour = i;
        this.subject = subject;
        this.attendance = attendance;
    }

    public final int getHour() {
        return this.hour;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getAttendance() {
        return this.attendance;
    }
}