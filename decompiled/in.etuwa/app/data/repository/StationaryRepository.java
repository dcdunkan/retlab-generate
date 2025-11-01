package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.stationary.AdvancePaymentResponse;
import in.etuwa.app.data.model.stationary.StationaryItemResponse;
import in.etuwa.app.data.model.stationary.StationaryReceiptResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StationaryRepository.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J \u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/data/repository/StationaryRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getStationaryListApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/stationary/StationaryItemResponse;", "getStationaryPaymentUrlApiCall", "Lin/etuwa/app/data/model/stationary/AdvancePaymentResponse;", "productDetails", "", "", "getStationaryReceiptsApiCall", "Lin/etuwa/app/data/model/stationary/StationaryReceiptResponse;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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