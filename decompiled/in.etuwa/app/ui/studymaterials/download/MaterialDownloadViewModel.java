package in.etuwa.app.ui.studymaterials.download;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.materials.MaterialRequest;
import in.etuwa.app.data.model.materials.MaterialsNew;
import in.etuwa.app.data.repository.MaterialRepository;
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

/* compiled from: MaterialDownloadViewModel.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\"\u0010\u0013\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f0\t0\bJ\b\u0010\u0014\u001a\u00020\u0010H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\nj\b\u0012\u0004\u0012\u00020\u000e`\f0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/ui/studymaterials/download/MaterialDownloadViewModel;", "Landroidx/lifecycle/ViewModel;", "materialRepository", "Lin/etuwa/app/data/repository/MaterialRepository;", "(Lin/etuwa/app/data/repository/MaterialRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "materialResponse", "Landroidx/lifecycle/MutableLiveData;", "Lin/etuwa/app/utils/Resource;", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/materials/MaterialsNew;", "Lkotlin/collections/ArrayList;", "semResponse", "Lin/etuwa/app/data/model/Semester;", "getMaterials", "", "semId", "", "getResponse", "onCleared", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MaterialDownloadViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final MaterialRepository materialRepository;
    private MutableLiveData<Resource<ArrayList<MaterialsNew>>> materialResponse;
    private final MutableLiveData<Resource<ArrayList<Semester>>> semResponse;

    public MaterialDownloadViewModel(MaterialRepository materialRepository) {
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
        Single<ArrayList<MaterialsNew>> observeOn = this.materialRepository.getStudyMaterialsApiCall(new MaterialRequest(semId)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<MaterialsNew>, Unit> function1 = new Function1<ArrayList<MaterialsNew>, Unit>() { // from class: in.etuwa.app.ui.studymaterials.download.MaterialDownloadViewModel$getMaterials$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<MaterialsNew> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<MaterialsNew> arrayList) {
                MutableLiveData mutableLiveData;
                mutableLiveData = MaterialDownloadViewModel.this.materialResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<MaterialsNew>> consumer = new Consumer() { // from class: in.etuwa.app.ui.studymaterials.download.MaterialDownloadViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MaterialDownloadViewModel.getMaterials$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.studymaterials.download.MaterialDownloadViewModel$getMaterials$2
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
                mutableLiveData = MaterialDownloadViewModel.this.materialResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(th.getMessage()));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.studymaterials.download.MaterialDownloadViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MaterialDownloadViewModel.getMaterials$lambda$1(Function1.this, obj);
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

    public final MutableLiveData<Resource<ArrayList<MaterialsNew>>> getResponse() {
        return this.materialResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}