package in.etuwa.app.data.model.chat.comment;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.data.model.chat.reply.Reply;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Comment.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003JU\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006\""}, d2 = {"Lin/etuwa/app/data/model/chat/comment/Comment;", "", "commentUser", "", "commentId", ClientCookie.COMMENT_ATTR, "time", "img", "reply", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/chat/reply/Reply;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getComment", "()Ljava/lang/String;", "getCommentId", "getCommentUser", "getImg", "getReply", "()Ljava/util/ArrayList;", "getTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Comment {
    private final String comment;

    @SerializedName("comment_id")
    @Expose
    private final String commentId;

    @SerializedName("cmnt_user")
    @Expose
    private final String commentUser;
    private final String img;
    private final ArrayList<Reply> reply;
    private final String time;

    public static /* synthetic */ Comment copy$default(Comment comment, String str, String str2, String str3, String str4, String str5, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = comment.commentUser;
        }
        if ((i & 2) != 0) {
            str2 = comment.commentId;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = comment.comment;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = comment.time;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = comment.img;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            arrayList = comment.reply;
        }
        return comment.copy(str, str6, str7, str8, str9, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCommentUser() {
        return this.commentUser;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCommentId() {
        return this.commentId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getComment() {
        return this.comment;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    /* renamed from: component5, reason: from getter */
    public final String getImg() {
        return this.img;
    }

    public final ArrayList<Reply> component6() {
        return this.reply;
    }

    public final Comment copy(String commentUser, String commentId, String comment, String time, String img, ArrayList<Reply> reply) {
        Intrinsics.checkNotNullParameter(commentUser, "commentUser");
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(img, "img");
        Intrinsics.checkNotNullParameter(reply, "reply");
        return new Comment(commentUser, commentId, comment, time, img, reply);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Comment)) {
            return false;
        }
        Comment comment = (Comment) other;
        return Intrinsics.areEqual(this.commentUser, comment.commentUser) && Intrinsics.areEqual(this.commentId, comment.commentId) && Intrinsics.areEqual(this.comment, comment.comment) && Intrinsics.areEqual(this.time, comment.time) && Intrinsics.areEqual(this.img, comment.img) && Intrinsics.areEqual(this.reply, comment.reply);
    }

    public int hashCode() {
        return (((((((((this.commentUser.hashCode() * 31) + this.commentId.hashCode()) * 31) + this.comment.hashCode()) * 31) + this.time.hashCode()) * 31) + this.img.hashCode()) * 31) + this.reply.hashCode();
    }

    public String toString() {
        return "Comment(commentUser=" + this.commentUser + ", commentId=" + this.commentId + ", comment=" + this.comment + ", time=" + this.time + ", img=" + this.img + ", reply=" + this.reply + ")";
    }

    public Comment(String commentUser, String commentId, String comment, String time, String img, ArrayList<Reply> reply) {
        Intrinsics.checkNotNullParameter(commentUser, "commentUser");
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(img, "img");
        Intrinsics.checkNotNullParameter(reply, "reply");
        this.commentUser = commentUser;
        this.commentId = commentId;
        this.comment = comment;
        this.time = time;
        this.img = img;
        this.reply = reply;
    }

    public final String getCommentUser() {
        return this.commentUser;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final String getComment() {
        return this.comment;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getImg() {
        return this.img;
    }

    public final ArrayList<Reply> getReply() {
        return this.reply;
    }
}