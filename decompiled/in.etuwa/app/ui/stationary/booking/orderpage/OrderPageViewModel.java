package in.etuwa.app.ui.stationary.booking.orderpage;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.stationary.AdvancePaymentResponse;
import in.etuwa.app.data.model.stationary.StationaryItemResponse;
import in.etuwa.app.data.repository.StationaryRepository;
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

/* compiled from: OrderPageViewModel.kt */
/* loaded from: classes5.dex */
public final class OrderPageViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final StationaryRepository stationaryRepository;
    private MutableLiveData<Resource<StationaryItemResponse>> stationaryResponse;
    private MutableLiveData<Resource<AdvancePaymentResponse>> urlResponse;

    public OrderPageViewModel(StationaryRepository stationaryRepository) {
        Intrinsics.checkNotNullParameter(stationaryRepository, "stationaryRepository");
        this.stationaryRepository = stationaryRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.urlResponse = new MutableLiveData<>();
        this.stationaryResponse = new MutableLiveData<>();
    }

    public final void getStationaryList() {
        this.stationaryResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<StationaryItemResponse> observeOn = this.stationaryRepository.getStationaryListApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<StationaryItemResponse, Unit> function1 = new Function1<StationaryItemResponse, Unit>() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageViewModel$getStationaryList$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StationaryItemResponse stationaryItemResponse) {
                invoke2(stationaryItemResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StationaryItemResponse stationaryItemResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = OrderPageViewModel.this.stationaryResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(stationaryItemResponse));
            }
        };
        Consumer<? super StationaryItemResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderPageViewModel.getStationaryList$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageViewModel$getStationaryList$2
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
                mutableLiveData = OrderPageViewModel.this.stationaryResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderPageViewModel.getStationaryList$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getStationaryList$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getStationaryList$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<StationaryItemResponse>> getResponse() {
        return this.stationaryResponse;
    }

    public final void getAdvancePaymentUrl(Map<String, String> productDetails) {
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        this.urlResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<AdvancePaymentResponse> observeOn = this.stationaryRepository.getStationaryPaymentUrlApiCall(productDetails).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<AdvancePaymentResponse, Unit> function1 = new Function1<AdvancePaymentResponse, Unit>() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageViewModel$getAdvancePaymentUrl$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AdvancePaymentResponse advancePaymentResponse) {
                invoke2(advancePaymentResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AdvancePaymentResponse advancePaymentResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = OrderPageViewModel.this.urlResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(advancePaymentResponse));
            }
        };
        Consumer<? super AdvancePaymentResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderPageViewModel.getAdvancePaymentUrl$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageViewModel$getAdvancePaymentUrl$2
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
                mutableLiveData = OrderPageViewModel.this.urlResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderPageViewModel.getAdvancePaymentUrl$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAdvancePaymentUrl$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAdvancePaymentUrl$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<AdvancePaymentResponse>> getUrlResponse() {
        return this.urlResponse;
    }
}