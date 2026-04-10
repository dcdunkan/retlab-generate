package in.etuwa.app.data.model.hostelnew;

import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.data.model.DownloadModel$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelNewPay.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class HostelNewPay {
    private final int fine;
    private final boolean login;
    private final double total_amount;
    private final String url;

    public static /* synthetic */ HostelNewPay copy$default(HostelNewPay hostelNewPay, boolean z, String str, double d, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = hostelNewPay.login;
        }
        if ((i2 & 2) != 0) {
            str = hostelNewPay.url;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            d = hostelNewPay.total_amount;
        }
        double d2 = d;
        if ((i2 & 8) != 0) {
            i = hostelNewPay.fine;
        }
        return hostelNewPay.copy(z, str2, d2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getTotal_amount() {
        return this.total_amount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getFine() {
        return this.fine;
    }

    public final HostelNewPay copy(boolean login, String url, double total_amount, int fine) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new HostelNewPay(login, url, total_amount, fine);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelNewPay)) {
            return false;
        }
        HostelNewPay hostelNewPay = (HostelNewPay) other;
        return this.login == hostelNewPay.login && Intrinsics.areEqual(this.url, hostelNewPay.url) && Double.compare(this.total_amount, hostelNewPay.total_amount) == 0 && this.fine == hostelNewPay.fine;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + this.url.hashCode()) * 31) + DownloadModel$$ExternalSyntheticBackport0.m(this.total_amount)) * 31) + this.fine;
    }

    public String toString() {
        return "HostelNewPay(login=" + this.login + ", url=" + this.url + ", total_amount=" + this.total_amount + ", fine=" + this.fine + ")";
    }

    public HostelNewPay(boolean z, String url, double d, int i) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.login = z;
        this.url = url;
        this.total_amount = d;
        this.fine = i;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getUrl() {
        return this.url;
    }

    public final double getTotal_amount() {
        return this.total_amount;
    }

    public final int getFine() {
        return this.fine;
    }
}