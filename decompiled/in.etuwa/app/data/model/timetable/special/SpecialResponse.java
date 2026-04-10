package in.etuwa.app.data.model.timetable.special;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpecialResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SpecialResponse {
    private String date;
    private String period;
    private String subject;
    private String teacher;

    public static /* synthetic */ SpecialResponse copy$default(SpecialResponse specialResponse, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = specialResponse.date;
        }
        if ((i & 2) != 0) {
            str2 = specialResponse.subject;
        }
        if ((i & 4) != 0) {
            str3 = specialResponse.teacher;
        }
        if ((i & 8) != 0) {
            str4 = specialResponse.period;
        }
        return specialResponse.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTeacher() {
        return this.teacher;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPeriod() {
        return this.period;
    }

    public final SpecialResponse copy(String date, String subject, String teacher, String period) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(period, "period");
        return new SpecialResponse(date, subject, teacher, period);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpecialResponse)) {
            return false;
        }
        SpecialResponse specialResponse = (SpecialResponse) other;
        return Intrinsics.areEqual(this.date, specialResponse.date) && Intrinsics.areEqual(this.subject, specialResponse.subject) && Intrinsics.areEqual(this.teacher, specialResponse.teacher) && Intrinsics.areEqual(this.period, specialResponse.period);
    }

    public int hashCode() {
        return (((((this.date.hashCode() * 31) + this.subject.hashCode()) * 31) + this.teacher.hashCode()) * 31) + this.period.hashCode();
    }

    public String toString() {
        return "SpecialResponse(date=" + this.date + ", subject=" + this.subject + ", teacher=" + this.teacher + ", period=" + this.period + ")";
    }

    public SpecialResponse(String date, String subject, String teacher, String period) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(period, "period");
        this.date = date;
        this.subject = subject;
        this.teacher = teacher;
        this.period = period;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final void setSubject(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subject = str;
    }

    public final String getTeacher() {
        return this.teacher;
    }

    public final void setTeacher(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.teacher = str;
    }

    public final String getPeriod() {
        return this.period;
    }

    public final void setPeriod(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.period = str;
    }
}