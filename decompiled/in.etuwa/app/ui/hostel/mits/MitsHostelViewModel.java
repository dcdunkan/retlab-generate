package in.etuwa.app.ui.hostel.mits;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.hostel.mits.MitsFeePay;
import in.etuwa.app.data.repository.HostelRepository;
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

/* compiled from: MitsHostelViewModel.kt */
/* loaded from: classes5.dex */
public final class MitsHostelViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final HostelRepository hostelRepository;
    private MutableLiveData<Resource<MitsFeePay>> mitsFeePay;

    public MitsHostelViewModel(HostelRepository hostelRepository) {
        Intrinsics.checkNotNullParameter(hostelRepository, "hostelRepository");
        this.hostelRepository = hostelRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.mitsFeePay = new MutableLiveData<>();
    }

    public final void getUrl() {
        this.mitsFeePay.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<MitsFeePay> observeOn = this.hostelRepository.getMitsFeePayUrl().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<MitsFeePay, Unit> function1 = new Function1<MitsFeePay, Unit>() { // from class: in.etuwa.app.ui.hostel.mits.MitsHostelViewModel$getUrl$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MitsFeePay mitsFeePay) {
                invoke2(mitsFeePay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MitsFeePay mitsFeePay) {
                MutableLiveData mutableLiveData;
                mutableLiveData = MitsHostelViewModel.this.mitsFeePay;
                mutableLiveData.postValue(Resource.INSTANCE.success(mitsFeePay));
            }
        };
        Consumer<? super MitsFeePay> consumer = new Consumer() { // from class: in.etuwa.app.ui.hostel.mits.MitsHostelViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MitsHostelViewModel.getUrl$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.hostel.mits.MitsHostelViewModel$getUrl$2
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
                mutableLiveData = MitsHostelViewModel.this.mitsFeePay;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.hostel.mits.MitsHostelViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MitsHostelViewModel.getUrl$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getUrl$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getUrl$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<MitsFeePay>> getResponse() {
        return this.mitsFeePay;
    }
}