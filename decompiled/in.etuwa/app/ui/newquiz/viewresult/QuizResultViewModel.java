package in.etuwa.app.ui.newquiz.viewresult;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.quiz.result.QuizResultResponse;
import in.etuwa.app.data.repository.QuizRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuizResultViewModel.kt */
/* loaded from: classes5.dex */
public final class QuizResultViewModel extends ViewModel {
    private MutableLiveData<Resource<SuccessResponse>> applyPlacementResponse;
    private final CompositeDisposable compositeDisposable;
    private final QuizRepository quizRepository;
    private MutableLiveData<Resource<QuizResultResponse>> quizResponse;

    public QuizResultViewModel(QuizRepository quizRepository) {
        Intrinsics.checkNotNullParameter(quizRepository, "quizRepository");
        this.quizRepository = quizRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.quizResponse = new MutableLiveData<>();
        this.applyPlacementResponse = new MutableLiveData<>();
    }

    public final void getQuizList(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.quizResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<QuizResultResponse> observeOn = this.quizRepository.quizResultNewApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<QuizResultResponse, Unit> function1 = new Function1<QuizResultResponse, Unit>() { // from class: in.etuwa.app.ui.newquiz.viewresult.QuizResultViewModel$getQuizList$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QuizResultResponse quizResultResponse) {
                invoke2(quizResultResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QuizResultResponse quizResultResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = QuizResultViewModel.this.quizResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(quizResultResponse));
            }
        };
        Consumer<? super QuizResultResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.newquiz.viewresult.QuizResultViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuizResultViewModel.getQuizList$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.newquiz.viewresult.QuizResultViewModel$getQuizList$2
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
                mutableLiveData = QuizResultViewModel.this.quizResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.newquiz.viewresult.QuizResultViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuizResultViewModel.getQuizList$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getQuizList$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getQuizList$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<QuizResultResponse>> getResponse() {
        return this.quizResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}