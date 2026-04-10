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

/* JADX INFO: compiled from: InternshipRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
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