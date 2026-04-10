package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.assignment.AssignmentRequest;
import in.etuwa.app.data.model.assignment.AssignmentResponse;
import in.etuwa.app.data.model.attendance.AttendanceRequest;
import in.etuwa.app.data.model.exam.ModuleTestResponse;
import in.etuwa.app.data.model.exam.SeriesExamResponse;
import in.etuwa.app.data.model.homework.HomeWorkResponse;
import in.etuwa.app.data.model.tutorial.TutorialResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EvaluationRepository {
    private final ApiHelper apiHelper;

    public EvaluationRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<AssignmentResponse> getAssignmentApiCall(AssignmentRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getAssignmentApiCall(request);
    }

    public final Single<SuccessResponse> deleteAssignmentApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteAssignmentApiCall(id);
    }

    public final Single<SeriesExamResponse> getSeriesExamApiCall(AttendanceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getSeriesExamApiCall(request);
    }

    public final Single<ModuleTestResponse> getModuleTestApiCall(String str) {
        Intrinsics.checkNotNullParameter(str, "new");
        return this.apiHelper.getModuleTestApiCall(str);
    }

    public final Single<SuccessResponse> deleteSeriesExamApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteSeriesExamApiCall(id);
    }

    public final Single<SuccessResponse> deleteModuleTestApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteModuleTestApiCall(id);
    }

    public final Single<TutorialResponse> getTutorialsApiCall() {
        return this.apiHelper.getTutorialsApiCall();
    }

    public final Single<SuccessResponse> deleteTutorialApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteTutorialApiCall(id);
    }

    public final Single<HomeWorkResponse> getHomeWorksApiCall() {
        return this.apiHelper.getHomeWorksApiCall();
    }

    public final Single<SuccessResponse> deleteHomeWorkApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteHomeWorkApiCall(id);
    }
}