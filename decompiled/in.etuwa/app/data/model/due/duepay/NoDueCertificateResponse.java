package in.etuwa.app.data.model.due.duepay;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoDueCertificateResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class NoDueCertificateResponse {
    private final boolean login;
    private final String url;

    public static /* synthetic */ NoDueCertificateResponse copy$default(NoDueCertificateResponse noDueCertificateResponse, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = noDueCertificateResponse.login;
        }
        if ((i & 2) != 0) {
            str = noDueCertificateResponse.url;
        }
        return noDueCertificateResponse.copy(z, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final NoDueCertificateResponse copy(boolean login, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new NoDueCertificateResponse(login, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoDueCertificateResponse)) {
            return false;
        }
        NoDueCertificateResponse noDueCertificateResponse = (NoDueCertificateResponse) other;
        return this.login == noDueCertificateResponse.login && Intrinsics.areEqual(this.url, noDueCertificateResponse.url);
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
        return (r0 * 31) + this.url.hashCode();
    }

    public String toString() {
        return "NoDueCertificateResponse(login=" + this.login + ", url=" + this.url + ")";
    }

    public NoDueCertificateResponse(boolean z, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.login = z;
        this.url = url;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getUrl() {
        return this.url;
    }
}