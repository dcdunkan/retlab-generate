package in.etuwa.app.data.model.examregister;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamCourse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006#"}, d2 = {"Lin/etuwa/app/data/model/examregister/ExamCourse;", "", "no", "", "feehead_id", "", "course", "type", "is_eligible", ExamSubjectDetailDialogKt.ARG_AMOUNT, "is_selected", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAmount", "()Ljava/lang/String;", "getCourse", "getFeehead_id", "()Z", "set_selected", "(Z)V", "getNo", "()I", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final int getNo() {
        return this.no;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFeehead_id() {
        return this.feehead_id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCourse() {
        return this.course;
    }

    /* renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final String getIs_eligible() {
        return this.is_eligible;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component7, reason: from getter */
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
    public int hashCode() {
        int hashCode = ((((((((((this.no * 31) + this.feehead_id.hashCode()) * 31) + this.course.hashCode()) * 31) + this.type.hashCode()) * 31) + this.is_eligible.hashCode()) * 31) + this.amount.hashCode()) * 31;
        boolean z = this.is_selected;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
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