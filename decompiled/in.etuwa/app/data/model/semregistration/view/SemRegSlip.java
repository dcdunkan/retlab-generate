package in.etuwa.app.data.model.semregistration.view;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SemRegSlip.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SemRegSlip {
    private final boolean login;
    private final String regslip_file;
    private final boolean success;

    public static /* synthetic */ SemRegSlip copy$default(SemRegSlip semRegSlip, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = semRegSlip.login;
        }
        if ((i & 2) != 0) {
            z2 = semRegSlip.success;
        }
        if ((i & 4) != 0) {
            str = semRegSlip.regslip_file;
        }
        return semRegSlip.copy(z, z2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRegslip_file() {
        return this.regslip_file;
    }

    public final SemRegSlip copy(boolean login, boolean success, String regslip_file) {
        Intrinsics.checkNotNullParameter(regslip_file, "regslip_file");
        return new SemRegSlip(login, success, regslip_file);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemRegSlip)) {
            return false;
        }
        SemRegSlip semRegSlip = (SemRegSlip) other;
        return this.login == semRegSlip.login && this.success == semRegSlip.success && Intrinsics.areEqual(this.regslip_file, semRegSlip.regslip_file);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((i + (z2 ? 1 : z2)) * 31) + this.regslip_file.hashCode();
    }

    public String toString() {
        return "SemRegSlip(login=" + this.login + ", success=" + this.success + ", regslip_file=" + this.regslip_file + ")";
    }

    public SemRegSlip(boolean z, boolean z2, String regslip_file) {
        Intrinsics.checkNotNullParameter(regslip_file, "regslip_file");
        this.login = z;
        this.success = z2;
        this.regslip_file = regslip_file;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getRegslip_file() {
        return this.regslip_file;
    }
}