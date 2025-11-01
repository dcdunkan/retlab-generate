package in.etuwa.app.data.repository;

import com.itextpdf.kernel.xmp.PdfConst;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.grievance.GrievanceResponse;
import in.etuwa.app.data.model.grievance.type.GrievanceTypeResponse;
import in.etuwa.app.data.model.grievance.view.ViewGrievanceResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: GrievanceRepository.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JH\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\nJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012J \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\nJH\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010JP\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0013\u001a\u00020\u000b2\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/data/repository/GrievanceRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "addGrievanceApiCall", "Lio/reactivex/Observable;", "Lin/etuwa/app/data/model/SuccessResponse;", "partMap", "Ljava/util/HashMap;", "", "Lokhttp3/RequestBody;", "Lkotlin/collections/HashMap;", "images", "Ljava/util/ArrayList;", "Lokhttp3/MultipartBody$Part;", "Lkotlin/collections/ArrayList;", "deleteGrievanceApiCall", "Lio/reactivex/Single;", "id", "getGrievanceApiCall", "Lin/etuwa/app/data/model/grievance/GrievanceResponse;", "getGrievanceTypeApiCall", "Lin/etuwa/app/data/model/grievance/type/GrievanceTypeResponse;", "remindGrievanceApiCall", PdfConst.Description, "reopenGrievanceApiCall", "updateGrievanceApiCall", "viewGrievanceApiCall", "Lin/etuwa/app/data/model/grievance/view/ViewGrievanceResponse;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GrievanceRepository {
    private final ApiHelper apiHelper;

    public GrievanceRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<GrievanceResponse> getGrievanceApiCall() {
        return this.apiHelper.getGrievanceApiCall();
    }

    public final Single<GrievanceTypeResponse> getGrievanceTypeApiCall() {
        return this.apiHelper.getGrievanceTypeApiCall();
    }

    public final Single<ViewGrievanceResponse> viewGrievanceApiCall(String id) {
        return this.apiHelper.viewGrievanceApiCall(id);
    }

    public final Observable<SuccessResponse> addGrievanceApiCall(HashMap<String, RequestBody> partMap, ArrayList<MultipartBody.Part> images) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        Intrinsics.checkNotNullParameter(images, "images");
        return this.apiHelper.addGrievanceApiCall(partMap, images);
    }

    public final Observable<SuccessResponse> updateGrievanceApiCall(RequestBody id, HashMap<String, RequestBody> partMap, ArrayList<MultipartBody.Part> images) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        Intrinsics.checkNotNullParameter(images, "images");
        return this.apiHelper.updateGrievanceApiCall(id, partMap, images);
    }

    public final Single<SuccessResponse> deleteGrievanceApiCall(String id) {
        return this.apiHelper.deleteGrievanceApiCall(id);
    }

    public final Single<SuccessResponse> remindGrievanceApiCall(String id, String description) {
        return this.apiHelper.remindGrievanceApiCall(id, description);
    }

    public final Single<SuccessResponse> reopenGrievanceApiCall(HashMap<String, RequestBody> partMap, ArrayList<MultipartBody.Part> images) {
        Intrinsics.checkNotNullParameter(partMap, "partMap");
        Intrinsics.checkNotNullParameter(images, "images");
        return this.apiHelper.reopenGrievanceApiCall(partMap, images);
    }
}