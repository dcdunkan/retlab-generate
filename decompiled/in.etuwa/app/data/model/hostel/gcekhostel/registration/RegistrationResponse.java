package in.etuwa.app.data.model.hostel.gcekhostel.registration;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RegistrationResponse.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003JA\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/model/hostel/gcekhostel/registration/RegistrationResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "reg", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/gcekhostel/registration/Registration;", "Lkotlin/collections/ArrayList;", "re_admission", "is_hostler", "(ZLjava/util/ArrayList;ZZ)V", "()Z", "getLogin", "getRe_admission", "getReg", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Registration> component2() {
        return this.reg;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getRe_admission() {
        return this.re_admission;
    }

    /* renamed from: component4, reason: from getter */
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
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = ((r0 * 31) + this.reg.hashCode()) * 31;
        ?? r2 = this.re_admission;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.is_hostler;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
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