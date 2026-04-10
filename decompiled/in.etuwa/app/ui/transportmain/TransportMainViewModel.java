package in.etuwa.app.ui.transportmain;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.fee.receipts.ReceiptResponse;
import in.etuwa.app.data.model.transport.TransportFeeResponse;
import in.etuwa.app.data.model.transport.TransportHistoryResponse;
import in.etuwa.app.data.model.transport.TransportPayUrl;
import in.etuwa.app.data.model.transportpalai.BusPass;
import in.etuwa.app.data.model.transportpalai.registration.RegisterViewResponse;
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

/* JADX INFO: compiled from: TransportMainViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class TransportMainViewModel extends ViewModel {
    private final MutableLiveData<Resource<BusPass>> busPassResponse;
    private final CompositeDisposable compositeDisposable;
    private final FeeEngineerRepository feeEngineerRepository;
    private MutableLiveData<Resource<TransportHistoryResponse>> feeHistoryResponse;
    private MutableLiveData<Resource<RegisterViewResponse>> historyResponse;
    private MutableLiveData<Resource<ReceiptResponse>> receiptResponse;
    private MutableLiveData<Resource<TransportFeeResponse>> transportFeeResponse;
    private MutableLiveData<Resource<TransportFeeResponse>> transportFeeResponseNew;
    private MutableLiveData<Resource<TransportPayUrl>> transportFeeUrlResponse;

    public TransportMainViewModel(FeeEngineerRepository feeEngineerRepository) {
        Intrinsics.checkNotNullParameter(feeEngineerRepository, "feeEngineerRepository");
        this.feeEngineerRepository = feeEngineerRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.transportFeeResponse = new MutableLiveData<>();
        this.transportFeeResponseNew = new MutableLiveData<>();
        this.transportFeeUrlResponse = new MutableLiveData<>();
        this.receiptResponse = new MutableLiveData<>();
        this.historyResponse = new MutableLiveData<>();
        this.feeHistoryResponse = new MutableLiveData<>();
        this.busPassResponse = new MutableLiveData<>();
    }

    public final void getTransportFeeYears() {
        this.transportFeeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<TransportFeeResponse> singleObserveOn = this.feeEngineerRepository.getTransportFeeApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<TransportFeeResponse, Unit> function1 = new Function1<TransportFeeResponse, Unit>() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel.getTransportFeeYears.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransportFeeResponse transportFeeResponse) {
                invoke2(transportFeeResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransportFeeResponse transportFeeResponse) {
                TransportMainViewModel.this.transportFeeResponse.postValue(Resource.INSTANCE.success(transportFeeResponse));
            }
        };
        Consumer<? super TransportFeeResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportMainViewModel.getTransportFeeYears$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel.getTransportFeeYears.2
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
                TransportMainViewModel.this.transportFeeResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportMainViewModel.getTransportFeeYears$lambda$1(function12, obj);
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
        Single<TransportFeeResponse> singleObserveOn = this.feeEngineerRepository.getTransportFeeApiCall(yearId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<TransportFeeResponse, Unit> function1 = new Function1<TransportFeeResponse, Unit>() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel.getTransportFees.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransportFeeResponse transportFeeResponse) {
                invoke2(transportFeeResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransportFeeResponse transportFeeResponse) {
                TransportMainViewModel.this.transportFeeResponseNew.postValue(Resource.INSTANCE.success(transportFeeResponse));
            }
        };
        Consumer<? super TransportFeeResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportMainViewModel.getTransportFees$lambda$2(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel.getTransportFees.2
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
                TransportMainViewModel.this.transportFeeResponseNew.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportMainViewModel.getTransportFees$lambda$3(function12, obj);
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
        Single<TransportPayUrl> singleObserveOn = this.feeEngineerRepository.getTransportFeeUrlApiCall(transportFeeCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<TransportPayUrl, Unit> function1 = new Function1<TransportPayUrl, Unit>() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel.getTransportFeesUrl.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransportPayUrl transportPayUrl) {
                invoke2(transportPayUrl);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransportPayUrl transportPayUrl) {
                TransportMainViewModel.this.transportFeeUrlResponse.postValue(Resource.INSTANCE.success(transportPayUrl));
            }
        };
        Consumer<? super TransportPayUrl> consumer = new Consumer() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportMainViewModel.getTransportFeesUrl$lambda$4(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel.getTransportFeesUrl.2
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
                TransportMainViewModel.this.transportFeeUrlResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportMainViewModel.getTransportFeesUrl$lambda$5(function12, obj);
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

    public final void getReceipts() {
        this.receiptResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ReceiptResponse> singleObserveOn = this.feeEngineerRepository.getTransportFeeReceiptsApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ReceiptResponse, Unit> function1 = new Function1<ReceiptResponse, Unit>() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel.getReceipts.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReceiptResponse receiptResponse) {
                invoke2(receiptResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ReceiptResponse receiptResponse) {
                TransportMainViewModel.this.receiptResponse.postValue(Resource.INSTANCE.success(receiptResponse));
            }
        };
        Consumer<? super ReceiptResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportMainViewModel.getReceipts$lambda$6(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel.getReceipts.2
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
                TransportMainViewModel.this.receiptResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportMainViewModel.getReceipts$lambda$7(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getReceipts$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getReceipts$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ReceiptResponse>> getReceiptResponse() {
        return this.receiptResponse;
    }

    public final void getRegHistory() {
        this.historyResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<RegisterViewResponse> singleObserveOn = this.feeEngineerRepository.getRegisterViewApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<RegisterViewResponse, Unit> function1 = new Function1<RegisterViewResponse, Unit>() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel.getRegHistory.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RegisterViewResponse registerViewResponse) {
                invoke2(registerViewResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RegisterViewResponse registerViewResponse) {
                TransportMainViewModel.this.historyResponse.postValue(Resource.INSTANCE.success(registerViewResponse));
            }
        };
        Consumer<? super RegisterViewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportMainViewModel.getRegHistory$lambda$8(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel.getRegHistory.2
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
                TransportMainViewModel.this.historyResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportMainViewModel.getRegHistory$lambda$9(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRegHistory$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRegHistory$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<RegisterViewResponse>> getHistoryResponse() {
        return this.historyResponse;
    }

    public final void getTransportFeeHistory() {
        this.feeHistoryResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<TransportHistoryResponse> singleObserveOn = this.feeEngineerRepository.getTransportHistoryUrlApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<TransportHistoryResponse, Unit> function1 = new Function1<TransportHistoryResponse, Unit>() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel.getTransportFeeHistory.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransportHistoryResponse transportHistoryResponse) {
                invoke2(transportHistoryResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransportHistoryResponse transportHistoryResponse) {
                TransportMainViewModel.this.feeHistoryResponse.postValue(Resource.INSTANCE.success(transportHistoryResponse));
            }
        };
        Consumer<? super TransportHistoryResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportMainViewModel.getTransportFeeHistory$lambda$10(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel.getTransportFeeHistory.2
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
                TransportMainViewModel.this.feeHistoryResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportMainViewModel.getTransportFeeHistory$lambda$11(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTransportFeeHistory$lambda$10(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTransportFeeHistory$lambda$11(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<TransportHistoryResponse>> getFeeHistoryResponse() {
        return this.feeHistoryResponse;
    }

    public final void getBusResponse() {
        this.busPassResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<BusPass> singleObserveOn = this.feeEngineerRepository.getTransportBusPassApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<BusPass, Unit> function1 = new Function1<BusPass, Unit>() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel.getBusResponse.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BusPass busPass) {
                invoke2(busPass);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BusPass busPass) {
                TransportMainViewModel.this.busPassResponse.postValue(Resource.INSTANCE.success(busPass));
            }
        };
        Consumer<? super BusPass> consumer = new Consumer() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportMainViewModel.getBusResponse$lambda$12(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel.getBusResponse.2
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
                TransportMainViewModel.this.busPassResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.transportmain.TransportMainViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportMainViewModel.getBusResponse$lambda$13(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBusResponse$lambda$12(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBusResponse$lambda$13(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<BusPass>> getBusPassResponse() {
        return this.busPassResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}