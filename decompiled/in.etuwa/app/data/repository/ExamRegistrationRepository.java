package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
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

/* compiled from: ExamRegistrationRepository.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\n\u001a\u00020\u000bJ \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\n\u001a\u00020\u000bJ \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fJ \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fJ \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fJ\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00062\u0006\u0010\n\u001a\u00020\u000bJ \u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00062\u0006\u0010\n\u001a\u00020\u000bJ \u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fJ\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00062\u0006\u0010\n\u001a\u00020\u000bJ \u0010/\u001a\b\u0012\u0004\u0012\u00020,0\u00062\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fJ\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00062\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lin/etuwa/app/data/repository/ExamRegistrationRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getAbcViewApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/dash/AbcResponse;", "getExamCourseApiCall", "Lin/etuwa/app/data/model/examregister/ExamCourseResponse;", "id", "", "getExamPayUrlApiCall", "Lin/etuwa/app/data/model/examregister/ExamPayResponse;", "FeeCollection", "", "getExamReceiptApiCall", "Lin/etuwa/app/data/model/examregister/ExamReceiptResponse;", "getExamRegisterDataApiCall", "Lin/etuwa/app/data/model/examregister/ExamRegisterResponse;", "getExamResult", "Lin/etuwa/app/data/model/university/UniversityResultResponse;", "getExamRevaluationApiCall", "Lin/etuwa/app/data/model/examregister/RevaluationResponse;", "getExamRevaluationConfirmApiCall", "Lin/etuwa/app/data/model/examregister/RevaluationApplyResponse;", "revaluationCollection", "getExamRevaluationConfirmUpdateApiCall", "getExamRevaluationPayApiCall", "Lin/etuwa/app/data/model/due/duepay/DuePayUrl;", "getExamRevaluationReceiptApiCall", "Lin/etuwa/app/data/model/examregister/RevaluationReceiptResponse;", "getExamRevaluationStatusApiCall", "Lin/etuwa/app/data/model/examregister/RevaluationStatusResponse;", "getExamRevaluationUpdateApiCall", "Lin/etuwa/app/data/model/examregister/RevaluationUpdateResponse;", "getExamRevaluationUpdatePayApiCall", "getExamRevaluationViewApiCall", "Lin/etuwa/app/data/model/examregister/RevaluationViewResponse;", "getExamUpdateApiCall", "Lin/etuwa/app/data/model/examregister/ExamUpdateResponse;", "getExamViewApiCall", "Lin/etuwa/app/data/model/examregister/ExamViewResponse;", "getPioPayUrlApiCall", "Lin/etuwa/app/data/model/examregister/ExamMessageResponse;", "getRegistrationSlipApiCall", "Lin/etuwa/app/data/model/examregister/RegistrationSlipResponse;", "getScStPayUrlApiCall", "verifyAbcIdApiCall", "Lin/etuwa/app/data/model/SuccessResponse;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    public final Single<SuccessResponse> verifyAbcIdApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.verifyAbcIdApiCall(id);
    }
}