package in.etuwa.app.data.model.lab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LabList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class LabList {
    private final String id;

    @SerializedName("laboratary_name")
    @Expose
    private final String labName;

    public static /* synthetic */ LabList copy$default(LabList labList, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = labList.id;
        }
        if ((i & 2) != 0) {
            str2 = labList.labName;
        }
        return labList.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabName() {
        return this.labName;
    }

    public final LabList copy(String id, String labName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(labName, "labName");
        return new LabList(id, labName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LabList)) {
            return false;
        }
        LabList labList = (LabList) other;
        return Intrinsics.areEqual(this.id, labList.id) && Intrinsics.areEqual(this.labName, labList.labName);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.labName.hashCode();
    }

    public String toString() {
        return "LabList(id=" + this.id + ", labName=" + this.labName + ")";
    }

    public LabList(String id, String labName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(labName, "labName");
        this.id = id;
        this.labName = labName;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLabName() {
        return this.labName;
    }
}