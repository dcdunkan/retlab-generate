package in.etuwa.app.ui.homework;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.homework.HomeWorkResponse;
import in.etuwa.app.data.repository.HomeWorkRepository;
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

/* compiled from: HomeWorkViewModel.kt */
/* loaded from: classes4.dex */
public final class HomeWorkViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<SuccessResponse>> deleteResponse;
    private final HomeWorkRepository homeWorkRepository;
    private MutableLiveData<Resource<HomeWorkResponse>> homeworkResponse;

    public HomeWorkViewModel(HomeWorkRepository homeWorkRepository) {
        Intrinsics.checkNotNullParameter(homeWorkRepository, "homeWorkRepository");
        this.homeWorkRepository = homeWorkRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.homeworkResponse = new MutableLiveData<>();
        this.deleteResponse = new MutableLiveData<>();
        getHomeWork();
    }

    public final MutableLiveData<Resource<HomeWorkResponse>> getHomeworkResponse() {
        return this.homeworkResponse;
    }

    public final void setHomeworkResponse(MutableLiveData<Resource<HomeWorkResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.homeworkResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<SuccessResponse>> getDeleteResponse() {
        return this.deleteResponse;
    }

    public final void setDeleteResponse(MutableLiveData<Resource<SuccessResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.deleteResponse = mutableLiveData;
    }

    public final void getHomeWork() {
        this.homeworkResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HomeWorkResponse> observeOn = this.homeWorkRepository.getHomeWorksApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HomeWorkResponse, Unit> function1 = new Function1<HomeWorkResponse, Unit>() { // from class: in.etuwa.app.ui.homework.HomeWorkViewModel$getHomeWork$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HomeWorkResponse homeWorkResponse) {
                invoke2(homeWorkResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HomeWorkResponse homeWorkResponse) {
                HomeWorkViewModel.this.getHomeworkResponse().postValue(Resource.INSTANCE.success(homeWorkResponse));
            }
        };
        Consumer<? super HomeWorkResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.homework.HomeWorkViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeWorkViewModel.getHomeWork$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.homework.HomeWorkViewModel$getHomeWork$2
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
                HomeWorkViewModel.this.getHomeworkResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.homework.HomeWorkViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeWorkViewModel.getHomeWork$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHomeWork$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHomeWork$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HomeWorkResponse>> getResponse() {
        return this.homeworkResponse;
    }

    public final void deleteHomeWork(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.deleteResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.homeWorkRepository.deleteHomeWorkApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.homework.HomeWorkViewModel$deleteHomeWork$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SuccessResponse successResponse) {
                invoke2(successResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SuccessResponse successResponse) {
                HomeWorkViewModel.this.getDeleteResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.homework.HomeWorkViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeWorkViewModel.deleteHomeWork$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.homework.HomeWorkViewModel$deleteHomeWork$2
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
                HomeWorkViewModel.this.getDeleteResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.homework.HomeWorkViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeWorkViewModel.deleteHomeWork$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteHomeWork$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteHomeWork$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}