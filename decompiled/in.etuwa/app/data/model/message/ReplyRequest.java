package in.etuwa.app.data.model.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReplyRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/message/ReplyRequest;", "", "to_id", "", "reply_for_id", "message", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getReply_for_id", "getTo_id", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getTo_id() {
        return this.to_id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReply_for_id() {
        return this.reply_for_id;
    }

    /* renamed from: component3, reason: from getter */
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
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.reply_for_id;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.message.hashCode();
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