package in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.hostel.attendance.HostelScanViewResponse;
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

/* compiled from: SecurityQrViewModel.kt */
/* loaded from: classes5.dex */
public final class SecurityQrViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<HostelScanViewResponse>> hostelQrResponse;
    private final HostelRepository hostelRepository;

    public SecurityQrViewModel(HostelRepository hostelRepository) {
        Intrinsics.checkNotNullParameter(hostelRepository, "hostelRepository");
        this.hostelRepository = hostelRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.hostelQrResponse = new MutableLiveData<>();
    }

    public final void getHostelGatePassView(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.hostelQrResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelScanViewResponse> observeOn = this.hostelRepository.getHostelGatePassApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelScanViewResponse, Unit> function1 = new Function1<HostelScanViewResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrViewModel$getHostelGatePassView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelScanViewResponse hostelScanViewResponse) {
                invoke2(hostelScanViewResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelScanViewResponse hostelScanViewResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = SecurityQrViewModel.this.hostelQrResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelScanViewResponse));
            }
        };
        Consumer<? super HostelScanViewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SecurityQrViewModel.getHostelGatePassView$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrViewModel$getHostelGatePassView$2
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
                mutableLiveData = SecurityQrViewModel.this.hostelQrResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.attendance.viewleave.qrdialog.SecurityQrViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SecurityQrViewModel.getHostelGatePassView$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelGatePassView$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelGatePassView$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelScanViewResponse>> getResponse() {
        return this.hostelQrResponse;
    }
}