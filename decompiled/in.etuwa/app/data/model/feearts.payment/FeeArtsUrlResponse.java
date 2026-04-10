package in.etuwa.app.data.model.feearts.payment;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeeArtsUrlResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class FeeArtsUrlResponse {
    private final String url;

    public static /* synthetic */ FeeArtsUrlResponse copy$default(FeeArtsUrlResponse feeArtsUrlResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = feeArtsUrlResponse.url;
        }
        return feeArtsUrlResponse.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final FeeArtsUrlResponse copy(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new FeeArtsUrlResponse(url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FeeArtsUrlResponse) && Intrinsics.areEqual(this.url, ((FeeArtsUrlResponse) other).url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "FeeArtsUrlResponse(url=" + this.url + ")";
    }

    public FeeArtsUrlResponse(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }

    public final String getUrl() {
        return this.url;
    }
}