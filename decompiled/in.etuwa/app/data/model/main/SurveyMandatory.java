package in.etuwa.app.data.model.main;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: SurveyMandatory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SurveyMandatory {
    private final boolean login;
    private final boolean survey_mandatory;

    public static /* synthetic */ SurveyMandatory copy$default(SurveyMandatory surveyMandatory, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = surveyMandatory.login;
        }
        if ((i & 2) != 0) {
            z2 = surveyMandatory.survey_mandatory;
        }
        return surveyMandatory.copy(z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSurvey_mandatory() {
        return this.survey_mandatory;
    }

    public final SurveyMandatory copy(boolean login, boolean survey_mandatory) {
        return new SurveyMandatory(login, survey_mandatory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyMandatory)) {
            return false;
        }
        SurveyMandatory surveyMandatory = (SurveyMandatory) other;
        return this.login == surveyMandatory.login && this.survey_mandatory == surveyMandatory.survey_mandatory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.survey_mandatory;
        return i + (z2 ? 1 : z2);
    }

    public String toString() {
        return "SurveyMandatory(login=" + this.login + ", survey_mandatory=" + this.survey_mandatory + ")";
    }

    public SurveyMandatory(boolean z, boolean z2) {
        this.login = z;
        this.survey_mandatory = z2;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSurvey_mandatory() {
        return this.survey_mandatory;
    }
}