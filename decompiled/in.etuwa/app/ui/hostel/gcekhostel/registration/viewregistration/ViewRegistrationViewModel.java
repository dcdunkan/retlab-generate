package in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.hostel.gcekhostel.registration.ViewRegistrationResponse;
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
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: ViewRegistrationViewModel.kt */
/* loaded from: classes5.dex */
public final class ViewRegistrationViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final HostelRepository hostelRepository;
    private MutableLiveData<Resource<ViewRegistrationResponse>> registrationResponse;

    public ViewRegistrationViewModel(HostelRepository hostelRepository) {
        Intrinsics.checkNotNullParameter(hostelRepository, "hostelRepository");
        this.hostelRepository = hostelRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.registrationResponse = new MutableLiveData<>();
    }

    public final void getViewRegistrationData(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        RequestBody create = RequestBody.INSTANCE.create(MultipartBody.FORM, id);
        this.registrationResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ViewRegistrationResponse> observeOn = this.hostelRepository.viewRegistrationApiCall(create).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ViewRegistrationResponse, Unit> function1 = new Function1<ViewRegistrationResponse, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationViewModel$getViewRegistrationData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewRegistrationResponse viewRegistrationResponse) {
                invoke2(viewRegistrationResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewRegistrationResponse viewRegistrationResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ViewRegistrationViewModel.this.registrationResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(viewRegistrationResponse));
            }
        };
        Consumer<? super ViewRegistrationResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewRegistrationViewModel.getViewRegistrationData$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationViewModel$getViewRegistrationData$2
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
                mutableLiveData = ViewRegistrationViewModel.this.registrationResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.viewregistration.ViewRegistrationViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewRegistrationViewModel.getViewRegistrationData$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getViewRegistrationData$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getViewRegistrationData$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ViewRegistrationResponse>> getResponse() {
        return this.registrationResponse;
    }
}