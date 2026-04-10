package in.etuwa.app.data.model.fee.feeheadgroups;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeeHeadGroupResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class FeeHeadGroupResponse {

    @SerializedName("fees")
    @Expose
    private final ArrayList<FeeHeadGroup> feeHeadGroups;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeeHeadGroupResponse copy$default(FeeHeadGroupResponse feeHeadGroupResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = feeHeadGroupResponse.feeHeadGroups;
        }
        return feeHeadGroupResponse.copy(arrayList);
    }

    public final ArrayList<FeeHeadGroup> component1() {
        return this.feeHeadGroups;
    }

    public final FeeHeadGroupResponse copy(ArrayList<FeeHeadGroup> feeHeadGroups) {
        Intrinsics.checkNotNullParameter(feeHeadGroups, "feeHeadGroups");
        return new FeeHeadGroupResponse(feeHeadGroups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FeeHeadGroupResponse) && Intrinsics.areEqual(this.feeHeadGroups, ((FeeHeadGroupResponse) other).feeHeadGroups);
    }

    public int hashCode() {
        return this.feeHeadGroups.hashCode();
    }

    public String toString() {
        return "FeeHeadGroupResponse(feeHeadGroups=" + this.feeHeadGroups + ")";
    }

    public FeeHeadGroupResponse(ArrayList<FeeHeadGroup> feeHeadGroups) {
        Intrinsics.checkNotNullParameter(feeHeadGroups, "feeHeadGroups");
        this.feeHeadGroups = feeHeadGroups;
    }

    public final ArrayList<FeeHeadGroup> getFeeHeadGroups() {
        return this.feeHeadGroups;
    }
}