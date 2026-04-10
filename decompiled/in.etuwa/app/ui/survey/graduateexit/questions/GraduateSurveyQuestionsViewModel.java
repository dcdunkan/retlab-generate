package in.etuwa.app.ui.survey.graduateexit.questions;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.survey.graduateexit.DoGraduateSurveyResponse;
import in.etuwa.app.data.repository.SurveyRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GraduateSurveyQuestionsViewModel.kt */
/* loaded from: classes5.dex */
public final class GraduateSurveyQuestionsViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<SuccessResponse>> submitResponse;
    private final SurveyRepository surveyRepository;
    private MutableLiveData<Resource<DoGraduateSurveyResponse>> surveyResponse;

    public GraduateSurveyQuestionsViewModel(SurveyRepository surveyRepository) {
        Intrinsics.checkNotNullParameter(surveyRepository, "surveyRepository");
        this.surveyRepository = surveyRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.surveyResponse = new MutableLiveData<>();
        this.submitResponse = new MutableLiveData<>();
    }

    public final void getSurveyQuestions(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.surveyResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<DoGraduateSurveyResponse> observeOn = this.surveyRepository.getGraduateSurveyQuestionsApiCall(sessionId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DoGraduateSurveyResponse, Unit> function1 = new Function1<DoGraduateSurveyResponse, Unit>() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsViewModel$getSurveyQuestions$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DoGraduateSurveyResponse doGraduateSurveyResponse) {
                invoke2(doGraduateSurveyResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DoGraduateSurveyResponse doGraduateSurveyResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = GraduateSurveyQuestionsViewModel.this.surveyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(doGraduateSurveyResponse));
            }
        };
        Consumer<? super DoGraduateSurveyResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GraduateSurveyQuestionsViewModel.getSurveyQuestions$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsViewModel$getSurveyQuestions$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableLiveData mutableLiveData;
                mutableLiveData = GraduateSurveyQuestionsViewModel.this.surveyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GraduateSurveyQuestionsViewModel.getSurveyQuestions$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyQuestions$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyQuestions$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<DoGraduateSurveyResponse>> getResponse() {
        return this.surveyResponse;
    }

    public final void getSurveyQuestions(Map<String, String> answerCollection) {
        Intrinsics.checkNotNullParameter(answerCollection, "answerCollection");
        this.submitResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.surveyRepository.postGESurveyAnswer(answerCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsViewModel$getSurveyQuestions$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SuccessResponse successResponse) {
                invoke2(successResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SuccessResponse successResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = GraduateSurveyQuestionsViewModel.this.submitResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GraduateSurveyQuestionsViewModel.getSurveyQuestions$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsViewModel$getSurveyQuestions$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableLiveData mutableLiveData;
                mutableLiveData = GraduateSurveyQuestionsViewModel.this.submitResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.survey.graduateexit.questions.GraduateSurveyQuestionsViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GraduateSurveyQuestionsViewModel.getSurveyQuestions$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyQuestions$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSurveyQuestions$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SuccessResponse>> getSubmitResponse() {
        return this.submitResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}