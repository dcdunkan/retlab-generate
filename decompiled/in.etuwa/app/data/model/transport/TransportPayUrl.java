package in.etuwa.app.data.model.transport;

import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransportPayUrl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class TransportPayUrl {
    private final String fine;
    private final String total;
    private final String url;

    public static /* synthetic */ TransportPayUrl copy$default(TransportPayUrl transportPayUrl, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transportPayUrl.total;
        }
        if ((i & 2) != 0) {
            str2 = transportPayUrl.fine;
        }
        if ((i & 4) != 0) {
            str3 = transportPayUrl.url;
        }
        return transportPayUrl.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTotal() {
        return this.total;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFine() {
        return this.fine;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final TransportPayUrl copy(String total, String fine, String url) {
        Intrinsics.checkNotNullParameter(total, "total");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(url, "url");
        return new TransportPayUrl(total, fine, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportPayUrl)) {
            return false;
        }
        TransportPayUrl transportPayUrl = (TransportPayUrl) other;
        return Intrinsics.areEqual(this.total, transportPayUrl.total) && Intrinsics.areEqual(this.fine, transportPayUrl.fine) && Intrinsics.areEqual(this.url, transportPayUrl.url);
    }

    public int hashCode() {
        return (((this.total.hashCode() * 31) + this.fine.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "TransportPayUrl(total=" + this.total + ", fine=" + this.fine + ", url=" + this.url + ")";
    }

    public TransportPayUrl(String total, String fine, String url) {
        Intrinsics.checkNotNullParameter(total, "total");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(url, "url");
        this.total = total;
        this.fine = fine;
        this.url = url;
    }

    public final String getTotal() {
        return this.total;
    }

    public final String getFine() {
        return this.fine;
    }

    public final String getUrl() {
        return this.url;
    }
}