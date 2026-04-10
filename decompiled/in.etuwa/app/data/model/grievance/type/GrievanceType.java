package in.etuwa.app.data.model.grievance.type;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GrievanceType.kt */
/* loaded from: classes3.dex */
public final /* data */ class GrievanceType {
    private final String id;
    private final String name;

    public static /* synthetic */ GrievanceType copy$default(GrievanceType grievanceType, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = grievanceType.id;
        }
        if ((i & 2) != 0) {
            str2 = grievanceType.name;
        }
        return grievanceType.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final GrievanceType copy(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new GrievanceType(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GrievanceType)) {
            return false;
        }
        GrievanceType grievanceType = (GrievanceType) other;
        return Intrinsics.areEqual(this.id, grievanceType.id) && Intrinsics.areEqual(this.name, grievanceType.name);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "GrievanceType(id=" + this.id + ", name=" + this.name + ")";
    }

    public GrievanceType(String id, String name) {
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
}