package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.dash.AbcResponse;
import in.etuwa.app.data.model.dash.DashResponse;
import in.etuwa.app.data.model.dash.LibraryResponse;
import in.etuwa.app.data.model.dash.MaintenanceResponse;
import in.etuwa.app.data.model.dash.PendingSurvey;
import in.etuwa.app.data.model.dash.ProfileResponse;
import in.etuwa.app.data.model.dash.daywisetimetaable.DayWiseResponse;
import in.etuwa.app.data.model.main.CourseSurveyPending;
import in.etuwa.app.data.model.main.POSurveyPending;
import in.etuwa.app.data.model.main.SurveyMandatory;
import in.etuwa.app.data.model.main.SurveyPending;
import in.etuwa.app.data.model.noticeboard.NoticeResponse;
import in.etuwa.app.data.model.timetable.TimetableResponse;
import in.etuwa.app.data.model.updateprofile.UpdateProfile;
import in.etuwa.app.data.network.ApiHelper;
import in.etuwa.app.data.preference.SharedPrefManager;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.MultipartBody;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* compiled from: DashRepository.kt */
/* loaded from: classes3.dex */
public final class DashRepository implements KoinComponent {
    private final ApiHelper apiHelper;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    public DashRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
        final DashRepository dashRepository = this;
        LazyThreadSafetyMode defaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(defaultLazyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.data.repository.DashRepository$special$$inlined$inject$default$1
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

    public final Single<ArrayList<Semester>> getSemestersApiCall() {
        return this.apiHelper.getSemestersApiCall();
    }

    public final Single<DashResponse> getDashApiCall() {
        return this.apiHelper.getDashApiCall();
    }

    public final void setUpdatedValues(String batchId, String semId, String semName, String hostelStatus, int hostel, String course, String img, boolean logout_status) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(semId, "semId");
        Intrinsics.checkNotNullParameter(semName, "semName");
        Intrinsics.checkNotNullParameter(hostelStatus, "hostelStatus");
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(img, "img");
        getPreference().setUpdateUserData(batchId, semId, semName, hostelStatus, hostel, course, img);
    }

    public final Observable<SuccessResponse> updateProPicApiCall(MultipartBody.Part file, MultipartBody.Part sign) {
        return this.apiHelper.updateProPicApiCall(file, sign);
    }

    public final Single<NoticeResponse> getNoticeClassApiCall() {
        return this.apiHelper.getNoticeClassApiCall();
    }

    public final Single<TimetableResponse> getTimetableApiCall() {
        return this.apiHelper.getTimetableApiCall();
    }

    public final Single<LibraryResponse> getDigitalLibraryApiCall() {
        return this.apiHelper.getDigitalLibraryApiCall();
    }

    public final Single<ProfileResponse> getProfileApiCall() {
        return this.apiHelper.getProfileApiCall();
    }

    public final Single<SuccessResponse> updateBankDetailsApiCall(Map<String, String> studentDetails) {
        Intrinsics.checkNotNullParameter(studentDetails, "studentDetails");
        return this.apiHelper.updateBankDetailsApiCall(studentDetails);
    }

    public final Single<SuccessResponse> verifyBankDetailsApiCall(Map<String, String> studentDetails) {
        Intrinsics.checkNotNullParameter(studentDetails, "studentDetails");
        return this.apiHelper.verifyBankDetailsApiCall(studentDetails);
    }

    public final Single<AbcResponse> getAbcViewApiCall() {
        return this.apiHelper.getAbcViewApiCall();
    }

    public final Single<SuccessResponse> getAbcUpdateApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getAbcUpdateApiCall(id);
    }

    public final Single<UpdateProfile> getUpdateProfileApiCall() {
        return this.apiHelper.getUpdateProfileApiCall();
    }

    public final Single<DayWiseResponse> getDayWiseTimeTable(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiHelper.getDayWiseTimeTable(date);
    }

    public final Single<MaintenanceResponse> getMaintenanceUrl() {
        return this.apiHelper.getMaintenanceUrl();
    }

    public final Single<PendingSurvey> getPendingSurveyUrl() {
        return this.apiHelper.getPendingSurveyUrl();
    }

    public final Single<SurveyPending> getSurveyPendingStatusUrlApiCall() {
        return this.apiHelper.getSurveyPendingStatusUrlApiCall();
    }

    public final Single<POSurveyPending> getPoSurveyPendingStatusUrlApiCall() {
        return this.apiHelper.getPoSurveyPendingStatusUrlApiCall();
    }

    public final Single<CourseSurveyPending> getCourseSurveyPendingStatusUrlApiCall() {
        return this.apiHelper.getCourseSurveyPendingStatusUrlApiCall();
    }

    public final Single<SurveyMandatory> getSurveyMandatoryStatusUrlApiCall() {
        return this.apiHelper.getSurveyMandatoryStatusUrlApiCall();
    }
}