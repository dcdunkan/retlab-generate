package in.etuwa.app.data.model.store;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Store.kt */
/* loaded from: classes3.dex */
public final /* data */ class Store {
    private final String name;
    private final String price;

    public static /* synthetic */ Store copy$default(Store store, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = store.name;
        }
        if ((i & 2) != 0) {
            str2 = store.price;
        }
        return store.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    public final Store copy(String name, String price) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        return new Store(name, price);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Store)) {
            return false;
        }
        Store store = (Store) other;
        return Intrinsics.areEqual(this.name, store.name) && Intrinsics.areEqual(this.price, store.price);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.price.hashCode();
    }

    public String toString() {
        return "Store(name=" + this.name + ", price=" + this.price + ")";
    }

    public Store(String name, String price) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        this.name = name;
        this.price = price;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPrice() {
        return this.price;
    }
}