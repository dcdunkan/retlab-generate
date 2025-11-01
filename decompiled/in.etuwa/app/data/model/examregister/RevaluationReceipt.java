package in.etuwa.app.data.model.examregister;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RevaluationReceipt.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/examregister/RevaluationReceipt;", "", "course", "", "revaluation", "answer_script", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnswer_script", "()Ljava/lang/String;", "getCourse", "getRevaluation", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getCourse() {
        return this.course;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRevaluation() {
        return this.revaluation;
    }

    /* renamed from: component3, reason: from getter */
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