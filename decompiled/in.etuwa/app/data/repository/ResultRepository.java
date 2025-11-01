package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.attendance.AttendanceRequest;
import in.etuwa.app.data.model.result.ResultAssignment;
import in.etuwa.app.data.model.result.ResultInternal;
import in.etuwa.app.data.model.result.ResultSeasonal;
import in.etuwa.app.data.model.result.SeasonRequest;
import in.etuwa.app.data.model.result.moduletest.ResultModuleTestResponse;
import in.etuwa.app.data.model.result.tutorial.TutorialResultResponse;
import in.etuwa.app.data.model.result.univ.UnivResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultRepository.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u00062\u0006\u0010\n\u001a\u00020\u000bJ$\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\u0007j\b\u0012\u0004\u0012\u00020\r`\t0\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\n\u001a\u00020\u000bJ$\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0007j\b\u0012\u0004\u0012\u00020\u0011`\t0\u00062\u0006\u0010\n\u001a\u00020\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00160\u0007j\b\u0012\u0004\u0012\u00020\u0016`\t0\u0006J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/repository/ResultRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getResultAssignmentApiCall", "Lio/reactivex/Single;", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/result/ResultAssignment;", "Lkotlin/collections/ArrayList;", "request", "Lin/etuwa/app/data/model/attendance/AttendanceRequest;", "getResultInternalApiCall", "Lin/etuwa/app/data/model/result/ResultInternal;", "getResultModuleTestApiCall", "Lin/etuwa/app/data/model/result/moduletest/ResultModuleTestResponse;", "getResultSeasonalApiCall", "Lin/etuwa/app/data/model/result/ResultSeasonal;", "Lin/etuwa/app/data/model/result/SeasonRequest;", "getResultUnivApiCall", "Lin/etuwa/app/data/model/result/univ/UnivResponse;", "getSemestersApiCall", "Lin/etuwa/app/data/model/Semester;", "getTutorialResultApiCall", "Lin/etuwa/app/data/model/result/tutorial/TutorialResultResponse;", "semId", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResultRepository {
    private final ApiHelper apiHelper;

    public ResultRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ArrayList<Semester>> getSemestersApiCall() {
        return this.apiHelper.getSemestersApiCall();
    }

    public final Single<ArrayList<ResultAssignment>> getResultAssignmentApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getResultAssignmentApiCall(request);
    }

    public final Single<ArrayList<ResultSeasonal>> getResultSeasonalApiCall(SeasonRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getResultSeasonalApiCall(request);
    }

    public final Single<ResultModuleTestResponse> getResultModuleTestApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getResultModuleTestApiCall(request);
    }

    public final Single<TutorialResultResponse> getTutorialResultApiCall(String semId) {
        Intrinsics.checkNotNullParameter(semId, "semId");
        return this.apiHelper.getTutorialResultApiCall(semId);
    }

    public final Single<ArrayList<ResultInternal>> getResultInternalApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getResultInternalApiCall(request);
    }

    public final Single<UnivResponse> getResultUnivApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getResultUnivApiCall(request);
    }
}