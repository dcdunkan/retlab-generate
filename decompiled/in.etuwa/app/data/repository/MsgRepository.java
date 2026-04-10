package in.etuwa.app.data.repository;

import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.message.Inbox;
import in.etuwa.app.data.model.message.MsgHandleRequest;
import in.etuwa.app.data.model.message.Outbox;
import in.etuwa.app.data.model.message.ReplyRequest;
import in.etuwa.app.data.network.ApiHelper;
import io.reactivex.Single;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MsgRepository.kt */
/* loaded from: classes3.dex */
public final class MsgRepository {
    private final ApiHelper apiHelper;

    public MsgRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ArrayList<Inbox>> getInboxApiCall() {
        return this.apiHelper.getInboxApiCall();
    }

    public final Single<SuccessResponse> readMsgApiCall(MsgHandleRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.readMsgApiCall(request);
    }

    public final Single<ArrayList<Outbox>> getOutboxApiCall() {
        return this.apiHelper.getOutboxApiCall();
    }

    public final Single<SuccessResponse> composeMsgApiCall(ReplyRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.composeMsgApiCall(request);
    }

    public final Single<SuccessResponse> getDeleteMsgApiCall(MsgHandleRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.apiHelper.getDeleteMsgApiCall(request);
    }
}