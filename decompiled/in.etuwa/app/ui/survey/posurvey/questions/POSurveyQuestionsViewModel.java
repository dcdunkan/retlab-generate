package in.etuwa.app.ui.survey.posurvey.questions;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.survey.posurvey.PoQuestionsResponse;
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

/* compiled from: POSurveyQuestionsViewModel.kt */
/* loaded from: classes5.dex */
public final class POSurveyQuestionsViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<SuccessResponse>> submitResponse;
    private final SurveyRepository surveyRepository;
    private MutableLiveData<Resource<PoQuestionsResponse>> surveyResponse;

    public POSurveyQuestionsViewModel(SurveyRepository surveyRepository) {
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
        Single<PoQuestionsResponse> observeOn = this.surveyRepository.getPoQuestionsUrl(sessionId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<PoQuestionsResponse, Unit> function1 = new Function1<PoQuestionsResponse, Unit>() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsViewModel$getSurveyQuestions$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PoQuestionsResponse poQuestionsResponse) {
                invoke2(poQuestionsResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PoQuestionsResponse poQuestionsResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = POSurveyQuestionsViewModel.this.surveyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(poQuestionsResponse));
            }
        };
        Consumer<? super PoQuestionsResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                POSurveyQuestionsViewModel.getSurveyQuestions$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsViewModel$getSurveyQuestions$2
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
                mutableLiveData = POSurveyQuestionsViewModel.this.surveyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                POSurveyQuestionsViewModel.getSurveyQuestions$lambda$1(Function1.this, obj);
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

    public final MutableLiveData<Resource<PoQuestionsResponse>> getResponse() {
        return this.surveyResponse;
    }

    public final void getSurveyQuestions(Map<String, String> answerCollection) {
        Intrinsics.checkNotNullParameter(answerCollection, "answerCollection");
        this.submitResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.surveyRepository.poAnswerSubmit(answerCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsViewModel$getSurveyQuestions$3
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
                mutableLiveData = POSurveyQuestionsViewModel.this.submitResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                POSurveyQuestionsViewModel.getSurveyQuestions$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsViewModel$getSurveyQuestions$4
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
                mutableLiveData = POSurveyQuestionsViewModel.this.submitResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.survey.posurvey.questions.POSurveyQuestionsViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                POSurveyQuestionsViewModel.getSurveyQuestions$lambda$3(Function1.this, obj);
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