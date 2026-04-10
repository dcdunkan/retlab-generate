package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.activitypoint.ActivityPointResponse;
import in.etuwa.app.data.model.activitypoint.manage.ActivityBatchResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: ActivityPointRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ActivityPointRepository {
    private final ApiHelper apiHelper;

    public ActivityPointRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ActivityPointResponse> getActivityPointApiCall() {
        return this.apiHelper.getActivityPointApiCall();
    }

    public final Single<ActivityBatchResponse> getManageActivityApiCall() {
        return this.apiHelper.getManageActivityApiCall();
    }

    public final Single<SuccessResponse> requestActivityApiCall(String id) {
        return this.apiHelper.requestActivityApiCall(id);
    }

    public final Single<SuccessResponse> deleteRequestActivityApiCall(String id) {
        return this.apiHelper.deleteRequestActivityApiCall(id);
    }

    public final Observable<SuccessResponse> requestActivityApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.requestActivityApiCall(id, file);
    }
}