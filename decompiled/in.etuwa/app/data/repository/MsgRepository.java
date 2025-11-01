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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u000bJ\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\u0006J\u001c\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0011`\u000f0\u0006J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/data/repository/MsgRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "composeMsgApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/SuccessResponse;", "request", "Lin/etuwa/app/data/model/message/ReplyRequest;", "getDeleteMsgApiCall", "Lin/etuwa/app/data/model/message/MsgHandleRequest;", "getInboxApiCall", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/message/Inbox;", "Lkotlin/collections/ArrayList;", "getOutboxApiCall", "Lin/etuwa/app/data/model/message/Outbox;", "readMsgApiCall", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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