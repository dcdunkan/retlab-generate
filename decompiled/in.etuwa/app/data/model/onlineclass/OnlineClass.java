package in.etuwa.app.data.model.onlineclass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnlineClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class OnlineClass {

    @SerializedName("sub_name")
    @Expose
    private final String subName;

    @SerializedName("suburl")
    @Expose
    private final String subUrl;

    public static /* synthetic */ OnlineClass copy$default(OnlineClass onlineClass, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = onlineClass.subName;
        }
        if ((i & 2) != 0) {
            str2 = onlineClass.subUrl;
        }
        return onlineClass.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubName() {
        return this.subName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubUrl() {
        return this.subUrl;
    }

    public final OnlineClass copy(String subName, String subUrl) {
        Intrinsics.checkNotNullParameter(subName, "subName");
        Intrinsics.checkNotNullParameter(subUrl, "subUrl");
        return new OnlineClass(subName, subUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnlineClass)) {
            return false;
        }
        OnlineClass onlineClass = (OnlineClass) other;
        return Intrinsics.areEqual(this.subName, onlineClass.subName) && Intrinsics.areEqual(this.subUrl, onlineClass.subUrl);
    }

    public int hashCode() {
        return (this.subName.hashCode() * 31) + this.subUrl.hashCode();
    }

    public String toString() {
        return "OnlineClass(subName=" + this.subName + ", subUrl=" + this.subUrl + ")";
    }

    public OnlineClass(String subName, String subUrl) {
        Intrinsics.checkNotNullParameter(subName, "subName");
        Intrinsics.checkNotNullParameter(subUrl, "subUrl");
        this.subName = subName;
        this.subUrl = subUrl;
    }

    public final String getSubName() {
        return this.subName;
    }

    public final String getSubUrl() {
        return this.subUrl;
    }
}