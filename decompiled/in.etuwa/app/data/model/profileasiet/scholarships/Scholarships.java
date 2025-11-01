package in.etuwa.app.data.model.profileasiet.scholarships;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scholarships.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/profileasiet/scholarships/Scholarships;", "", "id", "", "type", "name", "year", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getType", "getYear", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Scholarships {
    private final String id;
    private final String name;
    private final String type;
    private final String year;

    public static /* synthetic */ Scholarships copy$default(Scholarships scholarships, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scholarships.id;
        }
        if ((i & 2) != 0) {
            str2 = scholarships.type;
        }
        if ((i & 4) != 0) {
            str3 = scholarships.name;
        }
        if ((i & 8) != 0) {
            str4 = scholarships.year;
        }
        return scholarships.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    public final Scholarships copy(String id, String type, String name, String year) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(year, "year");
        return new Scholarships(id, type, name, year);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Scholarships)) {
            return false;
        }
        Scholarships scholarships = (Scholarships) other;
        return Intrinsics.areEqual(this.id, scholarships.id) && Intrinsics.areEqual(this.type, scholarships.type) && Intrinsics.areEqual(this.name, scholarships.name) && Intrinsics.areEqual(this.year, scholarships.year);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.name.hashCode()) * 31) + this.year.hashCode();
    }

    public String toString() {
        return "Scholarships(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", year=" + this.year + ")";
    }

    public Scholarships(String id, String type, String name, String year) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(year, "year");
        this.id = id;
        this.type = type;
        this.name = name;
        this.year = year;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final String getYear() {
        return this.year;
    }
}