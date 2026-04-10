package in.etuwa.app.data.model.feeengineer.payment;

import com.google.firebase.messaging.Constants;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeEngineerUrlResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class FeeEngineerUrlResponse {
    private final String error;
    private final String fine;
    private final String subtotal;
    private final String total;
    private final String url;

    public static /* synthetic */ FeeEngineerUrlResponse copy$default(FeeEngineerUrlResponse feeEngineerUrlResponse, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = feeEngineerUrlResponse.url;
        }
        if ((i & 2) != 0) {
            str2 = feeEngineerUrlResponse.fine;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = feeEngineerUrlResponse.subtotal;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = feeEngineerUrlResponse.total;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = feeEngineerUrlResponse.error;
        }
        return feeEngineerUrlResponse.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFine() {
        return this.fine;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubtotal() {
        return this.subtotal;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTotal() {
        return this.total;
    }

    /* renamed from: component5, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final FeeEngineerUrlResponse copy(String url, String fine, String subtotal, String total, String error) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(subtotal, "subtotal");
        Intrinsics.checkNotNullParameter(total, "total");
        Intrinsics.checkNotNullParameter(error, "error");
        return new FeeEngineerUrlResponse(url, fine, subtotal, total, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeeEngineerUrlResponse)) {
            return false;
        }
        FeeEngineerUrlResponse feeEngineerUrlResponse = (FeeEngineerUrlResponse) other;
        return Intrinsics.areEqual(this.url, feeEngineerUrlResponse.url) && Intrinsics.areEqual(this.fine, feeEngineerUrlResponse.fine) && Intrinsics.areEqual(this.subtotal, feeEngineerUrlResponse.subtotal) && Intrinsics.areEqual(this.total, feeEngineerUrlResponse.total) && Intrinsics.areEqual(this.error, feeEngineerUrlResponse.error);
    }

    public int hashCode() {
        return (((((((this.url.hashCode() * 31) + this.fine.hashCode()) * 31) + this.subtotal.hashCode()) * 31) + this.total.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "FeeEngineerUrlResponse(url=" + this.url + ", fine=" + this.fine + ", subtotal=" + this.subtotal + ", total=" + this.total + ", error=" + this.error + ")";
    }

    public FeeEngineerUrlResponse(String url, String fine, String subtotal, String total, String error) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(subtotal, "subtotal");
        Intrinsics.checkNotNullParameter(total, "total");
        Intrinsics.checkNotNullParameter(error, "error");
        this.url = url;
        this.fine = fine;
        this.subtotal = subtotal;
        this.total = total;
        this.error = error;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getFine() {
        return this.fine;
    }

    public final String getSubtotal() {
        return this.subtotal;
    }

    public final String getTotal() {
        return this.total;
    }

    public final String getError() {
        return this.error;
    }
}