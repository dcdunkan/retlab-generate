package in.etuwa.app.ui.leave.duty.directapply.updatehours;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.leave.duty.DutyLeaveDateResponse;
import in.etuwa.app.data.repository.LeaveRepository;
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

/* compiled from: UpdateHoursDirectViewModel.kt */
/* loaded from: classes5.dex */
public final class UpdateHoursDirectViewModel extends ViewModel {
    private MutableLiveData<Resource<SuccessResponse>> addHourResponse;
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<DutyLeaveDateResponse>> datesResponse;
    private MutableLiveData<Resource<DutyLeaveDateResponse>> hoursResponse;
    private final LeaveRepository leaveRepository;
    private MutableLiveData<Resource<SuccessResponse>> removeDateHourResponse;
    private MutableLiveData<Resource<SuccessResponse>> removeHourResponse;

    public UpdateHoursDirectViewModel(LeaveRepository leaveRepository) {
        Intrinsics.checkNotNullParameter(leaveRepository, "leaveRepository");
        this.leaveRepository = leaveRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.datesResponse = new MutableLiveData<>();
        this.hoursResponse = new MutableLiveData<>();
        this.addHourResponse = new MutableLiveData<>();
        this.removeHourResponse = new MutableLiveData<>();
        this.removeDateHourResponse = new MutableLiveData<>();
    }

    public final void getDates(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.datesResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<DutyLeaveDateResponse> observeOn = this.leaveRepository.getDutyLeaveDirectDatesApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DutyLeaveDateResponse, Unit> function1 = new Function1<DutyLeaveDateResponse, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$getDates$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DutyLeaveDateResponse dutyLeaveDateResponse) {
                invoke2(dutyLeaveDateResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DutyLeaveDateResponse dutyLeaveDateResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = UpdateHoursDirectViewModel.this.datesResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(dutyLeaveDateResponse));
            }
        };
        Consumer<? super DutyLeaveDateResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateHoursDirectViewModel.getDates$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$getDates$2
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
                mutableLiveData = UpdateHoursDirectViewModel.this.datesResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateHoursDirectViewModel.getDates$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDates$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDates$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<DutyLeaveDateResponse>> getResponse() {
        return this.datesResponse;
    }

    public final void getHours(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.hoursResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<DutyLeaveDateResponse> observeOn = this.leaveRepository.getDutyLeaveDirectDatesApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DutyLeaveDateResponse, Unit> function1 = new Function1<DutyLeaveDateResponse, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$getHours$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DutyLeaveDateResponse dutyLeaveDateResponse) {
                invoke2(dutyLeaveDateResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DutyLeaveDateResponse dutyLeaveDateResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = UpdateHoursDirectViewModel.this.hoursResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(dutyLeaveDateResponse));
            }
        };
        Consumer<? super DutyLeaveDateResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateHoursDirectViewModel.getHours$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$getHours$2
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
                mutableLiveData = UpdateHoursDirectViewModel.this.hoursResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateHoursDirectViewModel.getHours$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHours$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHours$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<DutyLeaveDateResponse>> getHourResponse() {
        return this.hoursResponse;
    }

    public final void addHour(String id, String date, String hour) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(hour, "hour");
        this.addHourResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.leaveRepository.addDutyLeaveDirectDatesApiCall(id, date, hour).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$addHour$1
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
                mutableLiveData = UpdateHoursDirectViewModel.this.addHourResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateHoursDirectViewModel.addHour$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$addHour$2
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
                mutableLiveData = UpdateHoursDirectViewModel.this.addHourResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateHoursDirectViewModel.addHour$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addHour$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addHour$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SuccessResponse>> getAddResponse() {
        return this.addHourResponse;
    }

    public final void removeHour(String id, String date, String hour) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(hour, "hour");
        this.removeHourResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.leaveRepository.removeDutyLeaveDirectDatesApiCall(id, date, hour).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$removeHour$1
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
                mutableLiveData = UpdateHoursDirectViewModel.this.removeHourResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateHoursDirectViewModel.removeHour$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$removeHour$2
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
                mutableLiveData = UpdateHoursDirectViewModel.this.removeHourResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateHoursDirectViewModel.removeHour$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeHour$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeHour$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SuccessResponse>> getRemoveResponse() {
        return this.removeHourResponse;
    }

    public final void removeDateHour(String id, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        this.removeDateHourResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.leaveRepository.removeDateHourDutyLeaveDirectDatesApiCall(id, date).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$removeDateHour$1
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
                mutableLiveData = UpdateHoursDirectViewModel.this.removeDateHourResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateHoursDirectViewModel.removeDateHour$lambda$8(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$removeDateHour$2
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
                mutableLiveData = UpdateHoursDirectViewModel.this.removeDateHourResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.leave.duty.directapply.updatehours.UpdateHoursDirectViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateHoursDirectViewModel.removeDateHour$lambda$9(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeDateHour$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeDateHour$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SuccessResponse>> getRemoveDateResponse() {
        return this.removeDateHourResponse;
    }
}