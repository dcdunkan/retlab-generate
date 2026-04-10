package in.etuwa.app.data.model.message;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Outbox.kt */
/* loaded from: classes3.dex */
public final /* data */ class Outbox {

    @SerializedName("content")
    @Expose
    private final String content;

    @SerializedName("date")
    @Expose
    private final String date;

    @SerializedName("id")
    @Expose
    private final String id;

    @SerializedName("subject")
    @Expose
    private final String subject;

    @SerializedName(TypedValues.TransitionType.S_TO)
    @Expose
    private final String to;

    public static /* synthetic */ Outbox copy$default(Outbox outbox, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = outbox.id;
        }
        if ((i & 2) != 0) {
            str2 = outbox.to;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = outbox.subject;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = outbox.content;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = outbox.date;
        }
        return outbox.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTo() {
        return this.to;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component4, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final Outbox copy(String id, String to, String subject, String content, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(date, "date");
        return new Outbox(id, to, subject, content, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Outbox)) {
            return false;
        }
        Outbox outbox = (Outbox) other;
        return Intrinsics.areEqual(this.id, outbox.id) && Intrinsics.areEqual(this.to, outbox.to) && Intrinsics.areEqual(this.subject, outbox.subject) && Intrinsics.areEqual(this.content, outbox.content) && Intrinsics.areEqual(this.date, outbox.date);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.to.hashCode()) * 31) + this.subject.hashCode()) * 31) + this.content.hashCode()) * 31) + this.date.hashCode();
    }

    public String toString() {
        return "Outbox(id=" + this.id + ", to=" + this.to + ", subject=" + this.subject + ", content=" + this.content + ", date=" + this.date + ")";
    }

    public Outbox(String id, String to, String subject, String content, String date) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(date, "date");
        this.id = id;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.date = date;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTo() {
        return this.to;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDate() {
        return this.date;
    }
}