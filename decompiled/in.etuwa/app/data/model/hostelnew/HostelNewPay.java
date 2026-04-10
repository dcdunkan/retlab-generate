package in.etuwa.app.data.model.hostelnew;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelNewPay.kt */
/* loaded from: classes3.dex */
public final /* data */ class HostelNewPay {
    private final int fine;
    private final int subtotal;
    private final int total_amount;
    private final String url;

    public static /* synthetic */ HostelNewPay copy$default(HostelNewPay hostelNewPay, String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = hostelNewPay.url;
        }
        if ((i4 & 2) != 0) {
            i = hostelNewPay.subtotal;
        }
        if ((i4 & 4) != 0) {
            i2 = hostelNewPay.total_amount;
        }
        if ((i4 & 8) != 0) {
            i3 = hostelNewPay.fine;
        }
        return hostelNewPay.copy(str, i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSubtotal() {
        return this.subtotal;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotal_amount() {
        return this.total_amount;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFine() {
        return this.fine;
    }

    public final HostelNewPay copy(String url, int subtotal, int total_amount, int fine) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new HostelNewPay(url, subtotal, total_amount, fine);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelNewPay)) {
            return false;
        }
        HostelNewPay hostelNewPay = (HostelNewPay) other;
        return Intrinsics.areEqual(this.url, hostelNewPay.url) && this.subtotal == hostelNewPay.subtotal && this.total_amount == hostelNewPay.total_amount && this.fine == hostelNewPay.fine;
    }

    public int hashCode() {
        return (((((this.url.hashCode() * 31) + this.subtotal) * 31) + this.total_amount) * 31) + this.fine;
    }

    public String toString() {
        return "HostelNewPay(url=" + this.url + ", subtotal=" + this.subtotal + ", total_amount=" + this.total_amount + ", fine=" + this.fine + ")";
    }

    public HostelNewPay(String url, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.subtotal = i;
        this.total_amount = i2;
        this.fine = i3;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getSubtotal() {
        return this.subtotal;
    }

    public final int getTotal_amount() {
        return this.total_amount;
    }

    public final int getFine() {
        return this.fine;
    }
}