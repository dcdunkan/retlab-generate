package in.etuwa.app.data.model.internship.companylist;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompanyList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CompanyList {
    private final String id;
    private final String name;

    public static /* synthetic */ CompanyList copy$default(CompanyList companyList, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = companyList.id;
        }
        if ((i & 2) != 0) {
            str2 = companyList.name;
        }
        return companyList.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final CompanyList copy(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new CompanyList(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompanyList)) {
            return false;
        }
        CompanyList companyList = (CompanyList) other;
        return Intrinsics.areEqual(this.id, companyList.id) && Intrinsics.areEqual(this.name, companyList.name);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "CompanyList(id=" + this.id + ", name=" + this.name + ")";
    }

    public CompanyList(String id, String name) {
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