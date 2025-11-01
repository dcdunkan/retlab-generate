package in.etuwa.app.data.model.profileasiet.positionheld;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PositionHeld.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/model/profileasiet/positionheld/PositionHeld;", "", "id", "", "name", "year", "start", "end", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnd", "()Ljava/lang/String;", "getId", "getName", "getStart", "getYear", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PositionHeld {
    private final String end;
    private final String id;
    private final String name;
    private final String start;
    private final String year;

    public static /* synthetic */ PositionHeld copy$default(PositionHeld positionHeld, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = positionHeld.id;
        }
        if ((i & 2) != 0) {
            str2 = positionHeld.name;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = positionHeld.year;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = positionHeld.start;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = positionHeld.end;
        }
        return positionHeld.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStart() {
        return this.start;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEnd() {
        return this.end;
    }

    public final PositionHeld copy(String id, String name, String year, String start, String end) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        return new PositionHeld(id, name, year, start, end);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PositionHeld)) {
            return false;
        }
        PositionHeld positionHeld = (PositionHeld) other;
        return Intrinsics.areEqual(this.id, positionHeld.id) && Intrinsics.areEqual(this.name, positionHeld.name) && Intrinsics.areEqual(this.year, positionHeld.year) && Intrinsics.areEqual(this.start, positionHeld.start) && Intrinsics.areEqual(this.end, positionHeld.end);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.year.hashCode()) * 31) + this.start.hashCode()) * 31) + this.end.hashCode();
    }

    public String toString() {
        return "PositionHeld(id=" + this.id + ", name=" + this.name + ", year=" + this.year + ", start=" + this.start + ", end=" + this.end + ")";
    }

    public PositionHeld(String id, String name, String year, String start, String end) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        this.id = id;
        this.name = name;
        this.year = year;
        this.start = start;
        this.end = end;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getYear() {
        return this.year;
    }

    public final String getStart() {
        return this.start;
    }

    public final String getEnd() {
        return this.end;
    }
}