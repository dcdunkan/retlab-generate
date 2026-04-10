package in.etuwa.app.data.model.survey.courseevaluation;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.kernel.xmp.PdfConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DoCourseSurveyResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class DoCourseSurveyResponse {
    private final String description;
    private final boolean login;
    private final String period;
    private final String session;
    private final ArrayList<DoCourseSurvey> subjects;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DoCourseSurveyResponse copy$default(DoCourseSurveyResponse doCourseSurveyResponse, boolean z, String str, String str2, String str3, String str4, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = doCourseSurveyResponse.login;
        }
        if ((i & 2) != 0) {
            str = doCourseSurveyResponse.type;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = doCourseSurveyResponse.session;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = doCourseSurveyResponse.period;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = doCourseSurveyResponse.description;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            arrayList = doCourseSurveyResponse.subjects;
        }
        return doCourseSurveyResponse.copy(z, str5, str6, str7, str8, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSession() {
        return this.session;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPeriod() {
        return this.period;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final ArrayList<DoCourseSurvey> component6() {
        return this.subjects;
    }

    public final DoCourseSurveyResponse copy(boolean login, String type, String session, String period, String description, ArrayList<DoCourseSurvey> subjects) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        return new DoCourseSurveyResponse(login, type, session, period, description, subjects);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DoCourseSurveyResponse)) {
            return false;
        }
        DoCourseSurveyResponse doCourseSurveyResponse = (DoCourseSurveyResponse) other;
        return this.login == doCourseSurveyResponse.login && Intrinsics.areEqual(this.type, doCourseSurveyResponse.type) && Intrinsics.areEqual(this.session, doCourseSurveyResponse.session) && Intrinsics.areEqual(this.period, doCourseSurveyResponse.period) && Intrinsics.areEqual(this.description, doCourseSurveyResponse.description) && Intrinsics.areEqual(this.subjects, doCourseSurveyResponse.subjects);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((r0 * 31) + this.type.hashCode()) * 31) + this.session.hashCode()) * 31) + this.period.hashCode()) * 31) + this.description.hashCode()) * 31) + this.subjects.hashCode();
    }

    public String toString() {
        return "DoCourseSurveyResponse(login=" + this.login + ", type=" + this.type + ", session=" + this.session + ", period=" + this.period + ", description=" + this.description + ", subjects=" + this.subjects + ")";
    }

    public DoCourseSurveyResponse(boolean z, String type, String session, String period, String description, ArrayList<DoCourseSurvey> subjects) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        this.login = z;
        this.type = type;
        this.session = session;
        this.period = period;
        this.description = description;
        this.subjects = subjects;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getType() {
        return this.type;
    }

    public final String getSession() {
        return this.session;
    }

    public final String getPeriod() {
        return this.period;
    }

    public final String getDescription() {
        return this.description;
    }

    public final ArrayList<DoCourseSurvey> getSubjects() {
        return this.subjects;
    }
}