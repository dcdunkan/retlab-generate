package in.etuwa.app.ui.feenewengineer.payment.dialog;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineerResponse;
import in.etuwa.app.data.repository.FeeEngineerRepository;
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

/* JADX INFO: compiled from: FeeDetailViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FeeDetailViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final FeeEngineerRepository feeEngineerRepository;
    private MutableLiveData<Resource<FeeEngineerResponse>> feeEngineerResponse;

    public FeeDetailViewModel(FeeEngineerRepository feeEngineerRepository) {
        Intrinsics.checkNotNullParameter(feeEngineerRepository, "feeEngineerRepository");
        this.feeEngineerRepository = feeEngineerRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.feeEngineerResponse = new MutableLiveData<>();
    }

    public final void getFees() {
        this.feeEngineerResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeEngineerResponse> singleObserveOn = this.feeEngineerRepository.getFeeEngineerApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeEngineerResponse, Unit> function1 = new Function1<FeeEngineerResponse, Unit>() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailViewModel.getFees.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeEngineerResponse feeEngineerResponse) {
                invoke2(feeEngineerResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeEngineerResponse feeEngineerResponse) {
                FeeDetailViewModel.this.feeEngineerResponse.postValue(Resource.INSTANCE.success(feeEngineerResponse));
            }
        };
        Consumer<? super FeeEngineerResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeDetailViewModel.getFees$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailViewModel.getFees.2
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
                FeeDetailViewModel.this.feeEngineerResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeDetailViewModel.getFees$lambda$1(function12, obj);
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

    public final MutableLiveData<Resource<FeeEngineerResponse>> getResponse() {
        return this.feeEngineerResponse;
    }

    public final void getFeesKmea(String batchId) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        this.feeEngineerResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeEngineerResponse> singleObserveOn = this.feeEngineerRepository.getFeeKmeaEngineerApiCall(batchId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeEngineerResponse, Unit> function1 = new Function1<FeeEngineerResponse, Unit>() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailViewModel.getFeesKmea.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeEngineerResponse feeEngineerResponse) {
                invoke2(feeEngineerResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeEngineerResponse feeEngineerResponse) {
                FeeDetailViewModel.this.feeEngineerResponse.postValue(Resource.INSTANCE.success(feeEngineerResponse));
            }
        };
        Consumer<? super FeeEngineerResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeDetailViewModel.getFeesKmea$lambda$2(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailViewModel.getFeesKmea.2
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
                FeeDetailViewModel.this.feeEngineerResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.feenewengineer.payment.dialog.FeeDetailViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeDetailViewModel.getFeesKmea$lambda$3(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeesKmea$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeesKmea$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<FeeEngineerResponse>> getKmeaResponse() {
        return this.feeEngineerResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}