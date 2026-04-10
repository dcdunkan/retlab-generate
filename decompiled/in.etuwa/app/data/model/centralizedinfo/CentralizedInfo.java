package in.etuwa.app.data.model.centralizedinfo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CentralizedInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CentralizedInfo {
    private final String date;
    private final String link;
    private final String title;
    private final String type;

    public static /* synthetic */ CentralizedInfo copy$default(CentralizedInfo centralizedInfo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = centralizedInfo.title;
        }
        if ((i & 2) != 0) {
            str2 = centralizedInfo.link;
        }
        if ((i & 4) != 0) {
            str3 = centralizedInfo.type;
        }
        if ((i & 8) != 0) {
            str4 = centralizedInfo.date;
        }
        return centralizedInfo.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final CentralizedInfo copy(String title, String link, String type, String date) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(date, "date");
        return new CentralizedInfo(title, link, type, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CentralizedInfo)) {
            return false;
        }
        CentralizedInfo centralizedInfo = (CentralizedInfo) other;
        return Intrinsics.areEqual(this.title, centralizedInfo.title) && Intrinsics.areEqual(this.link, centralizedInfo.link) && Intrinsics.areEqual(this.type, centralizedInfo.type) && Intrinsics.areEqual(this.date, centralizedInfo.date);
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.link.hashCode()) * 31) + this.type.hashCode()) * 31) + this.date.hashCode();
    }

    public String toString() {
        return "CentralizedInfo(title=" + this.title + ", link=" + this.link + ", type=" + this.type + ", date=" + this.date + ")";
    }

    public CentralizedInfo(String title, String link, String type, String date) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(date, "date");
        this.title = title;
        this.link = link;
        this.type = type;
        this.date = date;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getType() {
        return this.type;
    }

    public final String getDate() {
        return this.date;
    }
}