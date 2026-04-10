package in.etuwa.app.data.model.chat.reply;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Reply.kt */
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