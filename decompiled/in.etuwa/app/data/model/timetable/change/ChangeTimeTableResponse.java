package in.etuwa.app.data.model.timetable.change;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChangeTimeTableResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ChangeTimeTableResponse {
    private String date;
    private String inplace;
    private String period;
    private String teacher;

    public static /* synthetic */ ChangeTimeTableResponse copy$default(ChangeTimeTableResponse changeTimeTableResponse, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = changeTimeTableResponse.date;
        }
        if ((i & 2) != 0) {
            str2 = changeTimeTableResponse.teacher;
        }
        if ((i & 4) != 0) {
            str3 = changeTimeTableResponse.inplace;
        }
        if ((i & 8) != 0) {
            str4 = changeTimeTableResponse.period;
        }
        return changeTimeTableResponse.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTeacher() {
        return this.teacher;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInplace() {
        return this.inplace;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPeriod() {
        return this.period;
    }

    public final ChangeTimeTableResponse copy(String date, String teacher, String inplace, String period) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(inplace, "inplace");
        Intrinsics.checkNotNullParameter(period, "period");
        return new ChangeTimeTableResponse(date, teacher, inplace, period);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChangeTimeTableResponse)) {
            return false;
        }
        ChangeTimeTableResponse changeTimeTableResponse = (ChangeTimeTableResponse) other;
        return Intrinsics.areEqual(this.date, changeTimeTableResponse.date) && Intrinsics.areEqual(this.teacher, changeTimeTableResponse.teacher) && Intrinsics.areEqual(this.inplace, changeTimeTableResponse.inplace) && Intrinsics.areEqual(this.period, changeTimeTableResponse.period);
    }

    public int hashCode() {
        return (((((this.date.hashCode() * 31) + this.teacher.hashCode()) * 31) + this.inplace.hashCode()) * 31) + this.period.hashCode();
    }

    public String toString() {
        return "ChangeTimeTableResponse(date=" + this.date + ", teacher=" + this.teacher + ", inplace=" + this.inplace + ", period=" + this.period + ")";
    }

    public ChangeTimeTableResponse(String date, String teacher, String inplace, String period) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(inplace, "inplace");
        Intrinsics.checkNotNullParameter(period, "period");
        this.date = date;
        this.teacher = teacher;
        this.inplace = inplace;
        this.period = period;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final String getTeacher() {
        return this.teacher;
    }

    public final void setTeacher(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.teacher = str;
    }

    public final String getInplace() {
        return this.inplace;
    }

    public final void setInplace(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.inplace = str;
    }

    public final String getPeriod() {
        return this.period;
    }

    public final void setPeriod(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.period = str;
    }
}