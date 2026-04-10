package in.etuwa.app.ui.stationary.booking;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.stationary.StationaryItemResponse;
import in.etuwa.app.data.repository.StationaryRepository;
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

/* compiled from: BookingViewModel.kt */
/* loaded from: classes5.dex */
public final class BookingViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final StationaryRepository stationaryRepository;
    private MutableLiveData<Resource<StationaryItemResponse>> stationaryResponse;

    public BookingViewModel(StationaryRepository stationaryRepository) {
        Intrinsics.checkNotNullParameter(stationaryRepository, "stationaryRepository");
        this.stationaryRepository = stationaryRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.stationaryResponse = new MutableLiveData<>();
    }

    public final void getStationaryList() {
        this.stationaryResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<StationaryItemResponse> observeOn = this.stationaryRepository.getStationaryListApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<StationaryItemResponse, Unit> function1 = new Function1<StationaryItemResponse, Unit>() { // from class: in.etuwa.app.ui.stationary.booking.BookingViewModel$getStationaryList$1
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
                mutableLiveData = BookingViewModel.this.stationaryResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(stationaryItemResponse));
            }
        };
        Consumer<? super StationaryItemResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.stationary.booking.BookingViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BookingViewModel.getStationaryList$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.stationary.booking.BookingViewModel$getStationaryList$2
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
                mutableLiveData = BookingViewModel.this.stationaryResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.stationary.booking.BookingViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BookingViewModel.getStationaryList$lambda$1(Function1.this, obj);
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
}