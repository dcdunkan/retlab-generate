package in.etuwa.app.ui.university;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.university.UniversityResultResponse;
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

/* compiled from: UniversityResultViewModel.kt */
/* loaded from: classes5.dex */
public final class UniversityResultViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final ExamRegistrationRepository examRegistrationRepository;
    private MutableLiveData<Resource<UniversityResultResponse>> examResponse;

    public UniversityResultViewModel(ExamRegistrationRepository examRegistrationRepository) {
        Intrinsics.checkNotNullParameter(examRegistrationRepository, "examRegistrationRepository");
        this.examRegistrationRepository = examRegistrationRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.examResponse = new MutableLiveData<>();
    }

    public final void getUniversityResultResponse(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.examResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<UniversityResultResponse> observeOn = this.examRegistrationRepository.getExamResult(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<UniversityResultResponse, Unit> function1 = new Function1<UniversityResultResponse, Unit>() { // from class: in.etuwa.app.ui.university.UniversityResultViewModel$getUniversityResultResponse$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UniversityResultResponse universityResultResponse) {
                invoke2(universityResultResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UniversityResultResponse universityResultResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = UniversityResultViewModel.this.examResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(universityResultResponse));
            }
        };
        Consumer<? super UniversityResultResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.university.UniversityResultViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UniversityResultViewModel.getUniversityResultResponse$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.university.UniversityResultViewModel$getUniversityResultResponse$2
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
                mutableLiveData = UniversityResultViewModel.this.examResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.university.UniversityResultViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UniversityResultViewModel.getUniversityResultResponse$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getUniversityResultResponse$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getUniversityResultResponse$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<UniversityResultResponse>> getResponse() {
        return this.examResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}