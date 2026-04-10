package in.etuwa.app.data.model.main;

import kotlin.Metadata;

/* JADX INFO: compiled from: SurveyPending.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SurveyPending {
    private final boolean profile_status;
    private final boolean semreg_default;
    private final boolean survey_status;

    public static /* synthetic */ SurveyPending copy$default(SurveyPending surveyPending, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = surveyPending.profile_status;
        }
        if ((i & 2) != 0) {
            z2 = surveyPending.semreg_default;
        }
        if ((i & 4) != 0) {
            z3 = surveyPending.survey_status;
        }
        return surveyPending.copy(z, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getProfile_status() {
        return this.profile_status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSemreg_default() {
        return this.semreg_default;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSurvey_status() {
        return this.survey_status;
    }

    public final SurveyPending copy(boolean profile_status, boolean semreg_default, boolean survey_status) {
        return new SurveyPending(profile_status, semreg_default, survey_status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyPending)) {
            return false;
        }
        SurveyPending surveyPending = (SurveyPending) other;
        return this.profile_status == surveyPending.profile_status && this.semreg_default == surveyPending.semreg_default && this.survey_status == surveyPending.survey_status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z = this.profile_status;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.semreg_default;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.survey_status;
        return i2 + (z3 ? 1 : z3);
    }

    public String toString() {
        return "SurveyPending(profile_status=" + this.profile_status + ", semreg_default=" + this.semreg_default + ", survey_status=" + this.survey_status + ")";
    }

    public SurveyPending(boolean z, boolean z2, boolean z3) {
        this.profile_status = z;
        this.semreg_default = z2;
        this.survey_status = z3;
    }

    public final boolean getProfile_status() {
        return this.profile_status;
    }

    public final boolean getSemreg_default() {
        return this.semreg_default;
    }

    public final boolean getSurvey_status() {
        return this.survey_status;
    }
}