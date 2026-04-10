package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChangePasswordRepository.kt */
/* loaded from: classes3.dex */
public final class ChangePasswordRepository {
    private final ApiHelper apiHelper;

    public ChangePasswordRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<SuccessResponse> getChangePasswordApiCall(String oldPassword, String newPassword, String newPasswordRepeat) {
        Intrinsics.checkNotNullParameter(oldPassword, "oldPassword");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        Intrinsics.checkNotNullParameter(newPasswordRepeat, "newPasswordRepeat");
        return this.apiHelper.getChangePasswordApiCall(oldPassword, newPassword, newPasswordRepeat);
    }
}