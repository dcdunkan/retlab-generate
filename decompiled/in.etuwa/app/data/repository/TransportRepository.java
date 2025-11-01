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

/* compiled from: TransportRepository.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\b\u001a\u00020\tJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lin/etuwa/app/data/repository/TransportRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "addAsietTransRegApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/transportpalai/registration/RegisterSucessResponse;", "id", "", "exactPoint", "date", "addTransRegApiCall", "getAsietTransportRegistrationUrl", "Lin/etuwa/app/data/model/hostel/asiet/HostelAsietRegisterViewResponse;", "getRegisterViewApiCall", "Lin/etuwa/app/data/model/transportpalai/registration/RegisterViewResponse;", "getTransFeeApiCall", "Lin/etuwa/app/data/model/transport/TransportFeeResponse;", "getTransportBusPassApiCall", "Lin/etuwa/app/data/model/transportpalai/BusPass;", "getTransportHistoryUrlApiCall", "Lin/etuwa/app/data/model/transport/TransportHistoryResponse;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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