package in.etuwa.app.ui.transport.payment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.transport.TransportFeeResponse;
import in.etuwa.app.data.repository.TransportRepository;
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

/* compiled from: TransportFeeViewModel.kt */
/* loaded from: classes5.dex */
public final class TransportFeeViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<TransportFeeResponse>> feeResponse;
    private final TransportRepository transportRepository;

    public TransportFeeViewModel(TransportRepository transportRepository) {
        Intrinsics.checkNotNullParameter(transportRepository, "transportRepository");
        this.transportRepository = transportRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.feeResponse = new MutableLiveData<>();
    }

    public final void getTransportFee(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.feeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<TransportFeeResponse> observeOn = this.transportRepository.getTransFeeApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<TransportFeeResponse, Unit> function1 = new Function1<TransportFeeResponse, Unit>() { // from class: in.etuwa.app.ui.transport.payment.TransportFeeViewModel$getTransportFee$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransportFeeResponse transportFeeResponse) {
                invoke2(transportFeeResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransportFeeResponse transportFeeResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TransportFeeViewModel.this.feeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(transportFeeResponse));
            }
        };
        Consumer<? super TransportFeeResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.transport.payment.TransportFeeViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportFeeViewModel.getTransportFee$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.transport.payment.TransportFeeViewModel$getTransportFee$2
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
                mutableLiveData = TransportFeeViewModel.this.feeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.transport.payment.TransportFeeViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportFeeViewModel.getTransportFee$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTransportFee$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTransportFee$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<TransportFeeResponse>> getResponse() {
        return this.feeResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}