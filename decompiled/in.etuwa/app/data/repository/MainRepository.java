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

/* compiled from: MainRepository.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\fJ\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\fJ\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u0010\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006$"}, d2 = {"Lin/etuwa/app/data/repository/MainRepository;", "Lorg/koin/core/component/KoinComponent;", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "applyHostelApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/main/ApplyHostelResponse;", "doLogoutApiCall", "Lin/etuwa/app/data/model/SuccessResponse;", "request", "Lin/etuwa/app/data/model/login/LogoutRequest;", "getCalendarEvents", "Lin/etuwa/app/data/model/calendar/CalendarResponse;", "getFeeStatusApiCall", "Lin/etuwa/app/data/model/main/FeeStatusResponse;", "getTransportBusPassApiCall", "Lin/etuwa/app/data/model/transportpalai/BusPass;", "sendPushToken", "Lin/etuwa/app/data/model/main/PushResponse;", "Lin/etuwa/app/data/model/main/PushRequest;", "setHostel", "", "hostel", "", "hostelStatus", "", "setPushTokenStatus", NotificationCompat.CATEGORY_STATUS, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MainRepository implements KoinComponent {
    private final ApiHelper apiHelper;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    public MainRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
        final MainRepository mainRepository = this;
        LazyThreadSafetyMode defaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(defaultLazyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.data.repository.MainRepository$special$$inlined$inject$default$1
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