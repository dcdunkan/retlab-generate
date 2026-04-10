package in.etuwa.app.data.model.survey.posurvey;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PoQuestionsResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class PoQuestionsResponse {
    private final String period;
    private final ArrayList<PoQuestions> questions;
    private final String survey;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoQuestionsResponse copy$default(PoQuestionsResponse poQuestionsResponse, String str, String str2, String str3, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = poQuestionsResponse.survey;
        }
        if ((i & 2) != 0) {
            str2 = poQuestionsResponse.type;
        }
        if ((i & 4) != 0) {
            str3 = poQuestionsResponse.period;
        }
        if ((i & 8) != 0) {
            arrayList = poQuestionsResponse.questions;
        }
        return poQuestionsResponse.copy(str, str2, str3, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSurvey() {
        return this.survey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPeriod() {
        return this.period;
    }

    public final ArrayList<PoQuestions> component4() {
        return this.questions;
    }

    public final PoQuestionsResponse copy(String survey, String type, String period, ArrayList<PoQuestions> questions) {
        Intrinsics.checkNotNullParameter(survey, "survey");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(questions, "questions");
        return new PoQuestionsResponse(survey, type, period, questions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PoQuestionsResponse)) {
            return false;
        }
        PoQuestionsResponse poQuestionsResponse = (PoQuestionsResponse) other;
        return Intrinsics.areEqual(this.survey, poQuestionsResponse.survey) && Intrinsics.areEqual(this.type, poQuestionsResponse.type) && Intrinsics.areEqual(this.period, poQuestionsResponse.period) && Intrinsics.areEqual(this.questions, poQuestionsResponse.questions);
    }

    public int hashCode() {
        return (((((this.survey.hashCode() * 31) + this.type.hashCode()) * 31) + this.period.hashCode()) * 31) + this.questions.hashCode();
    }

    public String toString() {
        return "PoQuestionsResponse(survey=" + this.survey + ", type=" + this.type + ", period=" + this.period + ", questions=" + this.questions + ")";
    }

    public PoQuestionsResponse(String survey, String type, String period, ArrayList<PoQuestions> questions) {
        Intrinsics.checkNotNullParameter(survey, "survey");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(questions, "questions");
        this.survey = survey;
        this.type = type;
        this.period = period;
        this.questions = questions;
    }

    public final String getSurvey() {
        return this.survey;
    }

    public final String getType() {
        return this.type;
    }

    public final String getPeriod() {
        return this.period;
    }

    public final ArrayList<PoQuestions> getQuestions() {
        return this.questions;
    }
}