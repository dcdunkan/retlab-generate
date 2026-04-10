package in.etuwa.app.data.model.hostel.gcekhostel.registration;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RegistrationResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class RegistrationResponse {
    private final boolean is_hostler;
    private final boolean login;
    private final boolean re_admission;
    private final ArrayList<Registration> reg;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegistrationResponse copy$default(RegistrationResponse registrationResponse, boolean z, ArrayList arrayList, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = registrationResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = registrationResponse.reg;
        }
        if ((i & 4) != 0) {
            z2 = registrationResponse.re_admission;
        }
        if ((i & 8) != 0) {
            z3 = registrationResponse.is_hostler;
        }
        return registrationResponse.copy(z, arrayList, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Registration> component2() {
        return this.reg;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getRe_admission() {
        return this.re_admission;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIs_hostler() {
        return this.is_hostler;
    }

    public final RegistrationResponse copy(boolean login, ArrayList<Registration> reg, boolean re_admission, boolean is_hostler) {
        Intrinsics.checkNotNullParameter(reg, "reg");
        return new RegistrationResponse(login, reg, re_admission, is_hostler);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegistrationResponse)) {
            return false;
        }
        RegistrationResponse registrationResponse = (RegistrationResponse) other;
        return this.login == registrationResponse.login && Intrinsics.areEqual(this.reg, registrationResponse.reg) && this.re_admission == registrationResponse.re_admission && this.is_hostler == registrationResponse.is_hostler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int iHashCode = ((r0 * 31) + this.reg.hashCode()) * 31;
        boolean z2 = this.re_admission;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.is_hostler;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        return "RegistrationResponse(login=" + this.login + ", reg=" + this.reg + ", re_admission=" + this.re_admission + ", is_hostler=" + this.is_hostler + ")";
    }

    public RegistrationResponse(boolean z, ArrayList<Registration> reg, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(reg, "reg");
        this.login = z;
        this.reg = reg;
        this.re_admission = z2;
        this.is_hostler = z3;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Registration> getReg() {
        return this.reg;
    }

    public final boolean getRe_admission() {
        return this.re_admission;
    }

    public final boolean is_hostler() {
        return this.is_hostler;
    }
}