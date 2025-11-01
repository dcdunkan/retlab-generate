package in.etuwa.app.data.model.survey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurveyRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/survey/SurveyRequest;", "", "surveyId", "", "teacherId", "subjectId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSubjectId", "()Ljava/lang/String;", "getSurveyId", "getTeacherId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getSurveyId() {
        return this.surveyId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTeacherId() {
        return this.teacherId;
    }

    /* renamed from: component3, reason: from getter */
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
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.teacherId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subjectId;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
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