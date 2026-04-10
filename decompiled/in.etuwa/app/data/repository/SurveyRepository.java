package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.survey.GenSurveyQuestionRequest;
import in.etuwa.app.data.model.survey.SubmitResponse;
import in.etuwa.app.data.model.survey.Survey;
import in.etuwa.app.data.model.survey.SurveyQuestion;
import in.etuwa.app.data.model.survey.SurveyRequest;
import in.etuwa.app.data.model.survey.TeacherList;
import in.etuwa.app.data.model.survey.courseevaluation.CourseSurveyQuestionsResponse;
import in.etuwa.app.data.model.survey.courseevaluation.CourseSurveyResponse;
import in.etuwa.app.data.model.survey.courseevaluation.DoCourseSurveyResponse;
import in.etuwa.app.data.model.survey.graduateexit.DoGraduateSurveyResponse;
import in.etuwa.app.data.model.survey.graduateexit.GraduateExitSurveyListResponse;
import in.etuwa.app.data.model.survey.posurvey.POSurveyResponse;
import in.etuwa.app.data.model.survey.posurvey.PoQuestionsResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurveyRepository.kt */
/* loaded from: classes3.dex */
public final class SurveyRepository {
    private final ApiHelper apiHelper;

    public SurveyRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ArrayList<Survey>> getSurveyApiCall() {
        return this.apiHelper.getSurveyApiCall();
    }

    public final Single<ArrayList<SurveyQuestion>> getSurveyQuestionApiCall(GenSurveyQuestionRequest requestGen) {
        Intrinsics.checkNotNullParameter(requestGen, "requestGen");
        return this.apiHelper.getSurveyQuestionApiCall(requestGen);
    }

    public final Single<SubmitResponse> submitGenSurveyApiCall(String surveyId, String remark, Map<String, String> option) {
        Intrinsics.checkNotNullParameter(remark, "remark");
        Intrinsics.checkNotNullParameter(option, "option");
        return this.apiHelper.submitGenSurveyApiCall(surveyId, remark, option);
    }

    public final Single<ArrayList<TeacherList>> getSurveyTeachersApiCall(GenSurveyQuestionRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getSurveyTeachersApiCall(request);
    }

    public final Single<ArrayList<SurveyQuestion>> getSurveyQuestionApiCall(SurveyRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getSurveyQuestionApiCall(request);
    }

    public final Single<SubmitResponse> submitSurveyApiCall(String surveyId, String teacherId, String subjectId, String remark, String specialRemark, Map<String, String> option) {
        Intrinsics.checkNotNullParameter(remark, "remark");
        Intrinsics.checkNotNullParameter(specialRemark, "specialRemark");
        Intrinsics.checkNotNullParameter(option, "option");
        return this.apiHelper.submitSurveyApiCall(surveyId, teacherId, subjectId, remark, specialRemark, option);
    }

    public final Single<CourseSurveyResponse> getCourseSurveyList() {
        return this.apiHelper.getCourseSurveyList();
    }

    public final Single<DoCourseSurveyResponse> getDoCourseSurveyList(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getDoCourseSurveyList(id);
    }

    public final Single<CourseSurveyQuestionsResponse> getDoCourseSurveyQuestionList(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getDoCourseSurveyQuestionList(id);
    }

    public final Single<SuccessResponse> postCourseSurveyAnswer(Map<String, String> answerCollection) {
        Intrinsics.checkNotNullParameter(answerCollection, "answerCollection");
        return this.apiHelper.postCourseSurveyAnswer(answerCollection);
    }

    public final Single<POSurveyResponse> getPoSurveyUrl() {
        return this.apiHelper.getPoSurveyUrl();
    }

    public final Single<PoQuestionsResponse> getPoQuestionsUrl(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getPoQuestionsUrl(id);
    }

    public final Single<SuccessResponse> poAnswerSubmit(Map<String, String> answerDetails) {
        Intrinsics.checkNotNullParameter(answerDetails, "answerDetails");
        return this.apiHelper.poAnswerSubmit(answerDetails);
    }

    public final Single<GraduateExitSurveyListResponse> getGraduateSurveyListApiCall() {
        return this.apiHelper.getGraduateSurveyListApiCall();
    }

    public final Single<DoGraduateSurveyResponse> getGraduateSurveyQuestionsApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getGraduateSurveyQuestionsApiCall(id);
    }

    public final Single<SuccessResponse> postGESurveyAnswer(Map<String, String> answerCollection) {
        Intrinsics.checkNotNullParameter(answerCollection, "answerCollection");
        return this.apiHelper.postGESurveyAnswer(answerCollection);
    }
}