package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.assignment.AssignmentRequest;
import in.etuwa.app.data.model.assignment.AssignmentResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: AssignmentRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AssignmentRepository {
    private final ApiHelper apiHelper;

    public AssignmentRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ArrayList<Semester>> getSemestersApiCall() {
        return this.apiHelper.getSemestersApiCall();
    }

    public final Single<AssignmentResponse> getAssignmentApiCall(AssignmentRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getAssignmentApiCall(request);
    }

    public final Single<SuccessResponse> deleteAssignmentApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteAssignmentApiCall(id);
    }

    public final Observable<SuccessResponse> uploadAssignmentApiCall(RequestBody username, RequestBody password, RequestBody id, RequestBody link, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(link, "link");
        return this.apiHelper.uploadAssignmentApiCall(username, password, id, link, file);
    }
}