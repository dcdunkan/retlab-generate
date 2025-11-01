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

/* compiled from: ViewCounsellingViewModel.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\b\u0010\u0010\u001a\u00020\fH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/counselling/view/ViewCounsellingViewModel;", "Landroidx/lifecycle/ViewModel;", "counsellingRepository", "Lin/etuwa/app/data/repository/CounsellingRepository;", "(Lin/etuwa/app/data/repository/CounsellingRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "counsellingResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/counselling/view/ViewCounsellingResponse;", "getCounselling", "", "id", "", "getResponse", "onCleared", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
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
        Single<ViewCounsellingResponse> observeOn = this.counsellingRepository.viewCounsellingApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ViewCounsellingResponse, Unit> function1 = new Function1<ViewCounsellingResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingViewModel$getCounselling$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewCounsellingResponse viewCounsellingResponse) {
                invoke2(viewCounsellingResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewCounsellingResponse viewCounsellingResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ViewCounsellingViewModel.this.counsellingResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(viewCounsellingResponse));
            }
        };
        Consumer<? super ViewCounsellingResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewCounsellingViewModel.getCounselling$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingViewModel$getCounselling$2
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
                mutableLiveData = ViewCounsellingViewModel.this.counsellingResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ViewCounsellingViewModel.getCounselling$lambda$1(Function1.this, obj);
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