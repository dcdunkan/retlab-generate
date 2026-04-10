package in.etuwa.app.data.model.mess;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessType.kt */
/* loaded from: classes3.dex */
public final /* data */ class MessType {
    private final String id;
    private final String name;

    public static /* synthetic */ MessType copy$default(MessType messType, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messType.id;
        }
        if ((i & 2) != 0) {
            str2 = messType.name;
        }
        return messType.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final MessType copy(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new MessType(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessType)) {
            return false;
        }
        MessType messType = (MessType) other;
        return Intrinsics.areEqual(this.id, messType.id) && Intrinsics.areEqual(this.name, messType.name);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "MessType(id=" + this.id + ", name=" + this.name + ")";
    }

    public MessType(String id, String name) {
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