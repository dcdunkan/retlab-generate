package in.etuwa.app.data.model.profileasiet.achievements;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Achievements.kt */
/* loaded from: classes3.dex */
public final /* data */ class Achievements {
    private final String file;
    private final String id;
    private final String name;
    private final String year;

    public static /* synthetic */ Achievements copy$default(Achievements achievements, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = achievements.id;
        }
        if ((i & 2) != 0) {
            str2 = achievements.name;
        }
        if ((i & 4) != 0) {
            str3 = achievements.year;
        }
        if ((i & 8) != 0) {
            str4 = achievements.file;
        }
        return achievements.copy(str, str2, str3, str4);
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
    public final String getFile() {
        return this.file;
    }

    public final Achievements copy(String id, String name, String year, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(file, "file");
        return new Achievements(id, name, year, file);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Achievements)) {
            return false;
        }
        Achievements achievements = (Achievements) other;
        return Intrinsics.areEqual(this.id, achievements.id) && Intrinsics.areEqual(this.name, achievements.name) && Intrinsics.areEqual(this.year, achievements.year) && Intrinsics.areEqual(this.file, achievements.file);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.year.hashCode()) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "Achievements(id=" + this.id + ", name=" + this.name + ", year=" + this.year + ", file=" + this.file + ")";
    }

    public Achievements(String id, String name, String year, String file) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(year, "year");
        Intrinsics.checkNotNullParameter(file, "file");
        this.id = id;
        this.name = name;
        this.year = year;
        this.file = file;
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

    public final String getFile() {
        return this.file;
    }
}