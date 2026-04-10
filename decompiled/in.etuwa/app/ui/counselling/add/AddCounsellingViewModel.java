package in.etuwa.app.ui.counselling.add;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.counselling.status.CounsellingStatusResponse;
import in.etuwa.app.data.model.counselling.type.CounsellingTypesResponse;
import in.etuwa.app.data.model.counselling.view.ViewCounsellingResponse;
import in.etuwa.app.data.repository.CounsellingRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: AddCounsellingViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AddCounsellingViewModel extends ViewModel {
    private MutableLiveData<Resource<SuccessResponse>> addCounsellingResponse;
    private final CompositeDisposable compositeDisposable;
    private final CounsellingRepository counsellingRepository;
    private MutableLiveData<Resource<CounsellingStatusResponse>> counsellingStatusResponse;
    private MutableLiveData<Resource<CounsellingTypesResponse>> counsellingTypeResponse;
    private volatile boolean isDataLoaded;
    private ArrayList<MultipartBody.Part> multipartFile;
    private MutableLiveData<Resource<Float>> progressResponse;
    private MutableLiveData<Resource<SuccessResponse>> reopenCounsellingResponse;
    private MutableLiveData<Resource<ViewCounsellingResponse>> viewCounsellingResponse;

    public AddCounsellingViewModel(CounsellingRepository counsellingRepository) {
        Intrinsics.checkNotNullParameter(counsellingRepository, "counsellingRepository");
        this.counsellingRepository = counsellingRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.counsellingTypeResponse = new MutableLiveData<>();
        this.counsellingStatusResponse = new MutableLiveData<>();
        this.viewCounsellingResponse = new MutableLiveData<>();
        this.addCounsellingResponse = new MutableLiveData<>();
        this.reopenCounsellingResponse = new MutableLiveData<>();
        this.progressResponse = new MutableLiveData<>();
        this.multipartFile = new ArrayList<>();
        loadDataIfNeeded();
    }

    public final MutableLiveData<Resource<SuccessResponse>> getAddCounsellingResponse() {
        return this.addCounsellingResponse;
    }

    public final void setAddCounsellingResponse(MutableLiveData<Resource<SuccessResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.addCounsellingResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<SuccessResponse>> getReopenCounsellingResponse() {
        return this.reopenCounsellingResponse;
    }

    public final void setReopenCounsellingResponse(MutableLiveData<Resource<SuccessResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.reopenCounsellingResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<Float>> getProgressResponse() {
        return this.progressResponse;
    }

    public final void setProgressResponse(MutableLiveData<Resource<Float>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.progressResponse = mutableLiveData;
    }

    public final void loadDataIfNeeded() {
        if (this.isDataLoaded) {
            return;
        }
        this.isDataLoaded = true;
        getCounsellingTypes();
        getGrievanceStatus();
    }

    private final void getCounsellingTypes() {
        this.counsellingTypeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<CounsellingTypesResponse> singleObserveOn = this.counsellingRepository.getCounsellingTypeApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<CounsellingTypesResponse, Unit> function1 = new Function1<CounsellingTypesResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel.getCounsellingTypes.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CounsellingTypesResponse counsellingTypesResponse) {
                invoke2(counsellingTypesResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CounsellingTypesResponse counsellingTypesResponse) {
                AddCounsellingViewModel.this.counsellingTypeResponse.postValue(Resource.INSTANCE.success(counsellingTypesResponse));
            }
        };
        Consumer<? super CounsellingTypesResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.getCounsellingTypes$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel.getCounsellingTypes.2
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
                AddCounsellingViewModel.this.counsellingTypeResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.getCounsellingTypes$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCounsellingTypes$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCounsellingTypes$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void getGrievanceStatus() {
        this.counsellingStatusResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<CounsellingStatusResponse> singleObserveOn = this.counsellingRepository.getCounsellingStatusApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<CounsellingStatusResponse, Unit> function1 = new Function1<CounsellingStatusResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel.getGrievanceStatus.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CounsellingStatusResponse counsellingStatusResponse) {
                invoke2(counsellingStatusResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CounsellingStatusResponse counsellingStatusResponse) {
                AddCounsellingViewModel.this.counsellingStatusResponse.postValue(Resource.INSTANCE.success(counsellingStatusResponse));
            }
        };
        Consumer<? super CounsellingStatusResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.getGrievanceStatus$lambda$2(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel.getGrievanceStatus.2
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
                AddCounsellingViewModel.this.counsellingStatusResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.getGrievanceStatus$lambda$3(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGrievanceStatus$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGrievanceStatus$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void viewGrievance(String id) {
        this.viewCounsellingResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ViewCounsellingResponse> singleObserveOn = this.counsellingRepository.viewCounsellingApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ViewCounsellingResponse, Unit> function1 = new Function1<ViewCounsellingResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel.viewGrievance.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewCounsellingResponse viewCounsellingResponse) {
                invoke2(viewCounsellingResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewCounsellingResponse viewCounsellingResponse) {
                AddCounsellingViewModel.this.viewCounsellingResponse.postValue(Resource.INSTANCE.success(viewCounsellingResponse));
            }
        };
        Consumer<? super ViewCounsellingResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.viewGrievance$lambda$4(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel.viewGrievance.2
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
                AddCounsellingViewModel.this.viewCounsellingResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.viewGrievance$lambda$5(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewGrievance$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewGrievance$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void addCouselling(HashMap<String, RequestBody> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.multipartFile.clear();
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SuccessResponse> observableObserveOn = this.counsellingRepository.addCounsellingApiCall(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel.addCouselling.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SuccessResponse successResponse) {
                invoke2(successResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SuccessResponse successResponse) {
                AddCounsellingViewModel.this.getAddCounsellingResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.addCouselling$lambda$6(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel.addCouselling.2
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
                System.out.println((Object) ("============================================= " + th.getMessage()));
                AddCounsellingViewModel.this.getAddCounsellingResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observableObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.addCouselling$lambda$7(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addCouselling$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addCouselling$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void updateCounselling(RequestBody id, HashMap<String, RequestBody> map) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(map, "map");
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Observable<SuccessResponse> observableObserveOn = this.counsellingRepository.updateCounsellingApiCall(id, map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel.updateCounselling.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SuccessResponse successResponse) {
                invoke2(successResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SuccessResponse successResponse) {
                AddCounsellingViewModel.this.getAddCounsellingResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.updateCounselling$lambda$8(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel.updateCounselling.2
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
                AddCounsellingViewModel.this.getAddCounsellingResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observableObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.updateCounselling$lambda$9(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateCounselling$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateCounselling$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void reopenCounselling(String id, String type, String concern, String home, String studies, String relationship, String physical, String history, String session, String comments) {
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> singleObserveOn = this.counsellingRepository.reopenCounsellingApiCall(id, type, concern, home, studies, relationship, physical, history, session, comments).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel.reopenCounselling.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SuccessResponse successResponse) {
                invoke2(successResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SuccessResponse successResponse) {
                AddCounsellingViewModel.this.getReopenCounsellingResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.reopenCounselling$lambda$10(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel.reopenCounselling.2
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
                AddCounsellingViewModel.this.getReopenCounsellingResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.reopenCounselling$lambda$11(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reopenCounselling$lambda$10(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reopenCounselling$lambda$11(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ViewCounsellingResponse>> getViewResponse() {
        return this.viewCounsellingResponse;
    }

    public final MutableLiveData<Resource<CounsellingTypesResponse>> getTypeResponse() {
        return this.counsellingTypeResponse;
    }

    public final MutableLiveData<Resource<CounsellingStatusResponse>> getStatusResponse() {
        return this.counsellingStatusResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}