package in.etuwa.app.ui.store.storeview;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.store.StoreResponse;
import in.etuwa.app.data.model.store.departmentlist.DepartmentListResponse;
import in.etuwa.app.data.repository.StoreRepository;
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

/* JADX INFO: compiled from: StoreViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class StoreViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<DepartmentListResponse>> depResponse;
    private boolean isDataLoaded;
    private final StoreRepository storeRepository;
    private MutableLiveData<Resource<StoreResponse>> storeResponse;

    public StoreViewModel(StoreRepository storeRepository) {
        Intrinsics.checkNotNullParameter(storeRepository, "storeRepository");
        this.storeRepository = storeRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.storeResponse = new MutableLiveData<>();
        this.depResponse = new MutableLiveData<>();
        loadDataIfNeeded();
    }

    public final void getStoreData(String subId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        this.storeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<StoreResponse> singleObserveOn = this.storeRepository.getStoreDataApiCall(subId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<StoreResponse, Unit> function1 = new Function1<StoreResponse, Unit>() { // from class: in.etuwa.app.ui.store.storeview.StoreViewModel.getStoreData.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StoreResponse storeResponse) {
                invoke2(storeResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreResponse storeResponse) {
                StoreViewModel.this.storeResponse.postValue(Resource.INSTANCE.success(storeResponse));
            }
        };
        Consumer<? super StoreResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.store.storeview.StoreViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StoreViewModel.getStoreData$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.store.storeview.StoreViewModel.getStoreData.2
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
                StoreViewModel.this.storeResponse.postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.store.storeview.StoreViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StoreViewModel.getStoreData$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getStoreData$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getStoreData$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<StoreResponse>> getResponse() {
        return this.storeResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }

    public final void loadDataIfNeeded() {
        if (this.isDataLoaded) {
            return;
        }
        this.isDataLoaded = true;
        getDepartment();
    }

    public final void getDepartment() {
        this.depResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<DepartmentListResponse> singleObserveOn = this.storeRepository.getCategoryApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DepartmentListResponse, Unit> function1 = new Function1<DepartmentListResponse, Unit>() { // from class: in.etuwa.app.ui.store.storeview.StoreViewModel.getDepartment.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DepartmentListResponse departmentListResponse) {
                invoke2(departmentListResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DepartmentListResponse departmentListResponse) {
                StoreViewModel.this.depResponse.postValue(Resource.INSTANCE.success(departmentListResponse));
            }
        };
        Consumer<? super DepartmentListResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.store.storeview.StoreViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StoreViewModel.getDepartment$lambda$2(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.store.storeview.StoreViewModel.getDepartment.2
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
                StoreViewModel.this.depResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.store.storeview.StoreViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StoreViewModel.getDepartment$lambda$3(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDepartment$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDepartment$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<DepartmentListResponse>> getDepResponse() {
        return this.depResponse;
    }
}