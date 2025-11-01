package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.centralizedinfo.CentralizedInfoResponse;
import in.etuwa.app.data.model.common.Circular;
import in.etuwa.app.data.model.common.Remarks;
import in.etuwa.app.data.model.common.TeacherResponse;
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
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonRepository.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006J\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\u0006J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006J4\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0006J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0006J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0006J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0006J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0006J\u001c\u0010#\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020$0\rj\b\u0012\u0004\u0012\u00020$`\u000f0\u0006J\u001c\u0010%\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020&0\rj\b\u0012\u0004\u0012\u00020&`\u000f0\u0006J\u001c\u0010'\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020(0\rj\b\u0012\u0004\u0012\u00020(`\u000f0\u0006J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lin/etuwa/app/data/repository/CommonRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "applyPlacementsApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/SuccessResponse;", "request", "Lin/etuwa/app/data/model/placement/PlacementRequest;", "getCentralizedInfoApiCall", "Lin/etuwa/app/data/model/centralizedinfo/CentralizedInfoResponse;", "getCircularsApiCall", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/common/Circular;", "Lkotlin/collections/ArrayList;", "getDuePay", "Lin/etuwa/app/data/model/due/duepaynew/DuePayNewResponse;", "getDuePayUrlApiCall", "Lin/etuwa/app/data/model/due/duepay/DuePayUrl;", "dueFeeCollection", "", "", "dueFeeReceipt", "getDuesApiCall", "getExamsApiCall", "Lin/etuwa/app/data/model/examschedules/ExamScheduleResponse;", "getLiveTvApiCall", "Lin/etuwa/app/data/model/live/LiveResponse;", "getNoDueCertificate", "Lin/etuwa/app/data/model/due/duepay/NoDueCertificateResponse;", "getNoticeClassApiCall", "Lin/etuwa/app/data/model/noticeboard/NoticeResponse;", "getNoticeClassJeccApiCall", "Lin/etuwa/app/data/model/noticeboard/NoticeJeccResponse;", "getPlacementsApiCall", "Lin/etuwa/app/data/model/placement/Placement;", "getRemarksApiCall", "Lin/etuwa/app/data/model/common/Remarks;", "getSemestersApiCall", "Lin/etuwa/app/data/model/Semester;", "getTeacherApiCall", "Lin/etuwa/app/data/model/common/TeacherResponse;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CommonRepository {
    private final ApiHelper apiHelper;

    public CommonRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
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

    public final Single<DuePayNewResponse> getDuesApiCall() {
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
}