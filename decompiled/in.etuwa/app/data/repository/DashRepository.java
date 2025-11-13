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
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\fJ\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\f2\u0006\u0010\u0018\u001a\u00020\u000fJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\fJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\fJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\fJ\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\fJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\fJ\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\fJ\u001c\u0010%\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(0\fJ\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\fJ\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\fJ\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\fJ\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\fJF\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<J \u0010=\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0?J \u0010@\u001a\b\u0012\u0004\u0012\u00020\r0A2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u00010CJ \u0010E\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0?R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006F"}, d2 = {"Lin/etuwa/app/data/repository/DashRepository;", "Lorg/koin/core/component/KoinComponent;", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "Lkotlin/Lazy;", "getAbcUpdateApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/SuccessResponse;", "id", "", "getAbcViewApiCall", "Lin/etuwa/app/data/model/dash/AbcResponse;", "getCourseSurveyPendingStatusUrlApiCall", "Lin/etuwa/app/data/model/main/CourseSurveyPending;", "getDashApiCall", "Lin/etuwa/app/data/model/dash/DashResponse;", "getDayWiseTimeTable", "Lin/etuwa/app/data/model/dash/daywisetimetaable/DayWiseResponse;", "date", "getDigitalLibraryApiCall", "Lin/etuwa/app/data/model/dash/LibraryResponse;", "getMaintenanceUrl", "Lin/etuwa/app/data/model/dash/MaintenanceResponse;", "getNoticeClassApiCall", "Lin/etuwa/app/data/model/noticeboard/NoticeResponse;", "getPendingSurveyUrl", "Lin/etuwa/app/data/model/dash/PendingSurvey;", "getPoSurveyPendingStatusUrlApiCall", "Lin/etuwa/app/data/model/main/POSurveyPending;", "getProfileApiCall", "Lin/etuwa/app/data/model/dash/ProfileResponse;", "getSemestersApiCall", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/Semester;", "Lkotlin/collections/ArrayList;", "getSurveyMandatoryStatusUrlApiCall", "Lin/etuwa/app/data/model/main/SurveyMandatory;", "getSurveyPendingStatusUrlApiCall", "Lin/etuwa/app/data/model/main/SurveyPending;", "getTimetableApiCall", "Lin/etuwa/app/data/model/timetable/TimetableResponse;", "getUpdateProfileApiCall", "Lin/etuwa/app/data/model/updateprofile/UpdateProfile;", "setUpdatedValues", "", "batchId", "semId", "semName", "hostelStatus", "hostel", "", "course", "img", "logout_status", "", "updateBankDetailsApiCall", "studentDetails", "", "updateProPicApiCall", "Lio/reactivex/Observable;", "file", "Lokhttp3/MultipartBody$Part;", "sign", "verifyBankDetailsApiCall", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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