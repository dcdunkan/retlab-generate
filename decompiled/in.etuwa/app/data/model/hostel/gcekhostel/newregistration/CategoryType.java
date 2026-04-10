package in.etuwa.app.data.model.hostel.gcekhostel.newregistration;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CategoryType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CategoryType {
    private final int id;
    private final String name;

    public static /* synthetic */ CategoryType copy$default(CategoryType categoryType, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = categoryType.id;
        }
        if ((i2 & 2) != 0) {
            str = categoryType.name;
        }
        return categoryType.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final CategoryType copy(int id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new CategoryType(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CategoryType)) {
            return false;
        }
        CategoryType categoryType = (CategoryType) other;
        return this.id == categoryType.id && Intrinsics.areEqual(this.name, categoryType.name);
    }

    public int hashCode() {
        return (this.id * 31) + this.name.hashCode();
    }

    public String toString() {
        return "CategoryType(id=" + this.id + ", name=" + this.name + ")";
    }

    public CategoryType(int i, String name) {
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