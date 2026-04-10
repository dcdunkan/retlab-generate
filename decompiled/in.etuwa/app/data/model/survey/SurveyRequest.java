package in.etuwa.app.data.model.survey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SurveyRequest {

    @SerializedName("subject_id")
    @Expose
    private final String subjectId;

    @SerializedName("survey_id")
    @Expose
    private final String surveyId;

    @SerializedName("teacher_id")
    @Expose
    private final String teacherId;

    public static /* synthetic */ SurveyRequest copy$default(SurveyRequest surveyRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = surveyRequest.surveyId;
        }
        if ((i & 2) != 0) {
            str2 = surveyRequest.teacherId;
        }
        if ((i & 4) != 0) {
            str3 = surveyRequest.subjectId;
        }
        return surveyRequest.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSurveyId() {
        return this.surveyId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTeacherId() {
        return this.teacherId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    public final SurveyRequest copy(String surveyId, String teacherId, String subjectId) {
        return new SurveyRequest(surveyId, teacherId, subjectId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyRequest)) {
            return false;
        }
        SurveyRequest surveyRequest = (SurveyRequest) other;
        return Intrinsics.areEqual(this.surveyId, surveyRequest.surveyId) && Intrinsics.areEqual(this.teacherId, surveyRequest.teacherId) && Intrinsics.areEqual(this.subjectId, surveyRequest.subjectId);
    }

    public int hashCode() {
        String str = this.surveyId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.teacherId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subjectId;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "SurveyRequest(surveyId=" + this.surveyId + ", teacherId=" + this.teacherId + ", subjectId=" + this.subjectId + ")";
    }

    public SurveyRequest(String str, String str2, String str3) {
        this.surveyId = str;
        this.teacherId = str2;
        this.subjectId = str3;
    }

    public final String getSurveyId() {
        return this.surveyId;
    }

    public final String getTeacherId() {
        return this.teacherId;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }
}