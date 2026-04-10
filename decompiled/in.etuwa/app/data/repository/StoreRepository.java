package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.materials.MaterialRequest;
import in.etuwa.app.data.model.store.StoreResponse;
import in.etuwa.app.data.model.store.departmentlist.DepartmentListResponse;
import in.etuwa.app.data.model.subject.Subjects;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StoreRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StoreRepository {
    private final ApiHelper apiHelper;

    public StoreRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ArrayList<Semester>> getSemestersApiCall() {
        return this.apiHelper.getSemestersApiCall();
    }

    public final Single<ArrayList<Subjects>> getSubjectsApiCall(MaterialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getSubjectsApiCall(request);
    }

    public final Single<DepartmentListResponse> getDepartmentApiCall() {
        return this.apiHelper.getDepartmentApiCall();
    }

    public final Single<DepartmentListResponse> getSemesterListApiCall(String dept_id) {
        Intrinsics.checkNotNullParameter(dept_id, "dept_id");
        return this.apiHelper.getSemesterListApiCall(dept_id);
    }

    public final Single<DepartmentListResponse> getSubjectListApiCall(String dept_id, String sem_id) {
        Intrinsics.checkNotNullParameter(dept_id, "dept_id");
        Intrinsics.checkNotNullParameter(sem_id, "sem_id");
        return this.apiHelper.getSubjectListApiCall(dept_id, sem_id);
    }

    public final Single<DepartmentListResponse> getCategoryApiCall() {
        return this.apiHelper.getCategoryApiCall();
    }

    public final Single<StoreResponse> getStoreDataApiCall(String subjectId) {
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        return this.apiHelper.getStoreDataApiCall(subjectId);
    }
}