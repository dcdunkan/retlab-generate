package in.etuwa.app.data.model.semregistration;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AcademicYear.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AcademicYear {
    private final int id;
    private final String name;

    public static /* synthetic */ AcademicYear copy$default(AcademicYear academicYear, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = academicYear.id;
        }
        if ((i2 & 2) != 0) {
            str = academicYear.name;
        }
        return academicYear.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final AcademicYear copy(int id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new AcademicYear(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AcademicYear)) {
            return false;
        }
        AcademicYear academicYear = (AcademicYear) other;
        return this.id == academicYear.id && Intrinsics.areEqual(this.name, academicYear.name);
    }

    public int hashCode() {
        return (this.id * 31) + this.name.hashCode();
    }

    public String toString() {
        return "AcademicYear(id=" + this.id + ", name=" + this.name + ")";
    }

    public AcademicYear(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}