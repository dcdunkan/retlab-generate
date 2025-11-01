package in.etuwa.app.ui.transport.registration.asiet.registration;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.hostel.asiet.HostelAsietRegisterViewResponse;
import in.etuwa.app.data.model.transportpalai.registration.RegisterSucessResponse;
import in.etuwa.app.data.repository.TransportRepository;
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

/* compiled from: AsietTransRegViewModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006J\b\u0010\u0016\u001a\u00020\u000eH\u0014R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lin/etuwa/app/ui/transport/registration/asiet/registration/AsietTransRegViewModel;", "Landroidx/lifecycle/ViewModel;", "transportRepository", "Lin/etuwa/app/data/repository/TransportRepository;", "(Lin/etuwa/app/data/repository/TransportRepository;)V", "addResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/transportpalai/registration/RegisterSucessResponse;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "historyResponse", "Lin/etuwa/app/data/model/hostel/asiet/HostelAsietRegisterViewResponse;", "addTransportReg", "", "id", "", "exactPoint", "date", "getAddResponse", "getRegHistory", "getResponse", "onCleared", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AsietTransRegViewModel extends ViewModel {
    private MutableLiveData<Resource<RegisterSucessResponse>> addResponse;
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<HostelAsietRegisterViewResponse>> historyResponse;
    private final TransportRepository transportRepository;

    public AsietTransRegViewModel(TransportRepository transportRepository) {
        Intrinsics.checkNotNullParameter(transportRepository, "transportRepository");
        this.transportRepository = transportRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.addResponse = new MutableLiveData<>();
        this.historyResponse = new MutableLiveData<>();
    }

    public final void addTransportReg(String id, String exactPoint, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(exactPoint, "exactPoint");
        Intrinsics.checkNotNullParameter(date, "date");
        this.addResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<RegisterSucessResponse> observeOn = this.transportRepository.addAsietTransRegApiCall(id, exactPoint, date).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<RegisterSucessResponse, Unit> function1 = new Function1<RegisterSucessResponse, Unit>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegViewModel$addTransportReg$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RegisterSucessResponse registerSucessResponse) {
                invoke2(registerSucessResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RegisterSucessResponse registerSucessResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = AsietTransRegViewModel.this.addResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(registerSucessResponse));
            }
        };
        Consumer<? super RegisterSucessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AsietTransRegViewModel.addTransportReg$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegViewModel$addTransportReg$2
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
                mutableLiveData = AsietTransRegViewModel.this.addResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AsietTransRegViewModel.addTransportReg$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addTransportReg$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addTransportReg$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<RegisterSucessResponse>> getAddResponse() {
        return this.addResponse;
    }

    public final void getRegHistory() {
        this.historyResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<HostelAsietRegisterViewResponse> observeOn = this.transportRepository.getAsietTransportRegistrationUrl().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<HostelAsietRegisterViewResponse, Unit> function1 = new Function1<HostelAsietRegisterViewResponse, Unit>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegViewModel$getRegHistory$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HostelAsietRegisterViewResponse hostelAsietRegisterViewResponse) {
                invoke2(hostelAsietRegisterViewResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HostelAsietRegisterViewResponse hostelAsietRegisterViewResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = AsietTransRegViewModel.this.historyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(hostelAsietRegisterViewResponse));
            }
        };
        Consumer<? super HostelAsietRegisterViewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AsietTransRegViewModel.getRegHistory$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegViewModel$getRegHistory$2
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
                mutableLiveData = AsietTransRegViewModel.this.historyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.transport.registration.asiet.registration.AsietTransRegViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AsietTransRegViewModel.getRegHistory$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRegHistory$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRegHistory$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<HostelAsietRegisterViewResponse>> getResponse() {
        return this.historyResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}