package in.etuwa.app.data.model.centralizedinfo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CentralizedInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/centralizedinfo/CentralizedInfo;", "", "title", "", "link", "type", "date", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getLink", "getTitle", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
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