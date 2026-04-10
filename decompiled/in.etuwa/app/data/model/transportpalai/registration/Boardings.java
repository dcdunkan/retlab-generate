package in.etuwa.app.data.model.transportpalai.registration;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Boardings.kt */
/* loaded from: classes3.dex */
public final /* data */ class Boardings {
    private final int id;
    private final String name;

    public static /* synthetic */ Boardings copy$default(Boardings boardings, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = boardings.id;
        }
        if ((i2 & 2) != 0) {
            str = boardings.name;
        }
        return boardings.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Boardings copy(int id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new Boardings(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Boardings)) {
            return false;
        }
        Boardings boardings = (Boardings) other;
        return this.id == boardings.id && Intrinsics.areEqual(this.name, boardings.name);
    }

    public int hashCode() {
        return (this.id * 31) + this.name.hashCode();
    }

    public String toString() {
        return "Boardings(id=" + this.id + ", name=" + this.name + ")";
    }

    public Boardings(int i, String name) {
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