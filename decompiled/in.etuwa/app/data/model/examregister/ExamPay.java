package in.etuwa.app.data.model.examregister;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamPay.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/examregister/ExamPay;", "", ExamSubjectDetailDialogKt.ARG_AMOUNT, "", "fixed_amount", "fineAmount", "totalAmount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getFineAmount", "getFixed_amount", "getTotalAmount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFixed_amount() {
        return this.fixed_amount;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFineAmount() {
        return this.fineAmount;
    }

    /* renamed from: component4, reason: from getter */
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