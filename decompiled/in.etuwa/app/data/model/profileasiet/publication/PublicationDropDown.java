package in.etuwa.app.data.model.profileasiet.publication;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PublicationDropDown.kt */
/* loaded from: classes3.dex */
public final /* data */ class PublicationDropDown {
    private final int id;
    private final String name;

    public static /* synthetic */ PublicationDropDown copy$default(PublicationDropDown publicationDropDown, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = publicationDropDown.id;
        }
        if ((i2 & 2) != 0) {
            str = publicationDropDown.name;
        }
        return publicationDropDown.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final PublicationDropDown copy(int id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new PublicationDropDown(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublicationDropDown)) {
            return false;
        }
        PublicationDropDown publicationDropDown = (PublicationDropDown) other;
        return this.id == publicationDropDown.id && Intrinsics.areEqual(this.name, publicationDropDown.name);
    }

    public int hashCode() {
        return (this.id * 31) + this.name.hashCode();
    }

    public String toString() {
        return "PublicationDropDown(id=" + this.id + ", name=" + this.name + ")";
    }

    public PublicationDropDown(int i, String name) {
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