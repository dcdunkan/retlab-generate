package in.etuwa.app.data.model.examregister;

import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RevaluationView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class RevaluationView {
    private final String answer_script;
    private final String course;
    private final String revaluation;
    private final String revaluation_id;
    private final String total;
    private final String type;

    public static /* synthetic */ RevaluationView copy$default(RevaluationView revaluationView, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = revaluationView.course;
        }
        if ((i & 2) != 0) {
            str2 = revaluationView.type;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = revaluationView.revaluation;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = revaluationView.answer_script;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = revaluationView.total;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = revaluationView.revaluation_id;
        }
        return revaluationView.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCourse() {
        return this.course;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRevaluation() {
        return this.revaluation;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAnswer_script() {
        return this.answer_script;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTotal() {
        return this.total;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRevaluation_id() {
        return this.revaluation_id;
    }

    public final RevaluationView copy(String course, String type, String revaluation, String answer_script, String total, String revaluation_id) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        Intrinsics.checkNotNullParameter(answer_script, "answer_script");
        Intrinsics.checkNotNullParameter(total, "total");
        Intrinsics.checkNotNullParameter(revaluation_id, "revaluation_id");
        return new RevaluationView(course, type, revaluation, answer_script, total, revaluation_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RevaluationView)) {
            return false;
        }
        RevaluationView revaluationView = (RevaluationView) other;
        return Intrinsics.areEqual(this.course, revaluationView.course) && Intrinsics.areEqual(this.type, revaluationView.type) && Intrinsics.areEqual(this.revaluation, revaluationView.revaluation) && Intrinsics.areEqual(this.answer_script, revaluationView.answer_script) && Intrinsics.areEqual(this.total, revaluationView.total) && Intrinsics.areEqual(this.revaluation_id, revaluationView.revaluation_id);
    }

    public int hashCode() {
        return (((((((((this.course.hashCode() * 31) + this.type.hashCode()) * 31) + this.revaluation.hashCode()) * 31) + this.answer_script.hashCode()) * 31) + this.total.hashCode()) * 31) + this.revaluation_id.hashCode();
    }

    public String toString() {
        return "RevaluationView(course=" + this.course + ", type=" + this.type + ", revaluation=" + this.revaluation + ", answer_script=" + this.answer_script + ", total=" + this.total + ", revaluation_id=" + this.revaluation_id + ")";
    }

    public RevaluationView(String course, String type, String revaluation, String answer_script, String total, String revaluation_id) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        Intrinsics.checkNotNullParameter(answer_script, "answer_script");
        Intrinsics.checkNotNullParameter(total, "total");
        Intrinsics.checkNotNullParameter(revaluation_id, "revaluation_id");
        this.course = course;
        this.type = type;
        this.revaluation = revaluation;
        this.answer_script = answer_script;
        this.total = total;
        this.revaluation_id = revaluation_id;
    }

    public final String getCourse() {
        return this.course;
    }

    public final String getType() {
        return this.type;
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

    public final String getRevaluation_id() {
        return this.revaluation_id;
    }
}