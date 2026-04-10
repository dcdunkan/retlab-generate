package in.etuwa.app.data.model.survey.posurvey;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: POSurveyResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class POSurveyResponse {
    private final ArrayList<POSurvey> posurvey;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ POSurveyResponse copy$default(POSurveyResponse pOSurveyResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = pOSurveyResponse.posurvey;
        }
        return pOSurveyResponse.copy(arrayList);
    }

    public final ArrayList<POSurvey> component1() {
        return this.posurvey;
    }

    public final POSurveyResponse copy(ArrayList<POSurvey> posurvey) {
        Intrinsics.checkNotNullParameter(posurvey, "posurvey");
        return new POSurveyResponse(posurvey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof POSurveyResponse) && Intrinsics.areEqual(this.posurvey, ((POSurveyResponse) other).posurvey);
    }

    public int hashCode() {
        return this.posurvey.hashCode();
    }

    public String toString() {
        return "POSurveyResponse(posurvey=" + this.posurvey + ")";
    }

    public POSurveyResponse(ArrayList<POSurvey> posurvey) {
        Intrinsics.checkNotNullParameter(posurvey, "posurvey");
        this.posurvey = posurvey;
    }

    public final ArrayList<POSurvey> getPosurvey() {
        return this.posurvey;
    }
}