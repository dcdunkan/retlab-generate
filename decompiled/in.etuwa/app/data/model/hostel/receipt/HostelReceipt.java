package in.etuwa.app.data.model.hostel.receipt;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelReceipt.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/data/model/hostel/receipt/HostelReceipt;", "", "feeReceiptNo", "", "hostel", "installment", ExamSubjectDetailDialogKt.ARG_AMOUNT, "receipt_date", "receipt_url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getFeeReceiptNo", "getHostel", "getInstallment", "getReceipt_date", "getReceipt_url", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getFeeReceiptNo() {
        return this.feeReceiptNo;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHostel() {
        return this.hostel;
    }

    /* renamed from: component3, reason: from getter */
    public final String getInstallment() {
        return this.installment;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component5, reason: from getter */
    public final String getReceipt_date() {
        return this.receipt_date;
    }

    /* renamed from: component6, reason: from getter */
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