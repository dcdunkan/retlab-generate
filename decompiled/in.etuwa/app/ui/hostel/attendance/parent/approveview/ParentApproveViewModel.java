package in.etuwa.app.ui.hostel.attendance.parent.approveview;

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
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParentApproveViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ParentApproveViewModel extends ViewModel {
    private MutableLiveData<Resource<SuccessResponse>> approveResponse;
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<HostelAttParentViewResponse>> hostelApproveResponse;
    private MutableLiveData<Resource<HostelAttParentViewResponse>> hostelRejectResponse;
    private final HostelRepository hostelRepository;
    private MutableLiveData<Resource<HostelAttParentViewResponse>> hostelResponse;
    private MutableLiveData<Resource<SuccessResponse>> rejectResponse;
    private MutableLiveData<Resource<SuccessResponse>> successResponse;

    public ParentApproveViewModel(HostelRepository hostelRepository) {
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

    public final void getApproveResponse(Map<String, String> rejectDetails) {
        Intrinsics.checkNotNullParameter(rejectDetails, "rejectDetails");
        this.approveResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> singleObserveOn = this.hostelRepository.getHostelApproveLeaveParentApiCall(rejectDetails).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveViewModel.getApproveResponse.1
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
                ParentApproveViewModel.this.approveResponse.postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ParentApproveViewModel.getApproveResponse$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveViewModel.getApproveResponse.2
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
                ParentApproveViewModel.this.approveResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ParentApproveViewModel.getApproveResponse$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getApproveResponse$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getApproveResponse$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SuccessResponse>> getApproveResponse() {
        return this.approveResponse;
    }

    public final void getRejectParent(Map<String, String> rejectDetails) {
        Intrinsics.checkNotNullParameter(rejectDetails, "rejectDetails");
        this.rejectResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> singleObserveOn = this.hostelRepository.getHostelRejectLeaveParentApiCall(rejectDetails).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveViewModel.getRejectParent.1
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
                ParentApproveViewModel.this.rejectResponse.postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ParentApproveViewModel.getRejectParent$lambda$2(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveViewModel.getRejectParent.2
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
                ParentApproveViewModel.this.rejectResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ParentApproveViewModel.getRejectParent$lambda$3(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRejectParent$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRejectParent$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SuccessResponse>> getRejectResponse() {
        return this.rejectResponse;
    }
}