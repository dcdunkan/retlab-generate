package in.etuwa.app.ui.videoclass;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.materials.MaterialRequest;
import in.etuwa.app.data.model.video.VideoResponse;
import in.etuwa.app.data.repository.VideoClassRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoClassViewModel.kt */
/* loaded from: classes5.dex */
public final class VideoClassViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<ArrayList<Semester>>> semResponse;
    private final VideoClassRepository videoClassRepository;
    private MutableLiveData<Resource<VideoResponse>> videoResponse;

    public VideoClassViewModel(VideoClassRepository videoClassRepository) {
        Intrinsics.checkNotNullParameter(videoClassRepository, "videoClassRepository");
        this.videoClassRepository = videoClassRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.videoResponse = new MutableLiveData<>();
        this.semResponse = new MutableLiveData<>();
        getSemester();
    }

    public final void getSemester() {
        this.semResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<Semester>> observeOn = this.videoClassRepository.getSemestersApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<Semester>, Unit> function1 = new Function1<ArrayList<Semester>, Unit>() { // from class: in.etuwa.app.ui.videoclass.VideoClassViewModel$getSemester$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<Semester> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<Semester> arrayList) {
                MutableLiveData mutableLiveData;
                mutableLiveData = VideoClassViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<Semester>> consumer = new Consumer() { // from class: in.etuwa.app.ui.videoclass.VideoClassViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoClassViewModel.getSemester$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.videoclass.VideoClassViewModel$getSemester$2
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
                mutableLiveData = VideoClassViewModel.this.semResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.videoclass.VideoClassViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoClassViewModel.getSemester$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemester$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemester$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ArrayList<Semester>>> getSemResponse() {
        return this.semResponse;
    }

    public static /* synthetic */ void getVideoClass$default(VideoClassViewModel videoClassViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        videoClassViewModel.getVideoClass(str);
    }

    public final void getVideoClass(String semId) {
        Intrinsics.checkNotNullParameter(semId, "semId");
        this.videoResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<VideoResponse> observeOn = this.videoClassRepository.getVideoClassApiCall(new MaterialRequest(semId)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<VideoResponse, Unit> function1 = new Function1<VideoResponse, Unit>() { // from class: in.etuwa.app.ui.videoclass.VideoClassViewModel$getVideoClass$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VideoResponse videoResponse) {
                invoke2(videoResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VideoResponse videoResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = VideoClassViewModel.this.videoResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(videoResponse));
            }
        };
        Consumer<? super VideoResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.videoclass.VideoClassViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoClassViewModel.getVideoClass$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.videoclass.VideoClassViewModel$getVideoClass$2
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
                mutableLiveData = VideoClassViewModel.this.videoResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.videoclass.VideoClassViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoClassViewModel.getVideoClass$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getVideoClass$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getVideoClass$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<VideoResponse>> getResponse() {
        return this.videoResponse;
    }

    public final void watchVideoClass(String videoId, String youtubeId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Intrinsics.checkNotNullParameter(youtubeId, "youtubeId");
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.videoClassRepository.getWatchVideoApiCall(videoId, youtubeId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final VideoClassViewModel$watchVideoClass$1 videoClassViewModel$watchVideoClass$1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.videoclass.VideoClassViewModel$watchVideoClass$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SuccessResponse successResponse) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SuccessResponse successResponse) {
                invoke2(successResponse);
                return Unit.INSTANCE;
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.videoclass.VideoClassViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoClassViewModel.watchVideoClass$lambda$4(Function1.this, obj);
            }
        };
        final VideoClassViewModel$watchVideoClass$2 videoClassViewModel$watchVideoClass$2 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.videoclass.VideoClassViewModel$watchVideoClass$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.videoclass.VideoClassViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoClassViewModel.watchVideoClass$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void watchVideoClass$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void watchVideoClass$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}