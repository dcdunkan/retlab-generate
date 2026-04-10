package in.etuwa.app.data.model.fee;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeUrlResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class FeeUrlResponse {

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    private final String error;

    @SerializedName("url")
    private final String url;

    public static /* synthetic */ FeeUrlResponse copy$default(FeeUrlResponse feeUrlResponse, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = feeUrlResponse.error;
        }
        if ((i & 2) != 0) {
            str2 = feeUrlResponse.url;
        }
        return feeUrlResponse.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final FeeUrlResponse copy(String error, String url) {
        return new FeeUrlResponse(error, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeeUrlResponse)) {
            return false;
        }
        FeeUrlResponse feeUrlResponse = (FeeUrlResponse) other;
        return Intrinsics.areEqual(this.error, feeUrlResponse.error) && Intrinsics.areEqual(this.url, feeUrlResponse.url);
    }

    public int hashCode() {
        String str = this.error;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "FeeUrlResponse(error=" + this.error + ", url=" + this.url + ")";
    }

    public FeeUrlResponse(String str, String str2) {
        this.error = str;
        this.url = str2;
    }

    public final String getError() {
        return this.error;
    }

    public final String getUrl() {
        return this.url;
    }
}