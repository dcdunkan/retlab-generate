package in.etuwa.app.data.model.common;

import com.itextpdf.kernel.xmp.PdfConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Circular.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Circular {
    private final String date;
    private final String description;
    private final String heading;
    private final String link;
    private final String url;

    public static /* synthetic */ Circular copy$default(Circular circular, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = circular.heading;
        }
        if ((i & 2) != 0) {
            str2 = circular.description;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = circular.date;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = circular.url;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = circular.link;
        }
        return circular.copy(str, str6, str7, str8, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHeading() {
        return this.heading;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    public final Circular copy(String heading, String description, String date, String url, String link) {
        Intrinsics.checkNotNullParameter(heading, "heading");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(link, "link");
        return new Circular(heading, description, date, url, link);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Circular)) {
            return false;
        }
        Circular circular = (Circular) other;
        return Intrinsics.areEqual(this.heading, circular.heading) && Intrinsics.areEqual(this.description, circular.description) && Intrinsics.areEqual(this.date, circular.date) && Intrinsics.areEqual(this.url, circular.url) && Intrinsics.areEqual(this.link, circular.link);
    }

    public int hashCode() {
        return (((((((this.heading.hashCode() * 31) + this.description.hashCode()) * 31) + this.date.hashCode()) * 31) + this.url.hashCode()) * 31) + this.link.hashCode();
    }

    public String toString() {
        return "Circular(heading=" + this.heading + ", description=" + this.description + ", date=" + this.date + ", url=" + this.url + ", link=" + this.link + ")";
    }

    public Circular(String heading, String description, String date, String url, String link) {
        Intrinsics.checkNotNullParameter(heading, "heading");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(link, "link");
        this.heading = heading;
        this.description = description;
        this.date = date;
        this.url = url;
        this.link = link;
    }

    public final String getHeading() {
        return this.heading;
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

    public final String getLink() {
        return this.link;
    }
}