package in.etuwa.app.data.model.timetable.change;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChangeTimeTableResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/data/model/timetable/change/ChangeTimeTableResponse;", "", "date", "", "teacher", "inplace", TypedValues.CycleType.S_WAVE_PERIOD, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getInplace", "setInplace", "getPeriod", "setPeriod", "getTeacher", "setTeacher", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTeacher() {
        return this.teacher;
    }

    /* renamed from: component3, reason: from getter */
    public final String getInplace() {
        return this.inplace;
    }

    /* renamed from: component4, reason: from getter */
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