package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.dash.DashResponse;
import in.etuwa.app.data.model.fee.FeeResponse;
import in.etuwa.app.data.model.fee.FeeSreeChitraUrl;
import in.etuwa.app.data.model.fee.FeeUrlResponse;
import in.etuwa.app.data.model.fee.GatewayDetailsResponse;
import in.etuwa.app.data.model.fee.feeheadgroups.FeeHeadGroupResponse;
import in.etuwa.app.data.model.fee.installment.InstallmentResponse;
import in.etuwa.app.data.model.fee.receipts.ReceiptResponse;
import in.etuwa.app.data.model.feemedical.FeesMedResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeeRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FeeRepository {
    private final ApiHelper apiHelper;

    public FeeRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<InstallmentResponse> getFeeInstallmentsApiCall() {
        return this.apiHelper.getFeeInstallmentsApiCall();
    }

    public final Single<FeeResponse> getFeesApiCall(String installment) {
        return this.apiHelper.getFeesApiCall(installment);
    }

    public final Single<FeeUrlResponse> submitFeesApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return this.apiHelper.submitFeesApiCall(feeCollection, feeReceipt);
    }

    public final Single<FeeUrlResponse> payFeesApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        return this.apiHelper.payFeesApiCall(feeCollection, feeReceipt);
    }

    public final Single<FeeSreeChitraUrl> payFeesSreeChitraApiCall(Map<String, String> feeCollection, Map<String, String> feeReceipt, Map<String, String> transaction, String payment, String installment) {
        Intrinsics.checkNotNullParameter(feeCollection, "feeCollection");
        Intrinsics.checkNotNullParameter(feeReceipt, "feeReceipt");
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        Intrinsics.checkNotNullParameter(payment, "payment");
        Intrinsics.checkNotNullParameter(installment, "installment");
        return this.apiHelper.payFeesSreeChitraApiCall(feeCollection, feeReceipt, transaction, payment, installment);
    }

    public final Single<ReceiptResponse> getFeeReceiptsApiCall() {
        return this.apiHelper.getFeeReceiptsApiCall();
    }

    public final Single<ReceiptResponse> getTransportFeeReceiptsApiCall() {
        return this.apiHelper.getTransportFeeReceiptsApiCall();
    }

    public final Single<FeeHeadGroupResponse> getFeeHeadApiCall() {
        return this.apiHelper.getFeeHeadApiCall();
    }

    public final Single<DashResponse> getDashApiCall() {
        return this.apiHelper.getDashApiCall();
    }

    public final Single<GatewayDetailsResponse> getGatewayDetailsApiCall() {
        return this.apiHelper.getGatewayDetailsApiCall();
    }

    public final Single<FeesMedResponse> getFeesMedicalApiCall() {
        return this.apiHelper.getFeesMedicalApiCall();
    }

    public final Single<SuccessResponse> getMedicalFeePayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return this.apiHelper.getMedicalFeePayUrlApiCall(FeeCollection);
    }
}