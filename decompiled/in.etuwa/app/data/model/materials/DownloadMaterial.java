package in.etuwa.app.data.model.materials;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadMaterial.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class DownloadMaterial {
    private final String url;

    public static /* synthetic */ DownloadMaterial copy$default(DownloadMaterial downloadMaterial, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = downloadMaterial.url;
        }
        return downloadMaterial.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final DownloadMaterial copy(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new DownloadMaterial(url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DownloadMaterial) && Intrinsics.areEqual(this.url, ((DownloadMaterial) other).url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "DownloadMaterial(url=" + this.url + ")";
    }

    public DownloadMaterial(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }

    public final String getUrl() {
        return this.url;
    }
}