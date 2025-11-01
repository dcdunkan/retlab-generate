package in.etuwa.app.data.model.hostel;

import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelFeePalaiResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/data/model/hostel/HostelFeePalaiResponse;", "", "url", "", "subtotal", "", FeeConfirmDialogKt.ARG_TOTAL, "fine", "(Ljava/lang/String;III)V", "getFine", "()I", "getSubtotal", "getTotal", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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