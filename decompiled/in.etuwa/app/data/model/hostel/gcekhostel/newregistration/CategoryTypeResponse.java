package in.etuwa.app.data.model.hostel.gcekhostel.newregistration;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CategoryTypeResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CategoryTypeResponse {
    private final ArrayList<CategoryType> category;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CategoryTypeResponse copy$default(CategoryTypeResponse categoryTypeResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = categoryTypeResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = categoryTypeResponse.category;
        }
        return categoryTypeResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CategoryType> component2() {
        return this.category;
    }

    public final CategoryTypeResponse copy(boolean login, ArrayList<CategoryType> category) {
        Intrinsics.checkNotNullParameter(category, "category");
        return new CategoryTypeResponse(login, category);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CategoryTypeResponse)) {
            return false;
        }
        CategoryTypeResponse categoryTypeResponse = (CategoryTypeResponse) other;
        return this.login == categoryTypeResponse.login && Intrinsics.areEqual(this.category, categoryTypeResponse.category);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.category.hashCode();
    }

    public String toString() {
        return "CategoryTypeResponse(login=" + this.login + ", category=" + this.category + ")";
    }

    public CategoryTypeResponse(boolean z, ArrayList<CategoryType> category) {
        Intrinsics.checkNotNullParameter(category, "category");
        this.login = z;
        this.category = category;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CategoryType> getCategory() {
        return this.category;
    }
}