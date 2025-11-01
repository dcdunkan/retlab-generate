package in.etuwa.app.data.model.fee;

import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeUrlResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/fee/FeeUrlResponse;", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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