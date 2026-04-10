package in.etuwa.app.data.model.fee.feeheadgroups;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeHeadGroup.kt */
/* loaded from: classes3.dex */
public final /* data */ class FeeHeadGroup {

    @SerializedName("feeheadgroup_id")
    private final String feeHeadGroupId;

    public static /* synthetic */ FeeHeadGroup copy$default(FeeHeadGroup feeHeadGroup, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = feeHeadGroup.feeHeadGroupId;
        }
        return feeHeadGroup.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFeeHeadGroupId() {
        return this.feeHeadGroupId;
    }

    public final FeeHeadGroup copy(String feeHeadGroupId) {
        Intrinsics.checkNotNullParameter(feeHeadGroupId, "feeHeadGroupId");
        return new FeeHeadGroup(feeHeadGroupId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FeeHeadGroup) && Intrinsics.areEqual(this.feeHeadGroupId, ((FeeHeadGroup) other).feeHeadGroupId);
    }

    public int hashCode() {
        return this.feeHeadGroupId.hashCode();
    }

    public String toString() {
        return "FeeHeadGroup(feeHeadGroupId=" + this.feeHeadGroupId + ")";
    }

    public FeeHeadGroup(String feeHeadGroupId) {
        Intrinsics.checkNotNullParameter(feeHeadGroupId, "feeHeadGroupId");
        this.feeHeadGroupId = feeHeadGroupId;
    }

    public final String getFeeHeadGroupId() {
        return this.feeHeadGroupId;
    }
}