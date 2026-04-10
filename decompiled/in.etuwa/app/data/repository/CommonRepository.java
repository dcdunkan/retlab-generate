package in.etuwa.app.data.repository;

import com.google.gson.Gson;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.centralizedinfo.CentralizedInfoResponse;
import in.etuwa.app.data.model.common.Circular;
import in.etuwa.app.data.model.common.Remarks;
import in.etuwa.app.data.model.common.TeacherResponse;
import in.etuwa.app.data.model.due.DueResponse;
import in.etuwa.app.data.model.due.duepay.DuePayUrl;
import in.etuwa.app.data.model.due.duepay.NoDueCertificateResponse;
import in.etuwa.app.data.model.due.duepaynew.DuePayNewResponse;
import in.etuwa.app.data.model.examschedules.ExamScheduleResponse;
import in.etuwa.app.data.model.live.LiveResponse;
import in.etuwa.app.data.model.noticeboard.NoticeJeccResponse;
import in.etuwa.app.data.model.noticeboard.NoticeResponse;
import in.etuwa.app.data.model.placement.Placement;
import in.etuwa.app.data.model.placement.PlacementRequest;
import in.etuwa.app.data.network.ApiHelper;
import in.etuwa.app.data.preference.SharedPrefManager;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommonRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CommonRepository {
    private final ApiHelper apiHelper;
    private final SharedPrefManager sharedPref;

    public CommonRepository(ApiHelper apiHelper, SharedPrefManager sharedPref) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        Intrinsics.checkNotNullParameter(sharedPref, "sharedPref");
        this.apiHelper = apiHelper;
        this.sharedPref = sharedPref;
    }

    public final Single<ArrayList<Semester>> getSemestersApiCall() {
        return this.apiHelper.getSemestersApiCall();
    }

    public final Single<NoticeResponse> getNoticeClassApiCall() {
        return this.apiHelper.getNoticeClassApiCall();
    }

    public final Single<NoticeJeccResponse> getNoticeClassJeccApiCall() {
        return this.apiHelper.getNoticeClassJeccApiCall();
    }

    public final Single<ArrayList<Remarks>> getRemarksApiCall() {
        return this.apiHelper.getRemarksApiCall();
    }

    public final Single<ExamScheduleResponse> getExamsApiCall() {
        return this.apiHelper.getExamsApiCall();
    }

    public final Single<ArrayList<Circular>> getCircularsApiCall() {
        return this.apiHelper.getCircularsApiCall();
    }

    public final Single<ArrayList<Placement>> getPlacementsApiCall() {
        return this.apiHelper.getPlacementsApiCall();
    }

    public final Single<SuccessResponse> applyPlacementsApiCall(PlacementRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.applyPlacementsApiCall(request);
    }

    public final Single<TeacherResponse> getTeacherApiCall() {
        return this.apiHelper.getTeacherApiCall();
    }

    public final Single<CentralizedInfoResponse> getCentralizedInfoApiCall() {
        return this.apiHelper.getCentralizedInfoApiCall();
    }

    public final Single<LiveResponse> getLiveTvApiCall() {
        return this.apiHelper.getLiveTvApiCall();
    }

    public final Single<DueResponse> getDuesApiCall() {
        return this.apiHelper.getDuesApiCall();
    }

    public final Single<DuePayNewResponse> getDuePay() {
        return this.apiHelper.getDuePay();
    }

    public final Single<DuePayUrl> getDuePayUrlApiCall(Map<String, String> dueFeeCollection, Map<String, String> dueFeeReceipt) {
        Intrinsics.checkNotNullParameter(dueFeeCollection, "dueFeeCollection");
        Intrinsics.checkNotNullParameter(dueFeeReceipt, "dueFeeReceipt");
        return this.apiHelper.getDuePayUrlApiCall(dueFeeCollection, dueFeeReceipt);
    }

    public final Single<NoDueCertificateResponse> getNoDueCertificate() {
        return this.apiHelper.getNoDueCertificate();
    }

    public final void saveTeacherCache(TeacherResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        String json = new Gson().toJson(response);
        SharedPrefManager sharedPrefManager = this.sharedPref;
        Intrinsics.checkNotNullExpressionValue(json, "json");
        sharedPrefManager.saveString("teacher_cache", json);
        this.sharedPref.saveLong("teacher_cache_time", System.currentTimeMillis());
    }

    public final String getCachedTeacher() {
        return this.sharedPref.getString("teacher_cache");
    }

    public final long getTeacherCacheTime() {
        return this.sharedPref.getLong("teacher_cache_time");
    }

    public final TeacherResponse parseTeacher(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        Object objFromJson = new Gson().fromJson(json, (Class<Object>) TeacherResponse.class);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "Gson().fromJson(json, TeacherResponse::class.java)");
        return (TeacherResponse) objFromJson;
    }
}