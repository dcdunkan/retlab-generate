package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.materials.DownloadMaterialResponse;
import in.etuwa.app.data.model.materials.MaterialRequest;
import in.etuwa.app.data.model.materials.Materials;
import in.etuwa.app.data.model.materials.MaterialsNew;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaterialRepository.kt */
/* loaded from: classes3.dex */
public final class MaterialRepository {
    private final ApiHelper apiHelper;

    public MaterialRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ArrayList<Semester>> getSemestersApiCall() {
        return this.apiHelper.getSemestersApiCall();
    }

    public final Single<ArrayList<MaterialsNew>> getStudyMaterialsApiCall(MaterialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getStudyMaterialsApiCall(request);
    }

    public final Single<ArrayList<Materials>> getQuestionBankApiCall(MaterialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getQuestionBankApiCall(request);
    }

    public final Single<DownloadMaterialResponse> downloadMaterialApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.downloadMaterialApiCall(id);
    }
}