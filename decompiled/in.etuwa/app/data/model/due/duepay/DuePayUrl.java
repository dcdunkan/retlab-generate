package in.etuwa.app.data.model.due.duepay;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DuePayUrl.kt */
/* loaded from: classes3.dex */
public final /* data */ class DuePayUrl {
    private final String url;

    public static /* synthetic */ DuePayUrl copy$default(DuePayUrl duePayUrl, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = duePayUrl.url;
        }
        return duePayUrl.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final DuePayUrl copy(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new DuePayUrl(url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DuePayUrl) && Intrinsics.areEqual(this.url, ((DuePayUrl) other).url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "DuePayUrl(url=" + this.url + ")";
    }

    public DuePayUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }

    public final String getUrl() {
        return this.url;
    }
}