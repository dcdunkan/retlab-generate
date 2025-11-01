package in.etuwa.app.ui.main;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.login.LogoutRequest;
import in.etuwa.app.data.model.main.ApplyHostelResponse;
import in.etuwa.app.data.model.main.FeeStatusResponse;
import in.etuwa.app.data.model.main.PushRequest;
import in.etuwa.app.data.model.main.PushResponse;
import in.etuwa.app.data.model.transportpalai.BusPass;
import in.etuwa.app.data.repository.MainRepository;
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

/* compiled from: MainViewModel.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00070\u0006J\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u0018H\u0014J\u0016\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001fJ\u000e\u0010%\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lin/etuwa/app/ui/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "mainRepository", "Lin/etuwa/app/data/repository/MainRepository;", "(Lin/etuwa/app/data/repository/MainRepository;)V", "busPassResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/transportpalai/BusPass;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "feeResponse", "Lin/etuwa/app/data/model/main/FeeStatusResponse;", "getFeeResponse", "()Landroidx/lifecycle/MutableLiveData;", "hostelResponse", "Lin/etuwa/app/data/model/main/ApplyHostelResponse;", "getHostelResponse", "logoutResponse", "Lin/etuwa/app/data/model/SuccessResponse;", "getLogoutResponse", "pushResponse", "Lin/etuwa/app/data/model/main/PushResponse;", "applyHostel", "", "getBusPassResponse", "getBusResponse", "getFeeStatus", "getPushTokenResponse", "logout", "token", "", "onCleared", "saveHostelStatus", "hostel", "", "hostelStatus", "sendPushToken", "storePushResponse", NotificationCompat.CATEGORY_STATUS, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainViewModel extends ViewModel {
    private final MutableLiveData<Resource<BusPass>> busPassResponse;
    private final CompositeDisposable compositeDisposable;
    private final MutableLiveData<Resource<FeeStatusResponse>> feeResponse;
    private final MutableLiveData<Resource<ApplyHostelResponse>> hostelResponse;
    private final MutableLiveData<Resource<SuccessResponse>> logoutResponse;
    private final MainRepository mainRepository;
    private final MutableLiveData<Resource<PushResponse>> pushResponse;

    public MainViewModel(MainRepository mainRepository) {
        Intrinsics.checkNotNullParameter(mainRepository, "mainRepository");
        this.mainRepository = mainRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.pushResponse = new MutableLiveData<>();
        this.hostelResponse = new MutableLiveData<>();
        this.feeResponse = new MutableLiveData<>();
        this.logoutResponse = new MutableLiveData<>();
        this.busPassResponse = new MutableLiveData<>();
    }

    public final MutableLiveData<Resource<ApplyHostelResponse>> getHostelResponse() {
        return this.hostelResponse;
    }

    public final MutableLiveData<Resource<FeeStatusResponse>> getFeeResponse() {
        return this.feeResponse;
    }

    public final MutableLiveData<Resource<SuccessResponse>> getLogoutResponse() {
        return this.logoutResponse;
    }

    public final void sendPushToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.pushResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<PushResponse> observeOn = this.mainRepository.sendPushToken(new PushRequest(token, null, 2, null)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<PushResponse, Unit> function1 = new Function1<PushResponse, Unit>() { // from class: in.etuwa.app.ui.main.MainViewModel$sendPushToken$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PushResponse pushResponse) {
                invoke2(pushResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PushResponse pushResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = MainViewModel.this.pushResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(pushResponse));
            }
        };
        Consumer<? super PushResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.main.MainViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MainViewModel.sendPushToken$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.main.MainViewModel$sendPushToken$2
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
                mutableLiveData = MainViewModel.this.pushResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.main.MainViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MainViewModel.sendPushToken$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendPushToken$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendPushToken$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<PushResponse>> getPushTokenResponse() {
        return this.pushResponse;
    }

    public final void getBusResponse() {
        this.busPassResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<BusPass> observeOn = this.mainRepository.getTransportBusPassApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<BusPass, Unit> function1 = new Function1<BusPass, Unit>() { // from class: in.etuwa.app.ui.main.MainViewModel$getBusResponse$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BusPass busPass) {
                invoke2(busPass);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BusPass busPass) {
                MutableLiveData mutableLiveData;
                mutableLiveData = MainViewModel.this.busPassResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(busPass));
            }
        };
        Consumer<? super BusPass> consumer = new Consumer() { // from class: in.etuwa.app.ui.main.MainViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MainViewModel.getBusResponse$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.main.MainViewModel$getBusResponse$2
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
                mutableLiveData = MainViewModel.this.busPassResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.main.MainViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MainViewModel.getBusResponse$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBusResponse$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBusResponse$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<BusPass>> getBusPassResponse() {
        return this.busPassResponse;
    }

    public final void storePushResponse(boolean status) {
        this.mainRepository.setPushTokenStatus(status);
    }

    public final void getFeeStatus() {
        this.feeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<FeeStatusResponse> observeOn = this.mainRepository.getFeeStatusApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<FeeStatusResponse, Unit> function1 = new Function1<FeeStatusResponse, Unit>() { // from class: in.etuwa.app.ui.main.MainViewModel$getFeeStatus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeeStatusResponse feeStatusResponse) {
                invoke2(feeStatusResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeeStatusResponse feeStatusResponse) {
                MainViewModel.this.getFeeResponse().postValue(Resource.INSTANCE.success(feeStatusResponse));
            }
        };
        Consumer<? super FeeStatusResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.main.MainViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MainViewModel.getFeeStatus$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.main.MainViewModel$getFeeStatus$2
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
                MainViewModel.this.getFeeResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.main.MainViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MainViewModel.getFeeStatus$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeeStatus$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFeeStatus$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void applyHostel() {
        this.hostelResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ApplyHostelResponse> observeOn = this.mainRepository.applyHostelApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ApplyHostelResponse, Unit> function1 = new Function1<ApplyHostelResponse, Unit>() { // from class: in.etuwa.app.ui.main.MainViewModel$applyHostel$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ApplyHostelResponse applyHostelResponse) {
                invoke2(applyHostelResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ApplyHostelResponse applyHostelResponse) {
                MainViewModel.this.getHostelResponse().postValue(Resource.INSTANCE.success(applyHostelResponse));
            }
        };
        Consumer<? super ApplyHostelResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.main.MainViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MainViewModel.applyHostel$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.main.MainViewModel$applyHostel$2
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
                MainViewModel.this.getHostelResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.main.MainViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MainViewModel.applyHostel$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyHostel$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyHostel$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void saveHostelStatus(int hostel, String hostelStatus) {
        Intrinsics.checkNotNullParameter(hostelStatus, "hostelStatus");
        this.mainRepository.setHostel(hostel, hostelStatus);
    }

    public final void logout(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.logoutResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.mainRepository.doLogoutApiCall(new LogoutRequest(token)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.main.MainViewModel$logout$1
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
                MainViewModel.this.getLogoutResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.main.MainViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MainViewModel.logout$lambda$8(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.main.MainViewModel$logout$2
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
                MainViewModel.this.getLogoutResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.main.MainViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MainViewModel.logout$lambda$9(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logout$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logout$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}