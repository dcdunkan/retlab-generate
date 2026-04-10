package in.etuwa.app.ui.covidcertificate;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.repository.CovidCertificateRepository;
import in.etuwa.app.helper.ProgressRequestBody;
import in.etuwa.app.utils.Resource;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

/* JADX INFO: compiled from: CovidCertificateDialogViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CovidCertificateDialogViewModel extends ViewModel implements KoinComponent {
    private final CompositeDisposable compositeDisposable;
    private final CovidCertificateRepository covidCertificateRepository;
    private MutableLiveData<Resource<Float>> progressResponse;
    private MutableLiveData<Resource<SuccessResponse>> uploadResponse;

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public CovidCertificateDialogViewModel(CovidCertificateRepository covidCertificateRepository) {
        Intrinsics.checkNotNullParameter(covidCertificateRepository, "covidCertificateRepository");
        this.covidCertificateRepository = covidCertificateRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.uploadResponse = new MutableLiveData<>();
        this.progressResponse = new MutableLiveData<>();
    }

    public final MutableLiveData<Resource<SuccessResponse>> getUploadResponse() {
        return this.uploadResponse;
    }

    public final void setUploadResponse(MutableLiveData<Resource<SuccessResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.uploadResponse = mutableLiveData;
    }

    public final MutableLiveData<Resource<Float>> getProgressResponse() {
        return this.progressResponse;
    }

    public final void setProgressResponse(MutableLiveData<Resource<Float>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.progressResponse = mutableLiveData;
    }

    public final void uploadCovidCertificate(File filePath) {
        try {
            Intrinsics.checkNotNull(filePath);
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(filePath, FilesKt.getExtension(filePath), 1);
            MultipartBody.Part partCreateFormData = MultipartBody.Part.INSTANCE.createFormData("vaccineFile", filePath.getName(), progressRequestBody);
            Observable<Float> observableSubscribeOn = progressRequestBody.getProgressSubject().subscribeOn(Schedulers.io());
            final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateDialogViewModel.uploadCovidCertificate.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                    invoke2(f);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Float f) {
                    CovidCertificateDialogViewModel.this.getProgressResponse().postValue(Resource.INSTANCE.success(f));
                }
            };
            observableSubscribeOn.subscribe(new Consumer() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateDialogViewModel$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    CovidCertificateDialogViewModel.uploadCovidCertificate$lambda$0(function1, obj);
                }
            });
            CompositeDisposable compositeDisposable = this.compositeDisposable;
            Observable<SuccessResponse> observableObserveOn = this.covidCertificateRepository.uploadCovidCertificateApiCall(partCreateFormData).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            final Function1<SuccessResponse, Unit> function12 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateDialogViewModel.uploadCovidCertificate.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SuccessResponse successResponse) {
                    invoke2(successResponse);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SuccessResponse successResponse) {
                    CovidCertificateDialogViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.success(successResponse));
                }
            };
            Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateDialogViewModel$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    CovidCertificateDialogViewModel.uploadCovidCertificate$lambda$1(function12, obj);
                }
            };
            final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateDialogViewModel.uploadCovidCertificate.3
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
                    if (th instanceof SocketTimeoutException) {
                        CovidCertificateDialogViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.exception("Time out. Please try again."));
                    } else {
                        CovidCertificateDialogViewModel.this.getUploadResponse().postValue(Resource.INSTANCE.exception(th.getMessage()));
                    }
                }
            };
            compositeDisposable.add(observableObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.covidcertificate.CovidCertificateDialogViewModel$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    CovidCertificateDialogViewModel.uploadCovidCertificate$lambda$2(function13, obj);
                }
            }));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadCovidCertificate$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadCovidCertificate$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadCovidCertificate$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}