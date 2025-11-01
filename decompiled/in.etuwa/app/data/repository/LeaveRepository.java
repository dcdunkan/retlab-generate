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

/* compiled from: LeaveRepository.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\b\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J6\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010J.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ$\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c0\u00062\u0006\u0010\u001d\u001a\u00020\u001eJ\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00062\u0006\u0010\b\u001a\u00020\tJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0006J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0006J\u001c\u0010%\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020&0\u001aj\b\u0012\u0004\u0012\u00020&`\u001c0\u0006J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ$\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ>\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lin/etuwa/app/data/repository/LeaveRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "addDutyLeaveDirectDatesApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/SuccessResponse;", "id", "", "date", "hour", "applyDutyLeaveApiCall", "Lio/reactivex/Observable;", "Lokhttp3/RequestBody;", "file", "Lokhttp3/MultipartBody$Part;", "applyDutyLeaveDirectViewApiCall", "reason", "headId", "fromDate", "toDate", "uploadFile", "applyMedicalLeaveApiCall", "deleteDutyLeaveDirectViewApiCall", "getDutyLeaveApiCall", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/leave/duty/DutyLeave;", "Lkotlin/collections/ArrayList;", "request", "Lin/etuwa/app/data/model/leave/duty/DutyLeaveViewRequest;", "getDutyLeaveDirectDatesApiCall", "Lin/etuwa/app/data/model/leave/duty/DutyLeaveDateResponse;", "getDutyLeaveDirectHeadApiCall", "Lin/etuwa/app/data/model/leave/duty/DutyLeaveHeadResponse;", "getDutyLeaveDirectViewApiCall", "Lin/etuwa/app/data/model/leave/duty/DutyLeaveDirectApplyResponse;", "getMedicalLeaveApiCall", "Lin/etuwa/app/data/model/leave/medical/MedicalLeave;", "removeDateHourDutyLeaveDirectDatesApiCall", "removeDutyLeaveDirectDatesApiCall", "updateDutyLeaveDirectViewApiCall", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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