package in.etuwa.app.data.model.main;

import kotlin.Metadata;

/* JADX INFO: compiled from: POSurveyPending.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class POSurveyPending {
    private final boolean posurvey_status;

    public static /* synthetic */ POSurveyPending copy$default(POSurveyPending pOSurveyPending, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pOSurveyPending.posurvey_status;
        }
        return pOSurveyPending.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getPosurvey_status() {
        return this.posurvey_status;
    }

    public final POSurveyPending copy(boolean posurvey_status) {
        return new POSurveyPending(posurvey_status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof POSurveyPending) && this.posurvey_status == ((POSurveyPending) other).posurvey_status;
    }

    public int hashCode() {
        boolean z = this.posurvey_status;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "POSurveyPending(posurvey_status=" + this.posurvey_status + ")";
    }

    public POSurveyPending(boolean z) {
        this.posurvey_status = z;
    }

    public final boolean getPosurvey_status() {
        return this.posurvey_status;
    }
}