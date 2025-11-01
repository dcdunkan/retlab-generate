package in.etuwa.app.ui.academicfee;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AcadamicFeeBean.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/academicfee/AcadamicFeeBean;", "", "name", "", ExamSubjectDetailDialogKt.ARG_AMOUNT, "scholer", "paid", "balance", "payable", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getBalance", "getName", "getPaid", "getPayable", "getScholer", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AcadamicFeeBean {
    private final String amount;
    private final String balance;
    private final String name;
    private final String paid;
    private final String payable;
    private final String scholer;

    public AcadamicFeeBean(String name, String amount, String scholer, String paid, String balance, String payable) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(amount, "amount");
        Intrinsics.checkNotNullParameter(scholer, "scholer");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(payable, "payable");
        this.name = name;
        this.amount = amount;
        this.scholer = scholer;
        this.paid = paid;
        this.balance = balance;
        this.payable = payable;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPaid() {
        return this.paid;
    }

    public final String getScholer() {
        return this.scholer;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final String getPayable() {
        return this.payable;
    }
}