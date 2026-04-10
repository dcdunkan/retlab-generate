package in.etuwa.app.ui.counselling.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.counselling.view.ViewCounsellingResponse;
import in.etuwa.app.data.repository.CounsellingRepository;
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

/* JADX INFO: compiled from: ViewCounsellingViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ViewCounsellingViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final CounsellingRepository counsellingRepository;
    private MutableLiveData<Resource<ViewCounsellingResponse>> counsellingResponse;

    public ViewCounsellingViewModel(CounsellingRepository counsellingRepository) {
        Intrinsics.checkNotNullParameter(counsellingRepository, "counsellingRepository");
        this.counsellingRepository = counsellingRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.counsellingResponse = new MutableLiveData<>();
    }

    public final void getCounselling(String id) {
        this.counsellingResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ViewCounsellingResponse> singleObserveOn = this.counsellingRepository.viewCounsellingApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ViewCounsellingResponse, Unit> function1 = new Function1<ViewCounsellingResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingViewModel.getCounselling.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewCounsellingResponse viewCounsellingResponse) {
                invoke2(viewCounsellingResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewCounsellingResponse viewCounsellingResponse) {
                ViewCounsellingViewModel.this.counsellingResponse.postValue(Resource.INSTANCE.success(viewCounsellingResponse));
            }
        };
        Consumer<? super ViewCounsellingResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewCounsellingViewModel.getCounselling$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingViewModel.getCounselling.2
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
                ViewCounsellingViewModel.this.counsellingResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewCounsellingViewModel.getCounselling$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCounselling$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCounselling$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ViewCounsellingResponse>> getResponse() {
        return this.counsellingResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}