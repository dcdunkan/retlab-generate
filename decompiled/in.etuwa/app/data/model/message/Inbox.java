package in.etuwa.app.data.model.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.message.reply.ReplyDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Inbox.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSenderId() {
        return this.senderId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
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