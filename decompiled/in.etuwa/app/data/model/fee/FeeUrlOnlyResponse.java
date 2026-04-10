package in.etuwa.app.data.model.fee;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeeUrlOnlyResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class FeeUrlOnlyResponse {

    @SerializedName("url")
    private final String url;

    public static /* synthetic */ FeeUrlOnlyResponse copy$default(FeeUrlOnlyResponse feeUrlOnlyResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = feeUrlOnlyResponse.url;
        }
        return feeUrlOnlyResponse.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final FeeUrlOnlyResponse copy(String url) {
        return new FeeUrlOnlyResponse(url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FeeUrlOnlyResponse) && Intrinsics.areEqual(this.url, ((FeeUrlOnlyResponse) other).url);
    }

    public int hashCode() {
        String str = this.url;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "FeeUrlOnlyResponse(url=" + this.url + ")";
    }

    public FeeUrlOnlyResponse(String str) {
        this.url = str;
    }

    public final String getUrl() {
        return this.url;
    }
}