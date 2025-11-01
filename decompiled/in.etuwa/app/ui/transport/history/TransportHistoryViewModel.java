package in.etuwa.app.ui.transport.history;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.transport.TransportHistoryResponse;
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

/* compiled from: TransportHistoryViewModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/transport/history/TransportHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "transportRepository", "Lin/etuwa/app/data/repository/TransportRepository;", "(Lin/etuwa/app/data/repository/TransportRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "feeHistoryResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/transport/TransportHistoryResponse;", "getResponse", "getTransportFeeHistory", "", "onCleared", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransportHistoryViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<TransportHistoryResponse>> feeHistoryResponse;
    private final TransportRepository transportRepository;

    public TransportHistoryViewModel(TransportRepository transportRepository) {
        Intrinsics.checkNotNullParameter(transportRepository, "transportRepository");
        this.transportRepository = transportRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.feeHistoryResponse = new MutableLiveData<>();
    }

    public final void getTransportFeeHistory() {
        this.feeHistoryResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<TransportHistoryResponse> observeOn = this.transportRepository.getTransportHistoryUrlApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<TransportHistoryResponse, Unit> function1 = new Function1<TransportHistoryResponse, Unit>() { // from class: in.etuwa.app.ui.transport.history.TransportHistoryViewModel$getTransportFeeHistory$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransportHistoryResponse transportHistoryResponse) {
                invoke2(transportHistoryResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransportHistoryResponse transportHistoryResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = TransportHistoryViewModel.this.feeHistoryResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(transportHistoryResponse));
            }
        };
        Consumer<? super TransportHistoryResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.transport.history.TransportHistoryViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportHistoryViewModel.getTransportFeeHistory$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.transport.history.TransportHistoryViewModel$getTransportFeeHistory$2
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
                mutableLiveData = TransportHistoryViewModel.this.feeHistoryResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.transport.history.TransportHistoryViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TransportHistoryViewModel.getTransportFeeHistory$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTransportFeeHistory$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTransportFeeHistory$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<TransportHistoryResponse>> getResponse() {
        return this.feeHistoryResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}