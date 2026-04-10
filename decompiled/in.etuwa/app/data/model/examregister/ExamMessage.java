package in.etuwa.app.data.model.examregister;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamMessage.kt */
/* loaded from: classes3.dex */
public final /* data */ class ExamMessage {
    private final String amount;
    private final String course;
    private final String fineAmount;
    private final String fixed_amount;
    private final String is_eligible;
    private final String totalAmount;
    private final String type;

    public static /* synthetic */ ExamMessage copy$default(ExamMessage examMessage, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = examMessage.course;
        }
        if ((i & 2) != 0) {
            str2 = examMessage.type;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = examMessage.is_eligible;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = examMessage.amount;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = examMessage.fixed_amount;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = examMessage.fineAmount;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = examMessage.totalAmount;
        }
        return examMessage.copy(str, str8, str9, str10, str11, str12, str7);
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

    /* renamed from: component5, reason: from getter */
    public final String getFixed_amount() {
        return this.fixed_amount;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFineAmount() {
        return this.fineAmount;
    }

    /* renamed from: component7, reason: from getter */
    public final String getTotalAmount() {
        return this.totalAmount;
    }

    public final ExamMessage copy(String course, String type, String is_eligible, String amount, String fixed_amount, String fineAmount, String totalAmount) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(is_eligible, "is_eligible");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(fixed_amount, "fixed_amount");
        Intrinsics.checkNotNullParameter(fineAmount, "fineAmount");
        Intrinsics.checkNotNullParameter(totalAmount, "totalAmount");
        return new ExamMessage(course, type, is_eligible, amount, fixed_amount, fineAmount, totalAmount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamMessage)) {
            return false;
        }
        ExamMessage examMessage = (ExamMessage) other;
        return Intrinsics.areEqual(this.course, examMessage.course) && Intrinsics.areEqual(this.type, examMessage.type) && Intrinsics.areEqual(this.is_eligible, examMessage.is_eligible) && Intrinsics.areEqual(this.amount, examMessage.amount) && Intrinsics.areEqual(this.fixed_amount, examMessage.fixed_amount) && Intrinsics.areEqual(this.fineAmount, examMessage.fineAmount) && Intrinsics.areEqual(this.totalAmount, examMessage.totalAmount);
    }

    public int hashCode() {
        return (((((((((((this.course.hashCode() * 31) + this.type.hashCode()) * 31) + this.is_eligible.hashCode()) * 31) + this.amount.hashCode()) * 31) + this.fixed_amount.hashCode()) * 31) + this.fineAmount.hashCode()) * 31) + this.totalAmount.hashCode();
    }

    public String toString() {
        return "ExamMessage(course=" + this.course + ", type=" + this.type + ", is_eligible=" + this.is_eligible + ", amount=" + this.amount + ", fixed_amount=" + this.fixed_amount + ", fineAmount=" + this.fineAmount + ", totalAmount=" + this.totalAmount + ")";
    }

    public ExamMessage(String course, String type, String is_eligible, String amount, String fixed_amount, String fineAmount, String totalAmount) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(is_eligible, "is_eligible");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(fixed_amount, "fixed_amount");
        Intrinsics.checkNotNullParameter(fineAmount, "fineAmount");
        Intrinsics.checkNotNullParameter(totalAmount, "totalAmount");
        this.course = course;
        this.type = type;
        this.is_eligible = is_eligible;
        this.amount = amount;
        this.fixed_amount = fixed_amount;
        this.fineAmount = fineAmount;
        this.totalAmount = totalAmount;
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

    public final String getFixed_amount() {
        return this.fixed_amount;
    }

    public final String getFineAmount() {
        return this.fineAmount;
    }

    public final String getTotalAmount() {
        return this.totalAmount;
    }
}