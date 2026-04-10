package in.etuwa.app.ui.result.tutorials;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.result.tutorial.TutorialResultResponse;
import in.etuwa.app.data.repository.ResultRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TutorialResultViewModel.kt */
/* loaded from: classes5.dex */
public final class TutorialResultViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final ResultRepository resultRepository;
    private MutableLiveData<Resource<ArrayList<Semester>>> semResponse;
    private MutableLiveData<Resource<TutorialResultResponse>> tutorialResponse;

    public TutorialResultViewModel(ResultRepository resultRepository) {
        Intrinsics.checkNotNullParameter(resultRepository, "resultRepository");
        this.resultRepository = resultRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.tutorialResponse = new MutableLiveData<>();
        this.semResponse = new MutableLiveData<>();
        getSemester();
    }

    public final void getSemester() {
        this.semResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<Semester>> observeOn = this.resultRepository.getSemestersApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<Semester>, Unit> function1 = new Function1<ArrayList<Semester>, Unit>() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultViewModel$getSemester$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<Semester> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<Semester> arrayList) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TutorialResultViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<Semester>> consumer = new Consumer() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TutorialResultViewModel.getSemester$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultViewModel$getSemester$2
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
                mutableLiveData = TutorialResultViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TutorialResultViewModel.getSemester$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemester$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemester$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ArrayList<Semester>>> getSemResponse() {
        return this.semResponse;
    }

    public final void getTutorial(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.tutorialResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<TutorialResultResponse> observeOn = this.resultRepository.getTutorialResultApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<TutorialResultResponse, Unit> function1 = new Function1<TutorialResultResponse, Unit>() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultViewModel$getTutorial$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TutorialResultResponse tutorialResultResponse) {
                invoke2(tutorialResultResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TutorialResultResponse tutorialResultResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TutorialResultViewModel.this.tutorialResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(tutorialResultResponse));
            }
        };
        Consumer<? super TutorialResultResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TutorialResultViewModel.getTutorial$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultViewModel$getTutorial$2
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
                mutableLiveData = TutorialResultViewModel.this.tutorialResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.result.tutorials.TutorialResultViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TutorialResultViewModel.getTutorial$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTutorial$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTutorial$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<TutorialResultResponse>> getResponse() {
        return this.tutorialResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}