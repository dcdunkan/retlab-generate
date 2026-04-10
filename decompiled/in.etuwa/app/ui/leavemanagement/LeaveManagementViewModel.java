package in.etuwa.app.ui.leavemanagement;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.leavemanagement.LeaveManagementResponse;
import in.etuwa.app.data.repository.LeavemanagementRepository;
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

/* compiled from: LeaveManagementViewModel.kt */
/* loaded from: classes5.dex */
public final class LeaveManagementViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<LeaveManagementResponse>> leaveResponse;
    private final LeavemanagementRepository leavemanagementRepository;

    public LeaveManagementViewModel(LeavemanagementRepository leavemanagementRepository) {
        Intrinsics.checkNotNullParameter(leavemanagementRepository, "leavemanagementRepository");
        this.leavemanagementRepository = leavemanagementRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.leaveResponse = new MutableLiveData<>();
    }

    public final void getLeave() {
        this.leaveResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<LeaveManagementResponse> observeOn = this.leavemanagementRepository.getLeaveManagementApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<LeaveManagementResponse, Unit> function1 = new Function1<LeaveManagementResponse, Unit>() { // from class: in.etuwa.app.ui.leavemanagement.LeaveManagementViewModel$getLeave$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LeaveManagementResponse leaveManagementResponse) {
                invoke2(leaveManagementResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LeaveManagementResponse leaveManagementResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = LeaveManagementViewModel.this.leaveResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(leaveManagementResponse));
            }
        };
        Consumer<? super LeaveManagementResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.leavemanagement.LeaveManagementViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LeaveManagementViewModel.getLeave$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.leavemanagement.LeaveManagementViewModel$getLeave$2
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
                mutableLiveData = LeaveManagementViewModel.this.leaveResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.leavemanagement.LeaveManagementViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LeaveManagementViewModel.getLeave$lambda$1(Function1.this, obj);
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

    public final MutableLiveData<Resource<LeaveManagementResponse>> getResponse() {
        return this.leaveResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}