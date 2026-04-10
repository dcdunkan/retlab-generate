package in.etuwa.app.data.model.hostel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelFeeTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class HostelFeeTypes {
    private final int id;
    private final String name;

    public static /* synthetic */ HostelFeeTypes copy$default(HostelFeeTypes hostelFeeTypes, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = hostelFeeTypes.id;
        }
        if ((i2 & 2) != 0) {
            str = hostelFeeTypes.name;
        }
        return hostelFeeTypes.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final HostelFeeTypes copy(int id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new HostelFeeTypes(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelFeeTypes)) {
            return false;
        }
        HostelFeeTypes hostelFeeTypes = (HostelFeeTypes) other;
        return this.id == hostelFeeTypes.id && Intrinsics.areEqual(this.name, hostelFeeTypes.name);
    }

    public int hashCode() {
        return (this.id * 31) + this.name.hashCode();
    }

    public String toString() {
        return "HostelFeeTypes(id=" + this.id + ", name=" + this.name + ")";
    }

    public HostelFeeTypes(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}