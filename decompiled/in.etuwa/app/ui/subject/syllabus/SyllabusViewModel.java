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

/* compiled from: SyllabusViewModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/subject/syllabus/SyllabusViewModel;", "Landroidx/lifecycle/ViewModel;", "subjectRepository", "Lin/etuwa/app/data/repository/SubjectRepository;", "(Lin/etuwa/app/data/repository/SubjectRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "syllabusResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Lin/etuwa/app/data/model/subject/syllabus/SyllabusResponse;", "getResponse", "getSyllabus", "", StoreFragmentKt.SUB_ID, "", "onCleared", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
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
        Single<SyllabusResponse> observeOn = this.subjectRepository.getSyllabusApiCall(new CoSyllabusRequest(subId)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SyllabusResponse, Unit> function1 = new Function1<SyllabusResponse, Unit>() { // from class: in.etuwa.app.ui.subject.syllabus.SyllabusViewModel$getSyllabus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SyllabusResponse syllabusResponse) {
                invoke2(syllabusResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SyllabusResponse syllabusResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = SyllabusViewModel.this.syllabusResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(syllabusResponse));
            }
        };
        Consumer<? super SyllabusResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.subject.syllabus.SyllabusViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SyllabusViewModel.getSyllabus$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.subject.syllabus.SyllabusViewModel$getSyllabus$2
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
                mutableLiveData = SyllabusViewModel.this.syllabusResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.subject.syllabus.SyllabusViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SyllabusViewModel.getSyllabus$lambda$1(Function1.this, obj);
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