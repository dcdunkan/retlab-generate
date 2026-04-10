package in.etuwa.app.data.model.attendance;

import com.itextpdf.kernel.xmp.PdfConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AttendanceDay.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AttendanceDay {
    private final String attendance;
    private final ArrayList<String> coverage;
    private final String hour;
    private final String subject;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AttendanceDay copy$default(AttendanceDay attendanceDay, String str, String str2, ArrayList arrayList, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attendanceDay.hour;
        }
        if ((i & 2) != 0) {
            str2 = attendanceDay.subject;
        }
        if ((i & 4) != 0) {
            arrayList = attendanceDay.coverage;
        }
        if ((i & 8) != 0) {
            str3 = attendanceDay.attendance;
        }
        return attendanceDay.copy(str, str2, arrayList, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHour() {
        return this.hour;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    public final ArrayList<String> component3() {
        return this.coverage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAttendance() {
        return this.attendance;
    }

    public final AttendanceDay copy(String hour, String subject, ArrayList<String> coverage, String attendance) {
        Intrinsics.checkNotNullParameter(hour, "hour");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(coverage, "coverage");
        Intrinsics.checkNotNullParameter(attendance, "attendance");
        return new AttendanceDay(hour, subject, coverage, attendance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendanceDay)) {
            return false;
        }
        AttendanceDay attendanceDay = (AttendanceDay) other;
        return Intrinsics.areEqual(this.hour, attendanceDay.hour) && Intrinsics.areEqual(this.subject, attendanceDay.subject) && Intrinsics.areEqual(this.coverage, attendanceDay.coverage) && Intrinsics.areEqual(this.attendance, attendanceDay.attendance);
    }

    public int hashCode() {
        return (((((this.hour.hashCode() * 31) + this.subject.hashCode()) * 31) + this.coverage.hashCode()) * 31) + this.attendance.hashCode();
    }

    public String toString() {
        return "AttendanceDay(hour=" + this.hour + ", subject=" + this.subject + ", coverage=" + this.coverage + ", attendance=" + this.attendance + ")";
    }

    public AttendanceDay(String hour, String subject, ArrayList<String> coverage, String attendance) {
        Intrinsics.checkNotNullParameter(hour, "hour");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(coverage, "coverage");
        Intrinsics.checkNotNullParameter(attendance, "attendance");
        this.hour = hour;
        this.subject = subject;
        this.coverage = coverage;
        this.attendance = attendance;
    }

    public final String getHour() {
        return this.hour;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final ArrayList<String> getCoverage() {
        return this.coverage;
    }

    public final String getAttendance() {
        return this.attendance;
    }
}