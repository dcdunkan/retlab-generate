package in.etuwa.app.data.model.chat.comment;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommentResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class CommentResponse {

    @SerializedName("comments")
    @Expose
    private final ArrayList<Comment> comments;

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommentResponse copy$default(CommentResponse commentResponse, boolean z, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = commentResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = commentResponse.comments;
        }
        if ((i & 4) != 0) {
            str = commentResponse.error;
        }
        return commentResponse.copy(z, arrayList, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Comment> component2() {
        return this.comments;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final CommentResponse copy(boolean login, ArrayList<Comment> comments, String error) {
        Intrinsics.checkNotNullParameter(comments, "comments");
        Intrinsics.checkNotNullParameter(error, "error");
        return new CommentResponse(login, comments, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentResponse)) {
            return false;
        }
        CommentResponse commentResponse = (CommentResponse) other;
        return this.login == commentResponse.login && Intrinsics.areEqual(this.comments, commentResponse.comments) && Intrinsics.areEqual(this.error, commentResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.comments.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "CommentResponse(login=" + this.login + ", comments=" + this.comments + ", error=" + this.error + ")";
    }

    public CommentResponse(boolean z, ArrayList<Comment> comments, String error) {
        Intrinsics.checkNotNullParameter(comments, "comments");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.comments = comments;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Comment> getComments() {
        return this.comments;
    }

    public final String getError() {
        return this.error;
    }
}