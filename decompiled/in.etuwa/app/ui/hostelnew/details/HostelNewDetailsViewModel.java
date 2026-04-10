package in.etuwa.app.ui.hostelnew.details;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.hostelnew.HostelNewAdmissionResponse;
import in.etuwa.app.data.model.hostelnew.HostelNewMonthlyResponse;
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

/* JADX INFO: compiled from: HostelNewDetailsViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class HostelNewDetailsViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<HostelNewAdmissionResponse>> hostelAdmissionResponse;
    private MutableLiveData<Resource<HostelNewMonthlyResponse>> hostelMonthlyResponse;
    private final HostelRepository hostelRepository;

    public HostelNewDetailsViewModel(HostelRepository hostelRepository) {
        Intrinsics.checkNotNullParameter(hostelRepository, "hostelRepository");
        this.hostelRepository = hostelRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.hostelAdmissionResponse = new MutableLiveData<>();
        this.hostelMonthlyResponse = new MutableLiveData<>();
    }

    public final void getHostelAdmissionFee() {
        this.hostelAdmissionResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelNewAdmissionResponse> singleObserveOn = this.hostelRepository.getHostelNewAdmissionApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelNewAdmissionResponse, Unit> function1 = new Function1<HostelNewAdmissionResponse, Unit>() { // from class: in.etuwa.app.ui.hostelnew.details.HostelNewDetailsViewModel.getHostelAdmissionFee.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelNewAdmissionResponse hostelNewAdmissionResponse) {
                invoke2(hostelNewAdmissionResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelNewAdmissionResponse hostelNewAdmissionResponse) {
                HostelNewDetailsViewModel.this.hostelAdmissionResponse.postValue(Resource.INSTANCE.success(hostelNewAdmissionResponse));
            }
        };
        Consumer<? super HostelNewAdmissionResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostelnew.details.HostelNewDetailsViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelNewDetailsViewModel.getHostelAdmissionFee$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostelnew.details.HostelNewDetailsViewModel.getHostelAdmissionFee.2
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
                HostelNewDetailsViewModel.this.hostelAdmissionResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostelnew.details.HostelNewDetailsViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelNewDetailsViewModel.getHostelAdmissionFee$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelAdmissionFee$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelAdmissionFee$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelNewAdmissionResponse>> getAdmissionResponse() {
        return this.hostelAdmissionResponse;
    }

    public final void getHostelMonthlyFee() {
        this.hostelMonthlyResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelNewMonthlyResponse> singleObserveOn = this.hostelRepository.getHostelNewMonthlyApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelNewMonthlyResponse, Unit> function1 = new Function1<HostelNewMonthlyResponse, Unit>() { // from class: in.etuwa.app.ui.hostelnew.details.HostelNewDetailsViewModel.getHostelMonthlyFee.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelNewMonthlyResponse hostelNewMonthlyResponse) {
                invoke2(hostelNewMonthlyResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelNewMonthlyResponse hostelNewMonthlyResponse) {
                HostelNewDetailsViewModel.this.hostelMonthlyResponse.postValue(Resource.INSTANCE.success(hostelNewMonthlyResponse));
            }
        };
        Consumer<? super HostelNewMonthlyResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostelnew.details.HostelNewDetailsViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelNewDetailsViewModel.getHostelMonthlyFee$lambda$2(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostelnew.details.HostelNewDetailsViewModel.getHostelMonthlyFee.2
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
                HostelNewDetailsViewModel.this.hostelMonthlyResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostelnew.details.HostelNewDetailsViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HostelNewDetailsViewModel.getHostelMonthlyFee$lambda$3(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelMonthlyFee$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHostelMonthlyFee$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelNewMonthlyResponse>> getMonthlyResponse() {
        return this.hostelMonthlyResponse;
    }
}