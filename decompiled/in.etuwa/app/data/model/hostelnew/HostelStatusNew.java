package in.etuwa.app.data.model.hostelnew;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* compiled from: HostelStatusNew.kt */
/* loaded from: classes3.dex */
public final /* data */ class HostelStatusNew {
    private final boolean allpayment;
    private final boolean login;

    public static /* synthetic */ HostelStatusNew copy$default(HostelStatusNew hostelStatusNew, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hostelStatusNew.login;
        }
        if ((i & 2) != 0) {
            z2 = hostelStatusNew.allpayment;
        }
        return hostelStatusNew.copy(z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getAllpayment() {
        return this.allpayment;
    }

    public final HostelStatusNew copy(boolean login, boolean allpayment) {
        return new HostelStatusNew(login, allpayment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelStatusNew)) {
            return false;
        }
        HostelStatusNew hostelStatusNew = (HostelStatusNew) other;
        return this.login == hostelStatusNew.login && this.allpayment == hostelStatusNew.allpayment;
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
        int i = r0 * 31;
        boolean z2 = this.allpayment;
        return i + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "HostelStatusNew(login=" + this.login + ", allpayment=" + this.allpayment + ")";
    }

    public HostelStatusNew(boolean z, boolean z2) {
        this.login = z;
        this.allpayment = z2;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getAllpayment() {
        return this.allpayment;
    }
}