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

/* compiled from: AddCounsellingViewModel.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0002J\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u0006J\u0012\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u0006J\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00070\u0006J\b\u0010+\u001a\u00020!H\u0014Jj\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010$2\b\u0010.\u001a\u0004\u0018\u00010$2\b\u0010/\u001a\u0004\u0018\u00010$2\b\u00100\u001a\u0004\u0018\u00010$2\b\u00101\u001a\u0004\u0018\u00010$2\b\u00102\u001a\u0004\u0018\u00010$2\b\u00103\u001a\u0004\u0018\u00010$2\b\u00104\u001a\u0004\u0018\u00010$2\b\u00105\u001a\u0004\u0018\u00010$2\b\u00106\u001a\u0004\u0018\u00010$J2\u00107\u001a\u00020!2\u0006\u0010-\u001a\u00020%2\"\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#j\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%`8J\u0010\u00109\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010$R&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\fR&\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\fR\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lin/etuwa/app/ui/counselling/add/AddCounsellingViewModel;", "Landroidx/lifecycle/ViewModel;", "counsellingRepository", "Lin/etuwa/app/data/repository/CounsellingRepository;", "(Lin/etuwa/app/data/repository/CounsellingRepository;)V", "addCounsellingResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/SuccessResponse;", "getAddCounsellingResponse", "()Landroidx/lifecycle/MutableLiveData;", "setAddCounsellingResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "counsellingStatusResponse", "Lin/etuwa/app/data/model/counselling/status/CounsellingStatusResponse;", "counsellingTypeResponse", "Lin/etuwa/app/data/model/counselling/type/CounsellingTypesResponse;", "multipartFile", "Ljava/util/ArrayList;", "Lokhttp3/MultipartBody$Part;", "Lkotlin/collections/ArrayList;", "progressResponse", "", "getProgressResponse", "setProgressResponse", "reopenCounsellingResponse", "getReopenCounsellingResponse", "setReopenCounsellingResponse", "viewCounsellingResponse", "Lin/etuwa/app/data/model/counselling/view/ViewCounsellingResponse;", "addCouselling", "", "map", "Ljava/util/HashMap;", "", "Lokhttp3/RequestBody;", "getCounsellingTypes", "getGrievanceStatus", "getStatusResponse", "getTypeResponse", "getViewResponse", "onCleared", "reopenCounselling", "id", "type", "concern", "home", "studies", "relationship", "physical", "history", "session", "comments", "updateCounselling", "Lkotlin/collections/HashMap;", "viewGrievance", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddCounsellingViewModel extends ViewModel {
    private MutableLiveData<Resource<SuccessResponse>> addCounsellingResponse;
    private final CompositeDisposable compositeDisposable;
    private final CounsellingRepository counsellingRepository;
    private MutableLiveData<Resource<CounsellingStatusResponse>> counsellingStatusResponse;
    private MutableLiveData<Resource<CounsellingTypesResponse>> counsellingTypeResponse;
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
        getCounsellingTypes();
        getGrievanceStatus();
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

    private final void getCounsellingTypes() {
        this.counsellingTypeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<CounsellingTypesResponse> observeOn = this.counsellingRepository.getCounsellingTypeApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<CounsellingTypesResponse, Unit> function1 = new Function1<CounsellingTypesResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$getCounsellingTypes$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CounsellingTypesResponse counsellingTypesResponse) {
                invoke2(counsellingTypesResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CounsellingTypesResponse counsellingTypesResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = AddCounsellingViewModel.this.counsellingTypeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(counsellingTypesResponse));
            }
        };
        Consumer<? super CounsellingTypesResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.getCounsellingTypes$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$getCounsellingTypes$2
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
                mutableLiveData = AddCounsellingViewModel.this.counsellingTypeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.getCounsellingTypes$lambda$1(Function1.this, obj);
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
        Single<CounsellingStatusResponse> observeOn = this.counsellingRepository.getCounsellingStatusApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<CounsellingStatusResponse, Unit> function1 = new Function1<CounsellingStatusResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$getGrievanceStatus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CounsellingStatusResponse counsellingStatusResponse) {
                invoke2(counsellingStatusResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CounsellingStatusResponse counsellingStatusResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = AddCounsellingViewModel.this.counsellingStatusResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(counsellingStatusResponse));
            }
        };
        Consumer<? super CounsellingStatusResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.getGrievanceStatus$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$getGrievanceStatus$2
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
                mutableLiveData = AddCounsellingViewModel.this.counsellingStatusResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.getGrievanceStatus$lambda$3(Function1.this, obj);
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
        Single<ViewCounsellingResponse> observeOn = this.counsellingRepository.viewCounsellingApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ViewCounsellingResponse, Unit> function1 = new Function1<ViewCounsellingResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$viewGrievance$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewCounsellingResponse viewCounsellingResponse) {
                invoke2(viewCounsellingResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewCounsellingResponse viewCounsellingResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = AddCounsellingViewModel.this.viewCounsellingResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(viewCounsellingResponse));
            }
        };
        Consumer<? super ViewCounsellingResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.viewGrievance$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$viewGrievance$2
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
                mutableLiveData = AddCounsellingViewModel.this.viewCounsellingResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.viewGrievance$lambda$5(Function1.this, obj);
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
        Observable<SuccessResponse> observeOn = this.counsellingRepository.addCounsellingApiCall(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$addCouselling$1
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
                AddCounsellingViewModel.this.getAddCounsellingResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.addCouselling$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$addCouselling$2
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
                System.out.println((Object) ("============================================= " + th.getMessage()));
                AddCounsellingViewModel.this.getAddCounsellingResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.addCouselling$lambda$7(Function1.this, obj);
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
        Observable<SuccessResponse> observeOn = this.counsellingRepository.updateCounsellingApiCall(id, map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$updateCounselling$1
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
                AddCounsellingViewModel.this.getAddCounsellingResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.updateCounselling$lambda$8(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$updateCounselling$2
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
                AddCounsellingViewModel.this.getAddCounsellingResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.updateCounselling$lambda$9(Function1.this, obj);
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
        Single<SuccessResponse> observeOn = this.counsellingRepository.reopenCounsellingApiCall(id, type, concern, home, studies, relationship, physical, history, session, comments).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$reopenCounselling$1
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
                AddCounsellingViewModel.this.getReopenCounsellingResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.reopenCounselling$lambda$10(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$reopenCounselling$2
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
                AddCounsellingViewModel.this.getReopenCounsellingResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddCounsellingViewModel.reopenCounselling$lambda$11(Function1.this, obj);
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