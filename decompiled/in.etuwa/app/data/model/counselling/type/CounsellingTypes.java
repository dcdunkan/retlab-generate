package in.etuwa.app.data.model.counselling.type;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CounsellingTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CounsellingTypes {
    private final String id;
    private final String name;

    public static /* synthetic */ CounsellingTypes copy$default(CounsellingTypes counsellingTypes, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = counsellingTypes.id;
        }
        if ((i & 2) != 0) {
            str2 = counsellingTypes.name;
        }
        return counsellingTypes.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final CounsellingTypes copy(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new CounsellingTypes(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CounsellingTypes)) {
            return false;
        }
        CounsellingTypes counsellingTypes = (CounsellingTypes) other;
        return Intrinsics.areEqual(this.id, counsellingTypes.id) && Intrinsics.areEqual(this.name, counsellingTypes.name);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "CounsellingTypes(id=" + this.id + ", name=" + this.name + ")";
    }

    public CounsellingTypes(String id, String name) {
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