package in.etuwa.app.data.model.subjectregistration;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PathWay.kt */
/* loaded from: classes3.dex */
public final /* data */ class PathWay {
    private final int id;
    private final String name;

    public static /* synthetic */ PathWay copy$default(PathWay pathWay, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = pathWay.id;
        }
        if ((i2 & 2) != 0) {
            str = pathWay.name;
        }
        return pathWay.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final PathWay copy(int id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new PathWay(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PathWay)) {
            return false;
        }
        PathWay pathWay = (PathWay) other;
        return this.id == pathWay.id && Intrinsics.areEqual(this.name, pathWay.name);
    }

    public int hashCode() {
        return (this.id * 31) + this.name.hashCode();
    }

    public String toString() {
        return "PathWay(id=" + this.id + ", name=" + this.name + ")";
    }

    public PathWay(int i, String name) {
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