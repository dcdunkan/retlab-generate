package in.etuwa.app.data.repository;

import com.itextpdf.kernel.xmp.PdfConst;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.counselling.CounsellingResponse;
import in.etuwa.app.data.model.counselling.status.CounsellingStatusResponse;
import in.etuwa.app.data.model.counselling.type.CounsellingTypesResponse;
import in.etuwa.app.data.model.counselling.view.ViewCounsellingResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: CounsellingRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CounsellingRepository {
    private final ApiHelper apiHelper;

    public CounsellingRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<CounsellingResponse> getCounsellingRequestApiCall() {
        return this.apiHelper.getCounsellingRequestApiCall();
    }

    public final Single<CounsellingTypesResponse> getCounsellingTypeApiCall() {
        return this.apiHelper.getCounsellingTypeApiCall();
    }

    public final Single<CounsellingStatusResponse> getCounsellingStatusApiCall() {
        return this.apiHelper.getCounsellingStatusApiCall();
    }

    public final Single<ViewCounsellingResponse> viewCounsellingApiCall(String id) {
        return this.apiHelper.viewCounsellingApiCall(id);
    }

    public final Single<SuccessResponse> deleteCounsellingApiCall(String id) {
        return this.apiHelper.deleteCounsellingApiCall(id);
    }

    public final Observable<SuccessResponse> updateCounsellingApiCall(RequestBody id, HashMap<String, RequestBody> partMap) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return this.apiHelper.updateCounsellingApiCall(id, partMap);
    }

    public final Observable<SuccessResponse> addCounsellingApiCall(HashMap<String, RequestBody> partMap) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        return this.apiHelper.addCounsellingApiCall(partMap);
    }

    public final Single<SuccessResponse> remindCounsellingApiCall(String id, String description) {
        return this.apiHelper.remindCounsellingApiCall(id, description);
    }

    public final Single<SuccessResponse> reviewCounsellingApiCall(String id, String description) {
        return this.apiHelper.reviewCounsellingApiCall(id, description);
    }

    public final Single<SuccessResponse> reopenCounsellingApiCall(String id, String type, String concern, String home, String studies, String relationship, String physical, String history, String session, String comments) {
        return this.apiHelper.reopenCounsellingApiCall(id, type, concern, home, studies, relationship, physical, history, session, comments);
    }
}