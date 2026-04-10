package in.etuwa.app.ui.hostel.fee;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelFeeBean.kt */
/* JADX INFO: loaded from: classes5.dex */
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