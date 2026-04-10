package in.etuwa.app.data.model.placement;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlacementRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class PlacementRequest {

    @SerializedName("placement_id")
    @Expose
    private final String placementId;

    public static /* synthetic */ PlacementRequest copy$default(PlacementRequest placementRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = placementRequest.placementId;
        }
        return placementRequest.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPlacementId() {
        return this.placementId;
    }

    public final PlacementRequest copy(String placementId) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        return new PlacementRequest(placementId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PlacementRequest) && Intrinsics.areEqual(this.placementId, ((PlacementRequest) other).placementId);
    }

    public int hashCode() {
        return this.placementId.hashCode();
    }

    public String toString() {
        return "PlacementRequest(placementId=" + this.placementId + ")";
    }

    public PlacementRequest(String placementId) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        this.placementId = placementId;
    }

    public final String getPlacementId() {
        return this.placementId;
    }
}