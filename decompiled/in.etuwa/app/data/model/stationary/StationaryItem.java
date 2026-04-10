package in.etuwa.app.data.model.stationary;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StationaryItem.kt */
/* loaded from: classes3.dex */
public final /* data */ class StationaryItem {
    private final String category_id;
    private final String category_name;
    private final String id;
    private final String name;
    private final String pre_url;
    private final String price;
    private final String subcategory_id;
    private final String subcategory_name;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCategory_name() {
        return this.category_name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSubcategory_name() {
        return this.subcategory_name;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPre_url() {
        return this.pre_url;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCategory_id() {
        return this.category_id;
    }

    /* renamed from: component8, reason: from getter */
    public final String getSubcategory_id() {
        return this.subcategory_id;
    }

    public final StationaryItem copy(String id, String name, String category_name, String subcategory_name, String price, String pre_url, String category_id, String subcategory_id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(category_name, "category_name");
        Intrinsics.checkNotNullParameter(subcategory_name, "subcategory_name");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(pre_url, "pre_url");
        Intrinsics.checkNotNullParameter(category_id, "category_id");
        Intrinsics.checkNotNullParameter(subcategory_id, "subcategory_id");
        return new StationaryItem(id, name, category_name, subcategory_name, price, pre_url, category_id, subcategory_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StationaryItem)) {
            return false;
        }
        StationaryItem stationaryItem = (StationaryItem) other;
        return Intrinsics.areEqual(this.id, stationaryItem.id) && Intrinsics.areEqual(this.name, stationaryItem.name) && Intrinsics.areEqual(this.category_name, stationaryItem.category_name) && Intrinsics.areEqual(this.subcategory_name, stationaryItem.subcategory_name) && Intrinsics.areEqual(this.price, stationaryItem.price) && Intrinsics.areEqual(this.pre_url, stationaryItem.pre_url) && Intrinsics.areEqual(this.category_id, stationaryItem.category_id) && Intrinsics.areEqual(this.subcategory_id, stationaryItem.subcategory_id);
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.category_name.hashCode()) * 31) + this.subcategory_name.hashCode()) * 31) + this.price.hashCode()) * 31) + this.pre_url.hashCode()) * 31) + this.category_id.hashCode()) * 31) + this.subcategory_id.hashCode();
    }

    public String toString() {
        return "StationaryItem(id=" + this.id + ", name=" + this.name + ", category_name=" + this.category_name + ", subcategory_name=" + this.subcategory_name + ", price=" + this.price + ", pre_url=" + this.pre_url + ", category_id=" + this.category_id + ", subcategory_id=" + this.subcategory_id + ")";
    }

    public StationaryItem(String id, String name, String category_name, String subcategory_name, String price, String pre_url, String category_id, String subcategory_id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(category_name, "category_name");
        Intrinsics.checkNotNullParameter(subcategory_name, "subcategory_name");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(pre_url, "pre_url");
        Intrinsics.checkNotNullParameter(category_id, "category_id");
        Intrinsics.checkNotNullParameter(subcategory_id, "subcategory_id");
        this.id = id;
        this.name = name;
        this.category_name = category_name;
        this.subcategory_name = subcategory_name;
        this.price = price;
        this.pre_url = pre_url;
        this.category_id = category_id;
        this.subcategory_id = subcategory_id;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getCategory_name() {
        return this.category_name;
    }

    public final String getSubcategory_name() {
        return this.subcategory_name;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getPre_url() {
        return this.pre_url;
    }

    public final String getCategory_id() {
        return this.category_id;
    }

    public final String getSubcategory_id() {
        return this.subcategory_id;
    }
}