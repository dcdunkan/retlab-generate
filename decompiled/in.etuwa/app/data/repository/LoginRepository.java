package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.institutions.Colleges;
import in.etuwa.app.data.model.institutions.Institution;
import in.etuwa.app.data.model.login.LoginRequest;
import in.etuwa.app.data.model.login.LoginResponse;
import in.etuwa.app.data.model.resetpassword.ResetPassword;
import in.etuwa.app.data.network.ApiHelper;
import in.etuwa.app.data.preference.SharedPrefManager;
import io.reactivex.Single;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* compiled from: LoginRepository.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eJ\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eJ\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/data/repository/LoginRepository;", "Lorg/koin/core/component/KoinComponent;", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "clearPreference", "", "doLoginApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/login/LoginResponse;", "request", "Lin/etuwa/app/data/model/login/LoginRequest;", "getDebugInstitutionsApiCall", "Lin/etuwa/app/data/model/institutions/Institution;", "getInstitutionsApiCall", "getRegistrationApiCall", "Lin/etuwa/app/data/model/resetpassword/ResetPassword;", "setCollege", "college", "Lin/etuwa/app/data/model/institutions/Colleges;", "storeUser", "", "response", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LoginRepository implements KoinComponent {
    private final ApiHelper apiHelper;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    public LoginRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
        final LoginRepository loginRepository = this;
        LazyThreadSafetyMode defaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(defaultLazyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.data.repository.LoginRepository$special$$inlined$inject$default$1
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
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final Single<Institution> getDebugInstitutionsApiCall() {
        return this.apiHelper.getDebugInstitutionsApiCall();
    }

    public final Single<Institution> getInstitutionsApiCall() {
        return this.apiHelper.getInstitutions();
    }

    public final Single<LoginResponse> doLoginApiCall(LoginRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.doLogin(request);
    }

    public final void setCollege(Colleges college) {
        Intrinsics.checkNotNullParameter(college, "college");
        getPreference().setClg(true, Integer.parseInt(college.getClgId()), college.getBaseUrl(), college.getRegUrl());
    }

    public final boolean storeUser(LoginResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        getPreference().setLogin(response.getAccessToken(), response.getUserType(), response.getHostel(), response.getHostelStatus(), response.getProfileName(), response.getAcademicYear(), response.getUniv(), response.getPhotoUrl(), response.getSemName(), response.getSemId(), response.getCourse(), response.getUsername(), response.getPassword(), response.getStartYear(), response.getEndYear(), response.getBatchId());
        return true;
    }

    public final Single<ResetPassword> getRegistrationApiCall() {
        return this.apiHelper.getRegistrationApiCall();
    }

    public final void clearPreference() {
        getPreference().clearData();
    }
}