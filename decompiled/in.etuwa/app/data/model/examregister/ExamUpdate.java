package in.etuwa.app.data.model.examregister;

import androidx.core.app.NotificationCompat;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamUpdate.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\rR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lin/etuwa/app/data/model/examregister/ExamUpdate;", "", "course", "", "type", "is_eligible", NotificationCompat.CATEGORY_MESSAGE, ExamSubjectDetailDialogKt.ARG_AMOUNT, "feehead_id", "is_selected", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAmount", "()Ljava/lang/String;", "getCourse", "getFeehead_id", "()Z", "set_selected", "(Z)V", "getMsg", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFeehead_id() {
        return this.feehead_id;
    }

    /* renamed from: component7, reason: from getter */
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
    public int hashCode() {
        int hashCode = ((((((((((this.course.hashCode() * 31) + this.type.hashCode()) * 31) + this.is_eligible.hashCode()) * 31) + this.msg.hashCode()) * 31) + this.amount.hashCode()) * 31) + this.feehead_id.hashCode()) * 31;
        boolean z = this.is_selected;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
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