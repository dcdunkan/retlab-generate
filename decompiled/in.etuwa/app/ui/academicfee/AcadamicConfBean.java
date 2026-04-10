package in.etuwa.app.ui.academicfee;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AcadamicConfBean.kt */
/* loaded from: classes4.dex */
public final class AcadamicConfBean {
    private final String amount;
    private final String name;

    public AcadamicConfBean(String name, String amount) {
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