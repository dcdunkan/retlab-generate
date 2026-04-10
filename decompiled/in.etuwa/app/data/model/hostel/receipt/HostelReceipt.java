package in.etuwa.app.data.model.hostel.receipt;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelReceipt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class HostelReceipt {
    private final String amount;
    private final String feeReceiptNo;
    private final String hostel;
    private final String installment;
    private final String receipt_date;
    private final String receipt_url;

    public static /* synthetic */ HostelReceipt copy$default(HostelReceipt hostelReceipt, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hostelReceipt.feeReceiptNo;
        }
        if ((i & 2) != 0) {
            str2 = hostelReceipt.hostel;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = hostelReceipt.installment;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = hostelReceipt.amount;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = hostelReceipt.receipt_date;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = hostelReceipt.receipt_url;
        }
        return hostelReceipt.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFeeReceiptNo() {
        return this.feeReceiptNo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHostel() {
        return this.hostel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInstallment() {
        return this.installment;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getReceipt_date() {
        return this.receipt_date;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getReceipt_url() {
        return this.receipt_url;
    }

    public final HostelReceipt copy(String feeReceiptNo, String hostel, String installment, String amount, String receipt_date, String receipt_url) {
        Intrinsics.checkNotNullParameter(feeReceiptNo, "feeReceiptNo");
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(receipt_date, "receipt_date");
        Intrinsics.checkNotNullParameter(receipt_url, "receipt_url");
        return new HostelReceipt(feeReceiptNo, hostel, installment, amount, receipt_date, receipt_url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelReceipt)) {
            return false;
        }
        HostelReceipt hostelReceipt = (HostelReceipt) other;
        return Intrinsics.areEqual(this.feeReceiptNo, hostelReceipt.feeReceiptNo) && Intrinsics.areEqual(this.hostel, hostelReceipt.hostel) && Intrinsics.areEqual(this.installment, hostelReceipt.installment) && Intrinsics.areEqual(this.amount, hostelReceipt.amount) && Intrinsics.areEqual(this.receipt_date, hostelReceipt.receipt_date) && Intrinsics.areEqual(this.receipt_url, hostelReceipt.receipt_url);
    }

    public int hashCode() {
        return (((((((((this.feeReceiptNo.hashCode() * 31) + this.hostel.hashCode()) * 31) + this.installment.hashCode()) * 31) + this.amount.hashCode()) * 31) + this.receipt_date.hashCode()) * 31) + this.receipt_url.hashCode();
    }

    public String toString() {
        return "HostelReceipt(feeReceiptNo=" + this.feeReceiptNo + ", hostel=" + this.hostel + ", installment=" + this.installment + ", amount=" + this.amount + ", receipt_date=" + this.receipt_date + ", receipt_url=" + this.receipt_url + ")";
    }

    public HostelReceipt(String feeReceiptNo, String hostel, String installment, String amount, String receipt_date, String receipt_url) {
        Intrinsics.checkNotNullParameter(feeReceiptNo, "feeReceiptNo");
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(receipt_date, "receipt_date");
        Intrinsics.checkNotNullParameter(receipt_url, "receipt_url");
        this.feeReceiptNo = feeReceiptNo;
        this.hostel = hostel;
        this.installment = installment;
        this.amount = amount;
        this.receipt_date = receipt_date;
        this.receipt_url = receipt_url;
    }

    public final String getFeeReceiptNo() {
        return this.feeReceiptNo;
    }

    public final String getHostel() {
        return this.hostel;
    }

    public final String getInstallment() {
        return this.installment;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getReceipt_date() {
        return this.receipt_date;
    }

    public final String getReceipt_url() {
        return this.receipt_url;
    }
}