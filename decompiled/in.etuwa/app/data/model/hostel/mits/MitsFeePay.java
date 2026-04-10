package in.etuwa.app.data.model.hostel.mits;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MitsFeePay.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class MitsFeePay {
    private final boolean login;
    private final String url;

    public static /* synthetic */ MitsFeePay copy$default(MitsFeePay mitsFeePay, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = mitsFeePay.login;
        }
        if ((i & 2) != 0) {
            str = mitsFeePay.url;
        }
        return mitsFeePay.copy(z, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final MitsFeePay copy(boolean login, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new MitsFeePay(login, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MitsFeePay)) {
            return false;
        }
        MitsFeePay mitsFeePay = (MitsFeePay) other;
        return this.login == mitsFeePay.login && Intrinsics.areEqual(this.url, mitsFeePay.url);
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
        return "MitsFeePay(login=" + this.login + ", url=" + this.url + ")";
    }

    public MitsFeePay(boolean z, String url) {
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