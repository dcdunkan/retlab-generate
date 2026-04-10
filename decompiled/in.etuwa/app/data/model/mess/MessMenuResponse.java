package in.etuwa.app.data.model.mess;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessMenuResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class MessMenuResponse {
    private final ArrayList<MessItem> item;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessMenuResponse copy$default(MessMenuResponse messMenuResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = messMenuResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = messMenuResponse.item;
        }
        return messMenuResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<MessItem> component2() {
        return this.item;
    }

    public final MessMenuResponse copy(boolean login, ArrayList<MessItem> item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return new MessMenuResponse(login, item);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessMenuResponse)) {
            return false;
        }
        MessMenuResponse messMenuResponse = (MessMenuResponse) other;
        return this.login == messMenuResponse.login && Intrinsics.areEqual(this.item, messMenuResponse.item);
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
        return (r0 * 31) + this.item.hashCode();
    }

    public String toString() {
        return "MessMenuResponse(login=" + this.login + ", item=" + this.item + ")";
    }

    public MessMenuResponse(boolean z, ArrayList<MessItem> item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.login = z;
        this.item = item;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<MessItem> getItem() {
        return this.item;
    }
}