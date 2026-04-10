package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.tutorial.TutorialResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: TutorialRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TutorialRepository {
    private final ApiHelper apiHelper;

    public TutorialRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<TutorialResponse> getTutorialsApiCall() {
        return this.apiHelper.getTutorialsApiCall();
    }

    public final Single<SuccessResponse> deleteTutorialApiCall(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.deleteTutorialApiCall(id);
    }

    public final Observable<SuccessResponse> submitTutorialApiCall(RequestBody id, MultipartBody.Part file) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.apiHelper.submitTutorialApiCall(id, file);
    }
}