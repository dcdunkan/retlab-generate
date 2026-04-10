package in.etuwa.app.data.model.examregister;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RevaluationApplyResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class RevaluationApplyResponse {
    private final ArrayList<RevaluationApply> revaluation;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RevaluationApplyResponse copy$default(RevaluationApplyResponse revaluationApplyResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = revaluationApplyResponse.revaluation;
        }
        return revaluationApplyResponse.copy(arrayList);
    }

    public final ArrayList<RevaluationApply> component1() {
        return this.revaluation;
    }

    public final RevaluationApplyResponse copy(ArrayList<RevaluationApply> revaluation) {
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        return new RevaluationApplyResponse(revaluation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RevaluationApplyResponse) && Intrinsics.areEqual(this.revaluation, ((RevaluationApplyResponse) other).revaluation);
    }

    public int hashCode() {
        return this.revaluation.hashCode();
    }

    public String toString() {
        return "RevaluationApplyResponse(revaluation=" + this.revaluation + ")";
    }

    public RevaluationApplyResponse(ArrayList<RevaluationApply> revaluation) {
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        this.revaluation = revaluation;
    }

    public final ArrayList<RevaluationApply> getRevaluation() {
        return this.revaluation;
    }
}