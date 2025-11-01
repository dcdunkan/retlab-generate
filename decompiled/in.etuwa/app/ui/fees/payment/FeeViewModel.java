package in.etuwa.app.ui.fees.payment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.dash.DashResponse;
import in.etuwa.app.data.model.fee.FeeResponse;
import in.etuwa.app.data.model.fee.FeeSreeChitraUrl;
import in.etuwa.app.data.model.fee.FeeUrlResponse;
import in.etuwa.app.data.model.fee.feeheadgroups.FeeHeadGroupResponse;
import in.etuwa.app.data.model.fee.installment.InstallmentResponse;
import in.etuwa.app.data.repository.FeeRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeViewModel.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010&J\u0006\u0010)\u001a\u00020$J\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\bJ\u0006\u0010+\u001a\u00020$J\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\t0\bJ\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\b\u0010.\u001a\u00020$H\u0014JN\u0010/\u001a\u00020$2\"\u00100\u001a\u001e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&01j\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&`22\"\u00103\u001a\u001e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&01j\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&`2J\u0082\u0001\u00104\u001a\u00020$2\"\u00100\u001a\u001e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&01j\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&`22\"\u00103\u001a\u001e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&01j\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&`22\"\u00105\u001a\u001e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&01j\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&`22\u0006\u00106\u001a\u00020&2\u0006\u0010(\u001a\u00020&JN\u00107\u001a\u00020$2\"\u00100\u001a\u001e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&01j\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&`22\"\u00103\u001a\u001e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&01j\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&`2R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR&\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u0011R&\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u0011R&\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u0011R&\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u0011¨\u00068"}, d2 = {"Lin/etuwa/app/ui/fees/payment/FeeViewModel;", "Landroidx/lifecycle/ViewModel;", "feeRepository", "Lin/etuwa/app/data/repository/FeeRepository;", "(Lin/etuwa/app/data/repository/FeeRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "dashResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/dash/DashResponse;", "getDashResponse", "()Landroidx/lifecycle/MutableLiveData;", "feeHeadResponse", "Lin/etuwa/app/data/model/fee/feeheadgroups/FeeHeadGroupResponse;", "getFeeHeadResponse", "setFeeHeadResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "feeResponse", "Lin/etuwa/app/data/model/fee/FeeResponse;", "instalmentResponse", "Lin/etuwa/app/data/model/fee/installment/InstallmentResponse;", "getInstalmentResponse", "setInstalmentResponse", "payFeeSreeChitraResponse", "Lin/etuwa/app/data/model/fee/FeeSreeChitraUrl;", "getPayFeeSreeChitraResponse", "setPayFeeSreeChitraResponse", "payResponse", "Lin/etuwa/app/data/model/fee/FeeUrlResponse;", "getPayResponse", "setPayResponse", "submitResponse", "getSubmitResponse", "setSubmitResponse", "getDashData", "", "hostel", "", "getFees", "installment", "getFeesHead", "getHeadResponse", "getInstallments", "getResponse", "getResponseBatchId", "onCleared", "payFees", "feeCollection", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "feeReceipt", "paySreeChitraFees", "transaction", "payment", "submitFees", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeeViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final MutableLiveData<Resource<DashResponse>> dashResponse;
    private MutableLiveData<Resource<FeeHeadGroupResponse>> feeHeadResponse;
    private final FeeRepository feeRepository;
    private MutableLiveData<Resource<FeeResponse>> feeResponse;
    private MutableLiveData<Resource<InstallmentResponse>> instalmentResponse;
    private MutableLiveData<Resource<FeeSreeChitraUrl>> payFeeSreeChitraResponse;
    private MutableLiveData<Resource<FeeUrlResponse>> payResponse;
    private MutableLiveData<Resource<FeeUrlResponse>> submitResponse;

    public FeeViewModel(FeeRepository feeRepository) {
        Intrinsics.checkNotNullParameter(feeRepository, "feeRepository");
        this.feeRepository = feeRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.feeResponse = new MutableLiveData<>();
        this.feeHeadResponse = new MutableLiveData<>();
        this.submitResponse = new MutableLiveData<>();
        this.instalmentResponse = new MutableLiveData<>();
        this.payResponse = new MutableLiveData<>();
        this.payFeeSreeChitraResponse = new MutableLiveData<>();
        this.dashResponse = new MutableLiveData<>();
    }

    public final MutableLiveData<Resource<FeeHeadGroupResponse>> getFeeHeadResponse() {
        return this.feeHeadResponse;
    }

    public final void setFeeHeadResponse(MutableLiveData<Resource<FeeHeadGroupResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.feeHeadResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<FeeUrlResponse>> getSubmitResponse() {
        return this.submitResponse;
    }

    public final void setSubmitResponse(MutableLiveData<Resource<FeeUrlResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.submitResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<InstallmentResponse>> getInstalmentResponse() {
        return this.instalmentResponse;
    }

    public final void setInstalmentResponse(MutableLiveData<Resource<InstallmentResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.instalmentResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<FeeUrlResponse>> getPayResponse() {
        return this.payResponse;
    }

    public final void setPayResponse(MutableLiveData<Resource<FeeUrlResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.payResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<FeeSreeChitraUrl>> getPayFeeSreeChitraResponse() {
        return this.payFeeSreeChitraResponse;
    }

    public final void setPayFeeSreeChitraResponse(MutableLiveData<Resource<FeeSreeChitraUrl>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.payFeeSreeChitraResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<DashResponse>> getDashResponse() {
        return this.dashResponse;
    }

    public final void getInstallments() {
        this.instalmentResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<InstallmentResponse> observeOn = this.feeRepository.getFeeInstallmentsApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<InstallmentResponse, Unit> function1 = new Function1<InstallmentResponse, Unit>() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$getInstallments$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InstallmentResponse installmentResponse) {
                invoke2(installmentResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InstallmentResponse installmentResponse) {
                FeeViewModel.this.getInstalmentResponse().postValue(Resource.INSTANCE.success(installmentResponse));
            }
        };
        Consumer<? super InstallmentResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeViewModel.getInstallments$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$getInstallments$2
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
                FeeViewModel.this.getInstalmentResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeViewModel.getInstallments$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getInstallments$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getInstallments$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void getFees(String installment) {
        this.feeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeResponse> observeOn = this.feeRepository.getFeesApiCall(installment).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeResponse, Unit> function1 = new Function1<FeeResponse, Unit>() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$getFees$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeResponse feeResponse) {
                invoke2(feeResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeResponse feeResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = FeeViewModel.this.feeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(feeResponse));
            }
        };
        Consumer<? super FeeResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeViewModel.getFees$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$getFees$2
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
                mutableLiveData = FeeViewModel.this.feeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeViewModel.getFees$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFees$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFees$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void getFeesHead() {
        this.feeHeadResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeHeadGroupResponse> observeOn = this.feeRepository.getFeeHeadApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeHeadGroupResponse, Unit> function1 = new Function1<FeeHeadGroupResponse, Unit>() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$getFeesHead$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeHeadGroupResponse feeHeadGroupResponse) {
                invoke2(feeHeadGroupResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeHeadGroupResponse feeHeadGroupResponse) {
                FeeViewModel.this.getFeeHeadResponse().postValue(Resource.INSTANCE.success(feeHeadGroupResponse));
            }
        };
        Consumer<? super FeeHeadGroupResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeViewModel.getFeesHead$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$getFeesHead$2
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
                FeeViewModel.this.getFeeHeadResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeViewModel.getFeesHead$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeesHead$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeesHead$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void submitFees(HashMap<String, String> feeCollection, HashMap<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        this.submitResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeUrlResponse> observeOn = this.feeRepository.submitFeesApiCall(feeCollection, feeReceipt).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeUrlResponse, Unit> function1 = new Function1<FeeUrlResponse, Unit>() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$submitFees$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeUrlResponse feeUrlResponse) {
                invoke2(feeUrlResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeUrlResponse feeUrlResponse) {
                FeeViewModel.this.getSubmitResponse().postValue(Resource.INSTANCE.success(feeUrlResponse));
            }
        };
        Consumer<? super FeeUrlResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeViewModel.submitFees$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$submitFees$2
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
                FeeViewModel.this.getSubmitResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeViewModel.submitFees$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitFees$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitFees$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void payFees(HashMap<String, String> feeCollection, HashMap<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        this.payResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeUrlResponse> observeOn = this.feeRepository.submitFeesApiCall(feeCollection, feeReceipt).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeUrlResponse, Unit> function1 = new Function1<FeeUrlResponse, Unit>() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$payFees$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeUrlResponse feeUrlResponse) {
                invoke2(feeUrlResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeUrlResponse feeUrlResponse) {
                FeeViewModel.this.getPayResponse().postValue(Resource.INSTANCE.success(feeUrlResponse));
            }
        };
        Consumer<? super FeeUrlResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeViewModel.payFees$lambda$8(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$payFees$2
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
                FeeViewModel.this.getPayResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeViewModel.payFees$lambda$9(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void payFees$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void payFees$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void paySreeChitraFees(HashMap<String, String> feeCollection, HashMap<String, String> feeReceipt, HashMap<String, String> transaction, String payment, String installment) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        Intrinsics.checkNotNullParameter(payment, "payment");
        Intrinsics.checkNotNullParameter(installment, "installment");
        this.payResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeSreeChitraUrl> observeOn = this.feeRepository.payFeesSreeChitraApiCall(feeCollection, feeReceipt, transaction, payment, installment).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeSreeChitraUrl, Unit> function1 = new Function1<FeeSreeChitraUrl, Unit>() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$paySreeChitraFees$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeSreeChitraUrl feeSreeChitraUrl) {
                invoke2(feeSreeChitraUrl);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeSreeChitraUrl feeSreeChitraUrl) {
                FeeViewModel.this.getPayFeeSreeChitraResponse().postValue(Resource.INSTANCE.success(feeSreeChitraUrl));
            }
        };
        Consumer<? super FeeSreeChitraUrl> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeViewModel.paySreeChitraFees$lambda$10(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$paySreeChitraFees$2
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
                FeeViewModel.this.getPayFeeSreeChitraResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeViewModel.paySreeChitraFees$lambda$11(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void paySreeChitraFees$lambda$10(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void paySreeChitraFees$lambda$11(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<FeeResponse>> getResponse() {
        return this.feeResponse;
    }

    public final MutableLiveData<Resource<FeeHeadGroupResponse>> getHeadResponse() {
        return this.feeHeadResponse;
    }

    public final void getDashData(String hostel) {
        this.dashResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<DashResponse> observeOn = this.feeRepository.getDashApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DashResponse, Unit> function1 = new Function1<DashResponse, Unit>() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$getDashData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DashResponse dashResponse) {
                invoke2(dashResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DashResponse dashResponse) {
                FeeViewModel.this.getDashResponse().postValue(Resource.INSTANCE.success(dashResponse));
            }
        };
        Consumer<? super DashResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeViewModel.getDashData$lambda$12(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$getDashData$2
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
                FeeViewModel.this.getDashResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.payment.FeeViewModel$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeeViewModel.getDashData$lambda$13(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDashData$lambda$12(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDashData$lambda$13(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<DashResponse>> getResponseBatchId() {
        return this.dashResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}