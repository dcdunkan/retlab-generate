package in.etuwa.app.ui.grievance.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.grievance.view.ViewGrievanceResponse;
import in.etuwa.app.data.repository.GrievanceRepository;
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

/* compiled from: ViewGrievanceViewModel.kt */
/* loaded from: classes4.dex */
public final class ViewGrievanceViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final GrievanceRepository grievanceRepository;
    private MutableLiveData<Resource<ViewGrievanceResponse>> grievanceResponse;

    public ViewGrievanceViewModel(GrievanceRepository grievanceRepository) {
        Intrinsics.checkNotNullParameter(grievanceRepository, "grievanceRepository");
        this.grievanceRepository = grievanceRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.grievanceResponse = new MutableLiveData<>();
    }

    public final void getGrievance(String id) {
        this.grievanceResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ViewGrievanceResponse> observeOn = this.grievanceRepository.viewGrievanceApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ViewGrievanceResponse, Unit> function1 = new Function1<ViewGrievanceResponse, Unit>() { // from class: in.etuwa.app.ui.grievance.view.ViewGrievanceViewModel$getGrievance$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewGrievanceResponse viewGrievanceResponse) {
                invoke2(viewGrievanceResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewGrievanceResponse viewGrievanceResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ViewGrievanceViewModel.this.grievanceResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(viewGrievanceResponse));
            }
        };
        Consumer<? super ViewGrievanceResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.grievance.view.ViewGrievanceViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewGrievanceViewModel.getGrievance$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.grievance.view.ViewGrievanceViewModel$getGrievance$2
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
                mutableLiveData = ViewGrievanceViewModel.this.grievanceResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.grievance.view.ViewGrievanceViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewGrievanceViewModel.getGrievance$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGrievance$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGrievance$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ViewGrievanceResponse>> getResponse() {
        return this.grievanceResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}