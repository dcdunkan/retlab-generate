package in.etuwa.app.ui.evaluation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: EvaluationFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class EvaluationFragment$onDownloadComplete$1$onReceive$adapterToNotify$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    EvaluationFragment$onDownloadComplete$1$onReceive$adapterToNotify$1(Object obj) {
        super(1, obj, EvaluationAssignmentAdapter.class, "notifyDataChanged", "notifyDataChanged(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((EvaluationAssignmentAdapter) this.receiver).notifyDataChanged(i);
    }
}