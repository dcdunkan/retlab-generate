package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.internship.InternshipResponse;
import in.etuwa.app.data.model.internship.companylist.CompanyListResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: InternshipRepository.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/repository/InternshipRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "addCompanyApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/SuccessResponse;", "name", "", "address", "applyInternshipApiCall", "fromDate", "toDate", "getCompanyListApiCall", "Lin/etuwa/app/data/model/internship/companylist/CompanyListResponse;", "getInternshipRequestApiCall", "Lin/etuwa/app/data/model/internship/InternshipResponse;", "uploadInternshipApiCall", "Lio/reactivex/Observable;", "id", "Lokhttp3/RequestBody;", "file", "Lokhttp3/MultipartBody$Part;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InternshipRepository {
    private final ApiHelper apiHelper;

    public InternshipRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<InternshipResponse> getInternshipRequestApiCall() {
        return this.apiHelper.getInternshipRequestApiCall();
    }

    public final Single<SuccessResponse> applyInternshipApiCall(String name, String fromDate, String toDate) {
        return this.apiHelper.applyInternshipApiCall(name, fromDate, toDate);
    }

    public final Observable<SuccessResponse> uploadInternshipApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.uploadInternshipApiCall(id, file);
    }

    public final Single<CompanyListResponse> getCompanyListApiCall() {
        return this.apiHelper.getCompanyListApiCall();
    }

    public final Single<SuccessResponse> addCompanyApiCall(String name, String address) {
        return this.apiHelper.addCompanyApiCall(name, address);
    }
}