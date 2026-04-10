package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;

/* JADX INFO: compiled from: CovidCertificateRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CovidCertificateRepository {
    private final ApiHelper apiHelper;

    public CovidCertificateRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Observable<SuccessResponse> uploadCovidCertificateApiCall(MultipartBody.Part vaccineFile) {
        return this.apiHelper.uploadCovidCertificateApiCall(vaccineFile);
    }

    public final Observable<SuccessResponse> uploadCovidCertificateTwoApiCall(MultipartBody.Part vaccineFileTwo) {
        return this.apiHelper.uploadCovidCertificateTwoApiCall(vaccineFileTwo);
    }
}