package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.resetpassword.ResetPassword;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;

/* compiled from: ResetPasswordRepository.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t0\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lin/etuwa/app/data/repository/ResetPasswordRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getRegistrationApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/resetpassword/ResetPassword;", "getResetPasswordApiCall", "Lretrofit2/Response;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResetPasswordRepository {
    private final ApiHelper apiHelper;

    public ResetPasswordRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<Response<ResetPassword>> getResetPasswordApiCall() {
        return this.apiHelper.getResetPasswordApiCall();
    }

    public final Single<ResetPassword> getRegistrationApiCall() {
        return this.apiHelper.getRegistrationApiCall();
    }
}