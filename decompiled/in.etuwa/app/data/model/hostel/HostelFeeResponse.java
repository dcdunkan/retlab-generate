package in.etuwa.app.data.model.hostel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelFeeResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class HostelFeeResponse {
    private final String url;

    public static /* synthetic */ HostelFeeResponse copy$default(HostelFeeResponse hostelFeeResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hostelFeeResponse.url;
        }
        return hostelFeeResponse.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final HostelFeeResponse copy(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new HostelFeeResponse(url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HostelFeeResponse) && Intrinsics.areEqual(this.url, ((HostelFeeResponse) other).url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "HostelFeeResponse(url=" + this.url + ")";
    }

    public HostelFeeResponse(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }

    public final String getUrl() {
        return this.url;
    }
}