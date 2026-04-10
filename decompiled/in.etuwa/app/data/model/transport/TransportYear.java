package in.etuwa.app.data.model.transport;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TransportYear.kt */
/* loaded from: classes3.dex */
public final /* data */ class TransportYear {
    private final int id;
    private final String name;

    public static /* synthetic */ TransportYear copy$default(TransportYear transportYear, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = transportYear.id;
        }
        if ((i2 & 2) != 0) {
            str = transportYear.name;
        }
        return transportYear.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final TransportYear copy(int id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new TransportYear(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportYear)) {
            return false;
        }
        TransportYear transportYear = (TransportYear) other;
        return this.id == transportYear.id && Intrinsics.areEqual(this.name, transportYear.name);
    }

    public int hashCode() {
        return (this.id * 31) + this.name.hashCode();
    }

    public String toString() {
        return "TransportYear(id=" + this.id + ", name=" + this.name + ")";
    }

    public TransportYear(int i, String name) {
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