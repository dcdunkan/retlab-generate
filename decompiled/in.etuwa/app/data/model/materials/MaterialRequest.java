package in.etuwa.app.data.model.materials;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class MaterialRequest {

    @SerializedName("sem_id")
    @Expose
    private final String semId;

    public static /* synthetic */ MaterialRequest copy$default(MaterialRequest materialRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = materialRequest.semId;
        }
        return materialRequest.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSemId() {
        return this.semId;
    }

    public final MaterialRequest copy(String semId) {
        Intrinsics.checkNotNullParameter(semId, "semId");
        return new MaterialRequest(semId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MaterialRequest) && Intrinsics.areEqual(this.semId, ((MaterialRequest) other).semId);
    }

    public int hashCode() {
        return this.semId.hashCode();
    }

    public String toString() {
        return "MaterialRequest(semId=" + this.semId + ")";
    }

    public MaterialRequest(String semId) {
        Intrinsics.checkNotNullParameter(semId, "semId");
        this.semId = semId;
    }

    public final String getSemId() {
        return this.semId;
    }
}