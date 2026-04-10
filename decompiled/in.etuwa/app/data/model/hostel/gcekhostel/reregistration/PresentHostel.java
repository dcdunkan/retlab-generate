package in.etuwa.app.data.model.hostel.gcekhostel.reregistration;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PresentHostel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class PresentHostel {
    private final int id;
    private final String name;

    public static /* synthetic */ PresentHostel copy$default(PresentHostel presentHostel, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = presentHostel.id;
        }
        if ((i2 & 2) != 0) {
            str = presentHostel.name;
        }
        return presentHostel.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final PresentHostel copy(int id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new PresentHostel(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PresentHostel)) {
            return false;
        }
        PresentHostel presentHostel = (PresentHostel) other;
        return this.id == presentHostel.id && Intrinsics.areEqual(this.name, presentHostel.name);
    }

    public int hashCode() {
        return (this.id * 31) + this.name.hashCode();
    }

    public String toString() {
        return "PresentHostel(id=" + this.id + ", name=" + this.name + ")";
    }

    public PresentHostel(int i, String name) {
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