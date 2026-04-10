package in.etuwa.app.data.model.profileasiet.membership;

import com.itextpdf.kernel.xmp.PdfConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Membership.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Membership {
    private final String description;
    private final String file;
    private final String id;
    private final String member_id;
    private final String member_since;
    private final String name;
    private final String type;

    public static /* synthetic */ Membership copy$default(Membership membership, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = membership.id;
        }
        if ((i & 2) != 0) {
            str2 = membership.name;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = membership.type;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = membership.member_id;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = membership.description;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = membership.file;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = membership.member_since;
        }
        return membership.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMember_id() {
        return this.member_id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMember_since() {
        return this.member_since;
    }

    public final Membership copy(String id, String name, String type, String member_id, String description, String file, String member_since) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(member_id, "member_id");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(member_since, "member_since");
        return new Membership(id, name, type, member_id, description, file, member_since);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Membership)) {
            return false;
        }
        Membership membership = (Membership) other;
        return Intrinsics.areEqual(this.id, membership.id) && Intrinsics.areEqual(this.name, membership.name) && Intrinsics.areEqual(this.type, membership.type) && Intrinsics.areEqual(this.member_id, membership.member_id) && Intrinsics.areEqual(this.description, membership.description) && Intrinsics.areEqual(this.file, membership.file) && Intrinsics.areEqual(this.member_since, membership.member_since);
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31) + this.member_id.hashCode()) * 31) + this.description.hashCode()) * 31) + this.file.hashCode()) * 31) + this.member_since.hashCode();
    }

    public String toString() {
        return "Membership(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", member_id=" + this.member_id + ", description=" + this.description + ", file=" + this.file + ", member_since=" + this.member_since + ")";
    }

    public Membership(String id, String name, String type, String member_id, String description, String file, String member_since) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(member_id, "member_id");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(member_since, "member_since");
        this.id = id;
        this.name = name;
        this.type = type;
        this.member_id = member_id;
        this.description = description;
        this.file = file;
        this.member_since = member_since;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final String getMember_id() {
        return this.member_id;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getFile() {
        return this.file;
    }

    public final String getMember_since() {
        return this.member_since;
    }
}