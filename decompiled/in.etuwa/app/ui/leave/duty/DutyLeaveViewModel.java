package in.etuwa.app.ui.leave.duty;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.leave.duty.DutyLeave;
import in.etuwa.app.data.model.leave.duty.DutyLeaveViewRequest;
import in.etuwa.app.data.repository.LeaveRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DutyLeaveViewModel.kt */
/* loaded from: classes5.dex */
public final class DutyLeaveViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final LeaveRepository leaveRepository;
    private MutableLiveData<Resource<ArrayList<DutyLeave>>> leaveResponse;

    public DutyLeaveViewModel(LeaveRepository leaveRepository) {
        Intrinsics.checkNotNullParameter(leaveRepository, "leaveRepository");
        this.leaveRepository = leaveRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.leaveResponse = new MutableLiveData<>();
    }

    public final void getLeave(String filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.leaveResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<DutyLeave>> observeOn = this.leaveRepository.getDutyLeaveApiCall(new DutyLeaveViewRequest(filter)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<DutyLeave>, Unit> function1 = new Function1<ArrayList<DutyLeave>, Unit>() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveViewModel$getLeave$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<DutyLeave> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<DutyLeave> arrayList) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DutyLeaveViewModel.this.leaveResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<DutyLeave>> consumer = new Consumer() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DutyLeaveViewModel.getLeave$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveViewModel$getLeave$2
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
                mutableLiveData = DutyLeaveViewModel.this.leaveResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.leave.duty.DutyLeaveViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DutyLeaveViewModel.getLeave$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLeave$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLeave$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ArrayList<DutyLeave>>> getResponse() {
        return this.leaveResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}