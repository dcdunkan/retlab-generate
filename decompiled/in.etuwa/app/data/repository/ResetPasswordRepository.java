package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.resetpassword.ResetPassword;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResetPasswordRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ResetPasswordRepository {
    private final ApiHelper apiHelper;

    public ResetPasswordRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ResetPassword> getResetPasswordApiCall() {
        return this.apiHelper.getResetPasswordApiCall();
    }

    public final Single<ResetPassword> getRegistrationApiCall() {
        return this.apiHelper.getRegistrationApiCall();
    }
}