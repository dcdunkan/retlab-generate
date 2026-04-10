package in.etuwa.app.ui.lab.equipment.labequipments;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.lab.LabEquipRequest;
import in.etuwa.app.data.model.lab.LabEquipment;
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

/* compiled from: EquipmentViewModel.kt */
/* loaded from: classes5.dex */
public final class EquipmentViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private MutableLiveData<Resource<ArrayList<LabEquipment>>> equipResponse;
    private final LabRepository labRepository;

    public EquipmentViewModel(LabRepository labRepository) {
        Intrinsics.checkNotNullParameter(labRepository, "labRepository");
        this.labRepository = labRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.equipResponse = new MutableLiveData<>();
    }

    public final void getEquipList(String labId) {
        this.equipResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<LabEquipment>> observeOn = this.labRepository.getEquipmentsApiCall(new LabEquipRequest(labId)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<LabEquipment>, Unit> function1 = new Function1<ArrayList<LabEquipment>, Unit>() { // from class: in.etuwa.app.ui.lab.equipment.labequipments.EquipmentViewModel$getEquipList$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<LabEquipment> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<LabEquipment> arrayList) {
                MutableLiveData mutableLiveData;
                mutableLiveData = EquipmentViewModel.this.equipResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<LabEquipment>> consumer = new Consumer() { // from class: in.etuwa.app.ui.lab.equipment.labequipments.EquipmentViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EquipmentViewModel.getEquipList$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.lab.equipment.labequipments.EquipmentViewModel$getEquipList$2
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
                mutableLiveData = EquipmentViewModel.this.equipResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.lab.equipment.labequipments.EquipmentViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EquipmentViewModel.getEquipList$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getEquipList$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getEquipList$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ArrayList<LabEquipment>>> getResponse() {
        return this.equipResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}