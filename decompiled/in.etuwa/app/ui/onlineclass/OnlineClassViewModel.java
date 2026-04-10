package in.etuwa.app.ui.onlineclass;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.onlineclass.OnlineClassResponse;
import in.etuwa.app.data.repository.VideoClassRepository;
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

/* JADX INFO: compiled from: OnlineClassViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class OnlineClassViewModel extends ViewModel {
    private MutableLiveData<Resource<OnlineClassResponse>> classResponse;
    private final CompositeDisposable compositeDisposable;
    private boolean isDataLoaded;
    private final VideoClassRepository videoClassRepository;

    public OnlineClassViewModel(VideoClassRepository videoClassRepository) {
        Intrinsics.checkNotNullParameter(videoClassRepository, "videoClassRepository");
        this.videoClassRepository = videoClassRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.classResponse = new MutableLiveData<>();
        loadDataIfNeeded();
    }

    public final void loadDataIfNeeded() {
        if (this.isDataLoaded) {
            return;
        }
        this.isDataLoaded = true;
        getClass();
    }

    public final void getClass() {
        this.classResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<OnlineClassResponse> singleObserveOn = this.videoClassRepository.getOnlineClassApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<OnlineClassResponse, Unit> function1 = new Function1<OnlineClassResponse, Unit>() { // from class: in.etuwa.app.ui.onlineclass.OnlineClassViewModel.getClass.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnlineClassResponse onlineClassResponse) {
                invoke2(onlineClassResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineClassResponse onlineClassResponse) {
                OnlineClassViewModel.this.classResponse.postValue(Resource.INSTANCE.success(onlineClassResponse));
            }
        };
        Consumer<? super OnlineClassResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.onlineclass.OnlineClassViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OnlineClassViewModel.getClass$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.onlineclass.OnlineClassViewModel.getClass.2
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
                OnlineClassViewModel.this.classResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.onlineclass.OnlineClassViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OnlineClassViewModel.getClass$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getClass$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getClass$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<OnlineClassResponse>> getResponse() {
        return this.classResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}