package in.etuwa.app.data.model.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReplyRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ReplyRequest {

    @SerializedName("message")
    @Expose
    private final String message;

    @SerializedName("reply_for_id")
    @Expose
    private final String reply_for_id;

    @SerializedName("to_id")
    @Expose
    private final String to_id;

    public static /* synthetic */ ReplyRequest copy$default(ReplyRequest replyRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = replyRequest.to_id;
        }
        if ((i & 2) != 0) {
            str2 = replyRequest.reply_for_id;
        }
        if ((i & 4) != 0) {
            str3 = replyRequest.message;
        }
        return replyRequest.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTo_id() {
        return this.to_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getReply_for_id() {
        return this.reply_for_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final ReplyRequest copy(String to_id, String reply_for_id, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new ReplyRequest(to_id, reply_for_id, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReplyRequest)) {
            return false;
        }
        ReplyRequest replyRequest = (ReplyRequest) other;
        return Intrinsics.areEqual(this.to_id, replyRequest.to_id) && Intrinsics.areEqual(this.reply_for_id, replyRequest.reply_for_id) && Intrinsics.areEqual(this.message, replyRequest.message);
    }

    public int hashCode() {
        String str = this.to_id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.reply_for_id;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "ReplyRequest(to_id=" + this.to_id + ", reply_for_id=" + this.reply_for_id + ", message=" + this.message + ")";
    }

    public ReplyRequest(String str, String str2, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.to_id = str;
        this.reply_for_id = str2;
        this.message = message;
    }

    public final String getTo_id() {
        return this.to_id;
    }

    public final String getReply_for_id() {
        return this.reply_for_id;
    }

    public final String getMessage() {
        return this.message;
    }
}