package in.etuwa.app.ui.dashboard.maintenance;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.dash.MaintenanceResponse;
import in.etuwa.app.data.repository.DashRepository;
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
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

/* compiled from: MaintenanceViewModel.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tJ\b\u0010\u0011\u001a\u00020\u000fH\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/dashboard/maintenance/MaintenanceViewModel;", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/component/KoinComponent;", "dashRepository", "Lin/etuwa/app/data/repository/DashRepository;", "(Lin/etuwa/app/data/repository/DashRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "maintenanceResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/dash/MaintenanceResponse;", "getMaintenanceResponse", "()Landroidx/lifecycle/MutableLiveData;", "getDashData", "", "getResponse", "onCleared", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MaintenanceViewModel extends ViewModel implements KoinComponent {
    private final CompositeDisposable compositeDisposable;
    private final DashRepository dashRepository;
    private final MutableLiveData<Resource<MaintenanceResponse>> maintenanceResponse;

    public MaintenanceViewModel(DashRepository dashRepository) {
        Intrinsics.checkNotNullParameter(dashRepository, "dashRepository");
        this.dashRepository = dashRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.maintenanceResponse = new MutableLiveData<>();
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final MutableLiveData<Resource<MaintenanceResponse>> getMaintenanceResponse() {
        return this.maintenanceResponse;
    }

    public final void getDashData() {
        this.maintenanceResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<MaintenanceResponse> observeOn = this.dashRepository.getMaintenanceUrl().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<MaintenanceResponse, Unit> function1 = new Function1<MaintenanceResponse, Unit>() { // from class: in.etuwa.app.ui.dashboard.maintenance.MaintenanceViewModel$getDashData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MaintenanceResponse maintenanceResponse) {
                invoke2(maintenanceResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MaintenanceResponse maintenanceResponse) {
                MaintenanceViewModel.this.getMaintenanceResponse().postValue(Resource.INSTANCE.success(maintenanceResponse));
            }
        };
        Consumer<? super MaintenanceResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.dashboard.maintenance.MaintenanceViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MaintenanceViewModel.getDashData$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.dashboard.maintenance.MaintenanceViewModel$getDashData$2
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
                MaintenanceViewModel.this.getMaintenanceResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.dashboard.maintenance.MaintenanceViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MaintenanceViewModel.getDashData$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDashData$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDashData$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<MaintenanceResponse>> getResponse() {
        return this.maintenanceResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}