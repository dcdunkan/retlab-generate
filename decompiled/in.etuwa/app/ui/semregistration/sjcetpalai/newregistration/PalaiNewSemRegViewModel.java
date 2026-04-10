package in.etuwa.app.ui.semregistration.sjcetpalai.newregistration;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.counselling.status.CounsellingStatusResponse;
import in.etuwa.app.data.model.semregistration.list.SemRegisterListResponse;
import in.etuwa.app.data.repository.SemRegRepository;
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

/* compiled from: PalaiNewSemRegViewModel.kt */
/* loaded from: classes5.dex */
public final class PalaiNewSemRegViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<CounsellingStatusResponse>> counsellingStatusResponse;
    private MutableLiveData<Resource<SemRegisterListResponse>> regResponse;
    private final SemRegRepository semRegRepository;

    public PalaiNewSemRegViewModel(SemRegRepository semRegRepository) {
        Intrinsics.checkNotNullParameter(semRegRepository, "semRegRepository");
        this.semRegRepository = semRegRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.regResponse = new MutableLiveData<>();
        this.counsellingStatusResponse = new MutableLiveData<>();
        getData();
    }

    public final void getData() {
        this.regResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SemRegisterListResponse> observeOn = this.semRegRepository.getSemRegListApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegisterListResponse, Unit> function1 = new Function1<SemRegisterListResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegViewModel$getData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemRegisterListResponse semRegisterListResponse) {
                invoke2(semRegisterListResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemRegisterListResponse semRegisterListResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = PalaiNewSemRegViewModel.this.regResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(semRegisterListResponse));
            }
        };
        Consumer<? super SemRegisterListResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PalaiNewSemRegViewModel.getData$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegViewModel$getData$2
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
                mutableLiveData = PalaiNewSemRegViewModel.this.regResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PalaiNewSemRegViewModel.getData$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getData$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getData$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void getSemRegStatus() {
        this.counsellingStatusResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<CounsellingStatusResponse> observeOn = this.semRegRepository.getCounsellingStatusApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<CounsellingStatusResponse, Unit> function1 = new Function1<CounsellingStatusResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegViewModel$getSemRegStatus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CounsellingStatusResponse counsellingStatusResponse) {
                invoke2(counsellingStatusResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CounsellingStatusResponse counsellingStatusResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = PalaiNewSemRegViewModel.this.counsellingStatusResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(counsellingStatusResponse));
            }
        };
        Consumer<? super CounsellingStatusResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PalaiNewSemRegViewModel.getSemRegStatus$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegViewModel$getSemRegStatus$2
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
                mutableLiveData = PalaiNewSemRegViewModel.this.counsellingStatusResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.sjcetpalai.newregistration.PalaiNewSemRegViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PalaiNewSemRegViewModel.getSemRegStatus$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemRegStatus$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSemRegStatus$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<CounsellingStatusResponse>> getStatusResponse() {
        return this.counsellingStatusResponse;
    }

    public final MutableLiveData<Resource<SemRegisterListResponse>> getResponse() {
        return this.regResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}