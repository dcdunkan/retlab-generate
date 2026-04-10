package in.etuwa.app.data.model.mess;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OrderHistoryResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class OrderHistoryResponse {
    private final ArrayList<OrderHistory> data;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OrderHistoryResponse copy$default(OrderHistoryResponse orderHistoryResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = orderHistoryResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = orderHistoryResponse.data;
        }
        return orderHistoryResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<OrderHistory> component2() {
        return this.data;
    }

    public final OrderHistoryResponse copy(boolean login, ArrayList<OrderHistory> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new OrderHistoryResponse(login, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderHistoryResponse)) {
            return false;
        }
        OrderHistoryResponse orderHistoryResponse = (OrderHistoryResponse) other;
        return this.login == orderHistoryResponse.login && Intrinsics.areEqual(this.data, orderHistoryResponse.data);
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
        return (r0 * 31) + this.data.hashCode();
    }

    public String toString() {
        return "OrderHistoryResponse(login=" + this.login + ", data=" + this.data + ")";
    }

    public OrderHistoryResponse(boolean z, ArrayList<OrderHistory> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.login = z;
        this.data = data;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<OrderHistory> getData() {
        return this.data;
    }
}