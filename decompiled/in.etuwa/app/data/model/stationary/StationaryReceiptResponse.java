package in.etuwa.app.data.model.stationary;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StationaryReceiptResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class StationaryReceiptResponse {
    private final ArrayList<StationaryReceipt> data;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StationaryReceiptResponse copy$default(StationaryReceiptResponse stationaryReceiptResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = stationaryReceiptResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = stationaryReceiptResponse.data;
        }
        return stationaryReceiptResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<StationaryReceipt> component2() {
        return this.data;
    }

    public final StationaryReceiptResponse copy(boolean login, ArrayList<StationaryReceipt> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new StationaryReceiptResponse(login, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StationaryReceiptResponse)) {
            return false;
        }
        StationaryReceiptResponse stationaryReceiptResponse = (StationaryReceiptResponse) other;
        return this.login == stationaryReceiptResponse.login && Intrinsics.areEqual(this.data, stationaryReceiptResponse.data);
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
        return "StationaryReceiptResponse(login=" + this.login + ", data=" + this.data + ")";
    }

    public StationaryReceiptResponse(boolean z, ArrayList<StationaryReceipt> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.login = z;
        this.data = data;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<StationaryReceipt> getData() {
        return this.data;
    }
}