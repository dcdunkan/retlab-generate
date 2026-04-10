package in.etuwa.etlabstaff.data.model.timetable.period;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeTableHour.kt */
/* JADX INFO: loaded from: classes5.dex */
public final /* data */ class TimeTableHour {
    private final boolean attendance_status;
    private final String group;
    private final String name;
    private final String subject_id;
    private final String teacher;

    public static /* synthetic */ TimeTableHour copy$default(TimeTableHour timeTableHour, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = timeTableHour.group;
        }
        if ((i & 2) != 0) {
            str2 = timeTableHour.name;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = timeTableHour.subject_id;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = timeTableHour.teacher;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            z = timeTableHour.attendance_status;
        }
        return timeTableHour.copy(str, str5, str6, str7, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGroup() {
        return this.group;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubject_id() {
        return this.subject_id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTeacher() {
        return this.teacher;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getAttendance_status() {
        return this.attendance_status;
    }

    public final TimeTableHour copy(String group, String name, String subject_id, String teacher, boolean attendance_status) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subject_id, "subject_id");
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        return new TimeTableHour(group, name, subject_id, teacher, attendance_status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeTableHour)) {
            return false;
        }
        TimeTableHour timeTableHour = (TimeTableHour) other;
        return Intrinsics.areEqual(this.group, timeTableHour.group) && Intrinsics.areEqual(this.name, timeTableHour.name) && Intrinsics.areEqual(this.subject_id, timeTableHour.subject_id) && Intrinsics.areEqual(this.teacher, timeTableHour.teacher) && this.attendance_status == timeTableHour.attendance_status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iHashCode = ((((((this.group.hashCode() * 31) + this.name.hashCode()) * 31) + this.subject_id.hashCode()) * 31) + this.teacher.hashCode()) * 31;
        boolean z = this.attendance_status;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "TimeTableHour(group=" + this.group + ", name=" + this.name + ", subject_id=" + this.subject_id + ", teacher=" + this.teacher + ", attendance_status=" + this.attendance_status + ")";
    }

    public TimeTableHour(String group, String name, String subject_id, String teacher, boolean z) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subject_id, "subject_id");
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        this.group = group;
        this.name = name;
        this.subject_id = subject_id;
        this.teacher = teacher;
        this.attendance_status = z;
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSubject_id() {
        return this.subject_id;
    }

    public final String getTeacher() {
        return this.teacher;
    }

    public final boolean getAttendance_status() {
        return this.attendance_status;
    }
}