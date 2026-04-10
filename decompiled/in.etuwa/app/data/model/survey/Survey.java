package in.etuwa.app.data.model.survey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Survey.kt */
/* loaded from: classes3.dex */
public final /* data */ class Survey {

    @SerializedName("btn_status")
    @Expose
    private final String btnStatus;
    private final boolean complete;

    @SerializedName("last_date")
    @Expose
    private final String lastDate;
    private final String name;
    private final String session;

    @SerializedName("survey_id")
    @Expose
    private final String surveyId;
    private final String type;

    public static /* synthetic */ Survey copy$default(Survey survey, String str, String str2, String str3, String str4, boolean z, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = survey.type;
        }
        if ((i & 2) != 0) {
            str2 = survey.name;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = survey.session;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = survey.lastDate;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            z = survey.complete;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            str5 = survey.surveyId;
        }
        String str10 = str5;
        if ((i & 64) != 0) {
            str6 = survey.btnStatus;
        }
        return survey.copy(str, str7, str8, str9, z2, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSession() {
        return this.session;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLastDate() {
        return this.lastDate;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getComplete() {
        return this.complete;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSurveyId() {
        return this.surveyId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBtnStatus() {
        return this.btnStatus;
    }

    public final Survey copy(String type, String name, String session, String lastDate, boolean complete, String surveyId, String btnStatus) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(lastDate, "lastDate");
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(btnStatus, "btnStatus");
        return new Survey(type, name, session, lastDate, complete, surveyId, btnStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Survey)) {
            return false;
        }
        Survey survey = (Survey) other;
        return Intrinsics.areEqual(this.type, survey.type) && Intrinsics.areEqual(this.name, survey.name) && Intrinsics.areEqual(this.session, survey.session) && Intrinsics.areEqual(this.lastDate, survey.lastDate) && this.complete == survey.complete && Intrinsics.areEqual(this.surveyId, survey.surveyId) && Intrinsics.areEqual(this.btnStatus, survey.btnStatus);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.type.hashCode() * 31) + this.name.hashCode()) * 31) + this.session.hashCode()) * 31) + this.lastDate.hashCode()) * 31;
        boolean z = this.complete;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((((hashCode + i) * 31) + this.surveyId.hashCode()) * 31) + this.btnStatus.hashCode();
    }

    public String toString() {
        return "Survey(type=" + this.type + ", name=" + this.name + ", session=" + this.session + ", lastDate=" + this.lastDate + ", complete=" + this.complete + ", surveyId=" + this.surveyId + ", btnStatus=" + this.btnStatus + ")";
    }

    public Survey(String type, String name, String session, String lastDate, boolean z, String surveyId, String btnStatus) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(lastDate, "lastDate");
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(btnStatus, "btnStatus");
        this.type = type;
        this.name = name;
        this.session = session;
        this.lastDate = lastDate;
        this.complete = z;
        this.surveyId = surveyId;
        this.btnStatus = btnStatus;
    }

    public final String getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSession() {
        return this.session;
    }

    public final String getLastDate() {
        return this.lastDate;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final String getSurveyId() {
        return this.surveyId;
    }

    public final String getBtnStatus() {
        return this.btnStatus;
    }
}