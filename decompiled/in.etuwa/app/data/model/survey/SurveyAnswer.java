package in.etuwa.app.data.model.survey;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyAnswer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SurveyAnswer {
    private final String answer;
    private final String qid;
    private final String type;

    public static /* synthetic */ SurveyAnswer copy$default(SurveyAnswer surveyAnswer, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = surveyAnswer.qid;
        }
        if ((i & 2) != 0) {
            str2 = surveyAnswer.answer;
        }
        if ((i & 4) != 0) {
            str3 = surveyAnswer.type;
        }
        return surveyAnswer.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getQid() {
        return this.qid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAnswer() {
        return this.answer;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final SurveyAnswer copy(String qid, String answer, String type) {
        Intrinsics.checkNotNullParameter(qid, "qid");
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(type, "type");
        return new SurveyAnswer(qid, answer, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyAnswer)) {
            return false;
        }
        SurveyAnswer surveyAnswer = (SurveyAnswer) other;
        return Intrinsics.areEqual(this.qid, surveyAnswer.qid) && Intrinsics.areEqual(this.answer, surveyAnswer.answer) && Intrinsics.areEqual(this.type, surveyAnswer.type);
    }

    public int hashCode() {
        return (((this.qid.hashCode() * 31) + this.answer.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "SurveyAnswer(qid=" + this.qid + ", answer=" + this.answer + ", type=" + this.type + ")";
    }

    public SurveyAnswer(String qid, String answer, String type) {
        Intrinsics.checkNotNullParameter(qid, "qid");
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(type, "type");
        this.qid = qid;
        this.answer = answer;
        this.type = type;
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final String getQid() {
        return this.qid;
    }

    public final String getType() {
        return this.type;
    }
}