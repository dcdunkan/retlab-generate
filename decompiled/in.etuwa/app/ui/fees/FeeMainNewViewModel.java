package in.etuwa.app.ui.fees;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.fee.receipts.ReceiptResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArtsResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArtsSemesterResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArtsUrlResponse;
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

/* JADX INFO: compiled from: FeeMainNewViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FeeMainNewViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<FeeArtsResponse>> feeArtsResponse;
    private MutableLiveData<Resource<FeeArtsUrlResponse>> feeArtsUrlResponse;
    private final FeeEngineerRepository feeEngineerRepository;
    private MutableLiveData<Resource<FeeEngineerResponse>> feeEngineerResponse;
    private MutableLiveData<Resource<FeeEngineerUrlResponse>> feeUrlResponse;
    private MutableLiveData<Resource<ReceiptResponse>> receiptResponse;
    private MutableLiveData<Resource<FeeArtsSemesterResponse>> semResponse;

    public FeeMainNewViewModel(FeeEngineerRepository feeEngineerRepository) {
        Intrinsics.checkNotNullParameter(feeEngineerRepository, "feeEngineerRepository");
        this.feeEngineerRepository = feeEngineerRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.feeEngineerResponse = new MutableLiveData<>();
        this.feeUrlResponse = new MutableLiveData<>();
        this.receiptResponse = new MutableLiveData<>();
        this.feeArtsResponse = new MutableLiveData<>();
        this.feeArtsUrlResponse = new MutableLiveData<>();
        this.semResponse = new MutableLiveData<>();
    }

    public final void getFees() {
        this.feeEngineerResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeEngineerResponse> singleObserveOn = this.feeEngineerRepository.getFeeEngineerApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeEngineerResponse, Unit> function1 = new Function1<FeeEngineerResponse, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getFees.1
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
                FeeMainNewViewModel.this.feeEngineerResponse.postValue(Resource.INSTANCE.success(feeEngineerResponse));
            }
        };
        Consumer<? super FeeEngineerResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getFees$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getFees.2
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
                FeeMainNewViewModel.this.feeEngineerResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getFees$lambda$1(function12, obj);
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
        final Function1<FeeEngineerResponse, Unit> function1 = new Function1<FeeEngineerResponse, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getFeesKmea.1
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
                FeeMainNewViewModel.this.feeEngineerResponse.postValue(Resource.INSTANCE.success(feeEngineerResponse));
            }
        };
        Consumer<? super FeeEngineerResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getFeesKmea$lambda$2(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getFeesKmea.2
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
                FeeMainNewViewModel.this.feeEngineerResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getFeesKmea$lambda$3(function12, obj);
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
        Single<FeeEngineerUrlResponse> singleObserveOn = this.feeEngineerRepository.getEngineerFeePayUrlApiCall(FeeCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeEngineerUrlResponse, Unit> function1 = new Function1<FeeEngineerUrlResponse, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getFeeUrl.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeEngineerUrlResponse feeEngineerUrlResponse) {
                invoke2(feeEngineerUrlResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeEngineerUrlResponse feeEngineerUrlResponse) {
                FeeMainNewViewModel.this.feeUrlResponse.postValue(Resource.INSTANCE.success(feeEngineerUrlResponse));
            }
        };
        Consumer<? super FeeEngineerUrlResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getFeeUrl$lambda$4(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getFeeUrl.2
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
                FeeMainNewViewModel.this.feeUrlResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getFeeUrl$lambda$5(function12, obj);
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

    public final void getReceipts() {
        this.receiptResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ReceiptResponse> singleObserveOn = this.feeEngineerRepository.getFeeReceiptsApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ReceiptResponse, Unit> function1 = new Function1<ReceiptResponse, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getReceipts.1
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
                FeeMainNewViewModel.this.receiptResponse.postValue(Resource.INSTANCE.success(receiptResponse));
            }
        };
        Consumer<? super ReceiptResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getReceipts$lambda$6(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getReceipts.2
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
                FeeMainNewViewModel.this.receiptResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getReceipts$lambda$7(function12, obj);
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

    public final void getFeesArts() {
        this.feeArtsResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeArtsResponse> singleObserveOn = this.feeEngineerRepository.getFeeArtsApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeArtsResponse, Unit> function1 = new Function1<FeeArtsResponse, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getFeesArts.1
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
                FeeMainNewViewModel.this.feeArtsResponse.postValue(Resource.INSTANCE.success(feeArtsResponse));
            }
        };
        Consumer<? super FeeArtsResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getFeesArts$lambda$8(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getFeesArts.2
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
                FeeMainNewViewModel.this.feeArtsResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getFeesArts$lambda$9(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeesArts$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeesArts$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<FeeArtsResponse>> getFeeArtsResponse() {
        return this.feeArtsResponse;
    }

    public final void getFeesSemWise(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.feeArtsResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeArtsResponse> singleObserveOn = this.feeEngineerRepository.getFeeArtsApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeArtsResponse, Unit> function1 = new Function1<FeeArtsResponse, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getFeesSemWise.1
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
                FeeMainNewViewModel.this.feeArtsResponse.postValue(Resource.INSTANCE.success(feeArtsResponse));
            }
        };
        Consumer<? super FeeArtsResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getFeesSemWise$lambda$10(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getFeesSemWise.2
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
                FeeMainNewViewModel.this.feeArtsResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getFeesSemWise$lambda$11(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeesSemWise$lambda$10(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeesSemWise$lambda$11(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<FeeArtsResponse>> getSemWiseResponse() {
        return this.feeArtsResponse;
    }

    public final void getFeeArtsUrl(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        this.feeArtsUrlResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeArtsUrlResponse> singleObserveOn = this.feeEngineerRepository.getArtsFeePayUrlApiCall(FeeCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeArtsUrlResponse, Unit> function1 = new Function1<FeeArtsUrlResponse, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getFeeArtsUrl.1
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
                FeeMainNewViewModel.this.feeArtsUrlResponse.postValue(Resource.INSTANCE.success(feeArtsUrlResponse));
            }
        };
        Consumer<? super FeeArtsUrlResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getFeeArtsUrl$lambda$12(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getFeeArtsUrl.2
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
                FeeMainNewViewModel.this.feeArtsUrlResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getFeeArtsUrl$lambda$13(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeeArtsUrl$lambda$12(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeeArtsUrl$lambda$13(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<FeeArtsUrlResponse>> getFeeUrlArtsResponse() {
        return this.feeArtsUrlResponse;
    }

    public final void getSemester() {
        this.semResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeArtsSemesterResponse> singleObserveOn = this.feeEngineerRepository.getFeeArtsSemList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeArtsSemesterResponse, Unit> function1 = new Function1<FeeArtsSemesterResponse, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getSemester.1
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
                FeeMainNewViewModel.this.semResponse.postValue(Resource.INSTANCE.success(feeArtsSemesterResponse));
            }
        };
        Consumer<? super FeeArtsSemesterResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getSemester$lambda$14(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel.getSemester.2
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
                FeeMainNewViewModel.this.semResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.FeeMainNewViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeMainNewViewModel.getSemester$lambda$15(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemester$lambda$14(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemester$lambda$15(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<FeeArtsSemesterResponse>> getSemResponse() {
        return this.semResponse;
    }
}