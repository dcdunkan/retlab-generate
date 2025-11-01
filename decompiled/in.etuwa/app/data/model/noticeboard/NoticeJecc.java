package in.etuwa.app.data.model.noticeboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoticeJecc.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/model/noticeboard/NoticeJecc;", "", "heading", "", "content", "createdTime", "createBy", "document", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getCreateBy", "getCreatedTime", "getDocument", "getHeading", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class NoticeJecc {
    private final String content;

    @SerializedName("create by")
    @Expose
    private final String createBy;

    @SerializedName("created time")
    @Expose
    private final String createdTime;
    private final String document;
    private final String heading;

    public static /* synthetic */ NoticeJecc copy$default(NoticeJecc noticeJecc, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = noticeJecc.heading;
        }
        if ((i & 2) != 0) {
            str2 = noticeJecc.content;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = noticeJecc.createdTime;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = noticeJecc.createBy;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = noticeJecc.document;
        }
        return noticeJecc.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHeading() {
        return this.heading;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCreatedTime() {
        return this.createdTime;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCreateBy() {
        return this.createBy;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDocument() {
        return this.document;
    }

    public final NoticeJecc copy(String heading, String content, String createdTime, String createBy, String document) {
        Intrinsics.checkNotNullParameter(heading, "heading");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(createdTime, "createdTime");
        Intrinsics.checkNotNullParameter(createBy, "createBy");
        Intrinsics.checkNotNullParameter(document, "document");
        return new NoticeJecc(heading, content, createdTime, createBy, document);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoticeJecc)) {
            return false;
        }
        NoticeJecc noticeJecc = (NoticeJecc) other;
        return Intrinsics.areEqual(this.heading, noticeJecc.heading) && Intrinsics.areEqual(this.content, noticeJecc.content) && Intrinsics.areEqual(this.createdTime, noticeJecc.createdTime) && Intrinsics.areEqual(this.createBy, noticeJecc.createBy) && Intrinsics.areEqual(this.document, noticeJecc.document);
    }

    public int hashCode() {
        return (((((((this.heading.hashCode() * 31) + this.content.hashCode()) * 31) + this.createdTime.hashCode()) * 31) + this.createBy.hashCode()) * 31) + this.document.hashCode();
    }

    public String toString() {
        return "NoticeJecc(heading=" + this.heading + ", content=" + this.content + ", createdTime=" + this.createdTime + ", createBy=" + this.createBy + ", document=" + this.document + ")";
    }

    public NoticeJecc(String heading, String content, String createdTime, String createBy, String document) {
        Intrinsics.checkNotNullParameter(heading, "heading");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(createdTime, "createdTime");
        Intrinsics.checkNotNullParameter(createBy, "createBy");
        Intrinsics.checkNotNullParameter(document, "document");
        this.heading = heading;
        this.content = content;
        this.createdTime = createdTime;
        this.createBy = createBy;
        this.document = document;
    }

    public final String getHeading() {
        return this.heading;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getCreatedTime() {
        return this.createdTime;
    }

    public final String getCreateBy() {
        return this.createBy;
    }

    public final String getDocument() {
        return this.document;
    }
}