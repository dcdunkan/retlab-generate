package in.etuwa.app.data.model.survey.courseevaluation;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CourseSurvey.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lin/etuwa/app/data/model/survey/courseevaluation/CourseSurvey;", "", "slno", "", "survey", "", "session_id", "session", FirebaseAnalytics.Param.START_DATE, FirebaseAnalytics.Param.END_DATE, NotificationCompat.CATEGORY_STATUS, FullDayDialogKt.ARG_BTN, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBtn", "()Ljava/lang/String;", "getEnd_date", "getSession", "getSession_id", "getSlno", "()I", "getStart_date", "getStatus", "getSurvey", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CourseSurvey {
    private final String btn;
    private final String end_date;
    private final String session;
    private final String session_id;
    private final int slno;
    private final String start_date;
    private final String status;
    private final String survey;

    /* renamed from: component1, reason: from getter */
    public final int getSlno() {
        return this.slno;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSurvey() {
        return this.survey;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSession_id() {
        return this.session_id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSession() {
        return this.session;
    }

    /* renamed from: component5, reason: from getter */
    public final String getStart_date() {
        return this.start_date;
    }

    /* renamed from: component6, reason: from getter */
    public final String getEnd_date() {
        return this.end_date;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component8, reason: from getter */
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