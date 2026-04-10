package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.hostel.asiet.HostelAsietRegisterViewResponse;
import in.etuwa.app.data.model.transport.TransportFeeResponse;
import in.etuwa.app.data.model.transport.TransportHistoryResponse;
import in.etuwa.app.data.model.transportpalai.BusPass;
import in.etuwa.app.data.model.transportpalai.registration.RegisterSucessResponse;
import in.etuwa.app.data.model.transportpalai.registration.RegisterViewResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransportRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TransportRepository {
    private final ApiHelper apiHelper;

    public TransportRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<RegisterViewResponse> getRegisterViewApiCall() {
        return this.apiHelper.getRegisterViewApiCall();
    }

    public final Single<RegisterSucessResponse> addTransRegApiCall(String id, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiHelper.addTransRegApiCall(id, date);
    }

    public final Single<RegisterSucessResponse> addAsietTransRegApiCall(String id, String exactPoint, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(exactPoint, "exactPoint");
        Intrinsics.checkNotNullParameter(date, "date");
        return this.apiHelper.addAsietTransRegApiCall(id, exactPoint, date);
    }

    public final Single<TransportFeeResponse> getTransFeeApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.getTransFeeApiCall(id);
    }

    public final Single<BusPass> getTransportBusPassApiCall() {
        return this.apiHelper.getTransportBusPassApiCall();
    }

    public final Single<HostelAsietRegisterViewResponse> getAsietTransportRegistrationUrl() {
        return this.apiHelper.getAsietTransportRegistrationUrl();
    }

    public final Single<TransportHistoryResponse> getTransportHistoryUrlApiCall() {
        return this.apiHelper.getTransportHistoryUrlApiCall();
    }
}