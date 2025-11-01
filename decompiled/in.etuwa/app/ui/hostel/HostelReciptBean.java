package in.etuwa.app.ui.hostel;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelReciptBean.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/hostel/HostelReciptBean;", "", "receipt_no", "", "hostel", "installment", ExamSubjectDetailDialogKt.ARG_AMOUNT, "date", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getDate", "getHostel", "getInstallment", "getReceipt_no", "getUrl", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
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