package in.etuwa.app.data.model.attendance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttendancePeriod.kt */
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