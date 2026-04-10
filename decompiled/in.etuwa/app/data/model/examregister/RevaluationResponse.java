package in.etuwa.app.data.model.examregister;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RevaluationResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class RevaluationResponse {
    private final ArrayList<Revaluation> revaluation;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RevaluationResponse copy$default(RevaluationResponse revaluationResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = revaluationResponse.revaluation;
        }
        return revaluationResponse.copy(arrayList);
    }

    public final ArrayList<Revaluation> component1() {
        return this.revaluation;
    }

    public final RevaluationResponse copy(ArrayList<Revaluation> revaluation) {
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        return new RevaluationResponse(revaluation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RevaluationResponse) && Intrinsics.areEqual(this.revaluation, ((RevaluationResponse) other).revaluation);
    }

    public int hashCode() {
        return this.revaluation.hashCode();
    }

    public String toString() {
        return "RevaluationResponse(revaluation=" + this.revaluation + ")";
    }

    public RevaluationResponse(ArrayList<Revaluation> revaluation) {
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        this.revaluation = revaluation;
    }

    public final ArrayList<Revaluation> getRevaluation() {
        return this.revaluation;
    }
}