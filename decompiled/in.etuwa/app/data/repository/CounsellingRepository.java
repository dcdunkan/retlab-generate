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

/* compiled from: CounsellingRepository.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\fJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eJ \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\nJp\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\b\u0010 \u001a\u0004\u0018\u00010\n2\b\u0010!\u001a\u0004\u0018\u00010\nJ \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ8\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000f\u001a\u00020\u000b2\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\fJ\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lin/etuwa/app/data/repository/CounsellingRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "addCounsellingApiCall", "Lio/reactivex/Observable;", "Lin/etuwa/app/data/model/SuccessResponse;", "partMap", "Ljava/util/HashMap;", "", "Lokhttp3/RequestBody;", "Lkotlin/collections/HashMap;", "deleteCounsellingApiCall", "Lio/reactivex/Single;", "id", "getCounsellingRequestApiCall", "Lin/etuwa/app/data/model/counselling/CounsellingResponse;", "getCounsellingStatusApiCall", "Lin/etuwa/app/data/model/counselling/status/CounsellingStatusResponse;", "getCounsellingTypeApiCall", "Lin/etuwa/app/data/model/counselling/type/CounsellingTypesResponse;", "remindCounsellingApiCall", PdfConst.Description, "reopenCounsellingApiCall", "type", "concern", "home", "studies", "relationship", "physical", "history", "session", "comments", "reviewCounsellingApiCall", "updateCounsellingApiCall", "viewCounsellingApiCall", "Lin/etuwa/app/data/model/counselling/view/ViewCounsellingResponse;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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