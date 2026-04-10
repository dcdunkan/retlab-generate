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

/* JADX INFO: compiled from: ResultRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
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