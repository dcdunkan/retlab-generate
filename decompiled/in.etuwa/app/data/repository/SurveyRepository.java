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
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\n\u001a\u00020\u000bJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\n\u001a\u00020\u000bJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006J\u001c\u0010\u0016\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00190\u0006J$\u0010\u001a\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001b0\u0017j\b\u0012\u0004\u0012\u00020\u001b`\u00190\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ$\u0010\u001a\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001b0\u0017j\b\u0012\u0004\u0012\u00020\u001b`\u00190\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ$\u0010 \u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020!0\u0017j\b\u0012\u0004\u0012\u00020!`\u00190\u00062\u0006\u0010\u001e\u001a\u00020\u001dJ \u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00062\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0%J \u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u00062\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0%J \u0010(\u001a\b\u0012\u0004\u0012\u00020#0\u00062\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0%J2\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00062\b\u0010+\u001a\u0004\u0018\u00010\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0%JN\u0010.\u001a\b\u0012\u0004\u0012\u00020*0\u00062\b\u0010+\u001a\u0004\u0018\u00010\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u000b2\b\u00100\u001a\u0004\u0018\u00010\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lin/etuwa/app/data/repository/SurveyRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getCourseSurveyList", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/survey/courseevaluation/CourseSurveyResponse;", "getDoCourseSurveyList", "Lin/etuwa/app/data/model/survey/courseevaluation/DoCourseSurveyResponse;", "id", "", "getDoCourseSurveyQuestionList", "Lin/etuwa/app/data/model/survey/courseevaluation/CourseSurveyQuestionsResponse;", "getGraduateSurveyListApiCall", "Lin/etuwa/app/data/model/survey/graduateexit/GraduateExitSurveyListResponse;", "getGraduateSurveyQuestionsApiCall", "Lin/etuwa/app/data/model/survey/graduateexit/DoGraduateSurveyResponse;", "getPoQuestionsUrl", "Lin/etuwa/app/data/model/survey/posurvey/PoQuestionsResponse;", "getPoSurveyUrl", "Lin/etuwa/app/data/model/survey/posurvey/POSurveyResponse;", "getSurveyApiCall", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/survey/Survey;", "Lkotlin/collections/ArrayList;", "getSurveyQuestionApiCall", "Lin/etuwa/app/data/model/survey/SurveyQuestion;", "requestGen", "Lin/etuwa/app/data/model/survey/GenSurveyQuestionRequest;", "request", "Lin/etuwa/app/data/model/survey/SurveyRequest;", "getSurveyTeachersApiCall", "Lin/etuwa/app/data/model/survey/TeacherList;", "poAnswerSubmit", "Lin/etuwa/app/data/model/SuccessResponse;", "answerDetails", "", "postCourseSurveyAnswer", "answerCollection", "postGESurveyAnswer", "submitGenSurveyApiCall", "Lin/etuwa/app/data/model/survey/SubmitResponse;", "surveyId", "remark", "option", "submitSurveyApiCall", "teacherId", "subjectId", "specialRemark", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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