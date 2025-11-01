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

/* compiled from: ExamRepository.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\r\u001a\u00020\tJ\u001c\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00110\u0006J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\u0014\u001a\u00020\u0015J.\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ.\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/data/repository/ExamRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "deleteModuleTestApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/SuccessResponse;", "id", "", "deleteSeriesExamApiCall", "getModuleTestApiCall", "Lin/etuwa/app/data/model/exam/ModuleTestResponse;", "new", "getSemestersApiCall", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/Semester;", "Lkotlin/collections/ArrayList;", "getSeriesExamApiCall", "Lin/etuwa/app/data/model/exam/SeriesExamResponse;", "request", "Lin/etuwa/app/data/model/attendance/AttendanceRequest;", "uploadModuleTestApiCall", "Lio/reactivex/Observable;", "username", "Lokhttp3/RequestBody;", "password", "file", "Lokhttp3/MultipartBody$Part;", "uploadSeriesExamApiCall", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    public final Single<ModuleTestResponse> getModuleTestApiCall(String r2) {
        Intrinsics.checkNotNullParameter(r2, "new");
        return this.apiHelper.getModuleTestApiCall(r2);
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