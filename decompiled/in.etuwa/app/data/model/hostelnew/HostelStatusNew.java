package in.etuwa.app.data.model.hostelnew;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* compiled from: HostelStatusNew.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/hostelnew/HostelStatusNew;", "", FirebaseAnalytics.Event.LOGIN, "", "allpayment", "(ZZ)V", "getAllpayment", "()Z", "getLogin", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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