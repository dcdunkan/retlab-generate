package in.etuwa.app.data.model.examregister;

import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RevaluationView.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/data/model/examregister/RevaluationView;", "", "course", "", "type", "revaluation", "answer_script", FeeConfirmDialogKt.ARG_TOTAL, "revaluation_id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnswer_script", "()Ljava/lang/String;", "getCourse", "getRevaluation", "getRevaluation_id", "getTotal", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getCourse() {
        return this.course;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRevaluation() {
        return this.revaluation;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAnswer_script() {
        return this.answer_script;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTotal() {
        return this.total;
    }

    /* renamed from: component6, reason: from getter */
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