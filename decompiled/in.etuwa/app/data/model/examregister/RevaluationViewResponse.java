package in.etuwa.app.data.model.examregister;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RevaluationViewResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class RevaluationViewResponse {
    private final ArrayList<RevaluationView> revaluation;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RevaluationViewResponse copy$default(RevaluationViewResponse revaluationViewResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = revaluationViewResponse.revaluation;
        }
        return revaluationViewResponse.copy(arrayList);
    }

    public final ArrayList<RevaluationView> component1() {
        return this.revaluation;
    }

    public final RevaluationViewResponse copy(ArrayList<RevaluationView> revaluation) {
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        return new RevaluationViewResponse(revaluation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RevaluationViewResponse) && Intrinsics.areEqual(this.revaluation, ((RevaluationViewResponse) other).revaluation);
    }

    public int hashCode() {
        return this.revaluation.hashCode();
    }

    public String toString() {
        return "RevaluationViewResponse(revaluation=" + this.revaluation + ")";
    }

    public RevaluationViewResponse(ArrayList<RevaluationView> revaluation) {
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        this.revaluation = revaluation;
    }

    public final ArrayList<RevaluationView> getRevaluation() {
        return this.revaluation;
    }
}