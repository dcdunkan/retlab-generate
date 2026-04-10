package in.etuwa.app.ui.hostel.palaihostel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.hostel.HostelFeePalaiResponse;
import in.etuwa.app.data.model.hostel.HostelMonthResponse;
import in.etuwa.app.data.model.hostel.HostelPalaiAdmissionResponse;
import in.etuwa.app.data.model.hostel.HostelPalaiTypesResponse;
import in.etuwa.app.data.model.hostel.HostelResponse;
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

/* JADX INFO: compiled from: PalaiHostelViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class PalaiHostelViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<HostelPalaiAdmissionResponse>> hostelFeePalaiResponse;
    private MutableLiveData<Resource<HostelPalaiTypesResponse>> hostelFeePalaiTypeResponse;
    private MutableLiveData<Resource<HostelFeePalaiResponse>> hostelFeeResponse;
    private MutableLiveData<Resource<HostelMonthResponse>> hostelMonthResponse;
    private final HostelRepository hostelRepository;
    private MutableLiveData<Resource<HostelResponse>> hostelResponse;

    public PalaiHostelViewModel(HostelRepository hostelRepository) {
        Intrinsics.checkNotNullParameter(hostelRepository, "hostelRepository");
        this.hostelRepository = hostelRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.hostelResponse = new MutableLiveData<>();
        this.hostelMonthResponse = new MutableLiveData<>();
        this.hostelFeeResponse = new MutableLiveData<>();
        this.hostelFeePalaiResponse = new MutableLiveData<>();
        this.hostelFeePalaiTypeResponse = new MutableLiveData<>();
    }

    public final void getHostelFee() {
        this.hostelResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelResponse> singleObserveOn = this.hostelRepository.getHostelApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelResponse, Unit> function1 = new Function1<HostelResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel.getHostelFee.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelResponse hostelResponse) {
                invoke2(hostelResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelResponse hostelResponse) {
                PalaiHostelViewModel.this.hostelResponse.postValue(Resource.INSTANCE.success(hostelResponse));
            }
        };
        Consumer<? super HostelResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PalaiHostelViewModel.getHostelFee$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel.getHostelFee.2
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
                PalaiHostelViewModel.this.hostelResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PalaiHostelViewModel.getHostelFee$lambda$1(function12, obj);
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
        Single<HostelMonthResponse> singleObserveOn = this.hostelRepository.getHostelTkmApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelMonthResponse, Unit> function1 = new Function1<HostelMonthResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel.getHostelMonthFee.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelMonthResponse hostelMonthResponse) {
                invoke2(hostelMonthResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelMonthResponse hostelMonthResponse) {
                PalaiHostelViewModel.this.hostelMonthResponse.postValue(Resource.INSTANCE.success(hostelMonthResponse));
            }
        };
        Consumer<? super HostelMonthResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PalaiHostelViewModel.getHostelMonthFee$lambda$2(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel.getHostelMonthFee.2
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
                PalaiHostelViewModel.this.hostelMonthResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PalaiHostelViewModel.getHostelMonthFee$lambda$3(function12, obj);
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
        Single<HostelFeePalaiResponse> singleObserveOn = this.hostelRepository.getHostelFeeConfirmPalaiApiCall(feeCollection, feeReceipt).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelFeePalaiResponse, Unit> function1 = new Function1<HostelFeePalaiResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel.getHostelFee.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelFeePalaiResponse hostelFeePalaiResponse) {
                invoke2(hostelFeePalaiResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelFeePalaiResponse hostelFeePalaiResponse) {
                PalaiHostelViewModel.this.hostelFeeResponse.postValue(Resource.INSTANCE.success(hostelFeePalaiResponse));
            }
        };
        Consumer<? super HostelFeePalaiResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PalaiHostelViewModel.getHostelFee$lambda$4(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel.getHostelFee.4
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
                PalaiHostelViewModel.this.hostelFeeResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PalaiHostelViewModel.getHostelFee$lambda$5(function12, obj);
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
        Single<HostelPalaiAdmissionResponse> singleObserveOn = this.hostelRepository.getPalaiHostelAdmsnApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelPalaiAdmissionResponse, Unit> function1 = new Function1<HostelPalaiAdmissionResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel.getHostelPalaiFee.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelPalaiAdmissionResponse hostelPalaiAdmissionResponse) {
                invoke2(hostelPalaiAdmissionResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelPalaiAdmissionResponse hostelPalaiAdmissionResponse) {
                PalaiHostelViewModel.this.hostelFeePalaiResponse.postValue(Resource.INSTANCE.success(hostelPalaiAdmissionResponse));
            }
        };
        Consumer<? super HostelPalaiAdmissionResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PalaiHostelViewModel.getHostelPalaiFee$lambda$6(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel.getHostelPalaiFee.2
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
                PalaiHostelViewModel.this.hostelFeePalaiResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PalaiHostelViewModel.getHostelPalaiFee$lambda$7(function12, obj);
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

    public final MutableLiveData<Resource<HostelPalaiAdmissionResponse>> getHostelPalaiFeeResponse() {
        return this.hostelFeePalaiResponse;
    }

    public final void getHostelPalaiFeeTypes() {
        this.hostelFeePalaiTypeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelPalaiTypesResponse> singleObserveOn = this.hostelRepository.getHostelFeeTypesApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelPalaiTypesResponse, Unit> function1 = new Function1<HostelPalaiTypesResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel.getHostelPalaiFeeTypes.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelPalaiTypesResponse hostelPalaiTypesResponse) {
                invoke2(hostelPalaiTypesResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelPalaiTypesResponse hostelPalaiTypesResponse) {
                PalaiHostelViewModel.this.hostelFeePalaiTypeResponse.postValue(Resource.INSTANCE.success(hostelPalaiTypesResponse));
            }
        };
        Consumer<? super HostelPalaiTypesResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PalaiHostelViewModel.getHostelPalaiFeeTypes$lambda$8(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel.getHostelPalaiFeeTypes.2
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
                PalaiHostelViewModel.this.hostelFeePalaiTypeResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.palaihostel.PalaiHostelViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PalaiHostelViewModel.getHostelPalaiFeeTypes$lambda$9(function12, obj);
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