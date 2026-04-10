package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.homework.HomeWorkResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: HomeWorkRepository.kt */
/* loaded from: classes3.dex */
public final class HomeWorkRepository {
    private final ApiHelper apiHelper;

    public HomeWorkRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<HomeWorkResponse> getHomeWorksApiCall() {
        return this.apiHelper.getHomeWorksApiCall();
    }

    public final Single<SuccessResponse> deleteHomeWorkApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteHomeWorkApiCall(id);
    }

    public final Observable<SuccessResponse> submitHomeWorkApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.submitHomeWorkApiCall(id, file);
    }
}