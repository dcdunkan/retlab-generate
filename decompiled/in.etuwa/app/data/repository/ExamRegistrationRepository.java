package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.dash.AbcResponse;
import in.etuwa.app.data.model.due.duepay.DuePayUrl;
import in.etuwa.app.data.model.examregister.ExamCourseResponse;
import in.etuwa.app.data.model.examregister.ExamMessageResponse;
import in.etuwa.app.data.model.examregister.ExamPayResponse;
import in.etuwa.app.data.model.examregister.ExamReceiptResponse;
import in.etuwa.app.data.model.examregister.ExamRegisterResponse;
import in.etuwa.app.data.model.examregister.ExamUpdateResponse;
import in.etuwa.app.data.model.examregister.ExamViewResponse;
import in.etuwa.app.data.model.examregister.RegistrationSlipResponse;
import in.etuwa.app.data.model.examregister.RevaluationApplyResponse;
import in.etuwa.app.data.model.examregister.RevaluationReceiptResponse;
import in.etuwa.app.data.model.examregister.RevaluationResponse;
import in.etuwa.app.data.model.examregister.RevaluationStatusResponse;
import in.etuwa.app.data.model.examregister.RevaluationUpdateResponse;
import in.etuwa.app.data.model.examregister.RevaluationViewResponse;
import in.etuwa.app.data.model.university.UniversityResultResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamRegistrationRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ExamRegistrationRepository {
    private final ApiHelper apiHelper;

    public ExamRegistrationRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ExamRegisterResponse> getExamRegisterDataApiCall() {
        return this.apiHelper.getExamRegisterDataApiCall();
    }

    public final Single<ExamCourseResponse> getExamCourseApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getExamCourseApiCall(id);
    }

    public final Single<ExamPayResponse> getExamPayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return this.apiHelper.getExamPayUrlApiCall(FeeCollection);
    }

    public final Single<ExamViewResponse> getExamViewApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getExamViewApiCall(id);
    }

    public final Single<ExamUpdateResponse> getExamUpdateApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getExamUpdateApiCall(id);
    }

    public final Single<RegistrationSlipResponse> getRegistrationSlipApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getRegistrationSlipApiCall(id);
    }

    public final Single<ExamReceiptResponse> getExamReceiptApiCall() {
        return this.apiHelper.getExamReceiptApiCall();
    }

    public final Single<ExamMessageResponse> getPioPayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return this.apiHelper.getPioPayUrlApiCall(FeeCollection);
    }

    public final Single<ExamMessageResponse> getScStPayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return this.apiHelper.getScStPayUrlApiCall(FeeCollection);
    }

    public final Single<UniversityResultResponse> getExamResult(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getExamResult(id);
    }

    public final Single<RevaluationResponse> getExamRevaluationApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getExamRevaluationApiCall(id);
    }

    public final Single<RevaluationApplyResponse> getExamRevaluationConfirmApiCall(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        return this.apiHelper.getExamRevaluationConfirmApiCall(revaluationCollection);
    }

    public final Single<RevaluationApplyResponse> getExamRevaluationConfirmUpdateApiCall(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        return this.apiHelper.getExamRevaluationConfirmUpdateApiCall(revaluationCollection);
    }

    public final Single<DuePayUrl> getExamRevaluationPayApiCall(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        return this.apiHelper.getExamRevaluationPayApiCall(revaluationCollection);
    }

    public final Single<DuePayUrl> getExamRevaluationUpdatePayApiCall(Map<String, String> revaluationCollection) {
        Intrinsics.checkNotNullParameter(revaluationCollection, "revaluationCollection");
        return this.apiHelper.getExamRevaluationUpdatePayApiCall(revaluationCollection);
    }

    public final Single<RevaluationViewResponse> getExamRevaluationViewApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getExamRevaluationViewApiCall(id);
    }

    public final Single<RevaluationReceiptResponse> getExamRevaluationReceiptApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getExamRevaluationReceiptApiCall(id);
    }

    public final Single<RevaluationStatusResponse> getExamRevaluationStatusApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getExamRevaluationStatusApiCall(id);
    }

    public final Single<RevaluationUpdateResponse> getExamRevaluationUpdateApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getExamRevaluationUpdateApiCall(id);
    }

    public final Single<AbcResponse> getAbcViewApiCall() {
        return this.apiHelper.getAbcViewApiCall();
    }
}