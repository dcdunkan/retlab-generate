package in.etuwa.app.ui.hostel.attendance.parent;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.hostel.attendance.HostelAttParentViewResponse;
import in.etuwa.app.data.repository.HostelRepository;
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

/* compiled from: HostelAttendanceParentViewModel.kt */
/* loaded from: classes5.dex */
public final class HostelAttendanceParentViewModel extends ViewModel {
    private MutableLiveData<Resource<SuccessResponse>> approveResponse;
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<HostelAttParentViewResponse>> hostelApproveResponse;
    private MutableLiveData<Resource<HostelAttParentViewResponse>> hostelRejectResponse;
    private final HostelRepository hostelRepository;
    private MutableLiveData<Resource<HostelAttParentViewResponse>> hostelResponse;
    private MutableLiveData<Resource<SuccessResponse>> rejectResponse;
    private MutableLiveData<Resource<SuccessResponse>> successResponse;

    public HostelAttendanceParentViewModel(HostelRepository hostelRepository) {
        Intrinsics.checkNotNullParameter(hostelRepository, "hostelRepository");
        this.hostelRepository = hostelRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.hostelResponse = new MutableLiveData<>();
        this.hostelApproveResponse = new MutableLiveData<>();
        this.hostelRejectResponse = new MutableLiveData<>();
        this.successResponse = new MutableLiveData<>();
        this.approveResponse = new MutableLiveData<>();
        this.rejectResponse = new MutableLiveData<>();
    }

    public final void getHostelAttParentView(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.hostelResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelAttParentViewResponse> observeOn = this.hostelRepository.getHostelLeaveViewParentApiCall(date).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelAttParentViewResponse, Unit> function1 = new Function1<HostelAttParentViewResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$getHostelAttParentView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelAttParentViewResponse hostelAttParentViewResponse) {
                invoke2(hostelAttParentViewResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelAttParentViewResponse hostelAttParentViewResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelAttendanceParentViewModel.this.hostelResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelAttParentViewResponse));
            }
        };
        Consumer<? super HostelAttParentViewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelAttendanceParentViewModel.getHostelAttParentView$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$getHostelAttParentView$2
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
                mutableLiveData = HostelAttendanceParentViewModel.this.hostelResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelAttendanceParentViewModel.getHostelAttParentView$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelAttParentView$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelAttParentView$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelAttParentViewResponse>> getResponse() {
        return this.hostelResponse;
    }

    public final void getHostelAttParentApproveView(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.hostelApproveResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelAttParentViewResponse> observeOn = this.hostelRepository.getHostelLeaveViewParentApproveApiCall(date).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelAttParentViewResponse, Unit> function1 = new Function1<HostelAttParentViewResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$getHostelAttParentApproveView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelAttParentViewResponse hostelAttParentViewResponse) {
                invoke2(hostelAttParentViewResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelAttParentViewResponse hostelAttParentViewResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelAttendanceParentViewModel.this.hostelApproveResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelAttParentViewResponse));
            }
        };
        Consumer<? super HostelAttParentViewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelAttendanceParentViewModel.getHostelAttParentApproveView$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$getHostelAttParentApproveView$2
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
                mutableLiveData = HostelAttendanceParentViewModel.this.hostelApproveResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelAttendanceParentViewModel.getHostelAttParentApproveView$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelAttParentApproveView$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelAttParentApproveView$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelAttParentViewResponse>> getApproveViewResponse() {
        return this.hostelApproveResponse;
    }

    public final void getHostelAttParentRejectView(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.hostelRejectResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelAttParentViewResponse> observeOn = this.hostelRepository.getHostelLeaveViewParentRejectApiCall(date).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelAttParentViewResponse, Unit> function1 = new Function1<HostelAttParentViewResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$getHostelAttParentRejectView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelAttParentViewResponse hostelAttParentViewResponse) {
                invoke2(hostelAttParentViewResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelAttParentViewResponse hostelAttParentViewResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelAttendanceParentViewModel.this.hostelRejectResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelAttParentViewResponse));
            }
        };
        Consumer<? super HostelAttParentViewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelAttendanceParentViewModel.getHostelAttParentRejectView$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$getHostelAttParentRejectView$2
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
                mutableLiveData = HostelAttendanceParentViewModel.this.hostelRejectResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelAttendanceParentViewModel.getHostelAttParentRejectView$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelAttParentRejectView$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelAttParentRejectView$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelAttParentViewResponse>> getRejectViewResponse() {
        return this.hostelRejectResponse;
    }

    public final void getRevokeParent(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.successResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.hostelRepository.getHostelRevokeLeaveParentApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$getRevokeParent$1
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
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelAttendanceParentViewModel.this.successResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelAttendanceParentViewModel.getRevokeParent$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$getRevokeParent$2
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
                mutableLiveData = HostelAttendanceParentViewModel.this.successResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelAttendanceParentViewModel.getRevokeParent$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRevokeParent$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRevokeParent$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SuccessResponse>> getRevokeResponse() {
        return this.successResponse;
    }

    public final void getAApproveResponse(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.approveResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.hostelRepository.getHostelApproveLeaveParentApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$getAApproveResponse$1
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
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelAttendanceParentViewModel.this.approveResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelAttendanceParentViewModel.getAApproveResponse$lambda$8(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$getAApproveResponse$2
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
                mutableLiveData = HostelAttendanceParentViewModel.this.approveResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelAttendanceParentViewModel.getAApproveResponse$lambda$9(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAApproveResponse$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAApproveResponse$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SuccessResponse>> getApproveResponse() {
        return this.approveResponse;
    }

    public final void getRejectParent(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.rejectResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.hostelRepository.getHostelRejectLeaveParentApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$getRejectParent$1
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
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelAttendanceParentViewModel.this.rejectResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelAttendanceParentViewModel.getRejectParent$lambda$10(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$getRejectParent$2
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
                mutableLiveData = HostelAttendanceParentViewModel.this.rejectResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.HostelAttendanceParentViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelAttendanceParentViewModel.getRejectParent$lambda$11(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRejectParent$lambda$10(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRejectParent$lambda$11(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SuccessResponse>> getRejectResponse() {
        return this.rejectResponse;
    }
}