package in.etuwa.app.ui.examregistration.examreceipt;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.examregister.ExamReceiptResponse;
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

/* compiled from: ExamReceiptViewModel.kt */
/* loaded from: classes4.dex */
public final class ExamReceiptViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<ExamReceiptResponse>> examReceiptResponse;
    private final ExamRegistrationRepository examRegistrationRepository;

    public ExamReceiptViewModel(ExamRegistrationRepository examRegistrationRepository) {
        Intrinsics.checkNotNullParameter(examRegistrationRepository, "examRegistrationRepository");
        this.examRegistrationRepository = examRegistrationRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.examReceiptResponse = new MutableLiveData<>();
    }

    public final void getExamReceiptData() {
        this.examReceiptResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ExamReceiptResponse> observeOn = this.examRegistrationRepository.getExamReceiptApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ExamReceiptResponse, Unit> function1 = new Function1<ExamReceiptResponse, Unit>() { // from class: in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptViewModel$getExamReceiptData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExamReceiptResponse examReceiptResponse) {
                invoke2(examReceiptResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ExamReceiptResponse examReceiptResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ExamReceiptViewModel.this.examReceiptResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(examReceiptResponse));
            }
        };
        Consumer<? super ExamReceiptResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamReceiptViewModel.getExamReceiptData$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptViewModel$getExamReceiptData$2
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
                mutableLiveData = ExamReceiptViewModel.this.examReceiptResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.examregistration.examreceipt.ExamReceiptViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ExamReceiptViewModel.getExamReceiptData$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamReceiptData$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExamReceiptData$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ExamReceiptResponse>> getResponse() {
        return this.examReceiptResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}