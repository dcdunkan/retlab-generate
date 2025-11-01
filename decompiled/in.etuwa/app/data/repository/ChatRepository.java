package in.etuwa.app.data.repository;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.chat.comment.CommentResponse;
import in.etuwa.app.data.model.chat.reply.ReplyResponse;
import in.etuwa.app.data.model.chat.subjects.ChatResponse;
import in.etuwa.app.data.network.ApiHelper;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatRepository.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bJ(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u000bJ(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u000bJ2\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u000bJ(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u000bJ2\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u000bJ<\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/repository/ChatRepository;", "", "apiHelper", "Lin/etuwa/app/data/network/ApiHelper;", "(Lin/etuwa/app/data/network/ApiHelper;)V", "getChatSubjectsApiCall", "Lio/reactivex/Single;", "Lin/etuwa/app/data/model/chat/subjects/ChatResponse;", "getCommentsApiCall", "Lin/etuwa/app/data/model/chat/comment/CommentResponse;", StoreFragmentKt.SUB_ID, "", "chat", "getParentCommentsApiCall", "batchId", "getParentReplyApiCall", "Lin/etuwa/app/data/model/chat/reply/ReplyResponse;", "commentId", "reply", "getReplyApiCall", "setCommentsApiCall", "Lin/etuwa/app/data/model/SuccessResponse;", "semId", ClientCookie.COMMENT_ATTR, "setParentCommentsApiCall", "setParentReplyApiCall", "setReplyApiCall", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatRepository {
    private final ApiHelper apiHelper;

    public ChatRepository(ApiHelper apiHelper) {
        Intrinsics.checkNotNullParameter(apiHelper, "apiHelper");
        this.apiHelper = apiHelper;
    }

    public final Single<ChatResponse> getChatSubjectsApiCall() {
        return this.apiHelper.getChatSubjectsApiCall();
    }

    public final Single<CommentResponse> getCommentsApiCall(String subId, String chat) {
        Intrinsics.checkNotNullParameter(chat, "chat");
        return this.apiHelper.getCommentsApiCall(subId, chat);
    }

    public final Single<SuccessResponse> setCommentsApiCall(String subId, String batchId, String semId, String comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        return this.apiHelper.setCommentsApiCall(subId, batchId, semId, comment);
    }

    public final Single<CommentResponse> getParentCommentsApiCall(String batchId, String chat) {
        Intrinsics.checkNotNullParameter(chat, "chat");
        return this.apiHelper.getParentCommentsApiCall(batchId, chat);
    }

    public final Single<SuccessResponse> setParentCommentsApiCall(String batchId, String semId, String comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        return this.apiHelper.setParentCommentsApiCall(batchId, semId, comment);
    }

    public final Single<ReplyResponse> getReplyApiCall(String subId, String commentId, String reply) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        return this.apiHelper.getReplyApiCall(subId, commentId, reply);
    }

    public final Single<SuccessResponse> setReplyApiCall(String subId, String batchId, String semId, String commentId, String reply) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        return this.apiHelper.setReplyApiCall(subId, batchId, semId, commentId, reply);
    }

    public final Single<ReplyResponse> getParentReplyApiCall(String batchId, String commentId, String reply) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        return this.apiHelper.getParentReplyApiCall(batchId, commentId, reply);
    }

    public final Single<SuccessResponse> setParentReplyApiCall(String batchId, String semId, String commentId, String reply) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        return this.apiHelper.setParentReplyApiCall(batchId, semId, commentId, reply);
    }
}