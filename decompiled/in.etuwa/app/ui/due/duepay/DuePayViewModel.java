package in.etuwa.app.ui.due.duepay;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.due.duepay.DuePayUrl;
import in.etuwa.app.data.model.due.duepaynew.DuePayNewResponse;
import in.etuwa.app.data.repository.CommonRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DuePayViewModel.kt */
/* loaded from: classes4.dex */
public final class DuePayViewModel extends ViewModel {
    private final CommonRepository commonRepository;
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<DuePayNewResponse>> dueResponse;
    private MutableLiveData<Resource<DuePayUrl>> dueUrlResponse;

    public DuePayViewModel(CommonRepository commonRepository) {
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        this.commonRepository = commonRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.dueResponse = new MutableLiveData<>();
        this.dueUrlResponse = new MutableLiveData<>();
        getDues();
    }

    public final void getDues() {
        this.dueResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<DuePayNewResponse> observeOn = this.commonRepository.getDuePay().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DuePayNewResponse, Unit> function1 = new Function1<DuePayNewResponse, Unit>() { // from class: in.etuwa.app.ui.due.duepay.DuePayViewModel$getDues$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DuePayNewResponse duePayNewResponse) {
                invoke2(duePayNewResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DuePayNewResponse duePayNewResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DuePayViewModel.this.dueResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(duePayNewResponse));
            }
        };
        Consumer<? super DuePayNewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.due.duepay.DuePayViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DuePayViewModel.getDues$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.due.duepay.DuePayViewModel$getDues$2
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
                mutableLiveData = DuePayViewModel.this.dueResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.due.duepay.DuePayViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DuePayViewModel.getDues$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDues$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDues$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<DuePayNewResponse>> getResponse() {
        return this.dueResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }

    public final void getDueUrl(Map<String, String> dueFeeCollection, Map<String, String> dueFeeReceipt) {
        Intrinsics.checkNotNullParameter(dueFeeCollection, "dueFeeCollection");
        Intrinsics.checkNotNullParameter(dueFeeReceipt, "dueFeeReceipt");
        this.dueUrlResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<DuePayUrl> observeOn = this.commonRepository.getDuePayUrlApiCall(dueFeeCollection, dueFeeReceipt).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DuePayUrl, Unit> function1 = new Function1<DuePayUrl, Unit>() { // from class: in.etuwa.app.ui.due.duepay.DuePayViewModel$getDueUrl$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DuePayUrl duePayUrl) {
                invoke2(duePayUrl);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DuePayUrl duePayUrl) {
                MutableLiveData mutableLiveData;
                mutableLiveData = DuePayViewModel.this.dueUrlResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(duePayUrl));
            }
        };
        Consumer<? super DuePayUrl> consumer = new Consumer() { // from class: in.etuwa.app.ui.due.duepay.DuePayViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DuePayViewModel.getDueUrl$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.due.duepay.DuePayViewModel$getDueUrl$2
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
                mutableLiveData = DuePayViewModel.this.dueUrlResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.due.duepay.DuePayViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DuePayViewModel.getDueUrl$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDueUrl$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDueUrl$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<DuePayUrl>> getDueUrlResponse() {
        return this.dueUrlResponse;
    }
}