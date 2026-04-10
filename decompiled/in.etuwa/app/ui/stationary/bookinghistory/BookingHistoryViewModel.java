package in.etuwa.app.ui.stationary.bookinghistory;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.stationary.StationaryReceiptResponse;
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

/* compiled from: BookingHistoryViewModel.kt */
/* loaded from: classes5.dex */
public final class BookingHistoryViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final StationaryRepository stationaryRepository;
    private MutableLiveData<Resource<StationaryReceiptResponse>> stationaryResponse;

    public BookingHistoryViewModel(StationaryRepository stationaryRepository) {
        Intrinsics.checkNotNullParameter(stationaryRepository, "stationaryRepository");
        this.stationaryRepository = stationaryRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.stationaryResponse = new MutableLiveData<>();
    }

    public final void getStationaryReceipt() {
        this.stationaryResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<StationaryReceiptResponse> observeOn = this.stationaryRepository.getStationaryReceiptsApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<StationaryReceiptResponse, Unit> function1 = new Function1<StationaryReceiptResponse, Unit>() { // from class: in.etuwa.app.ui.stationary.bookinghistory.BookingHistoryViewModel$getStationaryReceipt$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StationaryReceiptResponse stationaryReceiptResponse) {
                invoke2(stationaryReceiptResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StationaryReceiptResponse stationaryReceiptResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = BookingHistoryViewModel.this.stationaryResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(stationaryReceiptResponse));
            }
        };
        Consumer<? super StationaryReceiptResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.stationary.bookinghistory.BookingHistoryViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BookingHistoryViewModel.getStationaryReceipt$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.stationary.bookinghistory.BookingHistoryViewModel$getStationaryReceipt$2
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
                mutableLiveData = BookingHistoryViewModel.this.stationaryResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.stationary.bookinghistory.BookingHistoryViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BookingHistoryViewModel.getStationaryReceipt$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getStationaryReceipt$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getStationaryReceipt$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<StationaryReceiptResponse>> getResponse() {
        return this.stationaryResponse;
    }
}