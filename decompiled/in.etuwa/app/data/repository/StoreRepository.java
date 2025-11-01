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

/* compiled from: StoreRepository.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\u0006J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\u0012\u001a\u00020\u000bJ\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bJ$\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00160\rj\b\u0012\u0004\u0012\u00020\u0016`\u000f0\u00062\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/data/repository/StoreRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getCategoryApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/store/departmentlist/DepartmentListResponse;", "getDepartmentApiCall", "getSemesterListApiCall", "dept_id", "", "getSemestersApiCall", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/Semester;", "Lkotlin/collections/ArrayList;", "getStoreDataApiCall", "Lin/etuwa/app/data/model/store/StoreResponse;", "subjectId", "getSubjectListApiCall", "sem_id", "getSubjectsApiCall", "Lin/etuwa/app/data/model/subject/Subjects;", "request", "Lin/etuwa/app/data/model/materials/MaterialRequest;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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