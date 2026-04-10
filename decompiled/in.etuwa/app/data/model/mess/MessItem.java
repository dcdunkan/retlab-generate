package in.etuwa.app.data.model.mess;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessItem.kt */
/* loaded from: classes3.dex */
public final /* data */ class MessItem {
    private final String id;
    private final String max_qty;
    private final String name;

    public static /* synthetic */ MessItem copy$default(MessItem messItem, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messItem.id;
        }
        if ((i & 2) != 0) {
            str2 = messItem.name;
        }
        if ((i & 4) != 0) {
            str3 = messItem.max_qty;
        }
        return messItem.copy(str, str2, str3);
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
    public final String getMax_qty() {
        return this.max_qty;
    }

    public final MessItem copy(String id, String name, String max_qty) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(max_qty, "max_qty");
        return new MessItem(id, name, max_qty);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessItem)) {
            return false;
        }
        MessItem messItem = (MessItem) other;
        return Intrinsics.areEqual(this.id, messItem.id) && Intrinsics.areEqual(this.name, messItem.name) && Intrinsics.areEqual(this.max_qty, messItem.max_qty);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.max_qty.hashCode();
    }

    public String toString() {
        return "MessItem(id=" + this.id + ", name=" + this.name + ", max_qty=" + this.max_qty + ")";
    }

    public MessItem(String id, String name, String max_qty) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(max_qty, "max_qty");
        this.id = id;
        this.name = name;
        this.max_qty = max_qty;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getMax_qty() {
        return this.max_qty;
    }
}