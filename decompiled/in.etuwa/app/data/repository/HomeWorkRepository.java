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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\b\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/data/repository/HomeWorkRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "deleteHomeWorkApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/SuccessResponse;", "id", "", "getHomeWorksApiCall", "Lin/etuwa/app/data/model/homework/HomeWorkResponse;", "submitHomeWorkApiCall", "Lio/reactivex/Observable;", "Lokhttp3/RequestBody;", "file", "Lokhttp3/MultipartBody$Part;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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