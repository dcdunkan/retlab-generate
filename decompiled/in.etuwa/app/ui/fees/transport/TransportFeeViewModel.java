package in.etuwa.app.ui.fees.transport;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.transport.TransportFeeResponse;
import in.etuwa.app.data.model.transport.TransportPayUrl;
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

/* compiled from: TransportFeeViewModel.kt */
/* loaded from: classes4.dex */
public final class TransportFeeViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final FeeEngineerRepository feeEngineerRepository;
    private MutableLiveData<Resource<TransportFeeResponse>> transportFeeResponse;
    private MutableLiveData<Resource<TransportFeeResponse>> transportFeeResponseNew;
    private MutableLiveData<Resource<TransportPayUrl>> transportFeeUrlResponse;

    public TransportFeeViewModel(FeeEngineerRepository feeEngineerRepository) {
        Intrinsics.checkNotNullParameter(feeEngineerRepository, "feeEngineerRepository");
        this.feeEngineerRepository = feeEngineerRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.transportFeeResponse = new MutableLiveData<>();
        this.transportFeeResponseNew = new MutableLiveData<>();
        this.transportFeeUrlResponse = new MutableLiveData<>();
    }

    public final void getTransportFeeYears() {
        this.transportFeeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<TransportFeeResponse> observeOn = this.feeEngineerRepository.getTransportFeeApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<TransportFeeResponse, Unit> function1 = new Function1<TransportFeeResponse, Unit>() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeViewModel$getTransportFeeYears$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransportFeeResponse transportFeeResponse) {
                invoke2(transportFeeResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransportFeeResponse transportFeeResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TransportFeeViewModel.this.transportFeeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(transportFeeResponse));
            }
        };
        Consumer<? super TransportFeeResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportFeeViewModel.getTransportFeeYears$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeViewModel$getTransportFeeYears$2
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
                mutableLiveData = TransportFeeViewModel.this.transportFeeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportFeeViewModel.getTransportFeeYears$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTransportFeeYears$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTransportFeeYears$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<TransportFeeResponse>> getResponse() {
        return this.transportFeeResponse;
    }

    public final void getTransportFees(String yearId) {
        Intrinsics.checkNotNullParameter(yearId, "yearId");
        this.transportFeeResponseNew.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<TransportFeeResponse> observeOn = this.feeEngineerRepository.getTransportFeeApiCall(yearId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<TransportFeeResponse, Unit> function1 = new Function1<TransportFeeResponse, Unit>() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeViewModel$getTransportFees$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransportFeeResponse transportFeeResponse) {
                invoke2(transportFeeResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransportFeeResponse transportFeeResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TransportFeeViewModel.this.transportFeeResponseNew;
                mutableLiveData.postValue(Resource.INSTANCE.success(transportFeeResponse));
            }
        };
        Consumer<? super TransportFeeResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportFeeViewModel.getTransportFees$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeViewModel$getTransportFees$2
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
                mutableLiveData = TransportFeeViewModel.this.transportFeeResponseNew;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportFeeViewModel.getTransportFees$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTransportFees$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTransportFees$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<TransportFeeResponse>> getFeesResponse() {
        return this.transportFeeResponseNew;
    }

    public final void getTransportFeesUrl(Map<String, String> transportFeeCollection) {
        Intrinsics.checkNotNullParameter(transportFeeCollection, "transportFeeCollection");
        this.transportFeeUrlResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<TransportPayUrl> observeOn = this.feeEngineerRepository.getTransportFeeUrlApiCall(transportFeeCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<TransportPayUrl, Unit> function1 = new Function1<TransportPayUrl, Unit>() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeViewModel$getTransportFeesUrl$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransportPayUrl transportPayUrl) {
                invoke2(transportPayUrl);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransportPayUrl transportPayUrl) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TransportFeeViewModel.this.transportFeeUrlResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(transportPayUrl));
            }
        };
        Consumer<? super TransportPayUrl> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportFeeViewModel.getTransportFeesUrl$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeViewModel$getTransportFeesUrl$2
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
                mutableLiveData = TransportFeeViewModel.this.transportFeeUrlResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.transport.TransportFeeViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportFeeViewModel.getTransportFeesUrl$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTransportFeesUrl$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTransportFeesUrl$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<TransportPayUrl>> getFeesUrlResponse() {
        return this.transportFeeUrlResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}