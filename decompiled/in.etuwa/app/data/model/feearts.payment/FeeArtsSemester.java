package in.etuwa.app.data.model.feearts.payment;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeeArtsSemester.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class FeeArtsSemester {
    private final int id;
    private final String name;

    public static /* synthetic */ FeeArtsSemester copy$default(FeeArtsSemester feeArtsSemester, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = feeArtsSemester.id;
        }
        if ((i2 & 2) != 0) {
            str = feeArtsSemester.name;
        }
        return feeArtsSemester.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final FeeArtsSemester copy(int id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new FeeArtsSemester(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeeArtsSemester)) {
            return false;
        }
        FeeArtsSemester feeArtsSemester = (FeeArtsSemester) other;
        return this.id == feeArtsSemester.id && Intrinsics.areEqual(this.name, feeArtsSemester.name);
    }

    public int hashCode() {
        return (this.id * 31) + this.name.hashCode();
    }

    public String toString() {
        return "FeeArtsSemester(id=" + this.id + ", name=" + this.name + ")";
    }

    public FeeArtsSemester(int i, String name) {
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