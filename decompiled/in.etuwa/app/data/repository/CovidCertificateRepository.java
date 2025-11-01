package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;

/* compiled from: CovidCertificateRepository.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lin/etuwa/app/data/repository/CovidCertificateRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "uploadCovidCertificateApiCall", "Lio/reactivex/Observable;", "Lin/etuwa/app/data/model/SuccessResponse;", "vaccineFile", "Lokhttp3/MultipartBody$Part;", "uploadCovidCertificateTwoApiCall", "vaccineFileTwo", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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