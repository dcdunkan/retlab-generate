package in.etuwa.app.data.model.dash;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PendingSurvey.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lin/etuwa/app/data/model/dash/PendingSurvey;", "", "survey_status", "", "coursesurvey_status", "posurvey_status", "semreg_default", "profile_status", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "(ZZZZZLjava/lang/String;)V", "getCoursesurvey_status", "()Z", "getError", "()Ljava/lang/String;", "getPosurvey_status", "getProfile_status", "getSemreg_default", "getSurvey_status", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getSurvey_status() {
        return this.survey_status;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCoursesurvey_status() {
        return this.coursesurvey_status;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getPosurvey_status() {
        return this.posurvey_status;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getSemreg_default() {
        return this.semreg_default;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getProfile_status() {
        return this.profile_status;
    }

    /* renamed from: component6, reason: from getter */
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
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public int hashCode() {
        boolean z = this.survey_status;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.coursesurvey_status;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.posurvey_status;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        ?? r23 = this.semreg_default;
        int i6 = r23;
        if (r23 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        boolean z2 = this.profile_status;
        return ((i7 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.error.hashCode();
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