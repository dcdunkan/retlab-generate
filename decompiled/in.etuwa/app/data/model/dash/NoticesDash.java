package in.etuwa.app.data.model.dash;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoticesDash.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class NoticesDash {

    @SerializedName("content")
    @Expose
    private final String content;

    public static /* synthetic */ NoticesDash copy$default(NoticesDash noticesDash, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = noticesDash.content;
        }
        return noticesDash.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final NoticesDash copy(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new NoticesDash(content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NoticesDash) && Intrinsics.areEqual(this.content, ((NoticesDash) other).content);
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public String toString() {
        return "NoticesDash(content=" + this.content + ")";
    }

    public NoticesDash(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
    }

    public final String getContent() {
        return this.content;
    }
}