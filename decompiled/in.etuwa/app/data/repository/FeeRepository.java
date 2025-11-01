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

/* compiled from: FeeRepository.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006J \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0019J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0006J4\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00192\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0019JX\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00062\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00192\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00192\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00192\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J4\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00192\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lin/etuwa/app/data/repository/FeeRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getDashApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/dash/DashResponse;", "getFeeHeadApiCall", "Lin/etuwa/app/data/model/fee/feeheadgroups/FeeHeadGroupResponse;", "getFeeInstallmentsApiCall", "Lin/etuwa/app/data/model/fee/installment/InstallmentResponse;", "getFeeReceiptsApiCall", "Lin/etuwa/app/data/model/fee/receipts/ReceiptResponse;", "getFeesApiCall", "Lin/etuwa/app/data/model/fee/FeeResponse;", "installment", "", "getFeesMedicalApiCall", "Lin/etuwa/app/data/model/feemedical/FeesMedResponse;", "getGatewayDetailsApiCall", "Lin/etuwa/app/data/model/fee/GatewayDetailsResponse;", "getMedicalFeePayUrlApiCall", "Lin/etuwa/app/data/model/SuccessResponse;", "FeeCollection", "", "getTransportFeeReceiptsApiCall", "payFeesApiCall", "Lin/etuwa/app/data/model/fee/FeeUrlResponse;", "feeCollection", "feeReceipt", "payFeesSreeChitraApiCall", "Lin/etuwa/app/data/model/fee/FeeSreeChitraUrl;", "transaction", "payment", "submitFeesApiCall", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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