package in.etuwa.app.data.model.survey.posurvey;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PoQuestionsResponse.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/data/model/survey/posurvey/PoQuestionsResponse;", "", "survey", "", "type", TypedValues.CycleType.S_WAVE_PERIOD, "questions", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/posurvey/PoQuestions;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getPeriod", "()Ljava/lang/String;", "getQuestions", "()Ljava/util/ArrayList;", "getSurvey", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getSurvey() {
        return this.survey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
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