package in.etuwa.app.ui.feenewarts.payment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.feearts.payment.FeeArtsResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArtsSemesterResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArtsUrlResponse;
import in.etuwa.app.data.repository.FeeArtsRepository;
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

/* JADX INFO: compiled from: FeeArtsViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FeeArtsViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final FeeArtsRepository feeArtsRepository;
    private MutableLiveData<Resource<FeeArtsResponse>> feeArtsResponse;
    private MutableLiveData<Resource<FeeArtsUrlResponse>> feeUrlResponse;
    private MutableLiveData<Resource<FeeArtsSemesterResponse>> semResponse;

    public FeeArtsViewModel(FeeArtsRepository feeArtsRepository) {
        Intrinsics.checkNotNullParameter(feeArtsRepository, "feeArtsRepository");
        this.feeArtsRepository = feeArtsRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.feeArtsResponse = new MutableLiveData<>();
        this.feeUrlResponse = new MutableLiveData<>();
        this.semResponse = new MutableLiveData<>();
    }

    public final void getFees() {
        this.feeArtsResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeArtsResponse> singleObserveOn = this.feeArtsRepository.getFeeArtsApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeArtsResponse, Unit> function1 = new Function1<FeeArtsResponse, Unit>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel.getFees.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeArtsResponse feeArtsResponse) {
                invoke2(feeArtsResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeArtsResponse feeArtsResponse) {
                FeeArtsViewModel.this.feeArtsResponse.postValue(Resource.INSTANCE.success(feeArtsResponse));
            }
        };
        Consumer<? super FeeArtsResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeArtsViewModel.getFees$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel.getFees.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                FeeArtsViewModel.this.feeArtsResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeArtsViewModel.getFees$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFees$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFees$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<FeeArtsResponse>> getResponse() {
        return this.feeArtsResponse;
    }

    public final void getFeesSemWise(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.feeArtsResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeArtsResponse> singleObserveOn = this.feeArtsRepository.getFeeArtsApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeArtsResponse, Unit> function1 = new Function1<FeeArtsResponse, Unit>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel.getFeesSemWise.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeArtsResponse feeArtsResponse) {
                invoke2(feeArtsResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeArtsResponse feeArtsResponse) {
                FeeArtsViewModel.this.feeArtsResponse.postValue(Resource.INSTANCE.success(feeArtsResponse));
            }
        };
        Consumer<? super FeeArtsResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeArtsViewModel.getFeesSemWise$lambda$2(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel.getFeesSemWise.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                FeeArtsViewModel.this.feeArtsResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeArtsViewModel.getFeesSemWise$lambda$3(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeesSemWise$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeesSemWise$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<FeeArtsResponse>> getSemWiseResponse() {
        return this.feeArtsResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }

    public final void getFeeUrl(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        this.feeUrlResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeArtsUrlResponse> singleObserveOn = this.feeArtsRepository.getArtsFeePayUrlApiCall(FeeCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeArtsUrlResponse, Unit> function1 = new Function1<FeeArtsUrlResponse, Unit>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel.getFeeUrl.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeArtsUrlResponse feeArtsUrlResponse) {
                invoke2(feeArtsUrlResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeArtsUrlResponse feeArtsUrlResponse) {
                FeeArtsViewModel.this.feeUrlResponse.postValue(Resource.INSTANCE.success(feeArtsUrlResponse));
            }
        };
        Consumer<? super FeeArtsUrlResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeArtsViewModel.getFeeUrl$lambda$4(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel.getFeeUrl.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                FeeArtsViewModel.this.feeUrlResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeArtsViewModel.getFeeUrl$lambda$5(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeeUrl$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeeUrl$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<FeeArtsUrlResponse>> getFeeUrlResponse() {
        return this.feeUrlResponse;
    }

    public final void getSemester() {
        this.semResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeArtsSemesterResponse> singleObserveOn = this.feeArtsRepository.getFeeArtsSemList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeArtsSemesterResponse, Unit> function1 = new Function1<FeeArtsSemesterResponse, Unit>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel.getSemester.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeArtsSemesterResponse feeArtsSemesterResponse) {
                invoke2(feeArtsSemesterResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeArtsSemesterResponse feeArtsSemesterResponse) {
                FeeArtsViewModel.this.semResponse.postValue(Resource.INSTANCE.success(feeArtsSemesterResponse));
            }
        };
        Consumer<? super FeeArtsSemesterResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeArtsViewModel.getSemester$lambda$6(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel.getSemester.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                FeeArtsViewModel.this.semResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.feenewarts.payment.FeeArtsViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeArtsViewModel.getSemester$lambda$7(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemester$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemester$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<FeeArtsSemesterResponse>> getSemResponse() {
        return this.semResponse;
    }
}