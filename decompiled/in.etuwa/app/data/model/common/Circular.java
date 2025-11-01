package in.etuwa.app.data.model.common;

import com.itextpdf.kernel.xmp.PdfConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Circular.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/model/common/Circular;", "", "heading", "", PdfConst.Description, "date", "url", "link", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getDescription", "getHeading", "getLink", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getHeading() {
        return this.heading;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component5, reason: from getter */
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