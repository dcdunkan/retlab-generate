package in.etuwa.app.data.model.hostel;

import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelFeePalaiResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class HostelFeePalaiResponse {
    private final int fine;
    private final int subtotal;
    private final int total;
    private final String url;

    public static /* synthetic */ HostelFeePalaiResponse copy$default(HostelFeePalaiResponse hostelFeePalaiResponse, String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = hostelFeePalaiResponse.url;
        }
        if ((i4 & 2) != 0) {
            i = hostelFeePalaiResponse.subtotal;
        }
        if ((i4 & 4) != 0) {
            i2 = hostelFeePalaiResponse.total;
        }
        if ((i4 & 8) != 0) {
            i3 = hostelFeePalaiResponse.fine;
        }
        return hostelFeePalaiResponse.copy(str, i, i2, i3);
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
    public final int getTotal() {
        return this.total;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFine() {
        return this.fine;
    }

    public final HostelFeePalaiResponse copy(String url, int subtotal, int total, int fine) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new HostelFeePalaiResponse(url, subtotal, total, fine);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelFeePalaiResponse)) {
            return false;
        }
        HostelFeePalaiResponse hostelFeePalaiResponse = (HostelFeePalaiResponse) other;
        return Intrinsics.areEqual(this.url, hostelFeePalaiResponse.url) && this.subtotal == hostelFeePalaiResponse.subtotal && this.total == hostelFeePalaiResponse.total && this.fine == hostelFeePalaiResponse.fine;
    }

    public int hashCode() {
        return (((((this.url.hashCode() * 31) + this.subtotal) * 31) + this.total) * 31) + this.fine;
    }

    public String toString() {
        return "HostelFeePalaiResponse(url=" + this.url + ", subtotal=" + this.subtotal + ", total=" + this.total + ", fine=" + this.fine + ")";
    }

    public HostelFeePalaiResponse(String url, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.subtotal = i;
        this.total = i2;
        this.fine = i3;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getSubtotal() {
        return this.subtotal;
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getFine() {
        return this.fine;
    }
}