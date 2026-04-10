package in.etuwa.app.ui.subject.syllabus;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.subject.co.CoSyllabusRequest;
import in.etuwa.app.data.model.subject.syllabus.SyllabusResponse;
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

/* JADX INFO: compiled from: SyllabusViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class SyllabusViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final SubjectRepository subjectRepository;
    private MutableLiveData<Resource<SyllabusResponse>> syllabusResponse;

    public SyllabusViewModel(SubjectRepository subjectRepository) {
        Intrinsics.checkNotNullParameter(subjectRepository, "subjectRepository");
        this.subjectRepository = subjectRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.syllabusResponse = new MutableLiveData<>();
    }

    public final void getSyllabus(String subId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        this.syllabusResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SyllabusResponse> singleObserveOn = this.subjectRepository.getSyllabusApiCall(new CoSyllabusRequest(subId)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SyllabusResponse, Unit> function1 = new Function1<SyllabusResponse, Unit>() { // from class: in.etuwa.app.ui.subject.syllabus.SyllabusViewModel.getSyllabus.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SyllabusResponse syllabusResponse) {
                invoke2(syllabusResponse);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SyllabusResponse syllabusResponse) {
                SyllabusViewModel.this.syllabusResponse.postValue(Resource.INSTANCE.success(syllabusResponse));
            }
        };
        Consumer<? super SyllabusResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.subject.syllabus.SyllabusViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SyllabusViewModel.getSyllabus$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.subject.syllabus.SyllabusViewModel.getSyllabus.2
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
                SyllabusViewModel.this.syllabusResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.subject.syllabus.SyllabusViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SyllabusViewModel.getSyllabus$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSyllabus$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSyllabus$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SyllabusResponse>> getResponse() {
        return this.syllabusResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}