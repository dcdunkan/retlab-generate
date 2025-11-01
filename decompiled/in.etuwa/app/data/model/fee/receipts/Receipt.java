package in.etuwa.app.data.model.fee.receipts;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Receipt.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lin/etuwa/app/data/model/fee/receipts/Receipt;", "", "receiptNo", "", "date", "installment", FirebaseAnalytics.Param.METHOD, NotificationCompat.CATEGORY_STATUS, ExamSubjectDetailDialogKt.ARG_AMOUNT, "refundStatus", "", "refundReason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getDate", "getInstallment", "getMethod", "getReceiptNo", "getRefundReason", "getRefundStatus", "()Z", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getReceiptNo() {
        return this.receiptNo;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component3, reason: from getter */
    public final String getInstallment() {
        return this.installment;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getRefundStatus() {
        return this.refundStatus;
    }

    /* renamed from: component8, reason: from getter */
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
    public int hashCode() {
        int hashCode = ((((((((((this.receiptNo.hashCode() * 31) + this.date.hashCode()) * 31) + this.installment.hashCode()) * 31) + this.method.hashCode()) * 31) + this.status.hashCode()) * 31) + this.amount.hashCode()) * 31;
        boolean z = this.refundStatus;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + this.refundReason.hashCode();
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