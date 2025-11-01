package in.etuwa.app.data.model.survey.courseevaluation;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.kernel.xmp.PdfConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DoCourseSurveyResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fHÆ\u0003JU\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006#"}, d2 = {"Lin/etuwa/app/data/model/survey/courseevaluation/DoCourseSurveyResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "type", "", "session", TypedValues.CycleType.S_WAVE_PERIOD, PdfConst.Description, "subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/courseevaluation/DoCourseSurvey;", "Lkotlin/collections/ArrayList;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getDescription", "()Ljava/lang/String;", "getLogin", "()Z", "getPeriod", "getSession", "getSubjects", "()Ljava/util/ArrayList;", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DoCourseSurveyResponse {
    private final String description;
    private final boolean login;
    private final String period;
    private final String session;
    private final ArrayList<DoCourseSurvey> subjects;
    private final String type;

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

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSession() {
        return this.session;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPeriod() {
        return this.period;
    }

    /* renamed from: component5, reason: from getter */
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