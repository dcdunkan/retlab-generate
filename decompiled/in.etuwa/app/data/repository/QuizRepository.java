package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.quiz.QuestionsNewResponse;
import in.etuwa.app.data.model.quiz.file.QuizDeleteFile;
import in.etuwa.app.data.model.quiz.file.QuizFileUploadResponse;
import in.etuwa.app.data.model.quiz.list.QuizResponse;
import in.etuwa.app.data.model.quiz.questions.QuestionResponse;
import in.etuwa.app.data.model.quiz.result.QuizResultResponse;
import in.etuwa.app.data.model.quiz.submit.QuizFinishRequest;
import in.etuwa.app.data.model.quiz.submit.QuizSubmitResponse;
import in.etuwa.app.data.model.quiz.submit.SubmitRequest;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: QuizRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class QuizRepository {
    private final ApiHelper apiHelper;

    public QuizRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<QuizResponse> getQuizListApiCall() {
        return this.apiHelper.getQuizListApiCall();
    }

    public final Single<QuestionResponse> getQuizQuestionsApiCall(String id) {
        return this.apiHelper.getQuizQuestionsApiCall(id);
    }

    public final Single<QuizSubmitResponse> submitQuizAnswersApiCall(String id, SubmitRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.submitQuizAnswersApiCall(id, request);
    }

    public final Single<QuizSubmitResponse> finishQuizAnswersApiCall(String id, QuizFinishRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.finishQuizAnswersApiCall(id, request);
    }

    public final Observable<ArrayList<QuizFileUploadResponse>> uploadQuizApiCall(String id, MultipartBody.Part file) {
        return this.apiHelper.uploadQuizApiCall(id, file);
    }

    public final Single<SuccessResponse> deleteQuizFileApiCall(QuizDeleteFile request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.deleteQuizFileApiCall(request);
    }

    public final Single<QuizResultResponse> quizResultApiCall(String id) {
        return this.apiHelper.quizResultApiCall(id);
    }

    public final Single<SuccessResponse> quizSaveStatusApiCall(String sessionId, String qId) {
        return this.apiHelper.quizSaveStatusApiCall(sessionId, qId);
    }

    public final Single<QuestionsNewResponse> getNewQuizQuestionsApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getNewQuizQuestionsApiCall(id);
    }

    public final Single<QuizSubmitResponse> newQuizAnswerSubmit(Map<String, String> answerDetails) {
        Intrinsics.checkNotNullParameter(answerDetails, "answerDetails");
        return this.apiHelper.newQuizAnswerSubmit(answerDetails);
    }

    public final Single<QuizSubmitResponse> newQuizAnswerUploadSubmit(RequestBody qNo, RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(qNo, "qNo");
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.newQuizAnswerUploadSubmit(qNo, id, file);
    }

    public final Single<QuizSubmitResponse> newQuizAnswerUploadFinalSubmit(RequestBody qNo, RequestBody id, RequestBody finalSubmit, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(qNo, "qNo");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(finalSubmit, "finalSubmit");
        return this.apiHelper.newQuizAnswerUploadFinalSubmit(qNo, id, finalSubmit, file);
    }

    public final Single<QuizResultResponse> quizResultNewApiCall(String id) {
        return this.apiHelper.quizResultNewApiCall(id);
    }
}