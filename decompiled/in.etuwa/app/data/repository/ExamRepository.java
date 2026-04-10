package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.attendance.AttendanceRequest;
import in.etuwa.app.data.model.exam.ModuleTestResponse;
import in.etuwa.app.data.model.exam.SeriesExamResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: ExamRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ExamRepository {
    private final ApiHelper apiHelper;

    public ExamRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ArrayList<Semester>> getSemestersApiCall() {
        return this.apiHelper.getSemestersApiCall();
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

    public final Observable<SuccessResponse> uploadSeriesExamApiCall(RequestBody username, RequestBody password, RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.uploadSeriesExamApiCall(username, password, id, file);
    }

    public final Observable<SuccessResponse> uploadModuleTestApiCall(RequestBody username, RequestBody password, RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.uploadModuleTestApiCall(username, password, id, file);
    }
}