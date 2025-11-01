package in.etuwa.app.ui.hostel.fee;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelFeeBean.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lin/etuwa/app/ui/hostel/fee/HostelFeeBean;", "", "name", "", ExamSubjectDetailDialogKt.ARG_AMOUNT, "scholar", "payable", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getName", "getPayable", "getScholar", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelFeeBean {
    private final String amount;
    private final String name;
    private final String payable;
    private final String scholar;

    public HostelFeeBean(String name, String amount, String scholar, String payable) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(scholar, "scholar");
        Intrinsics.checkNotNullParameter(payable, "payable");
        this.name = name;
        this.amount = amount;
        this.scholar = scholar;
        this.payable = payable;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPayable() {
        return this.payable;
    }

    public final String getScholar() {
        return this.scholar;
    }
}