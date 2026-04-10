package in.etuwa.app.ui.exam.module;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.exam.ModuleTestResponse;
import in.etuwa.app.data.repository.ExamRepository;
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

/* compiled from: ModuleTestViewModel.kt */
/* loaded from: classes4.dex */
public final class ModuleTestViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<SuccessResponse>> deleteResponse;
    private final ExamRepository examRepository;
    private MutableLiveData<Resource<ModuleTestResponse>> examResponse;

    public ModuleTestViewModel(ExamRepository examRepository) {
        Intrinsics.checkNotNullParameter(examRepository, "examRepository");
        this.examRepository = examRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.examResponse = new MutableLiveData<>();
        this.deleteResponse = new MutableLiveData<>();
        getExams();
    }

    public final MutableLiveData<Resource<SuccessResponse>> getDeleteResponse() {
        return this.deleteResponse;
    }

    public final void setDeleteResponse(MutableLiveData<Resource<SuccessResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.deleteResponse = mutableLiveData;
    }

    public final void getExams() {
        this.examResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ModuleTestResponse> observeOn = this.examRepository.getModuleTestApiCall("new").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ModuleTestResponse, Unit> function1 = new Function1<ModuleTestResponse, Unit>() { // from class: in.etuwa.app.ui.exam.module.ModuleTestViewModel$getExams$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModuleTestResponse moduleTestResponse) {
                invoke2(moduleTestResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModuleTestResponse moduleTestResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ModuleTestViewModel.this.examResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(moduleTestResponse));
            }
        };
        Consumer<? super ModuleTestResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.exam.module.ModuleTestViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ModuleTestViewModel.getExams$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.exam.module.ModuleTestViewModel$getExams$2
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
                mutableLiveData = ModuleTestViewModel.this.examResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.exam.module.ModuleTestViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ModuleTestViewModel.getExams$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExams$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExams$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ModuleTestResponse>> getResponse() {
        return this.examResponse;
    }

    public final void deleteExam(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.deleteResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.examRepository.deleteModuleTestApiCall(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.exam.module.ModuleTestViewModel$deleteExam$1
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
                ModuleTestViewModel.this.getDeleteResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.exam.module.ModuleTestViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ModuleTestViewModel.deleteExam$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.exam.module.ModuleTestViewModel$deleteExam$2
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
                ModuleTestViewModel.this.getDeleteResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.exam.module.ModuleTestViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ModuleTestViewModel.deleteExam$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteExam$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteExam$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}