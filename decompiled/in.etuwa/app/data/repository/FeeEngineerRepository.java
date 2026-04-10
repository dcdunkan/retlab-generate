package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineerResponse;
import in.etuwa.app.data.model.feeengineer.payment.FeeEngineerUrlResponse;
import in.etuwa.app.data.model.feepartial.InstallmentDetailsResponse;
import in.etuwa.app.data.model.feepartial.InstallmentListResponse;
import in.etuwa.app.data.model.transport.TransportFeeResponse;
import in.etuwa.app.data.model.transport.TransportPayUrl;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeEngineerRepository.kt */
/* loaded from: classes3.dex */
public final class FeeEngineerRepository {
    private final ApiHelper apiHelper;

    public FeeEngineerRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<FeeEngineerResponse> getFeeEngineerApiCall() {
        return this.apiHelper.getFeeEngineerApiCall();
    }

    public final Single<FeeEngineerUrlResponse> getEngineerFeePayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return this.apiHelper.getEngineerFeePayUrlApiCall(FeeCollection);
    }

    public final Single<FeeEngineerResponse> getFeeKmeaEngineerApiCall(String batchId) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        return this.apiHelper.getFeeKmeaEngineerApiCall(batchId);
    }

    public final Single<TransportFeeResponse> getTransportFeeApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getTransportFeeApiCall(id);
    }

    public final Single<TransportFeeResponse> getTransportFeeApiCall() {
        return this.apiHelper.getTransportFeeApiCall();
    }

    public final Single<TransportPayUrl> getTransportFeeUrlApiCall(Map<String, String> transportFeeCollection) {
        Intrinsics.checkNotNullParameter(transportFeeCollection, "transportFeeCollection");
        return this.apiHelper.getTransportFeeUrlApiCall(transportFeeCollection);
    }

    public final Single<InstallmentListResponse> getPartialInstallmentListApiCall() {
        return this.apiHelper.getPartialInstallmentListApiCall();
    }

    public final Single<InstallmentDetailsResponse> getPartialInstallmentFeeApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getPartialInstallmentFeeApiCall(id);
    }

    public final Single<SuccessResponse> getMedicalFeePayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return this.apiHelper.getMedicalFeePayUrlApiCall(FeeCollection);
    }
}