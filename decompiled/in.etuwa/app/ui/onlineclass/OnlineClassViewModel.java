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

/* compiled from: OnlineClassViewModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\b\u0010\u000e\u001a\u00020\fH\u0014R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/onlineclass/OnlineClassViewModel;", "Landroidx/lifecycle/ViewModel;", "videoClassRepository", "Lin/etuwa/app/data/repository/VideoClassRepository;", "(Lin/etuwa/app/data/repository/VideoClassRepository;)V", "classResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/onlineclass/OnlineClassResponse;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getClass", "", "getResponse", "onCleared", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnlineClassViewModel extends ViewModel {
    private MutableLiveData<Resource<OnlineClassResponse>> classResponse;
    private final CompositeDisposable compositeDisposable;
    private final VideoClassRepository videoClassRepository;

    public OnlineClassViewModel(VideoClassRepository videoClassRepository) {
        Intrinsics.checkNotNullParameter(videoClassRepository, "videoClassRepository");
        this.videoClassRepository = videoClassRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.classResponse = new MutableLiveData<>();
        getClass();
    }

    public final void getClass() {
        this.classResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<OnlineClassResponse> observeOn = this.videoClassRepository.getOnlineClassApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<OnlineClassResponse, Unit> function1 = new Function1<OnlineClassResponse, Unit>() { // from class: in.etuwa.app.ui.onlineclass.OnlineClassViewModel$getClass$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnlineClassResponse onlineClassResponse) {
                invoke2(onlineClassResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OnlineClassResponse onlineClassResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = OnlineClassViewModel.this.classResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(onlineClassResponse));
            }
        };
        Consumer<? super OnlineClassResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.onlineclass.OnlineClassViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OnlineClassViewModel.getClass$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.onlineclass.OnlineClassViewModel$getClass$2
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
                mutableLiveData = OnlineClassViewModel.this.classResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.onlineclass.OnlineClassViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OnlineClassViewModel.getClass$lambda$1(Function1.this, obj);
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