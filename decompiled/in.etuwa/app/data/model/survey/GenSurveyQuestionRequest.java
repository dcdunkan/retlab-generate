package in.etuwa.app.data.model.survey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GenSurveyQuestionRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/data/model/survey/GenSurveyQuestionRequest;", "", "surveyId", "", "(Ljava/lang/String;)V", "getSurveyId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GenSurveyQuestionRequest {

    @SerializedName("survey_id")
    @Expose
    private final String surveyId;

    public static /* synthetic */ GenSurveyQuestionRequest copy$default(GenSurveyQuestionRequest genSurveyQuestionRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = genSurveyQuestionRequest.surveyId;
        }
        return genSurveyQuestionRequest.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSurveyId() {
        return this.surveyId;
    }

    public final GenSurveyQuestionRequest copy(String surveyId) {
        return new GenSurveyQuestionRequest(surveyId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GenSurveyQuestionRequest) && Intrinsics.areEqual(this.surveyId, ((GenSurveyQuestionRequest) other).surveyId);
    }

    public int hashCode() {
        String str = this.surveyId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "GenSurveyQuestionRequest(surveyId=" + this.surveyId + ")";
    }

    public GenSurveyQuestionRequest(String str) {
        this.surveyId = str;
    }

    public final String getSurveyId() {
        return this.surveyId;
    }
}