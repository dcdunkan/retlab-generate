package in.etuwa.app.ui.hostel.mess.booknow;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.mess.MessMenuResponse;
import in.etuwa.app.data.model.mess.MessTypeResponse;
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

/* compiled from: MessBookingViewModel.kt */
/* loaded from: classes5.dex */
public final class MessBookingViewModel extends ViewModel {
    private MutableLiveData<Resource<SuccessResponse>> bookingResponse;
    private final CompositeDisposable compositeDisposable;
    private final HostelRepository hostelRepository;
    private MutableLiveData<Resource<MessMenuResponse>> messMenuResponse;
    private MutableLiveData<Resource<MessTypeResponse>> messTypeResponse;

    public MessBookingViewModel(HostelRepository hostelRepository) {
        Intrinsics.checkNotNullParameter(hostelRepository, "hostelRepository");
        this.hostelRepository = hostelRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.bookingResponse = new MutableLiveData<>();
        this.messMenuResponse = new MutableLiveData<>();
        this.messTypeResponse = new MutableLiveData<>();
    }

    public final void getMessBookingResponse(String type, String menuId, String qty) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(menuId, "menuId");
        Intrinsics.checkNotNullParameter(qty, "qty");
        this.bookingResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.hostelRepository.messBookingApiCall(type, menuId, qty).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel$getMessBookingResponse$1
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
                mutableLiveData = MessBookingViewModel.this.bookingResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MessBookingViewModel.getMessBookingResponse$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel$getMessBookingResponse$2
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
                mutableLiveData = MessBookingViewModel.this.bookingResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MessBookingViewModel.getMessBookingResponse$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMessBookingResponse$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMessBookingResponse$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SuccessResponse>> getResponse() {
        return this.bookingResponse;
    }

    public final void getMessMenuType(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.messMenuResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<MessMenuResponse> observeOn = this.hostelRepository.getMessTypeApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<MessMenuResponse, Unit> function1 = new Function1<MessMenuResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel$getMessMenuType$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessMenuResponse messMenuResponse) {
                invoke2(messMenuResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MessMenuResponse messMenuResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = MessBookingViewModel.this.messMenuResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(messMenuResponse));
            }
        };
        Consumer<? super MessMenuResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MessBookingViewModel.getMessMenuType$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel$getMessMenuType$2
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
                mutableLiveData = MessBookingViewModel.this.messMenuResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MessBookingViewModel.getMessMenuType$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMessMenuType$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMessMenuType$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<MessMenuResponse>> getMessMenuResponse() {
        return this.messMenuResponse;
    }

    public final void getMessType() {
        this.messTypeResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<MessTypeResponse> observeOn = this.hostelRepository.getMessTypeApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<MessTypeResponse, Unit> function1 = new Function1<MessTypeResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel$getMessType$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessTypeResponse messTypeResponse) {
                invoke2(messTypeResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MessTypeResponse messTypeResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = MessBookingViewModel.this.messTypeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(messTypeResponse));
            }
        };
        Consumer<? super MessTypeResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MessBookingViewModel.getMessType$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel$getMessType$2
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
                mutableLiveData = MessBookingViewModel.this.messTypeResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MessBookingViewModel.getMessType$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMessType$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMessType$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<MessTypeResponse>> getMessTypeResponse() {
        return this.messTypeResponse;
    }
}