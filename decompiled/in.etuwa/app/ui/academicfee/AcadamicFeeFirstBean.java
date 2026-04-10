package in.etuwa.app.ui.academicfee;

import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AcadamicFeeFirstBean.kt */
/* loaded from: classes4.dex */
public final class AcadamicFeeFirstBean {
    private final String amount;
    private final String id;
    private final String name;

    public AcadamicFeeFirstBean(String id, String name, String amount) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(amount, "amount");
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}