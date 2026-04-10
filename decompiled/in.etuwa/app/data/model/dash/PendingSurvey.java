package in.etuwa.app.data.model.dash;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PendingSurvey.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class PendingSurvey {
    private final boolean coursesurvey_status;
    private final String error;
    private final boolean posurvey_status;
    private final boolean profile_status;
    private final boolean semreg_default;
    private final boolean survey_status;

    public static /* synthetic */ PendingSurvey copy$default(PendingSurvey pendingSurvey, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pendingSurvey.survey_status;
        }
        if ((i & 2) != 0) {
            z2 = pendingSurvey.coursesurvey_status;
        }
        boolean z6 = z2;
        if ((i & 4) != 0) {
            z3 = pendingSurvey.posurvey_status;
        }
        boolean z7 = z3;
        if ((i & 8) != 0) {
            z4 = pendingSurvey.semreg_default;
        }
        boolean z8 = z4;
        if ((i & 16) != 0) {
            z5 = pendingSurvey.profile_status;
        }
        boolean z9 = z5;
        if ((i & 32) != 0) {
            str = pendingSurvey.error;
        }
        return pendingSurvey.copy(z, z6, z7, z8, z9, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSurvey_status() {
        return this.survey_status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCoursesurvey_status() {
        return this.coursesurvey_status;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getPosurvey_status() {
        return this.posurvey_status;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getSemreg_default() {
        return this.semreg_default;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getProfile_status() {
        return this.profile_status;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final PendingSurvey copy(boolean survey_status, boolean coursesurvey_status, boolean posurvey_status, boolean semreg_default, boolean profile_status, String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return new PendingSurvey(survey_status, coursesurvey_status, posurvey_status, semreg_default, profile_status, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingSurvey)) {
            return false;
        }
        PendingSurvey pendingSurvey = (PendingSurvey) other;
        return this.survey_status == pendingSurvey.survey_status && this.coursesurvey_status == pendingSurvey.coursesurvey_status && this.posurvey_status == pendingSurvey.posurvey_status && this.semreg_default == pendingSurvey.semreg_default && this.profile_status == pendingSurvey.profile_status && Intrinsics.areEqual(this.error, pendingSurvey.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z = this.survey_status;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.coursesurvey_status;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.posurvey_status;
        ?? r22 = z3;
        if (z3) {
            r22 = 1;
        }
        int i3 = (i2 + r22) * 31;
        boolean z4 = this.semreg_default;
        ?? r23 = z4;
        if (z4) {
            r23 = 1;
        }
        int i4 = (i3 + r23) * 31;
        boolean z5 = this.profile_status;
        return ((i4 + (z5 ? 1 : z5)) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "PendingSurvey(survey_status=" + this.survey_status + ", coursesurvey_status=" + this.coursesurvey_status + ", posurvey_status=" + this.posurvey_status + ", semreg_default=" + this.semreg_default + ", profile_status=" + this.profile_status + ", error=" + this.error + ")";
    }

    public PendingSurvey(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.survey_status = z;
        this.coursesurvey_status = z2;
        this.posurvey_status = z3;
        this.semreg_default = z4;
        this.profile_status = z5;
        this.error = error;
    }

    public final boolean getSurvey_status() {
        return this.survey_status;
    }

    public final boolean getCoursesurvey_status() {
        return this.coursesurvey_status;
    }

    public final boolean getPosurvey_status() {
        return this.posurvey_status;
    }

    public final boolean getSemreg_default() {
        return this.semreg_default;
    }

    public final boolean getProfile_status() {
        return this.profile_status;
    }

    public final String getError() {
        return this.error;
    }
}