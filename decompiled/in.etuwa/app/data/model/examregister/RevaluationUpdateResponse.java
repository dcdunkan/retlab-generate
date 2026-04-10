package in.etuwa.app.data.model.examregister;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RevaluationUpdateResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class RevaluationUpdateResponse {
    private final ArrayList<RevaluationUpdate> revaluation;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RevaluationUpdateResponse copy$default(RevaluationUpdateResponse revaluationUpdateResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = revaluationUpdateResponse.revaluation;
        }
        return revaluationUpdateResponse.copy(arrayList);
    }

    public final ArrayList<RevaluationUpdate> component1() {
        return this.revaluation;
    }

    public final RevaluationUpdateResponse copy(ArrayList<RevaluationUpdate> revaluation) {
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        return new RevaluationUpdateResponse(revaluation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RevaluationUpdateResponse) && Intrinsics.areEqual(this.revaluation, ((RevaluationUpdateResponse) other).revaluation);
    }

    public int hashCode() {
        return this.revaluation.hashCode();
    }

    public String toString() {
        return "RevaluationUpdateResponse(revaluation=" + this.revaluation + ")";
    }

    public RevaluationUpdateResponse(ArrayList<RevaluationUpdate> revaluation) {
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        this.revaluation = revaluation;
    }

    public final ArrayList<RevaluationUpdate> getRevaluation() {
        return this.revaluation;
    }
}