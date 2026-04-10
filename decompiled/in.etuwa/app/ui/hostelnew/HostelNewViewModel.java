package in.etuwa.app.ui.hostelnew;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.hostelnew.HostelNewAdmissionResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewHistoryResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewMonthlyResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewPay;
import in.etuwa.app.data.model.hostelnew.HostelStatusNew;
import in.etuwa.app.data.repository.HostelRepository;
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

/* compiled from: HostelNewViewModel.kt */
/* loaded from: classes5.dex */
public final class HostelNewViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<HostelNewAdmissionResponse>> hostelAdmissionResponse;
    private MutableLiveData<Resource<HostelNewHistoryResponse>> hostelHistoryResponse;
    private MutableLiveData<Resource<HostelNewMonthlyResponse>> hostelMonthlyResponse;
    private MutableLiveData<Resource<HostelNewPay>> hostelPayResponse;
    private final HostelRepository hostelRepository;
    private MutableLiveData<Resource<HostelStatusNew>> hostelStatusResponse;

    public HostelNewViewModel(HostelRepository hostelRepository) {
        Intrinsics.checkNotNullParameter(hostelRepository, "hostelRepository");
        this.hostelRepository = hostelRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.hostelAdmissionResponse = new MutableLiveData<>();
        this.hostelMonthlyResponse = new MutableLiveData<>();
        this.hostelHistoryResponse = new MutableLiveData<>();
        this.hostelPayResponse = new MutableLiveData<>();
        this.hostelStatusResponse = new MutableLiveData<>();
    }

    public final void getHostelAdmissionFee() {
        this.hostelAdmissionResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelNewAdmissionResponse> observeOn = this.hostelRepository.getHostelNewAdmissionApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelNewAdmissionResponse, Unit> function1 = new Function1<HostelNewAdmissionResponse, Unit>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$getHostelAdmissionFee$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelNewAdmissionResponse hostelNewAdmissionResponse) {
                invoke2(hostelNewAdmissionResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelNewAdmissionResponse hostelNewAdmissionResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelNewViewModel.this.hostelAdmissionResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelNewAdmissionResponse));
            }
        };
        Consumer<? super HostelNewAdmissionResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelNewViewModel.getHostelAdmissionFee$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$getHostelAdmissionFee$2
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
                mutableLiveData = HostelNewViewModel.this.hostelAdmissionResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelNewViewModel.getHostelAdmissionFee$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelAdmissionFee$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelAdmissionFee$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelNewAdmissionResponse>> getAdmissionResponse() {
        return this.hostelAdmissionResponse;
    }

    public final void getHostelMonthlyFee() {
        this.hostelMonthlyResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelNewMonthlyResponse> observeOn = this.hostelRepository.getHostelNewMonthlyApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelNewMonthlyResponse, Unit> function1 = new Function1<HostelNewMonthlyResponse, Unit>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$getHostelMonthlyFee$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelNewMonthlyResponse hostelNewMonthlyResponse) {
                invoke2(hostelNewMonthlyResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelNewMonthlyResponse hostelNewMonthlyResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelNewViewModel.this.hostelMonthlyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelNewMonthlyResponse));
            }
        };
        Consumer<? super HostelNewMonthlyResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelNewViewModel.getHostelMonthlyFee$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$getHostelMonthlyFee$2
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
                mutableLiveData = HostelNewViewModel.this.hostelMonthlyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelNewViewModel.getHostelMonthlyFee$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelMonthlyFee$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelMonthlyFee$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelNewMonthlyResponse>> getMonthlyResponse() {
        return this.hostelMonthlyResponse;
    }

    public final void getHostelHistory() {
        this.hostelHistoryResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelNewHistoryResponse> observeOn = this.hostelRepository.getHostelHistoryNewApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelNewHistoryResponse, Unit> function1 = new Function1<HostelNewHistoryResponse, Unit>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$getHostelHistory$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelNewHistoryResponse hostelNewHistoryResponse) {
                invoke2(hostelNewHistoryResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelNewHistoryResponse hostelNewHistoryResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelNewViewModel.this.hostelHistoryResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelNewHistoryResponse));
            }
        };
        Consumer<? super HostelNewHistoryResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelNewViewModel.getHostelHistory$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$getHostelHistory$2
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
                mutableLiveData = HostelNewViewModel.this.hostelHistoryResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelNewViewModel.getHostelHistory$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelHistory$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelHistory$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelNewHistoryResponse>> getHistoryResponse() {
        return this.hostelHistoryResponse;
    }

    public final void getHostelPay(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        this.hostelPayResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelNewPay> observeOn = this.hostelRepository.getHostelFeeNewPayApiCall(feeCollection, feeReceipt).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelNewPay, Unit> function1 = new Function1<HostelNewPay, Unit>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$getHostelPay$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelNewPay hostelNewPay) {
                invoke2(hostelNewPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelNewPay hostelNewPay) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelNewViewModel.this.hostelPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelNewPay));
            }
        };
        Consumer<? super HostelNewPay> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelNewViewModel.getHostelPay$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$getHostelPay$2
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
                mutableLiveData = HostelNewViewModel.this.hostelPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelNewViewModel.getHostelPay$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelPay$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelPay$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelNewPay>> getHostelPayResponse() {
        return this.hostelPayResponse;
    }

    public final void getHostelStatus() {
        this.hostelStatusResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelStatusNew> observeOn = this.hostelRepository.getHostelStatusNewApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelStatusNew, Unit> function1 = new Function1<HostelStatusNew, Unit>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$getHostelStatus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelStatusNew hostelStatusNew) {
                invoke2(hostelStatusNew);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelStatusNew hostelStatusNew) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelNewViewModel.this.hostelStatusResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelStatusNew));
            }
        };
        Consumer<? super HostelStatusNew> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelNewViewModel.getHostelStatus$lambda$8(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$getHostelStatus$2
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
                mutableLiveData = HostelNewViewModel.this.hostelStatusResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostelnew.HostelNewViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelNewViewModel.getHostelStatus$lambda$9(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelStatus$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelStatus$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelStatusNew>> getStatusResponse() {
        return this.hostelStatusResponse;
    }
}