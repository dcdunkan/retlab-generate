package in.etuwa.app.data.model.lab;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LabEquipRequest.kt */
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