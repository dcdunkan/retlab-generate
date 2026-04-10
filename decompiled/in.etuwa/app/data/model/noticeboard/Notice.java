package in.etuwa.app.data.model.noticeboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Notice.kt */
/* loaded from: classes3.dex */
public final /* data */ class Notice {
    private final String content;

    @SerializedName("create by")
    @Expose
    private final String createBy;

    @SerializedName("created time")
    @Expose
    private final String createdTime;
    private final String document;
    private final String heading;

    public static /* synthetic */ Notice copy$default(Notice notice, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notice.heading;
        }
        if ((i & 2) != 0) {
            str2 = notice.content;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = notice.createdTime;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = notice.createBy;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = notice.document;
        }
        return notice.copy(str, str6, str7, str8, str5);
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

    public final Notice copy(String heading, String content, String createdTime, String createBy, String document) {
        Intrinsics.checkNotNullParameter(heading, "heading");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(createdTime, "createdTime");
        Intrinsics.checkNotNullParameter(createBy, "createBy");
        Intrinsics.checkNotNullParameter(document, "document");
        return new Notice(heading, content, createdTime, createBy, document);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Notice)) {
            return false;
        }
        Notice notice = (Notice) other;
        return Intrinsics.areEqual(this.heading, notice.heading) && Intrinsics.areEqual(this.content, notice.content) && Intrinsics.areEqual(this.createdTime, notice.createdTime) && Intrinsics.areEqual(this.createBy, notice.createBy) && Intrinsics.areEqual(this.document, notice.document);
    }

    public int hashCode() {
        return (((((((this.heading.hashCode() * 31) + this.content.hashCode()) * 31) + this.createdTime.hashCode()) * 31) + this.createBy.hashCode()) * 31) + this.document.hashCode();
    }

    public String toString() {
        return "Notice(heading=" + this.heading + ", content=" + this.content + ", createdTime=" + this.createdTime + ", createBy=" + this.createBy + ", document=" + this.document + ")";
    }

    public Notice(String heading, String content, String createdTime, String createBy, String document) {
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