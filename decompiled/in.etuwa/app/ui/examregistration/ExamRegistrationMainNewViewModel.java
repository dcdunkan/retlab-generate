package in.etuwa.app.ui.examregistration;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.dash.AbcResponse;
import in.etuwa.app.data.model.examregister.ExamCourseResponse;
import in.etuwa.app.data.model.examregister.ExamReceiptResponse;
import in.etuwa.app.data.model.examregister.ExamRegisterResponse;
import in.etuwa.app.data.model.examregister.RevaluationResponse;
import in.etuwa.app.data.model.examregister.RevaluationStatusResponse;
import in.etuwa.app.data.repository.ExamRegistrationRepository;
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

/* JADX INFO: compiled from: ExamRegistrationMainNewViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ExamRegistrationMainNewViewModel extends ViewModel {
    private final MutableLiveData<Resource<AbcResponse>> abcViewResponse;
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<ExamReceiptResponse>> examReceiptResponse;
    private final ExamRegistrationRepository examRegistrationRepository;
    private MutableLiveData<Resource<ExamRegisterResponse>> examResponse;
    private MutableLiveData<Resource<RevaluationStatusResponse>> examStatusResponse;
    private MutableLiveData<Resource<ExamCourseResponse>> examViewResponse;
    private MutableLiveData<Resource<RevaluationResponse>> revaluationResponse;

    public ExamRegistrationMainNewViewModel(ExamRegistrationRepository examRegistrationRepository) {
        Intrinsics.checkNotNullParameter(examRegistrationRepository, "examRegistrationRepository");
        this.examRegistrationRepository = examRegistrationRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.examResponse = new MutableLiveData<>();
        this.examStatusResponse = new MutableLiveData<>();
        this.examViewResponse = new MutableLiveData<>();
        this.examReceiptResponse = new MutableLiveData<>();
        this.revaluationResponse = new MutableLiveData<>();
        this.abcViewResponse = new MutableLiveData<>();
    }

    public final void getExamData() {
        this.examResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ExamRegisterResponse> singleObserveOn = this.examRegistrationRepository.getExamRegisterDataApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ExamRegisterResponse, Unit> function1 = new Function1<ExamRegisterResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel.getExamData.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExamRegisterResponse examRegisterResponse) {
                invoke2(examRegisterResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ExamRegisterResponse examRegisterResponse) {
                ExamRegistrationMainNewViewModel.this.examResponse.postValue(Resource.INSTANCE.success(examRegisterResponse));
            }
        };
        Consumer<? super ExamRegisterResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegistrationMainNewViewModel.getExamData$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel.getExamData.2
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
                ExamRegistrationMainNewViewModel.this.examResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegistrationMainNewViewModel.getExamData$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamData$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamData$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ExamRegisterResponse>> getResponse() {
        return this.examResponse;
    }

    public final void getExamStatusData(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.examStatusResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<RevaluationStatusResponse> singleObserveOn = this.examRegistrationRepository.getExamRevaluationStatusApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<RevaluationStatusResponse, Unit> function1 = new Function1<RevaluationStatusResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel.getExamStatusData.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RevaluationStatusResponse revaluationStatusResponse) {
                invoke2(revaluationStatusResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RevaluationStatusResponse revaluationStatusResponse) {
                ExamRegistrationMainNewViewModel.this.examStatusResponse.postValue(Resource.INSTANCE.success(revaluationStatusResponse));
            }
        };
        Consumer<? super RevaluationStatusResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegistrationMainNewViewModel.getExamStatusData$lambda$2(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel.getExamStatusData.2
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
                ExamRegistrationMainNewViewModel.this.examStatusResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegistrationMainNewViewModel.getExamStatusData$lambda$3(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamStatusData$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamStatusData$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<RevaluationStatusResponse>> getStatusResponse() {
        return this.examStatusResponse;
    }

    public final void getExamDetails(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.examViewResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ExamCourseResponse> singleObserveOn = this.examRegistrationRepository.getExamCourseApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ExamCourseResponse, Unit> function1 = new Function1<ExamCourseResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel.getExamDetails.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExamCourseResponse examCourseResponse) {
                invoke2(examCourseResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ExamCourseResponse examCourseResponse) {
                ExamRegistrationMainNewViewModel.this.examViewResponse.postValue(Resource.INSTANCE.success(examCourseResponse));
            }
        };
        Consumer<? super ExamCourseResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegistrationMainNewViewModel.getExamDetails$lambda$4(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel.getExamDetails.2
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
                ExamRegistrationMainNewViewModel.this.examViewResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegistrationMainNewViewModel.getExamDetails$lambda$5(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamDetails$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamDetails$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ExamCourseResponse>> getDueResponse() {
        return this.examViewResponse;
    }

    public final void getExamReceiptData() {
        this.examReceiptResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ExamReceiptResponse> singleObserveOn = this.examRegistrationRepository.getExamReceiptApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ExamReceiptResponse, Unit> function1 = new Function1<ExamReceiptResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel.getExamReceiptData.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExamReceiptResponse examReceiptResponse) {
                invoke2(examReceiptResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ExamReceiptResponse examReceiptResponse) {
                ExamRegistrationMainNewViewModel.this.examReceiptResponse.postValue(Resource.INSTANCE.success(examReceiptResponse));
            }
        };
        Consumer<? super ExamReceiptResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegistrationMainNewViewModel.getExamReceiptData$lambda$6(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel.getExamReceiptData.2
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
                ExamRegistrationMainNewViewModel.this.examReceiptResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegistrationMainNewViewModel.getExamReceiptData$lambda$7(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamReceiptData$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamReceiptData$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ExamReceiptResponse>> getExamReceiptResponse() {
        return this.examReceiptResponse;
    }

    public final void getAbcData() {
        this.abcViewResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<AbcResponse> singleObserveOn = this.examRegistrationRepository.getAbcViewApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<AbcResponse, Unit> function1 = new Function1<AbcResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel.getAbcData.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AbcResponse abcResponse) {
                invoke2(abcResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AbcResponse abcResponse) {
                ExamRegistrationMainNewViewModel.this.abcViewResponse.postValue(Resource.INSTANCE.success(abcResponse));
            }
        };
        Consumer<? super AbcResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegistrationMainNewViewModel.getAbcData$lambda$8(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel.getAbcData.2
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
                ExamRegistrationMainNewViewModel.this.abcViewResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.ExamRegistrationMainNewViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegistrationMainNewViewModel.getAbcData$lambda$9(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAbcData$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAbcData$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<AbcResponse>> getAbcResponse() {
        return this.abcViewResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}