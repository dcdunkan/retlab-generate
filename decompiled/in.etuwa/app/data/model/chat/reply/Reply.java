package in.etuwa.app.data.model.chat.reply;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Reply.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/chat/reply/Reply;", "", "name", "", "reply", "time", "img", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImg", "()Ljava/lang/String;", "getName", "getReply", "getTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Reply {
    private final String img;
    private final String name;
    private final String reply;
    private final String time;

    public static /* synthetic */ Reply copy$default(Reply reply, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reply.name;
        }
        if ((i & 2) != 0) {
            str2 = reply.reply;
        }
        if ((i & 4) != 0) {
            str3 = reply.time;
        }
        if ((i & 8) != 0) {
            str4 = reply.img;
        }
        return reply.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReply() {
        return this.reply;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    /* renamed from: component4, reason: from getter */
    public final String getImg() {
        return this.img;
    }

    public final Reply copy(String name, String reply, String time, String img) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(img, "img");
        return new Reply(name, reply, time, img);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Reply)) {
            return false;
        }
        Reply reply = (Reply) other;
        return Intrinsics.areEqual(this.name, reply.name) && Intrinsics.areEqual(this.reply, reply.reply) && Intrinsics.areEqual(this.time, reply.time) && Intrinsics.areEqual(this.img, reply.img);
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.reply.hashCode()) * 31) + this.time.hashCode()) * 31) + this.img.hashCode();
    }

    public String toString() {
        return "Reply(name=" + this.name + ", reply=" + this.reply + ", time=" + this.time + ", img=" + this.img + ")";
    }

    public Reply(String name, String reply, String time, String img) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(img, "img");
        this.name = name;
        this.reply = reply;
        this.time = time;
        this.img = img;
    }

    public final String getName() {
        return this.name;
    }

    public final String getReply() {
        return this.reply;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getImg() {
        return this.img;
    }
}