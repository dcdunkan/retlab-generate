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

/* compiled from: ActivityPointRepository.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\b\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/data/repository/ActivityPointRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "deleteRequestActivityApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/SuccessResponse;", "id", "", "getActivityPointApiCall", "Lin/etuwa/app/data/model/activitypoint/ActivityPointResponse;", "getManageActivityApiCall", "Lin/etuwa/app/data/model/activitypoint/manage/ActivityBatchResponse;", "requestActivityApiCall", "Lio/reactivex/Observable;", "Lokhttp3/RequestBody;", "file", "Lokhttp3/MultipartBody$Part;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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