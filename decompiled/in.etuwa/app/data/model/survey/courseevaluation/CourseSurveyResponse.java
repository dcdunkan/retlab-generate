package in.etuwa.app.data.model.survey.courseevaluation;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CourseSurveyResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CourseSurveyResponse {
    private final boolean login;
    private final ArrayList<CourseSurvey> survey;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CourseSurveyResponse copy$default(CourseSurveyResponse courseSurveyResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = courseSurveyResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = courseSurveyResponse.survey;
        }
        return courseSurveyResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CourseSurvey> component2() {
        return this.survey;
    }

    public final CourseSurveyResponse copy(boolean login, ArrayList<CourseSurvey> survey) {
        Intrinsics.checkNotNullParameter(survey, "survey");
        return new CourseSurveyResponse(login, survey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CourseSurveyResponse)) {
            return false;
        }
        CourseSurveyResponse courseSurveyResponse = (CourseSurveyResponse) other;
        return this.login == courseSurveyResponse.login && Intrinsics.areEqual(this.survey, courseSurveyResponse.survey);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.survey.hashCode();
    }

    public String toString() {
        return "CourseSurveyResponse(login=" + this.login + ", survey=" + this.survey + ")";
    }

    public CourseSurveyResponse(boolean z, ArrayList<CourseSurvey> survey) {
        Intrinsics.checkNotNullParameter(survey, "survey");
        this.login = z;
        this.survey = survey;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CourseSurvey> getSurvey() {
        return this.survey;
    }
}