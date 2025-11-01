package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.feearts.payment.FeeArtsResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArtsSemesterResponse;
import in.etuwa.app.data.model.feearts.payment.FeeArtsUrlResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeArtsRepository.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\r\u001a\u00020\nJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lin/etuwa/app/data/repository/FeeArtsRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getArtsFeePayUrlApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/feearts/payment/FeeArtsUrlResponse;", "FeeCollection", "", "", "getFeeArtsApiCall", "Lin/etuwa/app/data/model/feearts/payment/FeeArtsResponse;", "id", "getFeeArtsSemList", "Lin/etuwa/app/data/model/feearts/payment/FeeArtsSemesterResponse;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FeeArtsRepository {
    private final ApiHelper apiHelper;

    public FeeArtsRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<FeeArtsResponse> getFeeArtsApiCall() {
        return this.apiHelper.getFeeArtsApiCall();
    }

    public final Single<FeeArtsResponse> getFeeArtsApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getFeeArtsApiCall(id);
    }

    public final Single<FeeArtsUrlResponse> getArtsFeePayUrlApiCall(Map<String, String> FeeCollection) {
        Intrinsics.checkNotNullParameter(FeeCollection, "FeeCollection");
        return this.apiHelper.getArtsFeePayUrlApiCall(FeeCollection);
    }

    public final Single<FeeArtsSemesterResponse> getFeeArtsSemList() {
        return this.apiHelper.getFeeArtsSemList();
    }
}