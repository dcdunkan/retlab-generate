package in.etuwa.app.data.model.transport;

import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TransportPayUrl.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/transport/TransportPayUrl;", "", FeeConfirmDialogKt.ARG_TOTAL, "", "fine", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFine", "()Ljava/lang/String;", "getTotal", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getTotal() {
        return this.total;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFine() {
        return this.fine;
    }

    /* renamed from: component3, reason: from getter */
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