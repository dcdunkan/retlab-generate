package in.etuwa.app.data.model.semregistration.view;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemRegSlip.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/data/model/semregistration/view/SemRegSlip;", "", FirebaseAnalytics.Event.LOGIN, "", "success", "regslip_file", "", "(ZZLjava/lang/String;)V", "getLogin", "()Z", "getRegslip_file", "()Ljava/lang/String;", "getSuccess", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component3, reason: from getter */
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
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.regslip_file.hashCode();
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