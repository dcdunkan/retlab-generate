package in.etuwa.app.data.model.main;

import kotlin.Metadata;

/* JADX INFO: compiled from: CourseSurveyPending.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CourseSurveyPending {
    private final boolean coursesurvey_status;

    public static /* synthetic */ CourseSurveyPending copy$default(CourseSurveyPending courseSurveyPending, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = courseSurveyPending.coursesurvey_status;
        }
        return courseSurveyPending.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCoursesurvey_status() {
        return this.coursesurvey_status;
    }

    public final CourseSurveyPending copy(boolean coursesurvey_status) {
        return new CourseSurveyPending(coursesurvey_status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CourseSurveyPending) && this.coursesurvey_status == ((CourseSurveyPending) other).coursesurvey_status;
    }

    public int hashCode() {
        boolean z = this.coursesurvey_status;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "CourseSurveyPending(coursesurvey_status=" + this.coursesurvey_status + ")";
    }

    public CourseSurveyPending(boolean z) {
        this.coursesurvey_status = z;
    }

    public final boolean getCoursesurvey_status() {
        return this.coursesurvey_status;
    }
}