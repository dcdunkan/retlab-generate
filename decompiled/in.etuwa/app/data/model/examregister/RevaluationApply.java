package in.etuwa.app.data.model.examregister;

import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RevaluationApply.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lin/etuwa/app/data/model/examregister/RevaluationApply;", "", "course", "", "type", "grade", "revaluation", "answer_script", FeeConfirmDialogKt.ARG_TOTAL, "date", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnswer_script", "()Ljava/lang/String;", "getCourse", "getDate", "getGrade", "getRevaluation", "getTotal", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RevaluationApply {
    private final String answer_script;
    private final String course;
    private final String date;
    private final String grade;
    private final String revaluation;
    private final String total;
    private final String type;

    public static /* synthetic */ RevaluationApply copy$default(RevaluationApply revaluationApply, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = revaluationApply.course;
        }
        if ((i & 2) != 0) {
            str2 = revaluationApply.type;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = revaluationApply.grade;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = revaluationApply.revaluation;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = revaluationApply.answer_script;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = revaluationApply.total;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = revaluationApply.date;
        }
        return revaluationApply.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCourse() {
        return this.course;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getGrade() {
        return this.grade;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRevaluation() {
        return this.revaluation;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAnswer_script() {
        return this.answer_script;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTotal() {
        return this.total;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final RevaluationApply copy(String course, String type, String grade, String revaluation, String answer_script, String total, String date) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(grade, "grade");
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        Intrinsics.checkNotNullParameter(answer_script, "answer_script");
        Intrinsics.checkNotNullParameter(total, "total");
        Intrinsics.checkNotNullParameter(date, "date");
        return new RevaluationApply(course, type, grade, revaluation, answer_script, total, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RevaluationApply)) {
            return false;
        }
        RevaluationApply revaluationApply = (RevaluationApply) other;
        return Intrinsics.areEqual(this.course, revaluationApply.course) && Intrinsics.areEqual(this.type, revaluationApply.type) && Intrinsics.areEqual(this.grade, revaluationApply.grade) && Intrinsics.areEqual(this.revaluation, revaluationApply.revaluation) && Intrinsics.areEqual(this.answer_script, revaluationApply.answer_script) && Intrinsics.areEqual(this.total, revaluationApply.total) && Intrinsics.areEqual(this.date, revaluationApply.date);
    }

    public int hashCode() {
        return (((((((((((this.course.hashCode() * 31) + this.type.hashCode()) * 31) + this.grade.hashCode()) * 31) + this.revaluation.hashCode()) * 31) + this.answer_script.hashCode()) * 31) + this.total.hashCode()) * 31) + this.date.hashCode();
    }

    public String toString() {
        return "RevaluationApply(course=" + this.course + ", type=" + this.type + ", grade=" + this.grade + ", revaluation=" + this.revaluation + ", answer_script=" + this.answer_script + ", total=" + this.total + ", date=" + this.date + ")";
    }

    public RevaluationApply(String course, String type, String grade, String revaluation, String answer_script, String total, String date) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(grade, "grade");
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        Intrinsics.checkNotNullParameter(answer_script, "answer_script");
        Intrinsics.checkNotNullParameter(total, "total");
        Intrinsics.checkNotNullParameter(date, "date");
        this.course = course;
        this.type = type;
        this.grade = grade;
        this.revaluation = revaluation;
        this.answer_script = answer_script;
        this.total = total;
        this.date = date;
    }

    public final String getCourse() {
        return this.course;
    }

    public final String getType() {
        return this.type;
    }

    public final String getGrade() {
        return this.grade;
    }

    public final String getRevaluation() {
        return this.revaluation;
    }

    public final String getAnswer_script() {
        return this.answer_script;
    }

    public final String getTotal() {
        return this.total;
    }

    public final String getDate() {
        return this.date;
    }
}