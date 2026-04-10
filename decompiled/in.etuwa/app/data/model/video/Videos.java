package in.etuwa.app.data.model.video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.kernel.xmp.PdfConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Videos.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSem() {
        return this.sem;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
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