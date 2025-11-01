package in.etuwa.app.data.model.lab;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LabEquipRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/data/model/lab/LabEquipRequest;", "", "lid", "", "(Ljava/lang/String;)V", "getLid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LabEquipRequest {
    private final String lid;

    public static /* synthetic */ LabEquipRequest copy$default(LabEquipRequest labEquipRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = labEquipRequest.lid;
        }
        return labEquipRequest.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLid() {
        return this.lid;
    }

    public final LabEquipRequest copy(String lid) {
        return new LabEquipRequest(lid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LabEquipRequest) && Intrinsics.areEqual(this.lid, ((LabEquipRequest) other).lid);
    }

    public int hashCode() {
        String str = this.lid;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "LabEquipRequest(lid=" + this.lid + ")";
    }

    public LabEquipRequest(String str) {
        this.lid = str;
    }

    public final String getLid() {
        return this.lid;
    }
}