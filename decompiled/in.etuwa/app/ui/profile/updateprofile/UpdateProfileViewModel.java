package in.etuwa.app.ui.profile.updateprofile;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.updateprofile.UpdateProfile;
import in.etuwa.app.data.repository.DashRepository;
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
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

/* compiled from: UpdateProfileViewModel.kt */
/* loaded from: classes5.dex */
public final class UpdateProfileViewModel extends ViewModel implements KoinComponent {
    private final CompositeDisposable compositeDisposable;
    private final DashRepository dashRepository;
    private final MutableLiveData<Resource<UpdateProfile>> updateResponse;

    public UpdateProfileViewModel(DashRepository dashRepository) {
        Intrinsics.checkNotNullParameter(dashRepository, "dashRepository");
        this.dashRepository = dashRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.updateResponse = new MutableLiveData<>();
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final void updateBankData() {
        this.updateResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<UpdateProfile> observeOn = this.dashRepository.getUpdateProfileApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<UpdateProfile, Unit> function1 = new Function1<UpdateProfile, Unit>() { // from class: in.etuwa.app.ui.profile.updateprofile.UpdateProfileViewModel$updateBankData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UpdateProfile updateProfile) {
                invoke2(updateProfile);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UpdateProfile updateProfile) {
                MutableLiveData mutableLiveData;
                mutableLiveData = UpdateProfileViewModel.this.updateResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(updateProfile));
            }
        };
        Consumer<? super UpdateProfile> consumer = new Consumer() { // from class: in.etuwa.app.ui.profile.updateprofile.UpdateProfileViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateProfileViewModel.updateBankData$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.profile.updateprofile.UpdateProfileViewModel$updateBankData$2
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
                mutableLiveData = UpdateProfileViewModel.this.updateResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.profile.updateprofile.UpdateProfileViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UpdateProfileViewModel.updateBankData$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateBankData$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateBankData$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<UpdateProfile>> getResponse() {
        return this.updateResponse;
    }
}