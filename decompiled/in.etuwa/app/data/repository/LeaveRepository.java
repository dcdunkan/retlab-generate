package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.leave.duty.DutyLeave;
import in.etuwa.app.data.model.leave.duty.DutyLeaveDateResponse;
import in.etuwa.app.data.model.leave.duty.DutyLeaveDirectApplyResponse;
import in.etuwa.app.data.model.leave.duty.DutyLeaveHeadResponse;
import in.etuwa.app.data.model.leave.duty.DutyLeaveViewRequest;
import in.etuwa.app.data.model.leave.medical.MedicalLeave;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: LeaveRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LeaveRepository {
    private final ApiHelper apiHelper;

    public LeaveRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ArrayList<MedicalLeave>> getMedicalLeaveApiCall() {
        return this.apiHelper.getMedicalLeaveApiCall();
    }

    public final Observable<SuccessResponse> applyMedicalLeaveApiCall(RequestBody reason, RequestBody fromDate, RequestBody toDate, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiHelper.applyMedicalLeaveApiCall(reason, fromDate, toDate, file);
    }

    public final Observable<SuccessResponse> applyDutyLeaveApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.applyDutyLeaveApiCall(id, file);
    }

    public final Single<ArrayList<DutyLeave>> getDutyLeaveApiCall(DutyLeaveViewRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getDutyLeaveApiCall(request);
    }

    public final Single<DutyLeaveDirectApplyResponse> getDutyLeaveDirectViewApiCall() {
        return this.apiHelper.getDutyLeaveDirectViewApiCall();
    }

    public final Single<SuccessResponse> deleteDutyLeaveDirectViewApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteDutyLeaveDirectViewApiCall(id);
    }

    public final Single<SuccessResponse> applyDutyLeaveDirectViewApiCall(RequestBody reason, RequestBody headId, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(headId, "headId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiHelper.applyDutyLeaveDirectViewApiCall(reason, headId, fromDate, toDate, uploadFile);
    }

    public final Single<SuccessResponse> updateDutyLeaveDirectViewApiCall(RequestBody id, RequestBody reason, RequestBody headId, RequestBody fromDate, RequestBody toDate, MultipartBody.Part uploadFile) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(headId, "headId");
        Intrinsics.checkNotNullParameter(fromDate, "fromDate");
        Intrinsics.checkNotNullParameter(toDate, "toDate");
        return this.apiHelper.updateDutyLeaveDirectViewApiCall(id, reason, headId, fromDate, toDate, uploadFile);
    }

    public final Single<DutyLeaveHeadResponse> getDutyLeaveDirectHeadApiCall() {
        return this.apiHelper.getDutyLeaveDirectHeadApiCall();
    }

    public final Single<DutyLeaveDateResponse> getDutyLeaveDirectDatesApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getDutyLeaveDirectDatesApiCall(id);
    }

    public final Single<SuccessResponse> addDutyLeaveDirectDatesApiCall(String id, String date, String hour) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(hour, "hour");
        return this.apiHelper.addDutyLeaveDirectDatesApiCall(id, date, hour);
    }

    public final Single<SuccessResponse> removeDutyLeaveDirectDatesApiCall(String id, String date, String hour) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(hour, "hour");
        return this.apiHelper.removeDutyLeaveDirectDatesApiCall(id, date, hour);
    }

    public final Single<SuccessResponse> removeDateHourDutyLeaveDirectDatesApiCall(String id, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiHelper.removeDateHourDutyLeaveDirectDatesApiCall(id, date);
    }
}