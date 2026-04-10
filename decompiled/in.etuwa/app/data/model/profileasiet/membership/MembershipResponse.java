package in.etuwa.app.data.model.profileasiet.membership;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MembershipResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class MembershipResponse {
    private final boolean login;
    private final ArrayList<Membership> professionalsociety;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MembershipResponse copy$default(MembershipResponse membershipResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = membershipResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = membershipResponse.professionalsociety;
        }
        return membershipResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Membership> component2() {
        return this.professionalsociety;
    }

    public final MembershipResponse copy(boolean login, ArrayList<Membership> professionalsociety) {
        Intrinsics.checkNotNullParameter(professionalsociety, "professionalsociety");
        return new MembershipResponse(login, professionalsociety);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MembershipResponse)) {
            return false;
        }
        MembershipResponse membershipResponse = (MembershipResponse) other;
        return this.login == membershipResponse.login && Intrinsics.areEqual(this.professionalsociety, membershipResponse.professionalsociety);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.professionalsociety.hashCode();
    }

    public String toString() {
        return "MembershipResponse(login=" + this.login + ", professionalsociety=" + this.professionalsociety + ")";
    }

    public MembershipResponse(boolean z, ArrayList<Membership> professionalsociety) {
        Intrinsics.checkNotNullParameter(professionalsociety, "professionalsociety");
        this.login = z;
        this.professionalsociety = professionalsociety;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Membership> getProfessionalsociety() {
        return this.professionalsociety;
    }
}