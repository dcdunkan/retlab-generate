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

/* compiled from: CertificateRequestRepository.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\fJ&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006J\u001c\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00180\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/data/repository/CertificateRequestRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "applyCertificateApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/SuccessResponse;", "certificate", "", "reason", "certificateCollection", "", "Lio/reactivex/Observable;", "Lokhttp3/RequestBody;", "file", "Lokhttp3/MultipartBody$Part;", "getCertificateRequestApiCall", "Lin/etuwa/app/data/model/certificaterequest/CertificateRequestResponse;", "getCertificateTypeRequestApiCall", "Lin/etuwa/app/data/model/certificaterequest/CertificateTypeResponse;", "getSemestersApiCall", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/Semester;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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