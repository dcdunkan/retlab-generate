package in.etuwa.app.ui.feepartial.hostel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.hostel.HostelFeePalaiResponse;
import in.etuwa.app.data.model.hostel.HostelMonthResponse;
import in.etuwa.app.data.model.hostel.HostelPalaiTypesResponse;
import in.etuwa.app.data.model.hostel.HostelResponse;
import in.etuwa.app.data.model.hostel.partial.admission.HostelPartialAdmission;
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

/* compiled from: HostelPartialViewModel.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J.\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016J\u0006\u0010\u0019\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0017J\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u0006\u0010\u001d\u001a\u00020\u0014J\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bJ\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\bJ\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\bJ\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lin/etuwa/app/ui/feepartial/hostel/HostelPartialViewModel;", "Landroidx/lifecycle/ViewModel;", "hostelRepository", "Lin/etuwa/app/data/repository/HostelRepository;", "(Lin/etuwa/app/data/repository/HostelRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "hostelFeePalaiResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/hostel/partial/admission/HostelPartialAdmission;", "hostelFeePalaiTypeResponse", "Lin/etuwa/app/data/model/hostel/HostelPalaiTypesResponse;", "hostelFeeResponse", "Lin/etuwa/app/data/model/hostel/HostelFeePalaiResponse;", "hostelMonthResponse", "Lin/etuwa/app/data/model/hostel/HostelMonthResponse;", "hostelResponse", "Lin/etuwa/app/data/model/hostel/HostelResponse;", "getHostelFee", "", "feeCollection", "", "", "feeReceipt", "getHostelMonthFee", "getHostelPalaiFee", "id", "getHostelPalaiFeeResponse", "getHostelPalaiFeeTypes", "getHostelPalaiFeeTypesResponse", "getMonthResponse", "getResponse", "getUrlResponse", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HostelPartialViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<HostelPartialAdmission>> hostelFeePalaiResponse;
    private MutableLiveData<Resource<HostelPalaiTypesResponse>> hostelFeePalaiTypeResponse;
    private MutableLiveData<Resource<HostelFeePalaiResponse>> hostelFeeResponse;
    private MutableLiveData<Resource<HostelMonthResponse>> hostelMonthResponse;
    private final HostelRepository hostelRepository;
    private MutableLiveData<Resource<HostelResponse>> hostelResponse;

    public HostelPartialViewModel(HostelRepository hostelRepository) {
        Intrinsics.checkNotNullParameter(hostelRepository, "hostelRepository");
        this.hostelRepository = hostelRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.hostelResponse = new MutableLiveData<>();
        this.hostelMonthResponse = new MutableLiveData<>();
        this.hostelFeeResponse = new MutableLiveData<>();
        this.hostelFeePalaiResponse = new MutableLiveData<>();
        this.hostelFeePalaiTypeResponse = new MutableLiveData<>();
        getHostelFee();
    }

    public final void getHostelFee() {
        this.hostelResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelResponse> observeOn = this.hostelRepository.getHostelApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelResponse, Unit> function1 = new Function1<HostelResponse, Unit>() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$getHostelFee$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelResponse hostelResponse) {
                invoke2(hostelResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelResponse hostelResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelPartialViewModel.this.hostelResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelResponse));
            }
        };
        Consumer<? super HostelResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelPartialViewModel.getHostelFee$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$getHostelFee$2
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
                mutableLiveData = HostelPartialViewModel.this.hostelResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelPartialViewModel.getHostelFee$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelFee$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelFee$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelResponse>> getResponse() {
        return this.hostelResponse;
    }

    public final void getHostelMonthFee() {
        this.hostelMonthResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelMonthResponse> observeOn = this.hostelRepository.getHostelTkmApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelMonthResponse, Unit> function1 = new Function1<HostelMonthResponse, Unit>() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$getHostelMonthFee$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelMonthResponse hostelMonthResponse) {
                invoke2(hostelMonthResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelMonthResponse hostelMonthResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelPartialViewModel.this.hostelMonthResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelMonthResponse));
            }
        };
        Consumer<? super HostelMonthResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelPartialViewModel.getHostelMonthFee$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$getHostelMonthFee$2
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
                mutableLiveData = HostelPartialViewModel.this.hostelMonthResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelPartialViewModel.getHostelMonthFee$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelMonthFee$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelMonthFee$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelMonthResponse>> getMonthResponse() {
        return this.hostelMonthResponse;
    }

    public final void getHostelFee(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        this.hostelFeeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelFeePalaiResponse> observeOn = this.hostelRepository.getHostelFeeConfirmPalaiApiCall(feeCollection, feeReceipt).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelFeePalaiResponse, Unit> function1 = new Function1<HostelFeePalaiResponse, Unit>() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$getHostelFee$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelFeePalaiResponse hostelFeePalaiResponse) {
                invoke2(hostelFeePalaiResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelFeePalaiResponse hostelFeePalaiResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelPartialViewModel.this.hostelFeeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelFeePalaiResponse));
            }
        };
        Consumer<? super HostelFeePalaiResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelPartialViewModel.getHostelFee$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$getHostelFee$4
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
                mutableLiveData = HostelPartialViewModel.this.hostelFeeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelPartialViewModel.getHostelFee$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelFee$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelFee$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelFeePalaiResponse>> getUrlResponse() {
        return this.hostelFeeResponse;
    }

    public final void getHostelPalaiFee(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.hostelFeePalaiResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelPartialAdmission> observeOn = this.hostelRepository.getPalaiHostelPartialAdmsnApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelPartialAdmission, Unit> function1 = new Function1<HostelPartialAdmission, Unit>() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$getHostelPalaiFee$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelPartialAdmission hostelPartialAdmission) {
                invoke2(hostelPartialAdmission);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelPartialAdmission hostelPartialAdmission) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelPartialViewModel.this.hostelFeePalaiResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelPartialAdmission));
            }
        };
        Consumer<? super HostelPartialAdmission> consumer = new Consumer() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelPartialViewModel.getHostelPalaiFee$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$getHostelPalaiFee$2
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
                mutableLiveData = HostelPartialViewModel.this.hostelFeePalaiResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelPartialViewModel.getHostelPalaiFee$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelPalaiFee$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelPalaiFee$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelPartialAdmission>> getHostelPalaiFeeResponse() {
        return this.hostelFeePalaiResponse;
    }

    public final void getHostelPalaiFeeTypes() {
        this.hostelFeePalaiTypeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelPalaiTypesResponse> observeOn = this.hostelRepository.getHostelFeeTypesApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelPalaiTypesResponse, Unit> function1 = new Function1<HostelPalaiTypesResponse, Unit>() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$getHostelPalaiFeeTypes$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelPalaiTypesResponse hostelPalaiTypesResponse) {
                invoke2(hostelPalaiTypesResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelPalaiTypesResponse hostelPalaiTypesResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelPartialViewModel.this.hostelFeePalaiTypeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelPalaiTypesResponse));
            }
        };
        Consumer<? super HostelPalaiTypesResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelPartialViewModel.getHostelPalaiFeeTypes$lambda$8(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$getHostelPalaiFeeTypes$2
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
                mutableLiveData = HostelPartialViewModel.this.hostelFeePalaiTypeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.feepartial.hostel.HostelPartialViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelPartialViewModel.getHostelPalaiFeeTypes$lambda$9(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelPalaiFeeTypes$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelPalaiFeeTypes$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelPalaiTypesResponse>> getHostelPalaiFeeTypesResponse() {
        return this.hostelFeePalaiTypeResponse;
    }
}