package in.etuwa.app.data.model.examregister;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamCourse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ExamCourse {
    private final String amount;
    private final String course;
    private final String feehead_id;
    private final String is_eligible;
    private boolean is_selected;
    private final int no;
    private final String type;

    public static /* synthetic */ ExamCourse copy$default(ExamCourse examCourse, int i, String str, String str2, String str3, String str4, String str5, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = examCourse.no;
        }
        if ((i2 & 2) != 0) {
            str = examCourse.feehead_id;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = examCourse.course;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = examCourse.type;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = examCourse.is_eligible;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = examCourse.amount;
        }
        String str10 = str5;
        if ((i2 & 64) != 0) {
            z = examCourse.is_selected;
        }
        return examCourse.copy(i, str6, str7, str8, str9, str10, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getNo() {
        return this.no;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFeehead_id() {
        return this.feehead_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCourse() {
        return this.course;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getIs_eligible() {
        return this.is_eligible;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIs_selected() {
        return this.is_selected;
    }

    public final ExamCourse copy(int no, String feehead_id, String course, String type, String is_eligible, String amount, boolean is_selected) {
        Intrinsics.checkNotNullParameter(feehead_id, "feehead_id");
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(is_eligible, "is_eligible");
        Intrinsics.checkNotNullParameter(amount, "amount");
        return new ExamCourse(no, feehead_id, course, type, is_eligible, amount, is_selected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamCourse)) {
            return false;
        }
        ExamCourse examCourse = (ExamCourse) other;
        return this.no == examCourse.no && Intrinsics.areEqual(this.feehead_id, examCourse.feehead_id) && Intrinsics.areEqual(this.course, examCourse.course) && Intrinsics.areEqual(this.type, examCourse.type) && Intrinsics.areEqual(this.is_eligible, examCourse.is_eligible) && Intrinsics.areEqual(this.amount, examCourse.amount) && this.is_selected == examCourse.is_selected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public int hashCode() {
        int iHashCode = ((((((((((this.no * 31) + this.feehead_id.hashCode()) * 31) + this.course.hashCode()) * 31) + this.type.hashCode()) * 31) + this.is_eligible.hashCode()) * 31) + this.amount.hashCode()) * 31;
        boolean z = this.is_selected;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "ExamCourse(no=" + this.no + ", feehead_id=" + this.feehead_id + ", course=" + this.course + ", type=" + this.type + ", is_eligible=" + this.is_eligible + ", amount=" + this.amount + ", is_selected=" + this.is_selected + ")";
    }

    public ExamCourse(int i, String feehead_id, String course, String type, String is_eligible, String amount, boolean z) {
        Intrinsics.checkNotNullParameter(feehead_id, "feehead_id");
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(is_eligible, "is_eligible");
        Intrinsics.checkNotNullParameter(amount, "amount");
        this.no = i;
        this.feehead_id = feehead_id;
        this.course = course;
        this.type = type;
        this.is_eligible = is_eligible;
        this.amount = amount;
        this.is_selected = z;
    }

    public final int getNo() {
        return this.no;
    }

    public final String getFeehead_id() {
        return this.feehead_id;
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

    public final boolean is_selected() {
        return this.is_selected;
    }

    public final void set_selected(boolean z) {
        this.is_selected = z;
    }
}