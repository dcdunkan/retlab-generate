package in.etuwa.app.data.model.examregister;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamPay.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ExamPay {
    private final String amount;
    private final String fineAmount;
    private final String fixed_amount;
    private final String totalAmount;

    public static /* synthetic */ ExamPay copy$default(ExamPay examPay, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = examPay.amount;
        }
        if ((i & 2) != 0) {
            str2 = examPay.fixed_amount;
        }
        if ((i & 4) != 0) {
            str3 = examPay.fineAmount;
        }
        if ((i & 8) != 0) {
            str4 = examPay.totalAmount;
        }
        return examPay.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFixed_amount() {
        return this.fixed_amount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFineAmount() {
        return this.fineAmount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTotalAmount() {
        return this.totalAmount;
    }

    public final ExamPay copy(String amount, String fixed_amount, String fineAmount, String totalAmount) {
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(fixed_amount, "fixed_amount");
        Intrinsics.checkNotNullParameter(fineAmount, "fineAmount");
        Intrinsics.checkNotNullParameter(totalAmount, "totalAmount");
        return new ExamPay(amount, fixed_amount, fineAmount, totalAmount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamPay)) {
            return false;
        }
        ExamPay examPay = (ExamPay) other;
        return Intrinsics.areEqual(this.amount, examPay.amount) && Intrinsics.areEqual(this.fixed_amount, examPay.fixed_amount) && Intrinsics.areEqual(this.fineAmount, examPay.fineAmount) && Intrinsics.areEqual(this.totalAmount, examPay.totalAmount);
    }

    public int hashCode() {
        return (((((this.amount.hashCode() * 31) + this.fixed_amount.hashCode()) * 31) + this.fineAmount.hashCode()) * 31) + this.totalAmount.hashCode();
    }

    public String toString() {
        return "ExamPay(amount=" + this.amount + ", fixed_amount=" + this.fixed_amount + ", fineAmount=" + this.fineAmount + ", totalAmount=" + this.totalAmount + ")";
    }

    public ExamPay(String amount, String fixed_amount, String fineAmount, String totalAmount) {
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(fixed_amount, "fixed_amount");
        Intrinsics.checkNotNullParameter(fineAmount, "fineAmount");
        Intrinsics.checkNotNullParameter(totalAmount, "totalAmount");
        this.amount = amount;
        this.fixed_amount = fixed_amount;
        this.fineAmount = fineAmount;
        this.totalAmount = totalAmount;
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