package in.etuwa.app.ui.due;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.due.duepay.NoDueCertificateResponse;
import in.etuwa.app.data.repository.CommonRepository;
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

/* compiled from: DueMainViewModel.kt */
/* loaded from: classes4.dex */
public final class DueMainViewModel extends ViewModel {
    private final CommonRepository commonRepository;
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<NoDueCertificateResponse>> dueResponse;

    public DueMainViewModel(CommonRepository commonRepository) {
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        this.commonRepository = commonRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.dueResponse = new MutableLiveData<>();
        getDuesCertificate();
    }

    public final void getDuesCertificate() {
        this.dueResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<NoDueCertificateResponse> observeOn = this.commonRepository.getNoDueCertificate().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<NoDueCertificateResponse, Unit> function1 = new Function1<NoDueCertificateResponse, Unit>() { // from class: in.etuwa.app.ui.due.DueMainViewModel$getDuesCertificate$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NoDueCertificateResponse noDueCertificateResponse) {
                invoke2(noDueCertificateResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NoDueCertificateResponse noDueCertificateResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DueMainViewModel.this.dueResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(noDueCertificateResponse));
            }
        };
        Consumer<? super NoDueCertificateResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.due.DueMainViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DueMainViewModel.getDuesCertificate$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.due.DueMainViewModel$getDuesCertificate$2
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
                mutableLiveData = DueMainViewModel.this.dueResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.due.DueMainViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DueMainViewModel.getDuesCertificate$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDuesCertificate$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDuesCertificate$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<NoDueCertificateResponse>> getResponse() {
        return this.dueResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}