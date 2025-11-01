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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ$\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r0\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u001c\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u000bj\b\u0012\u0004\u0012\u00020\u0011`\r0\u0006J$\u0010\u0012\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u000bj\b\u0012\u0004\u0012\u00020\u0013`\r0\u00062\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/data/repository/MaterialRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "downloadMaterialApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/materials/DownloadMaterialResponse;", "id", "", "getQuestionBankApiCall", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/materials/Materials;", "Lkotlin/collections/ArrayList;", "request", "Lin/etuwa/app/data/model/materials/MaterialRequest;", "getSemestersApiCall", "Lin/etuwa/app/data/model/Semester;", "getStudyMaterialsApiCall", "Lin/etuwa/app/data/model/materials/MaterialsNew;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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