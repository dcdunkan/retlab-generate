package in.etuwa.app.ui.fees.gateway;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.fee.GatewayDetailsResponse;
import in.etuwa.app.data.repository.FeeRepository;
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

/* JADX INFO: compiled from: GatewayViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GatewayViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final FeeRepository feeRepository;
    private MutableLiveData<Resource<GatewayDetailsResponse>> gatewayResponse;

    public GatewayViewModel(FeeRepository feeRepository) {
        Intrinsics.checkNotNullParameter(feeRepository, "feeRepository");
        this.feeRepository = feeRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.gatewayResponse = new MutableLiveData<>();
    }

    public final void getDetails() {
        this.gatewayResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<GatewayDetailsResponse> singleObserveOn = this.feeRepository.getGatewayDetailsApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<GatewayDetailsResponse, Unit> function1 = new Function1<GatewayDetailsResponse, Unit>() { // from class: in.etuwa.app.ui.fees.gateway.GatewayViewModel.getDetails.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GatewayDetailsResponse gatewayDetailsResponse) {
                invoke2(gatewayDetailsResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GatewayDetailsResponse gatewayDetailsResponse) {
                GatewayViewModel.this.gatewayResponse.postValue(Resource.INSTANCE.success(gatewayDetailsResponse));
            }
        };
        Consumer<? super GatewayDetailsResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.fees.gateway.GatewayViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GatewayViewModel.getDetails$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.fees.gateway.GatewayViewModel.getDetails.2
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
                GatewayViewModel.this.gatewayResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.fees.gateway.GatewayViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GatewayViewModel.getDetails$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDetails$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDetails$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<GatewayDetailsResponse>> getResponse() {
        return this.gatewayResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}