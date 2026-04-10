package in.etuwa.app.ui.changepassword;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.repository.ChangePasswordRepository;
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

/* compiled from: ChangePasswordViewModel.kt */
/* loaded from: classes4.dex */
public final class ChangePasswordViewModel extends ViewModel {
    private final ChangePasswordRepository changePasswordRepository;
    private MutableLiveData<Resource<SuccessResponse>> changePasswordResponse;
    private final CompositeDisposable compositeDisposable;

    public ChangePasswordViewModel(ChangePasswordRepository changePasswordRepository) {
        Intrinsics.checkNotNullParameter(changePasswordRepository, "changePasswordRepository");
        this.changePasswordRepository = changePasswordRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.changePasswordResponse = new MutableLiveData<>();
    }

    public final MutableLiveData<Resource<SuccessResponse>> getChangePasswordResponse() {
        return this.changePasswordResponse;
    }

    public final void setChangePasswordResponse(MutableLiveData<Resource<SuccessResponse>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.changePasswordResponse = mutableLiveData;
    }

    public final void changePassword(String oldPassword, String newPassword, String newPasswordRepeat) {
        Intrinsics.checkNotNullParameter(oldPassword, "oldPassword");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        Intrinsics.checkNotNullParameter(newPasswordRepeat, "newPasswordRepeat");
        this.changePasswordResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.changePasswordRepository.getChangePasswordApiCall(oldPassword, newPassword, newPasswordRepeat).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.changepassword.ChangePasswordViewModel$changePassword$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SuccessResponse successResponse) {
                invoke2(successResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SuccessResponse successResponse) {
                ChangePasswordViewModel.this.getChangePasswordResponse().postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.changepassword.ChangePasswordViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChangePasswordViewModel.changePassword$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.changepassword.ChangePasswordViewModel$changePassword$2
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
                ChangePasswordViewModel.this.getChangePasswordResponse().postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.changepassword.ChangePasswordViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChangePasswordViewModel.changePassword$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void changePassword$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void changePassword$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}