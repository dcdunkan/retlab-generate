package in.etuwa.app.data.model.mess;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessItem.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/mess/MessItem;", "", "id", "", "name", "max_qty", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getMax_qty", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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