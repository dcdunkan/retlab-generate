package in.etuwa.app.data.model.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.message.reply.ReplyDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Inbox.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JO\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lin/etuwa/app/data/model/message/Inbox;", "", "id", "", "senderId", "from", "subject", "date", "content", "isRead", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getDate", "getFrom", "getId", "getSenderId", "getSubject", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Inbox {

    @SerializedName("content")
    @Expose
    private final String content;

    @SerializedName("date")
    @Expose
    private final String date;

    @SerializedName("from")
    @Expose
    private final String from;

    @SerializedName("id")
    @Expose
    private final String id;

    @SerializedName("is_read")
    @Expose
    private final String isRead;

    @SerializedName(ReplyDialogKt.ARG_SENDER_ID)
    @Expose
    private final String senderId;

    @SerializedName("subject")
    @Expose
    private final String subject;

    public static /* synthetic */ Inbox copy$default(Inbox inbox, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inbox.id;
        }
        if ((i & 2) != 0) {
            str2 = inbox.senderId;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = inbox.from;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = inbox.subject;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = inbox.date;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = inbox.content;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = inbox.isRead;
        }
        return inbox.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSenderId() {
        return this.senderId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component6, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component7, reason: from getter */
    public final String getIsRead() {
        return this.isRead;
    }

    public final Inbox copy(String id, String senderId, String from, String subject, String date, String content, String isRead) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(senderId, "senderId");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(isRead, "isRead");
        return new Inbox(id, senderId, from, subject, date, content, isRead);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Inbox)) {
            return false;
        }
        Inbox inbox = (Inbox) other;
        return Intrinsics.areEqual(this.id, inbox.id) && Intrinsics.areEqual(this.senderId, inbox.senderId) && Intrinsics.areEqual(this.from, inbox.from) && Intrinsics.areEqual(this.subject, inbox.subject) && Intrinsics.areEqual(this.date, inbox.date) && Intrinsics.areEqual(this.content, inbox.content) && Intrinsics.areEqual(this.isRead, inbox.isRead);
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.senderId.hashCode()) * 31) + this.from.hashCode()) * 31) + this.subject.hashCode()) * 31) + this.date.hashCode()) * 31) + this.content.hashCode()) * 31) + this.isRead.hashCode();
    }

    public String toString() {
        return "Inbox(id=" + this.id + ", senderId=" + this.senderId + ", from=" + this.from + ", subject=" + this.subject + ", date=" + this.date + ", content=" + this.content + ", isRead=" + this.isRead + ")";
    }

    public Inbox(String id, String senderId, String from, String subject, String date, String content, String isRead) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(senderId, "senderId");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(isRead, "isRead");
        this.id = id;
        this.senderId = senderId;
        this.from = from;
        this.subject = subject;
        this.date = date;
        this.content = content;
        this.isRead = isRead;
    }

    public final String getId() {
        return this.id;
    }

    public final String getSenderId() {
        return this.senderId;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getContent() {
        return this.content;
    }

    public final String isRead() {
        return this.isRead;
    }
}