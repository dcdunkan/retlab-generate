package in.etuwa.app.data.model.examregister;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamView.kt */
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