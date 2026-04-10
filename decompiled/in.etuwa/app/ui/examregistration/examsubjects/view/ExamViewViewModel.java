package in.etuwa.app.ui.examregistration.examsubjects.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.dash.AbcResponse;
import in.etuwa.app.data.model.examregister.ExamCourseResponse;
import in.etuwa.app.data.model.examregister.ExamViewResponse;
import in.etuwa.app.data.model.examregister.RegistrationSlipResponse;
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

/* compiled from: ExamViewViewModel.kt */
/* loaded from: classes4.dex */
public final class ExamViewViewModel extends ViewModel {
    private final MutableLiveData<Resource<AbcResponse>> abcViewResponse;
    private final CompositeDisposable compositeDisposable;
    private final ExamRegistrationRepository examRegistrationRepository;
    private MutableLiveData<Resource<ExamCourseResponse>> examViewResponse;
    private MutableLiveData<Resource<ExamViewResponse>> examViewsResponse;
    private MutableLiveData<Resource<RegistrationSlipResponse>> slipResponse;

    public ExamViewViewModel(ExamRegistrationRepository examRegistrationRepository) {
        Intrinsics.checkNotNullParameter(examRegistrationRepository, "examRegistrationRepository");
        this.examRegistrationRepository = examRegistrationRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.examViewResponse = new MutableLiveData<>();
        this.examViewsResponse = new MutableLiveData<>();
        this.slipResponse = new MutableLiveData<>();
        this.abcViewResponse = new MutableLiveData<>();
    }

    public final void getExamDetails(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.examViewResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ExamCourseResponse> observeOn = this.examRegistrationRepository.getExamCourseApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ExamCourseResponse, Unit> function1 = new Function1<ExamCourseResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$getExamDetails$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExamCourseResponse examCourseResponse) {
                invoke2(examCourseResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ExamCourseResponse examCourseResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ExamViewViewModel.this.examViewResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(examCourseResponse));
            }
        };
        Consumer<? super ExamCourseResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamViewViewModel.getExamDetails$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$getExamDetails$2
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
                mutableLiveData = ExamViewViewModel.this.examViewResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamViewViewModel.getExamDetails$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamDetails$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamDetails$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ExamCourseResponse>> getResponse() {
        return this.examViewResponse;
    }

    public final void getExamView(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.examViewsResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ExamViewResponse> observeOn = this.examRegistrationRepository.getExamViewApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ExamViewResponse, Unit> function1 = new Function1<ExamViewResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$getExamView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExamViewResponse examViewResponse) {
                invoke2(examViewResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ExamViewResponse examViewResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ExamViewViewModel.this.examViewsResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(examViewResponse));
            }
        };
        Consumer<? super ExamViewResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamViewViewModel.getExamView$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$getExamView$2
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
                mutableLiveData = ExamViewViewModel.this.examViewsResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamViewViewModel.getExamView$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamView$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamView$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ExamViewResponse>> getViewResponse() {
        return this.examViewsResponse;
    }

    public final void getExamSlip(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.slipResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<RegistrationSlipResponse> observeOn = this.examRegistrationRepository.getRegistrationSlipApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<RegistrationSlipResponse, Unit> function1 = new Function1<RegistrationSlipResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$getExamSlip$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RegistrationSlipResponse registrationSlipResponse) {
                invoke2(registrationSlipResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RegistrationSlipResponse registrationSlipResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ExamViewViewModel.this.slipResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(registrationSlipResponse));
            }
        };
        Consumer<? super RegistrationSlipResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamViewViewModel.getExamSlip$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$getExamSlip$2
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
                mutableLiveData = ExamViewViewModel.this.slipResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamViewViewModel.getExamSlip$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamSlip$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamSlip$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<RegistrationSlipResponse>> getSlipResponse() {
        return this.slipResponse;
    }

    public final void getAbcData() {
        this.abcViewResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<AbcResponse> observeOn = this.examRegistrationRepository.getAbcViewApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<AbcResponse, Unit> function1 = new Function1<AbcResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$getAbcData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AbcResponse abcResponse) {
                invoke2(abcResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AbcResponse abcResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ExamViewViewModel.this.abcViewResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(abcResponse));
            }
        };
        Consumer<? super AbcResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamViewViewModel.getAbcData$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$getAbcData$2
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
                mutableLiveData = ExamViewViewModel.this.abcViewResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamViewViewModel.getAbcData$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAbcData$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAbcData$lambda$7(Function1 tmp0, Object obj) {
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