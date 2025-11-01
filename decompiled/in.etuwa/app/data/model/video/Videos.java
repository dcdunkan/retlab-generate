package in.etuwa.app.data.model.video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.kernel.xmp.PdfConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Videos.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lin/etuwa/app/data/model/video/Videos;", "", "id", "", "subject", "sem", "title", PdfConst.Description, "date", "url", "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getDate", "()Ljava/lang/String;", "getDescription", "getId", "getSem", "getSubject", "getTitle", "getType", "()I", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Videos {

    @SerializedName("date")
    @Expose
    private final String date;

    @SerializedName(PdfConst.Description)
    @Expose
    private final String description;

    @SerializedName("id")
    @Expose
    private final String id;

    @SerializedName("sem")
    @Expose
    private final String sem;

    @SerializedName("subject")
    @Expose
    private final String subject;

    @SerializedName("title")
    @Expose
    private final String title;
    private final int type;

    @SerializedName("url")
    @Expose
    private final String url;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSem() {
        return this.sem;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component7, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component8, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final Videos copy(String id, String subject, String sem, String title, String description, String date, String url, int type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(sem, "sem");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(url, "url");
        return new Videos(id, subject, sem, title, description, date, url, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Videos)) {
            return false;
        }
        Videos videos = (Videos) other;
        return Intrinsics.areEqual(this.id, videos.id) && Intrinsics.areEqual(this.subject, videos.subject) && Intrinsics.areEqual(this.sem, videos.sem) && Intrinsics.areEqual(this.title, videos.title) && Intrinsics.areEqual(this.description, videos.description) && Intrinsics.areEqual(this.date, videos.date) && Intrinsics.areEqual(this.url, videos.url) && this.type == videos.type;
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.subject.hashCode()) * 31) + this.sem.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.date.hashCode()) * 31) + this.url.hashCode()) * 31) + this.type;
    }

    public String toString() {
        return "Videos(id=" + this.id + ", subject=" + this.subject + ", sem=" + this.sem + ", title=" + this.title + ", description=" + this.description + ", date=" + this.date + ", url=" + this.url + ", type=" + this.type + ")";
    }

    public Videos(String id, String subject, String sem, String title, String description, String date, String url, int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(sem, "sem");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(url, "url");
        this.id = id;
        this.subject = subject;
        this.sem = sem;
        this.title = title;
        this.description = description;
        this.date = date;
        this.url = url;
        this.type = i;
    }

    public final String getId() {
        return this.id;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getSem() {
        return this.sem;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getType() {
        return this.type;
    }
}