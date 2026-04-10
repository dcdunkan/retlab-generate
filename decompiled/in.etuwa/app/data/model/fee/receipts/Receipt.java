package in.etuwa.app.data.model.fee.receipts;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Receipt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Receipt {
    private final String amount;
    private final String date;
    private final String installment;
    private final String method;

    @SerializedName("receipt_no")
    private final String receiptNo;

    @SerializedName("refund_reason")
    private final String refundReason;

    @SerializedName("refund_status")
    private final boolean refundStatus;
    private final String status;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getReceiptNo() {
        return this.receiptNo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInstallment() {
        return this.installment;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getRefundStatus() {
        return this.refundStatus;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getRefundReason() {
        return this.refundReason;
    }

    public final Receipt copy(String receiptNo, String date, String installment, String method, String status, String amount, boolean refundStatus, String refundReason) {
        Intrinsics.checkNotNullParameter(receiptNo, "receiptNo");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(refundReason, "refundReason");
        return new Receipt(receiptNo, date, installment, method, status, amount, refundStatus, refundReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Receipt)) {
            return false;
        }
        Receipt receipt = (Receipt) other;
        return Intrinsics.areEqual(this.receiptNo, receipt.receiptNo) && Intrinsics.areEqual(this.date, receipt.date) && Intrinsics.areEqual(this.installment, receipt.installment) && Intrinsics.areEqual(this.method, receipt.method) && Intrinsics.areEqual(this.status, receipt.status) && Intrinsics.areEqual(this.amount, receipt.amount) && this.refundStatus == receipt.refundStatus && Intrinsics.areEqual(this.refundReason, receipt.refundReason);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        int iHashCode = ((((((((((this.receiptNo.hashCode() * 31) + this.date.hashCode()) * 31) + this.installment.hashCode()) * 31) + this.method.hashCode()) * 31) + this.status.hashCode()) * 31) + this.amount.hashCode()) * 31;
        boolean z = this.refundStatus;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + this.refundReason.hashCode();
    }

    public String toString() {
        return "Receipt(receiptNo=" + this.receiptNo + ", date=" + this.date + ", installment=" + this.installment + ", method=" + this.method + ", status=" + this.status + ", amount=" + this.amount + ", refundStatus=" + this.refundStatus + ", refundReason=" + this.refundReason + ")";
    }

    public Receipt(String receiptNo, String date, String installment, String method, String status, String amount, boolean z, String refundReason) {
        Intrinsics.checkNotNullParameter(receiptNo, "receiptNo");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(refundReason, "refundReason");
        this.receiptNo = receiptNo;
        this.date = date;
        this.installment = installment;
        this.method = method;
        this.status = status;
        this.amount = amount;
        this.refundStatus = z;
        this.refundReason = refundReason;
    }

    public final String getReceiptNo() {
        return this.receiptNo;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getInstallment() {
        return this.installment;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final boolean getRefundStatus() {
        return this.refundStatus;
    }

    public final String getRefundReason() {
        return this.refundReason;
    }
}