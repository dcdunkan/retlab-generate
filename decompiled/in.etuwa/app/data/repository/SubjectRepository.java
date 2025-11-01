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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\u0007j\b\u0012\u0004\u0012\u00020\r`\t0\u0006J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J$\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0007j\b\u0012\u0004\u0012\u00020\u0014`\t0\u00062\u0006\u0010\n\u001a\u00020\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/repository/SubjectRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getCourseOutcomeApiCall", "Lio/reactivex/Single;", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subject/co/CoModel;", "Lkotlin/collections/ArrayList;", "request", "Lin/etuwa/app/data/model/subject/co/CoSyllabusRequest;", "getSemestersApiCall", "Lin/etuwa/app/data/model/Semester;", "getSubjectCoverageApiCall", "Lin/etuwa/app/data/model/subject/coverage/SubCoverageResponse;", StoreFragmentKt.SUB_ID, "", "batchId", "getSubjectsApiCall", "Lin/etuwa/app/data/model/subject/Subjects;", "Lin/etuwa/app/data/model/materials/MaterialRequest;", "getSyllabusApiCall", "Lin/etuwa/app/data/model/subject/syllabus/SyllabusResponse;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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