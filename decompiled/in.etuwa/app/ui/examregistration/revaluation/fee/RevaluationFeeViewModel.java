package in.etuwa.app.ui.examregistration.revaluation.fee;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.due.duepay.DuePayUrl;
import in.etuwa.app.data.model.examregister.RevaluationApplyResponse;
import in.etuwa.app.data.repository.ExamRegistrationRepository;
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

/* compiled from: RevaluationFeeViewModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010J\u001a\u0010\u0012\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010J\u001a\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010J\u001a\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010J\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bJ\b\u0010\u0017\u001a\u00020\u000eH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/ui/examregistration/revaluation/fee/RevaluationFeeViewModel;", "Landroidx/lifecycle/ViewModel;", "examRegistrationRepository", "Lin/etuwa/app/data/repository/ExamRegistrationRepository;", "(Lin/etuwa/app/data/repository/ExamRegistrationRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "revaluationPayResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/due/duepay/DuePayUrl;", "revaluationResponse", "Lin/etuwa/app/data/model/examregister/RevaluationApplyResponse;", "getExamRevaluationConfirm", "", "revaluationCollection", "", "", "getExamRevaluationConfirmUpdate", "getExamRevaluationPay", "getExamRevaluationUpdatePay", "getPayResponse", "getResponse", "onCleared", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RevaluationFeeViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final ExamRegistrationRepository examRegistrationRepository;
    private MutableLiveData<Resource<DuePayUrl>> revaluationPayResponse;
    private MutableLiveData<Resource<RevaluationApplyResponse>> revaluationResponse;

    public RevaluationFeeViewModel(ExamRegistrationRepository examRegistrationRepository) {
        Intrinsics.checkNotNullParameter(examRegistrationRepository, "examRegistrationRepository");
        this.examRegistrationRepository = examRegistrationRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.revaluationResponse = new MutableLiveData<>();
        this.revaluationPayResponse = new MutableLiveData<>();
    }

    public final void getExamRevaluationConfirm(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        this.revaluationResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<RevaluationApplyResponse> observeOn = this.examRegistrationRepository.getExamRevaluationConfirmApiCall(revaluationCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<RevaluationApplyResponse, Unit> function1 = new Function1<RevaluationApplyResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$getExamRevaluationConfirm$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RevaluationApplyResponse revaluationApplyResponse) {
                invoke2(revaluationApplyResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RevaluationApplyResponse revaluationApplyResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = RevaluationFeeViewModel.this.revaluationResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(revaluationApplyResponse));
            }
        };
        Consumer<? super RevaluationApplyResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RevaluationFeeViewModel.getExamRevaluationConfirm$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$getExamRevaluationConfirm$2
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
                mutableLiveData = RevaluationFeeViewModel.this.revaluationResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RevaluationFeeViewModel.getExamRevaluationConfirm$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamRevaluationConfirm$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamRevaluationConfirm$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void getExamRevaluationConfirmUpdate(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        this.revaluationResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<RevaluationApplyResponse> observeOn = this.examRegistrationRepository.getExamRevaluationConfirmUpdateApiCall(revaluationCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<RevaluationApplyResponse, Unit> function1 = new Function1<RevaluationApplyResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$getExamRevaluationConfirmUpdate$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RevaluationApplyResponse revaluationApplyResponse) {
                invoke2(revaluationApplyResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RevaluationApplyResponse revaluationApplyResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = RevaluationFeeViewModel.this.revaluationResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(revaluationApplyResponse));
            }
        };
        Consumer<? super RevaluationApplyResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RevaluationFeeViewModel.getExamRevaluationConfirmUpdate$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$getExamRevaluationConfirmUpdate$2
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
                mutableLiveData = RevaluationFeeViewModel.this.revaluationResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RevaluationFeeViewModel.getExamRevaluationConfirmUpdate$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamRevaluationConfirmUpdate$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamRevaluationConfirmUpdate$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<RevaluationApplyResponse>> getResponse() {
        return this.revaluationResponse;
    }

    public final void getExamRevaluationPay(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        this.revaluationPayResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<DuePayUrl> observeOn = this.examRegistrationRepository.getExamRevaluationPayApiCall(revaluationCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DuePayUrl, Unit> function1 = new Function1<DuePayUrl, Unit>() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$getExamRevaluationPay$1
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
                mutableLiveData = RevaluationFeeViewModel.this.revaluationPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(duePayUrl));
            }
        };
        Consumer<? super DuePayUrl> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RevaluationFeeViewModel.getExamRevaluationPay$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$getExamRevaluationPay$2
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
                mutableLiveData = RevaluationFeeViewModel.this.revaluationPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RevaluationFeeViewModel.getExamRevaluationPay$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamRevaluationPay$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamRevaluationPay$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void getExamRevaluationUpdatePay(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        this.revaluationPayResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<DuePayUrl> observeOn = this.examRegistrationRepository.getExamRevaluationUpdatePayApiCall(revaluationCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<DuePayUrl, Unit> function1 = new Function1<DuePayUrl, Unit>() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$getExamRevaluationUpdatePay$1
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
                mutableLiveData = RevaluationFeeViewModel.this.revaluationPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(duePayUrl));
            }
        };
        Consumer<? super DuePayUrl> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RevaluationFeeViewModel.getExamRevaluationUpdatePay$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$getExamRevaluationUpdatePay$2
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
                mutableLiveData = RevaluationFeeViewModel.this.revaluationPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.revaluation.fee.RevaluationFeeViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RevaluationFeeViewModel.getExamRevaluationUpdatePay$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamRevaluationUpdatePay$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamRevaluationUpdatePay$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<DuePayUrl>> getPayResponse() {
        return this.revaluationPayResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}