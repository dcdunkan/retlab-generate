package in.etuwa.app.data.model.lab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PracticalRequest.kt */
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