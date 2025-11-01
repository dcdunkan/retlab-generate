package in.etuwa.app.data.model.store;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoreRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/data/model/store/StoreRequest;", "", StoreFragmentKt.SUB_ID, "", "(Ljava/lang/String;)V", "getSubId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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