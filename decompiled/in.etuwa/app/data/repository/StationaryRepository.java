package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.stationary.AdvancePaymentResponse;
import in.etuwa.app.data.model.stationary.StationaryItemResponse;
import in.etuwa.app.data.model.stationary.StationaryReceiptResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StationaryRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StationaryRepository {
    private final ApiHelper apiHelper;

    public StationaryRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<StationaryItemResponse> getStationaryListApiCall() {
        return this.apiHelper.getStationaryListApiCall();
    }

    public final Single<StationaryReceiptResponse> getStationaryReceiptsApiCall() {
        return this.apiHelper.getStationaryReceiptsApiCall();
    }

    public final Single<AdvancePaymentResponse> getStationaryPaymentUrlApiCall(Map<String, String> productDetails) {
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        return this.apiHelper.getStationaryPaymentUrlApiCall(productDetails);
    }
}