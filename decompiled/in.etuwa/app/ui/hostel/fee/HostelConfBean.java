package in.etuwa.app.ui.hostel.fee;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelConfBean.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class HostelConfBean {
    private final String amount;
    private final String name;

    public HostelConfBean(String name, String amount) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(amount, "amount");
        this.name = name;
        this.amount = amount;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getName() {
        return this.name;
    }
}