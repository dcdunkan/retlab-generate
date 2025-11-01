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

/* compiled from: QuizRepository.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\f\u001a\u00020\rJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rJ \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0017J.\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rJ \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010#\u001a\u0004\u0018\u00010\r2\b\u0010$\u001a\u0004\u0018\u00010\rJ\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020&J0\u0010'\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+0(2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lin/etuwa/app/data/repository/QuizRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "deleteQuizFileApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/SuccessResponse;", "request", "Lin/etuwa/app/data/model/quiz/file/QuizDeleteFile;", "finishQuizAnswersApiCall", "Lin/etuwa/app/data/model/quiz/submit/QuizSubmitResponse;", "id", "", "Lin/etuwa/app/data/model/quiz/submit/QuizFinishRequest;", "getNewQuizQuestionsApiCall", "Lin/etuwa/app/data/model/quiz/QuestionsNewResponse;", "getQuizListApiCall", "Lin/etuwa/app/data/model/quiz/list/QuizResponse;", "getQuizQuestionsApiCall", "Lin/etuwa/app/data/model/quiz/questions/QuestionResponse;", "newQuizAnswerSubmit", "answerDetails", "", "newQuizAnswerUploadFinalSubmit", "qNo", "Lokhttp3/RequestBody;", "finalSubmit", "file", "Lokhttp3/MultipartBody$Part;", "newQuizAnswerUploadSubmit", "quizResultApiCall", "Lin/etuwa/app/data/model/quiz/result/QuizResultResponse;", "quizResultNewApiCall", "quizSaveStatusApiCall", "sessionId", "qId", "submitQuizAnswersApiCall", "Lin/etuwa/app/data/model/quiz/submit/SubmitRequest;", "uploadQuizApiCall", "Lio/reactivex/Observable;", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/quiz/file/QuizFileUploadResponse;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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