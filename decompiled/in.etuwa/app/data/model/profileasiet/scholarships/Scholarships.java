package in.etuwa.app.data.model.profileasiet.scholarships;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Scholarships.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
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