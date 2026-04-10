package in.etuwa.app.ui.centralizedinfo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.centralizedinfo.CentralizedInfoResponse;
import in.etuwa.app.data.repository.CommonRepository;
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

/* compiled from: CentralizedInfoViewModel.kt */
/* loaded from: classes4.dex */
public final class CentralizedInfoViewModel extends ViewModel {
    private final CommonRepository commonRepository;
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<CentralizedInfoResponse>> infoResponse;

    public CentralizedInfoViewModel(CommonRepository commonRepository) {
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        this.commonRepository = commonRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.infoResponse = new MutableLiveData<>();
        getCentralizedInfo();
    }

    public final void getCentralizedInfo() {
        this.infoResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<CentralizedInfoResponse> observeOn = this.commonRepository.getCentralizedInfoApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<CentralizedInfoResponse, Unit> function1 = new Function1<CentralizedInfoResponse, Unit>() { // from class: in.etuwa.app.ui.centralizedinfo.CentralizedInfoViewModel$getCentralizedInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CentralizedInfoResponse centralizedInfoResponse) {
                invoke2(centralizedInfoResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CentralizedInfoResponse centralizedInfoResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = CentralizedInfoViewModel.this.infoResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(centralizedInfoResponse));
            }
        };
        Consumer<? super CentralizedInfoResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.centralizedinfo.CentralizedInfoViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CentralizedInfoViewModel.getCentralizedInfo$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.centralizedinfo.CentralizedInfoViewModel$getCentralizedInfo$2
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
                mutableLiveData = CentralizedInfoViewModel.this.infoResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.centralizedinfo.CentralizedInfoViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CentralizedInfoViewModel.getCentralizedInfo$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCentralizedInfo$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCentralizedInfo$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<CentralizedInfoResponse>> getResponse() {
        return this.infoResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}