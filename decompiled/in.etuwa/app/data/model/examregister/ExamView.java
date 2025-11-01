package in.etuwa.app.data.model.examregister;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamView.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J1\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lin/etuwa/app/data/model/examregister/ExamView;", "", "course", "", "type", "is_eligible", ExamSubjectDetailDialogKt.ARG_AMOUNT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getCourse", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ExamView {
    private final String amount;
    private final String course;
    private final String is_eligible;
    private final String type;

    public static /* synthetic */ ExamView copy$default(ExamView examView, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = examView.course;
        }
        if ((i & 2) != 0) {
            str2 = examView.type;
        }
        if ((i & 4) != 0) {
            str3 = examView.is_eligible;
        }
        if ((i & 8) != 0) {
            str4 = examView.amount;
        }
        return examView.copy(str, str2, str3, str4);
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
    public final String getIs_eligible() {
        return this.is_eligible;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    public final ExamView copy(String course, String type, String is_eligible, String amount) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(is_eligible, "is_eligible");
        Intrinsics.checkNotNullParameter(amount, "amount");
        return new ExamView(course, type, is_eligible, amount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamView)) {
            return false;
        }
        ExamView examView = (ExamView) other;
        return Intrinsics.areEqual(this.course, examView.course) && Intrinsics.areEqual(this.type, examView.type) && Intrinsics.areEqual(this.is_eligible, examView.is_eligible) && Intrinsics.areEqual(this.amount, examView.amount);
    }

    public int hashCode() {
        return (((((this.course.hashCode() * 31) + this.type.hashCode()) * 31) + this.is_eligible.hashCode()) * 31) + this.amount.hashCode();
    }

    public String toString() {
        return "ExamView(course=" + this.course + ", type=" + this.type + ", is_eligible=" + this.is_eligible + ", amount=" + this.amount + ")";
    }

    public ExamView(String course, String type, String is_eligible, String amount) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(is_eligible, "is_eligible");
        Intrinsics.checkNotNullParameter(amount, "amount");
        this.course = course;
        this.type = type;
        this.is_eligible = is_eligible;
        this.amount = amount;
    }

    public final String getCourse() {
        return this.course;
    }

    public final String getType() {
        return this.type;
    }

    public final String is_eligible() {
        return this.is_eligible;
    }

    public final String getAmount() {
        return this.amount;
    }
}