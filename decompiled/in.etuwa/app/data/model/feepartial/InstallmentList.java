package in.etuwa.app.data.model.feepartial;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InstallmentList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class InstallmentList {
    private final String id;
    private final String name;

    public static /* synthetic */ InstallmentList copy$default(InstallmentList installmentList, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = installmentList.id;
        }
        if ((i & 2) != 0) {
            str2 = installmentList.name;
        }
        return installmentList.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final InstallmentList copy(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new InstallmentList(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstallmentList)) {
            return false;
        }
        InstallmentList installmentList = (InstallmentList) other;
        return Intrinsics.areEqual(this.id, installmentList.id) && Intrinsics.areEqual(this.name, installmentList.name);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "InstallmentList(id=" + this.id + ", name=" + this.name + ")";
    }

    public InstallmentList(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.name = name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}