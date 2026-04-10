package in.etuwa.app.ui.hostel.tkmhostel.receipt;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.hostel.receipt.HostelReceiptResponse;
import in.etuwa.app.data.repository.HostelRepository;
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

/* compiled from: TkmReceiptViewModel.kt */
/* loaded from: classes5.dex */
public final class TkmReceiptViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<HostelReceiptResponse>> hostelFeeResponse;
    private final HostelRepository hostelRepository;

    public TkmReceiptViewModel(HostelRepository hostelRepository) {
        Intrinsics.checkNotNullParameter(hostelRepository, "hostelRepository");
        this.hostelRepository = hostelRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.hostelFeeResponse = new MutableLiveData<>();
    }

    public final void getHostelReceipt() {
        this.hostelFeeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelReceiptResponse> observeOn = this.hostelRepository.getHostelReceiptTkmApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelReceiptResponse, Unit> function1 = new Function1<HostelReceiptResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.receipt.TkmReceiptViewModel$getHostelReceipt$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelReceiptResponse hostelReceiptResponse) {
                invoke2(hostelReceiptResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelReceiptResponse hostelReceiptResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TkmReceiptViewModel.this.hostelFeeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelReceiptResponse));
            }
        };
        Consumer<? super HostelReceiptResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.tkmhostel.receipt.TkmReceiptViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TkmReceiptViewModel.getHostelReceipt$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.tkmhostel.receipt.TkmReceiptViewModel$getHostelReceipt$2
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
                mutableLiveData = TkmReceiptViewModel.this.hostelFeeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.tkmhostel.receipt.TkmReceiptViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TkmReceiptViewModel.getHostelReceipt$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelReceipt$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelReceipt$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelReceiptResponse>> getResponse() {
        return this.hostelFeeResponse;
    }
}