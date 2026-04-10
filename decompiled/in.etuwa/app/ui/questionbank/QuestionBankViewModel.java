package in.etuwa.app.ui.questionbank;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.materials.MaterialRequest;
import in.etuwa.app.data.model.materials.Materials;
import in.etuwa.app.data.repository.MaterialRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuestionBankViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class QuestionBankViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final MaterialRepository materialRepository;
    private MutableLiveData<Resource<ArrayList<Materials>>> materialResponse;
    private MutableLiveData<Resource<ArrayList<Semester>>> semResponse;

    public QuestionBankViewModel(MaterialRepository materialRepository) {
        Intrinsics.checkNotNullParameter(materialRepository, "materialRepository");
        this.materialRepository = materialRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.materialResponse = new MutableLiveData<>();
        this.semResponse = new MutableLiveData<>();
    }

    public final void getMaterials(String semId) {
        Intrinsics.checkNotNullParameter(semId, "semId");
        this.materialResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<Materials>> singleObserveOn = this.materialRepository.getQuestionBankApiCall(new MaterialRequest(semId)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<Materials>, Unit> function1 = new Function1<ArrayList<Materials>, Unit>() { // from class: in.etuwa.app.ui.questionbank.QuestionBankViewModel.getMaterials.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<Materials> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<Materials> arrayList) {
                QuestionBankViewModel.this.materialResponse.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<Materials>> consumer = new Consumer() { // from class: in.etuwa.app.ui.questionbank.QuestionBankViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuestionBankViewModel.getMaterials$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.questionbank.QuestionBankViewModel.getMaterials.2
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
                QuestionBankViewModel.this.materialResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.questionbank.QuestionBankViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuestionBankViewModel.getMaterials$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMaterials$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMaterials$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ArrayList<Materials>>> getResponse() {
        return this.materialResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}