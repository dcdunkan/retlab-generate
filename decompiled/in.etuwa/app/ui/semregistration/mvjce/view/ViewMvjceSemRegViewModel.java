package in.etuwa.app.ui.semregistration.mvjce.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.semregistration.SemRegViewResponse;
import in.etuwa.app.data.model.semregistration.view.SemRegSlip;
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

/* compiled from: ViewMvjceSemRegViewModel.kt */
/* loaded from: classes5.dex */
public final class ViewMvjceSemRegViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<SemRegViewResponse>> regResponse;
    private final SemRegRepository semRegRepository;
    private MutableLiveData<Resource<SemRegSlip>> slipResponse;

    public ViewMvjceSemRegViewModel(SemRegRepository semRegRepository) {
        Intrinsics.checkNotNullParameter(semRegRepository, "semRegRepository");
        this.semRegRepository = semRegRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.regResponse = new MutableLiveData<>();
        this.slipResponse = new MutableLiveData<>();
    }

    public final void getData(String id) {
        this.regResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SemRegViewResponse> observeOn = this.semRegRepository.getSemRegDetailsApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegViewResponse, Unit> function1 = new Function1<SemRegViewResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel$getData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemRegViewResponse semRegViewResponse) {
                invoke2(semRegViewResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemRegViewResponse semRegViewResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ViewMvjceSemRegViewModel.this.regResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(semRegViewResponse));
            }
        };
        Consumer<? super SemRegViewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewMvjceSemRegViewModel.getData$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel$getData$2
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
                mutableLiveData = ViewMvjceSemRegViewModel.this.regResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewMvjceSemRegViewModel.getData$lambda$1(Function1.this, obj);
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

    public final MutableLiveData<Resource<SemRegViewResponse>> getResponse() {
        return this.regResponse;
    }

    public final void getData2(String id) {
        this.regResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SemRegViewResponse> observeOn = this.semRegRepository.getSemRegDetailsMvjceApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegViewResponse, Unit> function1 = new Function1<SemRegViewResponse, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel$getData2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemRegViewResponse semRegViewResponse) {
                invoke2(semRegViewResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemRegViewResponse semRegViewResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ViewMvjceSemRegViewModel.this.regResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(semRegViewResponse));
            }
        };
        Consumer<? super SemRegViewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewMvjceSemRegViewModel.getData2$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel$getData2$2
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
                mutableLiveData = ViewMvjceSemRegViewModel.this.regResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewMvjceSemRegViewModel.getData2$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getData2$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getData2$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void getRegistrationSlip(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.slipResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SemRegSlip> observeOn = this.semRegRepository.getRegistrationSlipUrl(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SemRegSlip, Unit> function1 = new Function1<SemRegSlip, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel$getRegistrationSlip$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemRegSlip semRegSlip) {
                invoke2(semRegSlip);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemRegSlip semRegSlip) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ViewMvjceSemRegViewModel.this.slipResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(semRegSlip));
            }
        };
        Consumer<? super SemRegSlip> consumer = new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewMvjceSemRegViewModel.getRegistrationSlip$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel$getRegistrationSlip$2
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
                mutableLiveData = ViewMvjceSemRegViewModel.this.slipResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.semregistration.mvjce.view.ViewMvjceSemRegViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewMvjceSemRegViewModel.getRegistrationSlip$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRegistrationSlip$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRegistrationSlip$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SemRegSlip>> getSlipResponse() {
        return this.slipResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}