package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SemRegSuccessResponse;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.counselling.status.CounsellingStatusResponse;
import in.etuwa.app.data.model.semregistration.AcademicYearResponse;
import in.etuwa.app.data.model.semregistration.SemRegViewResponse;
import in.etuwa.app.data.model.semregistration.list.SemRegisterListResponse;
import in.etuwa.app.data.model.semregistration.view.SemRegSlip;
import in.etuwa.app.data.model.subjectregistration.SubjectRegistrationResponse;
import in.etuwa.app.data.model.subjectregistration.SubjectSpinnerResponse;
import in.etuwa.app.data.model.subjectregistration.SubjectsListResponse;
import in.etuwa.app.data.model.subjectregistration.ViewSubjectRegistrationResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: SemRegRepository.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\nJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006J\u001c\u0010\u0017\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a0\u0006J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0006J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00062\u0006\u0010\u000f\u001a\u00020\nJ\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00062\u0006\u0010\u000f\u001a\u00020\nJ\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00062\u0006\u0010\u000f\u001a\u00020\nJ \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ \u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ:\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\"\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020,0+j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020,`-2\b\u0010.\u001a\u0004\u0018\u00010/J \u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ(\u00100\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010\u000f\u001a\u00020\n2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJB\u00100\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010\u000f\u001a\u00020,2\"\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020,0+j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020,`-2\b\u0010.\u001a\u0004\u0018\u00010/J \u00101\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lin/etuwa/app/data/repository/SemRegRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "addAsietSemRegApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/SuccessResponse;", "semesterRegistration", "", "", "getCounsellingStatusApiCall", "Lin/etuwa/app/data/model/counselling/status/CounsellingStatusResponse;", "getRegistrationSlipUrl", "Lin/etuwa/app/data/model/semregistration/view/SemRegSlip;", "id", "getSemRegDetailsApiCall", "Lin/etuwa/app/data/model/semregistration/SemRegViewResponse;", "getSemRegDetailsMvjceApiCall", "getSemRegDropListApiCall", "Lin/etuwa/app/data/model/semregistration/AcademicYearResponse;", "getSemRegListApiCall", "Lin/etuwa/app/data/model/semregistration/list/SemRegisterListResponse;", "getSemestersApiCall", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/Semester;", "Lkotlin/collections/ArrayList;", "getSubjectRegistrationListApiCall", "Lin/etuwa/app/data/model/subjectregistration/SubjectRegistrationResponse;", "getSubjectRegistrationSpinnerApiCall", "Lin/etuwa/app/data/model/subjectregistration/SubjectSpinnerResponse;", "getSubjectRegistrationViewApiCall", "Lin/etuwa/app/data/model/subjectregistration/ViewSubjectRegistrationResponse;", "getSubjectsRegListApiCall", "Lin/etuwa/app/data/model/subjectregistration/SubjectsListResponse;", "registerSemsterNewApiCall", "SemRegistration", "registerSubjectRegistrationApiCall", "registerCollection", "semRegisterApiCall", "Lio/reactivex/Observable;", "Lin/etuwa/app/data/model/SemRegSuccessResponse;", "partMap", "Ljava/util/HashMap;", "Lokhttp3/RequestBody;", "Lkotlin/collections/HashMap;", "file", "Lokhttp3/MultipartBody$Part;", "updateSemRegisterApiCall", "updateSubjectRegistrationApiCall", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SemRegRepository {
    private final ApiHelper apiHelper;

    public SemRegRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<SemRegViewResponse> getSemRegDetailsApiCall(String id) {
        return this.apiHelper.getSemRegDetailsApiCall(id);
    }

    public final Observable<SemRegSuccessResponse> semRegisterApiCall(HashMap<String, RequestBody> partMap, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return this.apiHelper.semRegisterApiCall(partMap, file);
    }

    public final Observable<SemRegSuccessResponse> semRegisterApiCall(Map<String, String> partMap) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return this.apiHelper.semRegisterApiCall(partMap);
    }

    public final Single<SemRegViewResponse> getSemRegDetailsMvjceApiCall(String id) {
        return this.apiHelper.getSemRegDetailsMvjceApiCall(id);
    }

    public final Observable<SemRegSuccessResponse> updateSemRegisterApiCall(RequestBody id, HashMap<String, RequestBody> partMap, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return this.apiHelper.updateSemRegisterApiCall(id, partMap, file);
    }

    public final Observable<SemRegSuccessResponse> updateSemRegisterApiCall(String id, Map<String, String> partMap) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return this.apiHelper.updateSemRegisterApiCall(id, partMap);
    }

    public final Single<SemRegisterListResponse> getSemRegListApiCall() {
        return this.apiHelper.getSemRegListApiCall();
    }

    public final Single<CounsellingStatusResponse> getCounsellingStatusApiCall() {
        return this.apiHelper.getCounsellingStatusApiCall();
    }

    public final Single<AcademicYearResponse> getSemRegDropListApiCall() {
        return this.apiHelper.getSemRegDropListApiCall();
    }

    public final Single<ArrayList<Semester>> getSemestersApiCall() {
        return this.apiHelper.getSemestersApiCall();
    }

    public final Single<SuccessResponse> registerSemsterNewApiCall(Map<String, String> SemRegistration) {
        Intrinsics.checkNotNullParameter(SemRegistration, "SemRegistration");
        return this.apiHelper.registerSemsterNewApiCall(SemRegistration);
    }

    public final Single<SemRegSlip> getRegistrationSlipUrl(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getRegistrationSlipUrl(id);
    }

    public final Single<SubjectRegistrationResponse> getSubjectRegistrationListApiCall() {
        return this.apiHelper.getSubjectRegistrationListApiCall();
    }

    public final Single<ViewSubjectRegistrationResponse> getSubjectRegistrationViewApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getSubjectRegistrationViewApiCall(id);
    }

    public final Single<SubjectSpinnerResponse> getSubjectRegistrationSpinnerApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getSubjectRegistrationSpinnerApiCall(id);
    }

    public final Single<SuccessResponse> registerSubjectRegistrationApiCall(Map<String, String> registerCollection) {
        Intrinsics.checkNotNullParameter(registerCollection, "registerCollection");
        return this.apiHelper.registerSubjectRegistrationApiCall(registerCollection);
    }

    public final Single<SuccessResponse> updateSubjectRegistrationApiCall(Map<String, String> registerCollection) {
        Intrinsics.checkNotNullParameter(registerCollection, "registerCollection");
        return this.apiHelper.updateSubjectRegistrationApiCall(registerCollection);
    }

    public final Single<SuccessResponse> addAsietSemRegApiCall(Map<String, String> semesterRegistration) {
        Intrinsics.checkNotNullParameter(semesterRegistration, "semesterRegistration");
        return this.apiHelper.addAsietSemRegApiCall(semesterRegistration);
    }

    public final Single<SubjectsListResponse> getSubjectsRegListApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getSubjectsRegListApiCall(id);
    }
}