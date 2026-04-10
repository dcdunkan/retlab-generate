package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.programoutcome.ProgramOutcomeResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgramOutcomeRepository.kt */
/* loaded from: classes3.dex */
public final class ProgramOutcomeRepository {
    private final ApiHelper apiHelper;

    public ProgramOutcomeRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ProgramOutcomeResponse> getProgramOutcomeApiCall() {
        return this.apiHelper.getProgramOutcomeApiCall();
    }
}