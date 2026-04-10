package in.etuwa.app.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Semester.kt */
/* loaded from: classes3.dex */
public final /* data */ class Semester {
    private final String id;
    private final String name;

    public static /* synthetic */ Semester copy$default(Semester semester, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = semester.id;
        }
        if ((i & 2) != 0) {
            str2 = semester.name;
        }
        return semester.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Semester copy(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new Semester(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Semester)) {
            return false;
        }
        Semester semester = (Semester) other;
        return Intrinsics.areEqual(this.id, semester.id) && Intrinsics.areEqual(this.name, semester.name);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode();
    }

    public Semester(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.name = name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }
}