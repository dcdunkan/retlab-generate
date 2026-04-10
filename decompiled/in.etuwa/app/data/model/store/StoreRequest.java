package in.etuwa.app.data.model.store;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoreRequest.kt */
/* loaded from: classes3.dex */
public final /* data */ class StoreRequest {

    @SerializedName("subject_id")
    @Expose
    private final String subId;

    public static /* synthetic */ StoreRequest copy$default(StoreRequest storeRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storeRequest.subId;
        }
        return storeRequest.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSubId() {
        return this.subId;
    }

    public final StoreRequest copy(String subId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        return new StoreRequest(subId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StoreRequest) && Intrinsics.areEqual(this.subId, ((StoreRequest) other).subId);
    }

    public int hashCode() {
        return this.subId.hashCode();
    }

    public String toString() {
        return "StoreRequest(subId=" + this.subId + ")";
    }

    public StoreRequest(String subId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        this.subId = subId;
    }

    public final String getSubId() {
        return this.subId;
    }
}