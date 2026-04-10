package in.etuwa.app.ui.certificate_request;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.certificaterequest.CertificateRequestResponse;
import in.etuwa.app.data.repository.CertificateRequestRepository;
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

/* compiled from: CertificateRequestViewModel.kt */
/* loaded from: classes4.dex */
public final class CertificateRequestViewModel extends ViewModel {
    private final CertificateRequestRepository certificateRequestRepository;
    private MutableLiveData<Resource<CertificateRequestResponse>> certificateRequestResponse;
    private final CompositeDisposable compositeDisposable;

    public CertificateRequestViewModel(CertificateRequestRepository certificateRequestRepository) {
        Intrinsics.checkNotNullParameter(certificateRequestRepository, "certificateRequestRepository");
        this.certificateRequestRepository = certificateRequestRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.certificateRequestResponse = new MutableLiveData<>();
        getCertificateRequest();
    }

    public final void getCertificateRequest() {
        this.certificateRequestResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<CertificateRequestResponse> observeOn = this.certificateRequestRepository.getCertificateRequestApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<CertificateRequestResponse, Unit> function1 = new Function1<CertificateRequestResponse, Unit>() { // from class: in.etuwa.app.ui.certificate_request.CertificateRequestViewModel$getCertificateRequest$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CertificateRequestResponse certificateRequestResponse) {
                invoke2(certificateRequestResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CertificateRequestResponse certificateRequestResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = CertificateRequestViewModel.this.certificateRequestResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(certificateRequestResponse));
            }
        };
        Consumer<? super CertificateRequestResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.certificate_request.CertificateRequestViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CertificateRequestViewModel.getCertificateRequest$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.certificate_request.CertificateRequestViewModel$getCertificateRequest$2
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
                mutableLiveData = CertificateRequestViewModel.this.certificateRequestResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.certificate_request.CertificateRequestViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CertificateRequestViewModel.getCertificateRequest$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCertificateRequest$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCertificateRequest$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<CertificateRequestResponse>> getResponse() {
        return this.certificateRequestResponse;
    }
}