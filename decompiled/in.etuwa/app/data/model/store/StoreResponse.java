package in.etuwa.app.data.model.store;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoreResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class StoreResponse {
    private final ArrayList<Store> data;
    private final boolean login;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreResponse copy$default(StoreResponse storeResponse, boolean z, boolean z2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = storeResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = storeResponse.success;
        }
        if ((i & 4) != 0) {
            arrayList = storeResponse.data;
        }
        return storeResponse.copy(z, z2, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<Store> component3() {
        return this.data;
    }

    public final StoreResponse copy(boolean login, boolean success, ArrayList<Store> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new StoreResponse(login, success, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreResponse)) {
            return false;
        }
        StoreResponse storeResponse = (StoreResponse) other;
        return this.login == storeResponse.login && this.success == storeResponse.success && Intrinsics.areEqual(this.data, storeResponse.data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "StoreResponse(login=" + this.login + ", success=" + this.success + ", data=" + this.data + ")";
    }

    public StoreResponse(boolean z, boolean z2, ArrayList<Store> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.login = z;
        this.success = z2;
        this.data = data;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<Store> getData() {
        return this.data;
    }
}