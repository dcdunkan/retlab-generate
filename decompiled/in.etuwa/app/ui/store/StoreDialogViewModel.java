package in.etuwa.app.ui.store;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
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

/* JADX INFO: compiled from: StoreDialogViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class StoreDialogViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<DepartmentListResponse>> depResponse;
    private boolean isDataLoaded;
    private MutableLiveData<Resource<DepartmentListResponse>> semResponse;
    private final StoreRepository storeRepository;
    private MutableLiveData<Resource<DepartmentListResponse>> subResponse;

    public StoreDialogViewModel(StoreRepository storeRepository) {
        Intrinsics.checkNotNullParameter(storeRepository, "storeRepository");
        this.storeRepository = storeRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.depResponse = new MutableLiveData<>();
        this.semResponse = new MutableLiveData<>();
        this.subResponse = new MutableLiveData<>();
        loadDataIfNeeded();
    }

    public final void getSemester(String dept_id) {
        Intrinsics.checkNotNullParameter(dept_id, "dept_id");
        this.semResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<DepartmentListResponse> singleObserveOn = this.storeRepository.getSemesterListApiCall(dept_id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DepartmentListResponse, Unit> function1 = new Function1<DepartmentListResponse, Unit>() { // from class: in.etuwa.app.ui.store.StoreDialogViewModel.getSemester.1
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
                StoreDialogViewModel.this.semResponse.postValue(Resource.INSTANCE.success(departmentListResponse));
            }
        };
        Consumer<? super DepartmentListResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.store.StoreDialogViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StoreDialogViewModel.getSemester$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.store.StoreDialogViewModel.getSemester.2
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
                StoreDialogViewModel.this.semResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.store.StoreDialogViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StoreDialogViewModel.getSemester$lambda$1(function12, obj);
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

    public final MutableLiveData<Resource<DepartmentListResponse>> getSemResponse() {
        return this.semResponse;
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
        Single<DepartmentListResponse> singleObserveOn = this.storeRepository.getDepartmentApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DepartmentListResponse, Unit> function1 = new Function1<DepartmentListResponse, Unit>() { // from class: in.etuwa.app.ui.store.StoreDialogViewModel.getDepartment.1
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
                StoreDialogViewModel.this.depResponse.postValue(Resource.INSTANCE.success(departmentListResponse));
            }
        };
        Consumer<? super DepartmentListResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.store.StoreDialogViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StoreDialogViewModel.getDepartment$lambda$2(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.store.StoreDialogViewModel.getDepartment.2
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
                StoreDialogViewModel.this.depResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.store.StoreDialogViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StoreDialogViewModel.getDepartment$lambda$3(function12, obj);
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

    public final void getSubject(String dept_id, String sem_id) {
        Intrinsics.checkNotNullParameter(dept_id, "dept_id");
        Intrinsics.checkNotNullParameter(sem_id, "sem_id");
        this.subResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<DepartmentListResponse> singleObserveOn = this.storeRepository.getSubjectListApiCall(dept_id, sem_id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DepartmentListResponse, Unit> function1 = new Function1<DepartmentListResponse, Unit>() { // from class: in.etuwa.app.ui.store.StoreDialogViewModel.getSubject.1
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
                StoreDialogViewModel.this.subResponse.postValue(Resource.INSTANCE.success(departmentListResponse));
            }
        };
        Consumer<? super DepartmentListResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.store.StoreDialogViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StoreDialogViewModel.getSubject$lambda$4(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.store.StoreDialogViewModel.getSubject.2
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
                StoreDialogViewModel.this.subResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.store.StoreDialogViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StoreDialogViewModel.getSubject$lambda$5(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSubject$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSubject$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<DepartmentListResponse>> getSubResponse() {
        return this.subResponse;
    }
}