package in.etuwa.app.ui.activitypoint;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.activitypoint.ActivityPointResponse;
import in.etuwa.app.data.repository.ActivityPointRepository;
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

/* JADX INFO: compiled from: ActivityPointViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ActivityPointViewModel extends ViewModel {
    private final ActivityPointRepository activityPointRepository;
    private MutableLiveData<Resource<ActivityPointResponse>> activityResponse;
    private final CompositeDisposable compositeDisposable;
    private boolean isDataLoaded;

    public ActivityPointViewModel(ActivityPointRepository activityPointRepository) {
        Intrinsics.checkNotNullParameter(activityPointRepository, "activityPointRepository");
        this.activityPointRepository = activityPointRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.activityResponse = new MutableLiveData<>();
        loadDataIfNeeded();
    }

    public final void loadDataIfNeeded() {
        if (this.isDataLoaded) {
            return;
        }
        this.isDataLoaded = true;
        getActivities();
    }

    public final void getActivities() {
        this.activityResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ActivityPointResponse> singleObserveOn = this.activityPointRepository.getActivityPointApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ActivityPointResponse, Unit> function1 = new Function1<ActivityPointResponse, Unit>() { // from class: in.etuwa.app.ui.activitypoint.ActivityPointViewModel.getActivities.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActivityPointResponse activityPointResponse) {
                invoke2(activityPointResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ActivityPointResponse activityPointResponse) {
                ActivityPointViewModel.this.activityResponse.postValue(Resource.INSTANCE.success(activityPointResponse));
            }
        };
        Consumer<? super ActivityPointResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.activitypoint.ActivityPointViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ActivityPointViewModel.getActivities$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.activitypoint.ActivityPointViewModel.getActivities.2
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
                ActivityPointViewModel.this.activityResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.activitypoint.ActivityPointViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ActivityPointViewModel.getActivities$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getActivities$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getActivities$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ActivityPointResponse>> getResponse() {
        return this.activityResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}