package in.etuwa.app.data.model.survey;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurveyAnswer.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/survey/SurveyAnswer;", "", "qid", "", "answer", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnswer", "()Ljava/lang/String;", "getQid", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getQid() {
        return this.qid;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAnswer() {
        return this.answer;
    }

    /* renamed from: component3, reason: from getter */
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