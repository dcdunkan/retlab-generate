package in.etuwa.app.data.model.stationary;

import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StationaryItemResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class StationaryItemResponse {
    private final ArrayList<StationaryItem> data;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StationaryItemResponse copy$default(StationaryItemResponse stationaryItemResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = stationaryItemResponse.data;
        }
        return stationaryItemResponse.copy(arrayList);
    }

    public final ArrayList<StationaryItem> component1() {
        return this.data;
    }

    public final StationaryItemResponse copy(ArrayList<StationaryItem> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new StationaryItemResponse(data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StationaryItemResponse) && Intrinsics.areEqual(this.data, ((StationaryItemResponse) other).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "StationaryItemResponse(data=" + this.data + ")";
    }

    public StationaryItemResponse(ArrayList<StationaryItem> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public final ArrayList<StationaryItem> getData() {
        return this.data;
    }
}