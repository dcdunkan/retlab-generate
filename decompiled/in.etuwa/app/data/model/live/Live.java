package in.etuwa.app.data.model.live;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* JADX INFO: compiled from: Live.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
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