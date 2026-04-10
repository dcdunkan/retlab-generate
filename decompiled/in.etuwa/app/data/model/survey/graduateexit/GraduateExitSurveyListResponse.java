package in.etuwa.app.data.model.survey.graduateexit;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GraduateExitSurveyListResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class GraduateExitSurveyListResponse {
    private final ArrayList<GraduateExitSurveyList> gesurvey;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GraduateExitSurveyListResponse copy$default(GraduateExitSurveyListResponse graduateExitSurveyListResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = graduateExitSurveyListResponse.gesurvey;
        }
        return graduateExitSurveyListResponse.copy(arrayList);
    }

    public final ArrayList<GraduateExitSurveyList> component1() {
        return this.gesurvey;
    }

    public final GraduateExitSurveyListResponse copy(ArrayList<GraduateExitSurveyList> gesurvey) {
        Intrinsics.checkNotNullParameter(gesurvey, "gesurvey");
        return new GraduateExitSurveyListResponse(gesurvey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GraduateExitSurveyListResponse) && Intrinsics.areEqual(this.gesurvey, ((GraduateExitSurveyListResponse) other).gesurvey);
    }

    public int hashCode() {
        return this.gesurvey.hashCode();
    }

    public String toString() {
        return "GraduateExitSurveyListResponse(gesurvey=" + this.gesurvey + ")";
    }

    public GraduateExitSurveyListResponse(ArrayList<GraduateExitSurveyList> gesurvey) {
        Intrinsics.checkNotNullParameter(gesurvey, "gesurvey");
        this.gesurvey = gesurvey;
    }

    public final ArrayList<GraduateExitSurveyList> getGesurvey() {
        return this.gesurvey;
    }
}