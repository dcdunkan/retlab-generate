package in.etuwa.app.data.model.examregister;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RevaluationReceipt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class RevaluationReceipt {
    private final String answer_script;
    private final String course;
    private final String revaluation;

    public static /* synthetic */ RevaluationReceipt copy$default(RevaluationReceipt revaluationReceipt, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = revaluationReceipt.course;
        }
        if ((i & 2) != 0) {
            str2 = revaluationReceipt.revaluation;
        }
        if ((i & 4) != 0) {
            str3 = revaluationReceipt.answer_script;
        }
        return revaluationReceipt.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCourse() {
        return this.course;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRevaluation() {
        return this.revaluation;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAnswer_script() {
        return this.answer_script;
    }

    public final RevaluationReceipt copy(String course, String revaluation, String answer_script) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        Intrinsics.checkNotNullParameter(answer_script, "answer_script");
        return new RevaluationReceipt(course, revaluation, answer_script);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RevaluationReceipt)) {
            return false;
        }
        RevaluationReceipt revaluationReceipt = (RevaluationReceipt) other;
        return Intrinsics.areEqual(this.course, revaluationReceipt.course) && Intrinsics.areEqual(this.revaluation, revaluationReceipt.revaluation) && Intrinsics.areEqual(this.answer_script, revaluationReceipt.answer_script);
    }

    public int hashCode() {
        return (((this.course.hashCode() * 31) + this.revaluation.hashCode()) * 31) + this.answer_script.hashCode();
    }

    public String toString() {
        return "RevaluationReceipt(course=" + this.course + ", revaluation=" + this.revaluation + ", answer_script=" + this.answer_script + ")";
    }

    public RevaluationReceipt(String course, String revaluation, String answer_script) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        Intrinsics.checkNotNullParameter(answer_script, "answer_script");
        this.course = course;
        this.revaluation = revaluation;
        this.answer_script = answer_script;
    }

    public final String getCourse() {
        return this.course;
    }

    public final String getRevaluation() {
        return this.revaluation;
    }

    public final String getAnswer_script() {
        return this.answer_script;
    }
}