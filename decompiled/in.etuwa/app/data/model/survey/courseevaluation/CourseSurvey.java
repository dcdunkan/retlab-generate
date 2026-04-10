package in.etuwa.app.data.model.survey.courseevaluation;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CourseSurvey.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CourseSurvey {
    private final String btn;
    private final String end_date;
    private final String session;
    private final String session_id;
    private final int slno;
    private final String start_date;
    private final String status;
    private final String survey;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSlno() {
        return this.slno;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSurvey() {
        return this.survey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSession_id() {
        return this.session_id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSession() {
        return this.session;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStart_date() {
        return this.start_date;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getEnd_date() {
        return this.end_date;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBtn() {
        return this.btn;
    }

    public final CourseSurvey copy(int slno, String survey, String session_id, String session, String start_date, String end_date, String status, String btn) {
        Intrinsics.checkNotNullParameter(survey, "survey");
        Intrinsics.checkNotNullParameter(session_id, "session_id");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(start_date, "start_date");
        Intrinsics.checkNotNullParameter(end_date, "end_date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(btn, "btn");
        return new CourseSurvey(slno, survey, session_id, session, start_date, end_date, status, btn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CourseSurvey)) {
            return false;
        }
        CourseSurvey courseSurvey = (CourseSurvey) other;
        return this.slno == courseSurvey.slno && Intrinsics.areEqual(this.survey, courseSurvey.survey) && Intrinsics.areEqual(this.session_id, courseSurvey.session_id) && Intrinsics.areEqual(this.session, courseSurvey.session) && Intrinsics.areEqual(this.start_date, courseSurvey.start_date) && Intrinsics.areEqual(this.end_date, courseSurvey.end_date) && Intrinsics.areEqual(this.status, courseSurvey.status) && Intrinsics.areEqual(this.btn, courseSurvey.btn);
    }

    public int hashCode() {
        return (((((((((((((this.slno * 31) + this.survey.hashCode()) * 31) + this.session_id.hashCode()) * 31) + this.session.hashCode()) * 31) + this.start_date.hashCode()) * 31) + this.end_date.hashCode()) * 31) + this.status.hashCode()) * 31) + this.btn.hashCode();
    }

    public String toString() {
        return "CourseSurvey(slno=" + this.slno + ", survey=" + this.survey + ", session_id=" + this.session_id + ", session=" + this.session + ", start_date=" + this.start_date + ", end_date=" + this.end_date + ", status=" + this.status + ", btn=" + this.btn + ")";
    }

    public CourseSurvey(int i, String survey, String session_id, String session, String start_date, String end_date, String status, String btn) {
        Intrinsics.checkNotNullParameter(survey, "survey");
        Intrinsics.checkNotNullParameter(session_id, "session_id");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(start_date, "start_date");
        Intrinsics.checkNotNullParameter(end_date, "end_date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(btn, "btn");
        this.slno = i;
        this.survey = survey;
        this.session_id = session_id;
        this.session = session;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.btn = btn;
    }

    public final int getSlno() {
        return this.slno;
    }

    public final String getSurvey() {
        return this.survey;
    }

    public final String getSession_id() {
        return this.session_id;
    }

    public final String getSession() {
        return this.session;
    }

    public final String getStart_date() {
        return this.start_date;
    }

    public final String getEnd_date() {
        return this.end_date;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getBtn() {
        return this.btn;
    }
}