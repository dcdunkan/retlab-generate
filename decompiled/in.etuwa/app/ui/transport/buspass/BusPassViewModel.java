package in.etuwa.app.ui.transport.buspass;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.transportpalai.BusPass;
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

/* compiled from: BusPassViewModel.kt */
/* loaded from: classes5.dex */
public final class BusPassViewModel extends ViewModel {
    private final MutableLiveData<Resource<BusPass>> busPassResponse;
    private final CompositeDisposable compositeDisposable;
    private final TransportRepository transportRepository;

    public BusPassViewModel(TransportRepository transportRepository) {
        Intrinsics.checkNotNullParameter(transportRepository, "transportRepository");
        this.transportRepository = transportRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.busPassResponse = new MutableLiveData<>();
    }

    public final void getBusResponse() {
        this.busPassResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<BusPass> observeOn = this.transportRepository.getTransportBusPassApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<BusPass, Unit> function1 = new Function1<BusPass, Unit>() { // from class: in.etuwa.app.ui.transport.buspass.BusPassViewModel$getBusResponse$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BusPass busPass) {
                invoke2(busPass);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BusPass busPass) {
                MutableLiveData mutableLiveData;
                mutableLiveData = BusPassViewModel.this.busPassResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(busPass));
            }
        };
        Consumer<? super BusPass> consumer = new Consumer() { // from class: in.etuwa.app.ui.transport.buspass.BusPassViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BusPassViewModel.getBusResponse$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.transport.buspass.BusPassViewModel$getBusResponse$2
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
                mutableLiveData = BusPassViewModel.this.busPassResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.transport.buspass.BusPassViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BusPassViewModel.getBusResponse$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBusResponse$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBusResponse$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<BusPass>> getBusPassResponse() {
        return this.busPassResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}