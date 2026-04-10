package in.etuwa.app.data.model.subject.co;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoSyllabusRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CoSyllabusRequest {

    @SerializedName("sub_id")
    @Expose
    private final String subId;

    public static /* synthetic */ CoSyllabusRequest copy$default(CoSyllabusRequest coSyllabusRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = coSyllabusRequest.subId;
        }
        return coSyllabusRequest.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubId() {
        return this.subId;
    }

    public final CoSyllabusRequest copy(String subId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        return new CoSyllabusRequest(subId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CoSyllabusRequest) && Intrinsics.areEqual(this.subId, ((CoSyllabusRequest) other).subId);
    }

    public int hashCode() {
        return this.subId.hashCode();
    }

    public String toString() {
        return "CoSyllabusRequest(subId=" + this.subId + ")";
    }

    public CoSyllabusRequest(String subId) {
        Intrinsics.checkNotNullParameter(subId, "subId");
        this.subId = subId;
    }

    public final String getSubId() {
        return this.subId;
    }
}