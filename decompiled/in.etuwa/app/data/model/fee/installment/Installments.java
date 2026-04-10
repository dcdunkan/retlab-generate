package in.etuwa.app.data.model.fee.installment;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Installments.kt */
/* loaded from: classes3.dex */
public final /* data */ class Installments {
    private final String id;
    private final String name;

    public static /* synthetic */ Installments copy$default(Installments installments, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = installments.id;
        }
        if ((i & 2) != 0) {
            str2 = installments.name;
        }
        return installments.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Installments copy(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new Installments(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Installments)) {
            return false;
        }
        Installments installments = (Installments) other;
        return Intrinsics.areEqual(this.id, installments.id) && Intrinsics.areEqual(this.name, installments.name);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "Installments(id=" + this.id + ", name=" + this.name + ")";
    }

    public Installments(String id, String name) {
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