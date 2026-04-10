package in.etuwa.app.ui.counselling;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.counselling.CounsellingResponse;
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

/* compiled from: CounsellingViewModel.kt */
/* loaded from: classes4.dex */
public final class CounsellingViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final CounsellingRepository counsellingRepository;
    private MutableLiveData<Resource<CounsellingResponse>> counsellingResponse;
    private MutableLiveData<Resource<SuccessResponse>> deleteResponse;

    public CounsellingViewModel(CounsellingRepository counsellingRepository) {
        Intrinsics.checkNotNullParameter(counsellingRepository, "counsellingRepository");
        this.counsellingRepository = counsellingRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.counsellingResponse = new MutableLiveData<>();
        this.deleteResponse = new MutableLiveData<>();
        getCounselling();
    }

    public final void getCounselling() {
        this.counsellingResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<CounsellingResponse> observeOn = this.counsellingRepository.getCounsellingRequestApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<CounsellingResponse, Unit> function1 = new Function1<CounsellingResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.CounsellingViewModel$getCounselling$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CounsellingResponse counsellingResponse) {
                invoke2(counsellingResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CounsellingResponse counsellingResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = CounsellingViewModel.this.counsellingResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(counsellingResponse));
            }
        };
        Consumer<? super CounsellingResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.CounsellingViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CounsellingViewModel.getCounselling$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.CounsellingViewModel$getCounselling$2
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
                mutableLiveData = CounsellingViewModel.this.counsellingResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.CounsellingViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CounsellingViewModel.getCounselling$lambda$1(Function1.this, obj);
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

    public final void deleteCounselling(String id) {
        this.deleteResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.counsellingRepository.deleteCounsellingApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.counselling.CounsellingViewModel$deleteCounselling$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SuccessResponse successResponse) {
                invoke2(successResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SuccessResponse successResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = CounsellingViewModel.this.deleteResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.counselling.CounsellingViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CounsellingViewModel.deleteCounselling$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.counselling.CounsellingViewModel$deleteCounselling$2
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
                mutableLiveData = CounsellingViewModel.this.deleteResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.counselling.CounsellingViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CounsellingViewModel.deleteCounselling$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteCounselling$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteCounselling$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<CounsellingResponse>> getResponse() {
        return this.counsellingResponse;
    }

    public final MutableLiveData<Resource<SuccessResponse>> getDeleteResponse() {
        return this.deleteResponse;
    }
}