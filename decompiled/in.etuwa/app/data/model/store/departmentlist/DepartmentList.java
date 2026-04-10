package in.etuwa.app.data.model.store.departmentlist;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DepartmentList.kt */
/* loaded from: classes3.dex */
public final /* data */ class DepartmentList {
    private final String id;
    private final String name;

    public static /* synthetic */ DepartmentList copy$default(DepartmentList departmentList, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = departmentList.id;
        }
        if ((i & 2) != 0) {
            str2 = departmentList.name;
        }
        return departmentList.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final DepartmentList copy(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new DepartmentList(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DepartmentList)) {
            return false;
        }
        DepartmentList departmentList = (DepartmentList) other;
        return Intrinsics.areEqual(this.id, departmentList.id) && Intrinsics.areEqual(this.name, departmentList.name);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "DepartmentList(id=" + this.id + ", name=" + this.name + ")";
    }

    public DepartmentList(String id, String name) {
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