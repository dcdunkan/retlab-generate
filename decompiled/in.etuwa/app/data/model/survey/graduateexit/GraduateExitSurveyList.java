package in.etuwa.app.data.model.survey.graduateexit;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GraduateExitSurveyList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class GraduateExitSurveyList {
    private final String btn;
    private final String end_date;
    private final String session;
    private final String session_id;
    private final int slno;
    private final String start_date;
    private final String status;
    private final String survey;
    private final String survey_id;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSlno() {
        return this.slno;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSurvey() {
        return this.survey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSurvey_id() {
        return this.survey_id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSession() {
        return this.session;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSession_id() {
        return this.session_id;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStart_date() {
        return this.start_date;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getEnd_date() {
        return this.end_date;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getBtn() {
        return this.btn;
    }

    public final GraduateExitSurveyList copy(int slno, String survey, String survey_id, String session, String session_id, String start_date, String end_date, String status, String btn) {
        Intrinsics.checkNotNullParameter(survey, "survey");
        Intrinsics.checkNotNullParameter(survey_id, "survey_id");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(session_id, "session_id");
        Intrinsics.checkNotNullParameter(start_date, "start_date");
        Intrinsics.checkNotNullParameter(end_date, "end_date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(btn, "btn");
        return new GraduateExitSurveyList(slno, survey, survey_id, session, session_id, start_date, end_date, status, btn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GraduateExitSurveyList)) {
            return false;
        }
        GraduateExitSurveyList graduateExitSurveyList = (GraduateExitSurveyList) other;
        return this.slno == graduateExitSurveyList.slno && Intrinsics.areEqual(this.survey, graduateExitSurveyList.survey) && Intrinsics.areEqual(this.survey_id, graduateExitSurveyList.survey_id) && Intrinsics.areEqual(this.session, graduateExitSurveyList.session) && Intrinsics.areEqual(this.session_id, graduateExitSurveyList.session_id) && Intrinsics.areEqual(this.start_date, graduateExitSurveyList.start_date) && Intrinsics.areEqual(this.end_date, graduateExitSurveyList.end_date) && Intrinsics.areEqual(this.status, graduateExitSurveyList.status) && Intrinsics.areEqual(this.btn, graduateExitSurveyList.btn);
    }

    public int hashCode() {
        return (((((((((((((((this.slno * 31) + this.survey.hashCode()) * 31) + this.survey_id.hashCode()) * 31) + this.session.hashCode()) * 31) + this.session_id.hashCode()) * 31) + this.start_date.hashCode()) * 31) + this.end_date.hashCode()) * 31) + this.status.hashCode()) * 31) + this.btn.hashCode();
    }

    public String toString() {
        return "GraduateExitSurveyList(slno=" + this.slno + ", survey=" + this.survey + ", survey_id=" + this.survey_id + ", session=" + this.session + ", session_id=" + this.session_id + ", start_date=" + this.start_date + ", end_date=" + this.end_date + ", status=" + this.status + ", btn=" + this.btn + ")";
    }

    public GraduateExitSurveyList(int i, String survey, String survey_id, String session, String session_id, String start_date, String end_date, String status, String btn) {
        Intrinsics.checkNotNullParameter(survey, "survey");
        Intrinsics.checkNotNullParameter(survey_id, "survey_id");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(session_id, "session_id");
        Intrinsics.checkNotNullParameter(start_date, "start_date");
        Intrinsics.checkNotNullParameter(end_date, "end_date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(btn, "btn");
        this.slno = i;
        this.survey = survey;
        this.survey_id = survey_id;
        this.session = session;
        this.session_id = session_id;
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

    public final String getSurvey_id() {
        return this.survey_id;
    }

    public final String getSession() {
        return this.session;
    }

    public final String getSession_id() {
        return this.session_id;
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