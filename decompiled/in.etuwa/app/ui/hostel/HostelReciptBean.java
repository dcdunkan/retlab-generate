package in.etuwa.app.ui.hostel;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelReciptBean.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class HostelReciptBean {
    private final String amount;
    private final String date;
    private final String hostel;
    private final String installment;
    private final String receipt_no;
    private final String url;

    public HostelReciptBean(String receipt_no, String hostel, String installment, String amount, String date, String url) {
        Intrinsics.checkNotNullParameter(receipt_no, "receipt_no");
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(installment, "installment");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(url, "url");
        this.receipt_no = receipt_no;
        this.hostel = hostel;
        this.installment = installment;
        this.amount = amount;
        this.date = date;
        this.url = url;
    }

    public final String getHostel() {
        return this.hostel;
    }

    public final String getInstallment() {
        return this.installment;
    }

    public final String getReceipt_no() {
        return this.receipt_no;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getUrl() {
        return this.url;
    }
}