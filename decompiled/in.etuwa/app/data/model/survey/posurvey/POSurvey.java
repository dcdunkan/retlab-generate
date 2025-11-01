package in.etuwa.app.data.model.survey.posurvey;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: POSurvey.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lin/etuwa/app/data/model/survey/posurvey/POSurvey;", "", "id", "", "survey", "session", FirebaseAnalytics.Param.START_DATE, FirebaseAnalytics.Param.END_DATE, NotificationCompat.CATEGORY_STATUS, FullDayDialogKt.ARG_BTN, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBtn", "()Ljava/lang/String;", "getEnd_date", "getId", "getSession", "getStart_date", "getStatus", "getSurvey", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class POSurvey {
    private final String btn;
    private final String end_date;
    private final String id;
    private final String session;
    private final String start_date;
    private final String status;
    private final String survey;

    public static /* synthetic */ POSurvey copy$default(POSurvey pOSurvey, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pOSurvey.id;
        }
        if ((i & 2) != 0) {
            str2 = pOSurvey.survey;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = pOSurvey.session;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = pOSurvey.start_date;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = pOSurvey.end_date;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = pOSurvey.status;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = pOSurvey.btn;
        }
        return pOSurvey.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSurvey() {
        return this.survey;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSession() {
        return this.session;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStart_date() {
        return this.start_date;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEnd_date() {
        return this.end_date;
    }

    /* renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBtn() {
        return this.btn;
    }

    public final POSurvey copy(String id, String survey, String session, String start_date, String end_date, String status, String btn) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(survey, "survey");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(start_date, "start_date");
        Intrinsics.checkNotNullParameter(end_date, "end_date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(btn, "btn");
        return new POSurvey(id, survey, session, start_date, end_date, status, btn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof POSurvey)) {
            return false;
        }
        POSurvey pOSurvey = (POSurvey) other;
        return Intrinsics.areEqual(this.id, pOSurvey.id) && Intrinsics.areEqual(this.survey, pOSurvey.survey) && Intrinsics.areEqual(this.session, pOSurvey.session) && Intrinsics.areEqual(this.start_date, pOSurvey.start_date) && Intrinsics.areEqual(this.end_date, pOSurvey.end_date) && Intrinsics.areEqual(this.status, pOSurvey.status) && Intrinsics.areEqual(this.btn, pOSurvey.btn);
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.survey.hashCode()) * 31) + this.session.hashCode()) * 31) + this.start_date.hashCode()) * 31) + this.end_date.hashCode()) * 31) + this.status.hashCode()) * 31) + this.btn.hashCode();
    }

    public String toString() {
        return "POSurvey(id=" + this.id + ", survey=" + this.survey + ", session=" + this.session + ", start_date=" + this.start_date + ", end_date=" + this.end_date + ", status=" + this.status + ", btn=" + this.btn + ")";
    }

    public POSurvey(String id, String survey, String session, String start_date, String end_date, String status, String btn) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(survey, "survey");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(start_date, "start_date");
        Intrinsics.checkNotNullParameter(end_date, "end_date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(btn, "btn");
        this.id = id;
        this.survey = survey;
        this.session = session;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.btn = btn;
    }

    public final String getId() {
        return this.id;
    }

    public final String getSurvey() {
        return this.survey;
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