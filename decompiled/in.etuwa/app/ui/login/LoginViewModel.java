package in.etuwa.app.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.etuwa.app.data.model.institutions.Colleges;
import in.etuwa.app.data.model.institutions.Institution;
import in.etuwa.app.data.model.login.LoginRequest;
import in.etuwa.app.data.model.login.LoginResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.data.repository.LoginRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* compiled from: LoginViewModel.kt */
/* loaded from: classes5.dex */
public final class LoginViewModel extends ViewModel implements KoinComponent {
    private final MutableLiveData<Resource<ArrayList<Colleges>>> colleges;
    private final CompositeDisposable compositeDisposable;
    private final LoginRepository loginRepository;
    private MutableLiveData<Resource<LoginResponse>> loginResponse;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    public LoginViewModel(LoginRepository loginRepository) {
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        this.loginRepository = loginRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.colleges = new MutableLiveData<>();
        this.loginResponse = new MutableLiveData<>();
        final LoginViewModel loginViewModel = this;
        LazyThreadSafetyMode defaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(defaultLazyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.login.LoginViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                Scope rootScope;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = b;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), qualifier2, function0);
            }
        });
        checkLogin();
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    private final void checkLogin() {
        if (getPreference().getLoginStatus()) {
            return;
        }
        clearPreference();
    }

    public final void fetchColleges() {
        this.colleges.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<Institution> observeOn = this.loginRepository.getInstitutionsApiCall().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<Institution, Unit> function1 = new Function1<Institution, Unit>() { // from class: in.etuwa.app.ui.login.LoginViewModel$fetchColleges$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Institution institution) {
                invoke2(institution);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Institution institution) {
                MutableLiveData mutableLiveData;
                mutableLiveData = LoginViewModel.this.colleges;
                mutableLiveData.postValue(Resource.INSTANCE.success(institution.getColleges()));
            }
        };
        Consumer<? super Institution> consumer = new Consumer() { // from class: in.etuwa.app.ui.login.LoginViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LoginViewModel.fetchColleges$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.login.LoginViewModel$fetchColleges$2
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
                mutableLiveData = LoginViewModel.this.colleges;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.login.LoginViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LoginViewModel.fetchColleges$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchColleges$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchColleges$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void validateCredentials(String userName, String password, String hostel) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(password, "password");
        this.colleges.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<LoginResponse> observeOn = this.loginRepository.doLoginApiCall(new LoginRequest(userName, password, hostel)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<LoginResponse, Unit> function1 = new Function1<LoginResponse, Unit>() { // from class: in.etuwa.app.ui.login.LoginViewModel$validateCredentials$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LoginResponse loginResponse) {
                invoke2(loginResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LoginResponse loginResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = LoginViewModel.this.loginResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(loginResponse));
            }
        };
        Consumer<? super LoginResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.login.LoginViewModel$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LoginViewModel.validateCredentials$lambda$2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.login.LoginViewModel$validateCredentials$2
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
                mutableLiveData = LoginViewModel.this.loginResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.login.LoginViewModel$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LoginViewModel.validateCredentials$lambda$3(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateCredentials$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateCredentials$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }

    public final MutableLiveData<Resource<ArrayList<Colleges>>> getColleges() {
        return this.colleges;
    }

    public final MutableLiveData<Resource<LoginResponse>> getResponse() {
        return this.loginResponse;
    }

    public final void setCollege(Colleges colleges) {
        Intrinsics.checkNotNullParameter(colleges, "colleges");
        this.loginRepository.setCollege(colleges);
    }

    public final boolean storeUserDetails(LoginResponse loginResponse) {
        Intrinsics.checkNotNullParameter(loginResponse, "loginResponse");
        this.loginRepository.storeUser(loginResponse);
        return true;
    }

    private final void clearPreference() {
        this.loginRepository.clearPreference();
    }
}