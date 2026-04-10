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