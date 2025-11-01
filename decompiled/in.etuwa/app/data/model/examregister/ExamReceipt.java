package in.etuwa.app.data.model.examregister;

import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamReceipt.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/examregister/ExamReceipt;", "", "feeReceiptNo", "", FeeConfirmDialogKt.ARG_SUB_TOTAL, "receipt_date", "print_url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFeeReceiptNo", "()Ljava/lang/String;", "getPrint_url", "getReceipt_date", "getSub_total", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getFeeReceiptNo() {
        return this.feeReceiptNo;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSub_total() {
        return this.sub_total;
    }

    /* renamed from: component3, reason: from getter */
    public final String getReceipt_date() {
        return this.receipt_date;
    }

    /* renamed from: component4, reason: from getter */
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