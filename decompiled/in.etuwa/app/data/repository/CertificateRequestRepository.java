package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.certificaterequest.CertificateRequestResponse;
import in.etuwa.app.data.model.certificaterequest.CertificateTypeResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: CertificateRequestRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CertificateRequestRepository {
    private final ApiHelper apiHelper;

    public CertificateRequestRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<CertificateRequestResponse> getCertificateRequestApiCall() {
        return this.apiHelper.getCertificateRequestApiCall();
    }

    public final Single<CertificateTypeResponse> getCertificateTypeRequestApiCall() {
        return this.apiHelper.getCertificateTypeRequestApiCall();
    }

    public final Single<SuccessResponse> applyCertificateApiCall(String certificate, String reason) {
        return this.apiHelper.applyCertificateApiCall(certificate, reason);
    }

    public final Single<SuccessResponse> applyCertificateApiCall(Map<String, String> certificateCollection) {
        Intrinsics.checkNotNullParameter(certificateCollection, "certificateCollection");
        return this.apiHelper.applyCertificateApiCall(certificateCollection);
    }

    public final Observable<SuccessResponse> applyCertificateApiCall(RequestBody certificate, RequestBody reason, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return this.apiHelper.applyCertificateApiCall(certificate, reason, file);
    }

    public final Single<ArrayList<Semester>> getSemestersApiCall() {
        return this.apiHelper.getSemestersApiCall();
    }
}