package in.etuwa.app.ui.subject.coverage;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.subject.coverage.SubCoverageResponse;
import in.etuwa.app.data.repository.SubjectRepository;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
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

/* compiled from: SubjectCoverageViewModel.kt */
/* loaded from: classes5.dex */
public final class SubjectCoverageViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<SubCoverageResponse>> coverageResponse;
    private final SubjectRepository subjectRepository;

    public SubjectCoverageViewModel(SubjectRepository subjectRepository) {
        Intrinsics.checkNotNullParameter(subjectRepository, "subjectRepository");
        this.subjectRepository = subjectRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.coverageResponse = new MutableLiveData<>();
    }

    public final void getCoverage(String subId, String batchId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        this.coverageResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SubCoverageResponse> observeOn = this.subjectRepository.getSubjectCoverageApiCall(subId, batchId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SubCoverageResponse, Unit> function1 = new Function1<SubCoverageResponse, Unit>() { // from class: in.etuwa.app.ui.subject.coverage.SubjectCoverageViewModel$getCoverage$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubCoverageResponse subCoverageResponse) {
                invoke2(subCoverageResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SubCoverageResponse subCoverageResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = SubjectCoverageViewModel.this.coverageResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(subCoverageResponse));
            }
        };
        Consumer<? super SubCoverageResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.subject.coverage.SubjectCoverageViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SubjectCoverageViewModel.getCoverage$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.subject.coverage.SubjectCoverageViewModel$getCoverage$2
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
                mutableLiveData = SubjectCoverageViewModel.this.coverageResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.subject.coverage.SubjectCoverageViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SubjectCoverageViewModel.getCoverage$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCoverage$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCoverage$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SubCoverageResponse>> getResponse() {
        return this.coverageResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}