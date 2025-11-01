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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\u000e\u001a\u00020\nJ \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u0013\u001a\u00020\nJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\u0013\u001a\u00020\nJ \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/repository/FeeEngineerRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getEngineerFeePayUrlApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/feeengineer/payment/FeeEngineerUrlResponse;", "FeeCollection", "", "", "getFeeEngineerApiCall", "Lin/etuwa/app/data/model/feeengineer/payment/FeeEngineerResponse;", "getFeeKmeaEngineerApiCall", "batchId", "getMedicalFeePayUrlApiCall", "Lin/etuwa/app/data/model/SuccessResponse;", "getPartialInstallmentFeeApiCall", "Lin/etuwa/app/data/model/feepartial/InstallmentDetailsResponse;", "id", "getPartialInstallmentListApiCall", "Lin/etuwa/app/data/model/feepartial/InstallmentListResponse;", "getTransportFeeApiCall", "Lin/etuwa/app/data/model/transport/TransportFeeResponse;", "getTransportFeeUrlApiCall", "Lin/etuwa/app/data/model/transport/TransportPayUrl;", "transportFeeCollection", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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