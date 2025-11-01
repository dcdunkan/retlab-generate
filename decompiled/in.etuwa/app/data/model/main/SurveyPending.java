package in.etuwa.app.data.model.main;

import kotlin.Metadata;

/* compiled from: SurveyPending.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/main/SurveyPending;", "", "profile_status", "", "semreg_default", "survey_status", "(ZZZ)V", "getProfile_status", "()Z", "getSemreg_default", "getSurvey_status", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getProfile_status() {
        return this.profile_status;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSemreg_default() {
        return this.semreg_default;
    }

    /* renamed from: component3, reason: from getter */
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
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z = this.profile_status;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.semreg_default;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        boolean z2 = this.survey_status;
        return i3 + (z2 ? 1 : z2 ? 1 : 0);
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