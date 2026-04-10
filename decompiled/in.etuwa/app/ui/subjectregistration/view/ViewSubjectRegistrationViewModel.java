package in.etuwa.app.ui.subjectregistration.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.subjectregistration.ViewSubjectRegistrationResponse;
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

/* compiled from: ViewSubjectRegistrationViewModel.kt */
/* loaded from: classes5.dex */
public final class ViewSubjectRegistrationViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<ViewSubjectRegistrationResponse>> regResponse;
    private final SemRegRepository semRegRepository;

    public ViewSubjectRegistrationViewModel(SemRegRepository semRegRepository) {
        Intrinsics.checkNotNullParameter(semRegRepository, "semRegRepository");
        this.semRegRepository = semRegRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.regResponse = new MutableLiveData<>();
    }

    public final void getData(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.regResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ViewSubjectRegistrationResponse> observeOn = this.semRegRepository.getSubjectRegistrationViewApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ViewSubjectRegistrationResponse, Unit> function1 = new Function1<ViewSubjectRegistrationResponse, Unit>() { // from class: in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationViewModel$getData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewSubjectRegistrationResponse viewSubjectRegistrationResponse) {
                invoke2(viewSubjectRegistrationResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewSubjectRegistrationResponse viewSubjectRegistrationResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ViewSubjectRegistrationViewModel.this.regResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(viewSubjectRegistrationResponse));
            }
        };
        Consumer<? super ViewSubjectRegistrationResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewSubjectRegistrationViewModel.getData$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationViewModel$getData$2
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
                mutableLiveData = ViewSubjectRegistrationViewModel.this.regResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.subjectregistration.view.ViewSubjectRegistrationViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewSubjectRegistrationViewModel.getData$lambda$1(Function1.this, obj);
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

    public final MutableLiveData<Resource<ViewSubjectRegistrationResponse>> getResponse() {
        return this.regResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}