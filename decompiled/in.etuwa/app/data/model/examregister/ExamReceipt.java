package in.etuwa.app.data.model.examregister;

import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamReceipt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ExamReceipt {
    private final String feeReceiptNo;
    private final String print_url;
    private final String receipt_date;
    private final String sub_total;

    public static /* synthetic */ ExamReceipt copy$default(ExamReceipt examReceipt, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = examReceipt.feeReceiptNo;
        }
        if ((i & 2) != 0) {
            str2 = examReceipt.sub_total;
        }
        if ((i & 4) != 0) {
            str3 = examReceipt.receipt_date;
        }
        if ((i & 8) != 0) {
            str4 = examReceipt.print_url;
        }
        return examReceipt.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFeeReceiptNo() {
        return this.feeReceiptNo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSub_total() {
        return this.sub_total;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getReceipt_date() {
        return this.receipt_date;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPrint_url() {
        return this.print_url;
    }

    public final ExamReceipt copy(String feeReceiptNo, String sub_total, String receipt_date, String print_url) {
        Intrinsics.checkNotNullParameter(feeReceiptNo, "feeReceiptNo");
        Intrinsics.checkNotNullParameter(sub_total, "sub_total");
        Intrinsics.checkNotNullParameter(receipt_date, "receipt_date");
        Intrinsics.checkNotNullParameter(print_url, "print_url");
        return new ExamReceipt(feeReceiptNo, sub_total, receipt_date, print_url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamReceipt)) {
            return false;
        }
        ExamReceipt examReceipt = (ExamReceipt) other;
        return Intrinsics.areEqual(this.feeReceiptNo, examReceipt.feeReceiptNo) && Intrinsics.areEqual(this.sub_total, examReceipt.sub_total) && Intrinsics.areEqual(this.receipt_date, examReceipt.receipt_date) && Intrinsics.areEqual(this.print_url, examReceipt.print_url);
    }

    public int hashCode() {
        return (((((this.feeReceiptNo.hashCode() * 31) + this.sub_total.hashCode()) * 31) + this.receipt_date.hashCode()) * 31) + this.print_url.hashCode();
    }

    public String toString() {
        return "ExamReceipt(feeReceiptNo=" + this.feeReceiptNo + ", sub_total=" + this.sub_total + ", receipt_date=" + this.receipt_date + ", print_url=" + this.print_url + ")";
    }

    public ExamReceipt(String feeReceiptNo, String sub_total, String receipt_date, String print_url) {
        Intrinsics.checkNotNullParameter(feeReceiptNo, "feeReceiptNo");
        Intrinsics.checkNotNullParameter(sub_total, "sub_total");
        Intrinsics.checkNotNullParameter(receipt_date, "receipt_date");
        Intrinsics.checkNotNullParameter(print_url, "print_url");
        this.feeReceiptNo = feeReceiptNo;
        this.sub_total = sub_total;
        this.receipt_date = receipt_date;
        this.print_url = print_url;
    }

    public final String getFeeReceiptNo() {
        return this.feeReceiptNo;
    }

    public final String getSub_total() {
        return this.sub_total;
    }

    public final String getReceipt_date() {
        return this.receipt_date;
    }

    public final String getPrint_url() {
        return this.print_url;
    }
}