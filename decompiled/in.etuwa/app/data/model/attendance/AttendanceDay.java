package in.etuwa.app.data.model.attendance;

import com.itextpdf.kernel.xmp.PdfConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttendanceDay.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003JA\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/model/attendance/AttendanceDay;", "", "hour", "", "subject", PdfConst.Coverage, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "attendance", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getAttendance", "()Ljava/lang/String;", "getCoverage", "()Ljava/util/ArrayList;", "getHour", "getSubject", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getHour() {
        return this.hour;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    public final ArrayList<String> component3() {
        return this.coverage;
    }

    /* renamed from: component4, reason: from getter */
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