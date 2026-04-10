package in.etuwa.app.ui.academicfee;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AcadamicFeeBean.kt */
/* JADX INFO: loaded from: classes4.dex */
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