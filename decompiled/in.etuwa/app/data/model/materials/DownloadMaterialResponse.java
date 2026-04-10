package in.etuwa.app.data.model.materials;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadMaterialResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class DownloadMaterialResponse {
    private final ArrayList<DownloadMaterial> files;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DownloadMaterialResponse copy$default(DownloadMaterialResponse downloadMaterialResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = downloadMaterialResponse.files;
        }
        return downloadMaterialResponse.copy(arrayList);
    }

    public final ArrayList<DownloadMaterial> component1() {
        return this.files;
    }

    public final DownloadMaterialResponse copy(ArrayList<DownloadMaterial> files) {
        Intrinsics.checkNotNullParameter(files, "files");
        return new DownloadMaterialResponse(files);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DownloadMaterialResponse) && Intrinsics.areEqual(this.files, ((DownloadMaterialResponse) other).files);
    }

    public int hashCode() {
        return this.files.hashCode();
    }

    public String toString() {
        return "DownloadMaterialResponse(files=" + this.files + ")";
    }

    public DownloadMaterialResponse(ArrayList<DownloadMaterial> files) {
        Intrinsics.checkNotNullParameter(files, "files");
        this.files = files;
    }

    public final ArrayList<DownloadMaterial> getFiles() {
        return this.files;
    }
}