package in.etuwa.app.ui.hostel.attendance.applyleave;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.hostel.attendance.LeaveTypeResponse;
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

/* compiled from: HostelApplyLeaveViewModel.kt */
/* loaded from: classes5.dex */
public final class HostelApplyLeaveViewModel extends ViewModel {
    private MutableLiveData<Resource<SuccessResponse>> applyResponse;
    private final CompositeDisposable compositeDisposable;
    private final HostelRepository hostelRepository;
    private MutableLiveData<Resource<LeaveTypeResponse>> leaveTypeResponse;

    public HostelApplyLeaveViewModel(HostelRepository hostelRepository) {
        Intrinsics.checkNotNullParameter(hostelRepository, "hostelRepository");
        this.hostelRepository = hostelRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.leaveTypeResponse = new MutableLiveData<>();
        this.applyResponse = new MutableLiveData<>();
    }

    public final void getHostelLeaveType() {
        this.leaveTypeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<LeaveTypeResponse> observeOn = this.hostelRepository.getHostelLeaveTypeApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<LeaveTypeResponse, Unit> function1 = new Function1<LeaveTypeResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveViewModel$getHostelLeaveType$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LeaveTypeResponse leaveTypeResponse) {
                invoke2(leaveTypeResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LeaveTypeResponse leaveTypeResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HostelApplyLeaveViewModel.this.leaveTypeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(leaveTypeResponse));
            }
        };
        Consumer<? super LeaveTypeResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelApplyLeaveViewModel.getHostelLeaveType$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveViewModel$getHostelLeaveType$2
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
                mutableLiveData = HostelApplyLeaveViewModel.this.leaveTypeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelApplyLeaveViewModel.getHostelLeaveType$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelLeaveType$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelLeaveType$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<LeaveTypeResponse>> getTypeResponse() {
        return this.leaveTypeResponse;
    }

    public final void appluyHostelLeave(String leaveType, String fromDate, String toDate, String reason) {
        Intrinsics.checkNotNullParameter(leaveType, "leaveType");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.applyResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.hostelRepository.getHostelApplyLeaveApiCall(leaveType, fromDate, toDate, reason).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveViewModel$appluyHostelLeave$1
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
                mutableLiveData = HostelApplyLeaveViewModel.this.applyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelApplyLeaveViewModel.appluyHostelLeave$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveViewModel$appluyHostelLeave$2
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
                mutableLiveData = HostelApplyLeaveViewModel.this.applyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.applyleave.HostelApplyLeaveViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelApplyLeaveViewModel.appluyHostelLeave$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void appluyHostelLeave$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void appluyHostelLeave$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SuccessResponse>> getApplyResponse() {
        return this.applyResponse;
    }
}