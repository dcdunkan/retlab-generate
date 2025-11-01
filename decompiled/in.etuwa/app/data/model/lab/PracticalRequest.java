package in.etuwa.app.data.model.lab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PracticalRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/lab/PracticalRequest;", "", StoreFragmentKt.SUB_ID, "", "subPid", "(Ljava/lang/String;Ljava/lang/String;)V", "getSubId", "()Ljava/lang/String;", "getSubPid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PracticalRequest {

    @SerializedName("sub_id")
    @Expose
    private final String subId;

    @SerializedName("sub_pid")
    @Expose
    private final String subPid;

    public static /* synthetic */ PracticalRequest copy$default(PracticalRequest practicalRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = practicalRequest.subId;
        }
        if ((i & 2) != 0) {
            str2 = practicalRequest.subPid;
        }
        return practicalRequest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSubId() {
        return this.subId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubPid() {
        return this.subPid;
    }

    public final PracticalRequest copy(String subId, String subPid) {
        return new PracticalRequest(subId, subPid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PracticalRequest)) {
            return false;
        }
        PracticalRequest practicalRequest = (PracticalRequest) other;
        return Intrinsics.areEqual(this.subId, practicalRequest.subId) && Intrinsics.areEqual(this.subPid, practicalRequest.subPid);
    }

    public int hashCode() {
        String str = this.subId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subPid;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PracticalRequest(subId=" + this.subId + ", subPid=" + this.subPid + ")";
    }

    public PracticalRequest(String str, String str2) {
        this.subId = str;
        this.subPid = str2;
    }

    public final String getSubId() {
        return this.subId;
    }

    public final String getSubPid() {
        return this.subPid;
    }
}