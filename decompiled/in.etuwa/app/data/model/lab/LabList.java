package in.etuwa.app.data.model.lab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LabList.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/lab/LabList;", "", "id", "", "labName", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLabName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
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