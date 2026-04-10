package in.etuwa.app.ui.examregistration.examsubjects.register;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.examregister.ExamCourseResponse;
import in.etuwa.app.data.model.examregister.ExamMessageResponse;
import in.etuwa.app.data.model.examregister.ExamPayResponse;
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

/* compiled from: ExamRegisterViewModel.kt */
/* loaded from: classes4.dex */
public final class ExamRegisterViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<ExamPayResponse>> examPayResponse;
    private final ExamRegistrationRepository examRegistrationRepository;
    private MutableLiveData<Resource<ExamCourseResponse>> examViewResponse;
    private MutableLiveData<Resource<ExamMessageResponse>> pioPayResponse;
    private MutableLiveData<Resource<ExamMessageResponse>> scstPayResponse;

    public ExamRegisterViewModel(ExamRegistrationRepository examRegistrationRepository) {
        Intrinsics.checkNotNullParameter(examRegistrationRepository, "examRegistrationRepository");
        this.examRegistrationRepository = examRegistrationRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.examViewResponse = new MutableLiveData<>();
        this.examPayResponse = new MutableLiveData<>();
        this.pioPayResponse = new MutableLiveData<>();
        this.scstPayResponse = new MutableLiveData<>();
    }

    public final void getExamDetails(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.examViewResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ExamCourseResponse> observeOn = this.examRegistrationRepository.getExamCourseApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ExamCourseResponse, Unit> function1 = new Function1<ExamCourseResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$getExamDetails$1
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
                mutableLiveData = ExamRegisterViewModel.this.examViewResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(examCourseResponse));
            }
        };
        Consumer<? super ExamCourseResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegisterViewModel.getExamDetails$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$getExamDetails$2
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
                mutableLiveData = ExamRegisterViewModel.this.examViewResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegisterViewModel.getExamDetails$lambda$1(Function1.this, obj);
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

    public final void getExamPay(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        this.examPayResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ExamPayResponse> observeOn = this.examRegistrationRepository.getExamPayUrlApiCall(FeeCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ExamPayResponse, Unit> function1 = new Function1<ExamPayResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$getExamPay$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExamPayResponse examPayResponse) {
                invoke2(examPayResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ExamPayResponse examPayResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ExamRegisterViewModel.this.examPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(examPayResponse));
            }
        };
        Consumer<? super ExamPayResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegisterViewModel.getExamPay$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$getExamPay$2
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
                mutableLiveData = ExamRegisterViewModel.this.examPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegisterViewModel.getExamPay$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamPay$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamPay$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ExamPayResponse>> getPayResponse() {
        return this.examPayResponse;
    }

    public final void getPioPay(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        this.pioPayResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ExamMessageResponse> observeOn = this.examRegistrationRepository.getPioPayUrlApiCall(FeeCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ExamMessageResponse, Unit> function1 = new Function1<ExamMessageResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$getPioPay$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExamMessageResponse examMessageResponse) {
                invoke2(examMessageResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ExamMessageResponse examMessageResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ExamRegisterViewModel.this.pioPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(examMessageResponse));
            }
        };
        Consumer<? super ExamMessageResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegisterViewModel.getPioPay$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$getPioPay$2
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
                mutableLiveData = ExamRegisterViewModel.this.pioPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegisterViewModel.getPioPay$lambda$5(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPioPay$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPioPay$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ExamMessageResponse>> getPioPayResponse() {
        return this.pioPayResponse;
    }

    public final void getScStPay(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        this.scstPayResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ExamMessageResponse> observeOn = this.examRegistrationRepository.getScStPayUrlApiCall(FeeCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ExamMessageResponse, Unit> function1 = new Function1<ExamMessageResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$getScStPay$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExamMessageResponse examMessageResponse) {
                invoke2(examMessageResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ExamMessageResponse examMessageResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ExamRegisterViewModel.this.scstPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(examMessageResponse));
            }
        };
        Consumer<? super ExamMessageResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegisterViewModel.getScStPay$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$getScStPay$2
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
                mutableLiveData = ExamRegisterViewModel.this.scstPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.register.ExamRegisterViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamRegisterViewModel.getScStPay$lambda$7(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getScStPay$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getScStPay$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ExamMessageResponse>> getScStPayResponse() {
        return this.scstPayResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}