package in.etuwa.app.data.model.live;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: Live.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/model/live/Live;", "", "link", "", "type", ErrorBundle.DETAIL_ENTRY, "title", "date", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getDetails", "getLink", "getTitle", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Live {
    private final String date;
    private final String details;
    private final String link;
    private final String title;
    private final String type;

    public static /* synthetic */ Live copy$default(Live live, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = live.link;
        }
        if ((i & 2) != 0) {
            str2 = live.type;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = live.details;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = live.title;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = live.date;
        }
        return live.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final Live copy(String link, String type, String details, String title, String date) {
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(date, "date");
        return new Live(link, type, details, title, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Live)) {
            return false;
        }
        Live live = (Live) other;
        return Intrinsics.areEqual(this.link, live.link) && Intrinsics.areEqual(this.type, live.type) && Intrinsics.areEqual(this.details, live.details) && Intrinsics.areEqual(this.title, live.title) && Intrinsics.areEqual(this.date, live.date);
    }

    public int hashCode() {
        return (((((((this.link.hashCode() * 31) + this.type.hashCode()) * 31) + this.details.hashCode()) * 31) + this.title.hashCode()) * 31) + this.date.hashCode();
    }

    public String toString() {
        return "Live(link=" + this.link + ", type=" + this.type + ", details=" + this.details + ", title=" + this.title + ", date=" + this.date + ")";
    }

    public Live(String link, String type, String details, String title, String date) {
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(date, "date");
        this.link = link;
        this.type = type;
        this.details = details;
        this.title = title;
        this.date = date;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getType() {
        return this.type;
    }

    public final String getDetails() {
        return this.details;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDate() {
        return this.date;
    }
}