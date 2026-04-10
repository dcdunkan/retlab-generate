package in.etuwa.app.ui.attendance.bydaynew.attendaceday;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.attendance.AttendanceDayRequest;
import in.etuwa.app.data.model.attendance.AttendanceDayResponse;
import in.etuwa.app.data.repository.AttendanceRepository;
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

/* JADX INFO: compiled from: AttendanceDayDialogViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AttendanceDayDialogViewModel extends ViewModel {
    private final AttendanceRepository attendanceRepository;
    private MutableLiveData<Resource<AttendanceDayResponse>> attendanceResponse;
    private final CompositeDisposable compositeDisposable;

    public AttendanceDayDialogViewModel(AttendanceRepository attendanceRepository) {
        Intrinsics.checkNotNullParameter(attendanceRepository, "attendanceRepository");
        this.attendanceRepository = attendanceRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.attendanceResponse = new MutableLiveData<>();
    }

    public final void getAttendanceByDay(String sem, String date) {
        Intrinsics.checkNotNullParameter(sem, "sem");
        Intrinsics.checkNotNullParameter(date, "date");
        this.attendanceResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<AttendanceDayResponse> singleObserveOn = this.attendanceRepository.getAttendanceByDayApiCall(new AttendanceDayRequest(sem, date)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<AttendanceDayResponse, Unit> function1 = new Function1<AttendanceDayResponse, Unit>() { // from class: in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogViewModel.getAttendanceByDay.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AttendanceDayResponse attendanceDayResponse) {
                invoke2(attendanceDayResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AttendanceDayResponse attendanceDayResponse) {
                AttendanceDayDialogViewModel.this.attendanceResponse.postValue(Resource.INSTANCE.success(attendanceDayResponse));
            }
        };
        Consumer<? super AttendanceDayResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AttendanceDayDialogViewModel.getAttendanceByDay$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogViewModel.getAttendanceByDay.2
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
                AttendanceDayDialogViewModel.this.attendanceResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AttendanceDayDialogViewModel.getAttendanceByDay$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAttendanceByDay$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAttendanceByDay$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<AttendanceDayResponse>> getResponse() {
        return this.attendanceResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}