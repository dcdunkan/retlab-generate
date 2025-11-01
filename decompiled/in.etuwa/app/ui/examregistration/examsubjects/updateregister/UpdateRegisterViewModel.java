package in.etuwa.app.ui.examregistration.examsubjects.updateregister;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.examregister.ExamMessageResponse;
import in.etuwa.app.data.model.examregister.ExamPayResponse;
import in.etuwa.app.data.model.examregister.ExamUpdateResponse;
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

/* compiled from: UpdateRegisterViewModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0016J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u001a\u0010\u0018\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0016J\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\bJ\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bJ\u001a\u0010\u001b\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0016J\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\bJ\b\u0010\u001d\u001a\u00020\u0011H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/updateregister/UpdateRegisterViewModel;", "Landroidx/lifecycle/ViewModel;", "examRegistrationRepository", "Lin/etuwa/app/data/repository/ExamRegistrationRepository;", "(Lin/etuwa/app/data/repository/ExamRegistrationRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "examPayResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/examregister/ExamPayResponse;", "examViewResponse", "Lin/etuwa/app/data/model/examregister/ExamUpdateResponse;", "pioPayResponse", "Lin/etuwa/app/data/model/examregister/ExamMessageResponse;", "scstPayResponse", "getExamDetails", "", "id", "", "getExamPay", "FeeCollection", "", "getPayResponse", "getPioPay", "getPioPayResponse", "getResponse", "getScStPay", "getScStPayResponse", "onCleared", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UpdateRegisterViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<ExamPayResponse>> examPayResponse;
    private final ExamRegistrationRepository examRegistrationRepository;
    private MutableLiveData<Resource<ExamUpdateResponse>> examViewResponse;
    private MutableLiveData<Resource<ExamMessageResponse>> pioPayResponse;
    private MutableLiveData<Resource<ExamMessageResponse>> scstPayResponse;

    public UpdateRegisterViewModel(ExamRegistrationRepository examRegistrationRepository) {
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
        Single<ExamUpdateResponse> observeOn = this.examRegistrationRepository.getExamUpdateApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ExamUpdateResponse, Unit> function1 = new Function1<ExamUpdateResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$getExamDetails$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExamUpdateResponse examUpdateResponse) {
                invoke2(examUpdateResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ExamUpdateResponse examUpdateResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = UpdateRegisterViewModel.this.examViewResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(examUpdateResponse));
            }
        };
        Consumer<? super ExamUpdateResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateRegisterViewModel.getExamDetails$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$getExamDetails$2
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
                mutableLiveData = UpdateRegisterViewModel.this.examViewResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateRegisterViewModel.getExamDetails$lambda$1(Function1.this, obj);
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

    public final MutableLiveData<Resource<ExamUpdateResponse>> getResponse() {
        return this.examViewResponse;
    }

    public final void getExamPay(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        this.examPayResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ExamPayResponse> observeOn = this.examRegistrationRepository.getExamPayUrlApiCall(FeeCollection).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ExamPayResponse, Unit> function1 = new Function1<ExamPayResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$getExamPay$1
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
                mutableLiveData = UpdateRegisterViewModel.this.examPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(examPayResponse));
            }
        };
        Consumer<? super ExamPayResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateRegisterViewModel.getExamPay$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$getExamPay$2
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
                mutableLiveData = UpdateRegisterViewModel.this.examPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateRegisterViewModel.getExamPay$lambda$3(Function1.this, obj);
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
        final Function1<ExamMessageResponse, Unit> function1 = new Function1<ExamMessageResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$getPioPay$1
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
                mutableLiveData = UpdateRegisterViewModel.this.pioPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(examMessageResponse));
            }
        };
        Consumer<? super ExamMessageResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateRegisterViewModel.getPioPay$lambda$4(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$getPioPay$2
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
                mutableLiveData = UpdateRegisterViewModel.this.pioPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateRegisterViewModel.getPioPay$lambda$5(Function1.this, obj);
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
        final Function1<ExamMessageResponse, Unit> function1 = new Function1<ExamMessageResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$getScStPay$1
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
                mutableLiveData = UpdateRegisterViewModel.this.scstPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(examMessageResponse));
            }
        };
        Consumer<? super ExamMessageResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateRegisterViewModel.getScStPay$lambda$6(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$getScStPay$2
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
                mutableLiveData = UpdateRegisterViewModel.this.scstPayResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.examsubjects.updateregister.UpdateRegisterViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateRegisterViewModel.getScStPay$lambda$7(Function1.this, obj);
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