package in.etuwa.app.data.model.examregister;

import androidx.core.app.NotificationCompat;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamUpdate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ExamUpdate {
    private final String amount;
    private final String course;
    private final String feehead_id;
    private final String is_eligible;
    private boolean is_selected;
    private final String msg;
    private final String type;

    public static /* synthetic */ ExamUpdate copy$default(ExamUpdate examUpdate, String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = examUpdate.course;
        }
        if ((i & 2) != 0) {
            str2 = examUpdate.type;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = examUpdate.is_eligible;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = examUpdate.msg;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = examUpdate.amount;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = examUpdate.feehead_id;
        }
        String str11 = str6;
        if ((i & 64) != 0) {
            z = examUpdate.is_selected;
        }
        return examUpdate.copy(str, str7, str8, str9, str10, str11, z);
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
    public final String getIs_eligible() {
        return this.is_eligible;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFeehead_id() {
        return this.feehead_id;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIs_selected() {
        return this.is_selected;
    }

    public final ExamUpdate copy(String course, String type, String is_eligible, String msg, String amount, String feehead_id, boolean is_selected) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(is_eligible, "is_eligible");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(feehead_id, "feehead_id");
        return new ExamUpdate(course, type, is_eligible, msg, amount, feehead_id, is_selected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamUpdate)) {
            return false;
        }
        ExamUpdate examUpdate = (ExamUpdate) other;
        return Intrinsics.areEqual(this.course, examUpdate.course) && Intrinsics.areEqual(this.type, examUpdate.type) && Intrinsics.areEqual(this.is_eligible, examUpdate.is_eligible) && Intrinsics.areEqual(this.msg, examUpdate.msg) && Intrinsics.areEqual(this.amount, examUpdate.amount) && Intrinsics.areEqual(this.feehead_id, examUpdate.feehead_id) && this.is_selected == examUpdate.is_selected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public int hashCode() {
        int iHashCode = ((((((((((this.course.hashCode() * 31) + this.type.hashCode()) * 31) + this.is_eligible.hashCode()) * 31) + this.msg.hashCode()) * 31) + this.amount.hashCode()) * 31) + this.feehead_id.hashCode()) * 31;
        boolean z = this.is_selected;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "ExamUpdate(course=" + this.course + ", type=" + this.type + ", is_eligible=" + this.is_eligible + ", msg=" + this.msg + ", amount=" + this.amount + ", feehead_id=" + this.feehead_id + ", is_selected=" + this.is_selected + ")";
    }

    public ExamUpdate(String course, String type, String is_eligible, String msg, String amount, String feehead_id, boolean z) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(is_eligible, "is_eligible");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(feehead_id, "feehead_id");
        this.course = course;
        this.type = type;
        this.is_eligible = is_eligible;
        this.msg = msg;
        this.amount = amount;
        this.feehead_id = feehead_id;
        this.is_selected = z;
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

    public final String getMsg() {
        return this.msg;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getFeehead_id() {
        return this.feehead_id;
    }

    public final boolean is_selected() {
        return this.is_selected;
    }

    public final void set_selected(boolean z) {
        this.is_selected = z;
    }
}