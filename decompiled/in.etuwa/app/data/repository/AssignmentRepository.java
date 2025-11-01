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

/* compiled from: AssignmentRepository.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00110\u0006J.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/data/repository/AssignmentRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "deleteAssignmentApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/SuccessResponse;", "id", "", "getAssignmentApiCall", "Lin/etuwa/app/data/model/assignment/AssignmentResponse;", "request", "Lin/etuwa/app/data/model/assignment/AssignmentRequest;", "getSemestersApiCall", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/Semester;", "Lkotlin/collections/ArrayList;", "uploadAssignmentApiCall", "Lio/reactivex/Observable;", "username", "Lokhttp3/RequestBody;", "password", "file", "Lokhttp3/MultipartBody$Part;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    public final Observable<SuccessResponse> uploadAssignmentApiCall(RequestBody username, RequestBody password, RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.uploadAssignmentApiCall(username, password, id, file);
    }
}