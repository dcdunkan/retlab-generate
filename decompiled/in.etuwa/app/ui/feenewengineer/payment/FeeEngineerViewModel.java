package in.etuwa.app.ui.feenewengineer.payment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineerResponse;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineerUrlResponse;
import in.etuwa.app.data.repository.FeeEngineerRepository;
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

/* compiled from: FeeEngineerViewModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0011J\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\b\u0010\u0018\u001a\u00020\u000eH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/ui/feenewengineer/payment/FeeEngineerViewModel;", "Landroidx/lifecycle/ViewModel;", "feeEngineerRepository", "Lin/etuwa/app/data/repository/FeeEngineerRepository;", "(Lin/etuwa/app/data/repository/FeeEngineerRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "feeEngineerResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/feeengineer/payment/FeeEngineerResponse;", "feeUrlResponse", "Lin/etuwa/app/data/model/feeengineer/payment/FeeEngineerUrlResponse;", "getFeeUrl", "", "FeeCollection", "", "", "getFeeUrlResponse", "getFees", "getFeesKmea", "batchId", "getKmeaResponse", "getResponse", "onCleared", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeeEngineerViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final FeeEngineerRepository feeEngineerRepository;
    private MutableLiveData<Resource<FeeEngineerResponse>> feeEngineerResponse;
    private MutableLiveData<Resource<FeeEngineerUrlResponse>> feeUrlResponse;

    public FeeEngineerViewModel(FeeEngineerRepository feeEngineerRepository) {
        Intrinsics.checkNotNullParameter(feeEngineerRepository, "feeEngineerRepository");
        this.feeEngineerRepository = feeEngineerRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.feeEngineerResponse = new MutableLiveData<>();
        this.feeUrlResponse = new MutableLiveData<>();
    }

    public final void getFees() {
        this.feeEngineerResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeEngineerResponse> observeOn = this.feeEngineerRepository.getFeeEngineerApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeEngineerResponse, Unit> function1 = new Function1<FeeEngineerResponse, Unit>() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel$getFees$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeEngineerResponse feeEngineerResponse) {
                invoke2(feeEngineerResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeEngineerResponse feeEngineerResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = FeeEngineerViewModel.this.feeEngineerResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(feeEngineerResponse));
            }
        };
        Consumer<? super FeeEngineerResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeEngineerViewModel.getFees$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel$getFees$2
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
                mutableLiveData = FeeEngineerViewModel.this.feeEngineerResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeEngineerViewModel.getFees$lambda$1(Function1.this, obj);
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
        Single<FeeEngineerResponse> observeOn = this.feeEngineerRepository.getFeeKmeaEngineerApiCall(batchId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeEngineerResponse, Unit> function1 = new Function1<FeeEngineerResponse, Unit>() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel$getFeesKmea$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeEngineerResponse feeEngineerResponse) {
                invoke2(feeEngineerResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeEngineerResponse feeEngineerResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = FeeEngineerViewModel.this.feeEngineerResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(feeEngineerResponse));
            }
        };
        Consumer<? super FeeEngineerResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeEngineerViewModel.getFeesKmea$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel$getFeesKmea$2
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
                mutableLiveData = FeeEngineerViewModel.this.feeEngineerResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeEngineerViewModel.getFeesKmea$lambda$3(Function1.this, obj);
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

    public final void getFeeUrl(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        this.feeUrlResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeEngineerUrlResponse> observeOn = this.feeEngineerRepository.getEngineerFeePayUrlApiCall(FeeCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeEngineerUrlResponse, Unit> function1 = new Function1<FeeEngineerUrlResponse, Unit>() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel$getFeeUrl$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeEngineerUrlResponse feeEngineerUrlResponse) {
                invoke2(feeEngineerUrlResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeEngineerUrlResponse feeEngineerUrlResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = FeeEngineerViewModel.this.feeUrlResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(feeEngineerUrlResponse));
            }
        };
        Consumer<? super FeeEngineerUrlResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeEngineerViewModel.getFeeUrl$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel$getFeeUrl$2
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
                mutableLiveData = FeeEngineerViewModel.this.feeUrlResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.feenewengineer.payment.FeeEngineerViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeEngineerViewModel.getFeeUrl$lambda$5(Function1.this, obj);
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

    public final MutableLiveData<Resource<FeeEngineerUrlResponse>> getFeeUrlResponse() {
        return this.feeUrlResponse;
    }
}