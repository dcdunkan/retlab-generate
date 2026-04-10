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