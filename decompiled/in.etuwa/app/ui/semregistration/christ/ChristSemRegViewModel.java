package in.etuwa.app.ui.semregistration.christ;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SemRegSuccessResponse;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.repository.SemRegRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChristSemRegViewModel.kt */
/* loaded from: classes5.dex */
public final class ChristSemRegViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<SemRegSuccessResponse>> regResponse;
    private final SemRegRepository semRegRepository;
    private MutableLiveData<Resource<ArrayList<Semester>>> semResponse;

    public ChristSemRegViewModel(SemRegRepository semRegRepository) {
        Intrinsics.checkNotNullParameter(semRegRepository, "semRegRepository");
        this.semRegRepository = semRegRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.regResponse = new MutableLiveData<>();
        this.semResponse = new MutableLiveData<>();
    }

    public final void getAddData(Map<String, String> partMap) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        this.regResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SemRegSuccessResponse> observeOn = this.semRegRepository.semRegisterApiCall(partMap).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegSuccessResponse, Unit> function1 = new Function1<SemRegSuccessResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegViewModel$getAddData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemRegSuccessResponse semRegSuccessResponse) {
                invoke2(semRegSuccessResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemRegSuccessResponse semRegSuccessResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ChristSemRegViewModel.this.regResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(semRegSuccessResponse));
            }
        };
        Consumer<? super SemRegSuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChristSemRegViewModel.getAddData$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegViewModel$getAddData$2
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
                mutableLiveData = ChristSemRegViewModel.this.regResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChristSemRegViewModel.getAddData$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAddData$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAddData$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SemRegSuccessResponse>> getResponse() {
        return this.regResponse;
    }

    public final void getSemester() {
        this.semResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<Semester>> observeOn = this.semRegRepository.getSemestersApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<Semester>, Unit> function1 = new Function1<ArrayList<Semester>, Unit>() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegViewModel$getSemester$1
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
                mutableLiveData = ChristSemRegViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<Semester>> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChristSemRegViewModel.getSemester$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegViewModel$getSemester$2
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
                mutableLiveData = ChristSemRegViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.christ.ChristSemRegViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChristSemRegViewModel.getSemester$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemester$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemester$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ArrayList<Semester>>> getSemResponse() {
        return this.semResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}