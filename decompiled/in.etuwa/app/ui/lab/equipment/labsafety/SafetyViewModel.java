package in.etuwa.app.ui.lab.equipment.labsafety;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.lab.LabEquipRequest;
import in.etuwa.app.data.repository.LabRepository;
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

/* compiled from: SafetyViewModel.kt */
/* loaded from: classes5.dex */
public final class SafetyViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final LabRepository labRepository;
    private MutableLiveData<Resource<ArrayList<String>>> safetyResponse;

    public SafetyViewModel(LabRepository labRepository) {
        Intrinsics.checkNotNullParameter(labRepository, "labRepository");
        this.labRepository = labRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.safetyResponse = new MutableLiveData<>();
    }

    public final void getSafetyList(String labId) {
        this.safetyResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<String>> observeOn = this.labRepository.getSafetyApiCall(new LabEquipRequest(labId)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<String>, Unit> function1 = new Function1<ArrayList<String>, Unit>() { // from class: in.etuwa.app.ui.lab.equipment.labsafety.SafetyViewModel$getSafetyList$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<String> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<String> arrayList) {
                MutableLiveData mutableLiveData;
                mutableLiveData = SafetyViewModel.this.safetyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<String>> consumer = new Consumer() { // from class: in.etuwa.app.ui.lab.equipment.labsafety.SafetyViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SafetyViewModel.getSafetyList$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.lab.equipment.labsafety.SafetyViewModel$getSafetyList$2
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
                mutableLiveData = SafetyViewModel.this.safetyResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.lab.equipment.labsafety.SafetyViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SafetyViewModel.getSafetyList$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSafetyList$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSafetyList$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ArrayList<String>>> getResponse() {
        return this.safetyResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}