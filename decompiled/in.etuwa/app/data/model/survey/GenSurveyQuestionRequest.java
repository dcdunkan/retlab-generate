package in.etuwa.app.data.model.survey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GenSurveyQuestionRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
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