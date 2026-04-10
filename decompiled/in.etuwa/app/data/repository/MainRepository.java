package in.etuwa.app.data.repository;

import androidx.core.app.NotificationCompat;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.calendar.CalendarResponse;
import in.etuwa.app.data.model.login.LogoutRequest;
import in.etuwa.app.data.model.main.ApplyHostelResponse;
import in.etuwa.app.data.model.main.FeeStatusResponse;
import in.etuwa.app.data.model.main.PushRequest;
import in.etuwa.app.data.model.main.PushResponse;
import in.etuwa.app.data.model.transportpalai.BusPass;
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

/* JADX INFO: compiled from: MainRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MainRepository implements KoinComponent {
    private final ApiHelper apiHelper;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    public MainRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
        final MainRepository mainRepository = this;
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.data.repository.MainRepository$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                Scope rootScope;
                KoinComponent koinComponent = mainRepository;
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

    public final Single<SuccessResponse> doLogoutApiCall(LogoutRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.doLogoutApiCall(request);
    }

    public final Single<PushResponse> sendPushToken(PushRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.sendPushToken(request);
    }

    public final void setPushTokenStatus(boolean status) {
        getPreference().setPushTokenServerStatus(status);
    }

    public final Single<CalendarResponse> getCalendarEvents() {
        return this.apiHelper.getCalendarEvents();
    }

    public final Single<ApplyHostelResponse> applyHostelApiCall() {
        return this.apiHelper.applyHostelApiCall();
    }

    public final Single<FeeStatusResponse> getFeeStatusApiCall() {
        return this.apiHelper.getFeeStatusApiCall();
    }

    public final void setHostel(int hostel, String hostelStatus) {
        Intrinsics.checkNotNullParameter(hostelStatus, "hostelStatus");
        getPreference().setHostelStatus(hostel, hostelStatus);
    }

    public final Single<BusPass> getTransportBusPassApiCall() {
        return this.apiHelper.getTransportBusPassApiCall();
    }
}