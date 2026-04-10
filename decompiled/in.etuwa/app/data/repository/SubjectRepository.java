package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.materials.MaterialRequest;
import in.etuwa.app.data.model.subject.Subjects;
import in.etuwa.app.data.model.subject.co.CoModel;
import in.etuwa.app.data.model.subject.co.CoSyllabusRequest;
import in.etuwa.app.data.model.subject.coverage.SubCoverageResponse;
import in.etuwa.app.data.model.subject.syllabus.SyllabusResponse;
import in.etuwa.app.data.network.ApiHelper;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import io.reactivex.Single;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubjectRepository.kt */
/* loaded from: classes3.dex */
public final class SubjectRepository {
    private final ApiHelper apiHelper;

    public SubjectRepository(ApiHelper apiHelper) {
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

    public final Single<SyllabusResponse> getSyllabusApiCall(CoSyllabusRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getSyllabusApiCall(request);
    }

    public final Single<ArrayList<CoModel>> getCourseOutcomeApiCall(CoSyllabusRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getCourseOutcomeApiCall(request);
    }

    public final Single<SubCoverageResponse> getSubjectCoverageApiCall(String subId, String batchId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        return this.apiHelper.getSubjectCoverageApiCall(subId, batchId);
    }
}