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