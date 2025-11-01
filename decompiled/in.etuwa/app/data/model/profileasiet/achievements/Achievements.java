package in.etuwa.app.data.model.profileasiet.achievements;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Achievements.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/profileasiet/achievements/Achievements;", "", "id", "", "name", "year", "file", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getId", "getName", "getYear", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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