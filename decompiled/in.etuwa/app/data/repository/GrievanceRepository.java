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