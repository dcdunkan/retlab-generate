package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.leavemanagement.LeaveManagementResponse;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LeavemanagementRepository.kt */
/* loaded from: classes3.dex */
public final class LeavemanagementRepository {
    private final ApiHelper apiHelper;

    public LeavemanagementRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<LeaveManagementResponse> getLeaveManagementApiCall() {
        return this.apiHelper.getLeaveManagementApiCall();
    }
}