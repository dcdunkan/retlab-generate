package in.etuwa.app.ui.evaluation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: EvaluationFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class EvaluationFragment$onDownloadComplete$1$onReceive$adapterToNotify$5 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    EvaluationFragment$onDownloadComplete$1$onReceive$adapterToNotify$5(Object obj) {
        super(1, obj, EvaluationModuleAdapter.class, "notifyDataChanged", "notifyDataChanged(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((EvaluationModuleAdapter) this.receiver).notifyDataChanged(i);
    }
}