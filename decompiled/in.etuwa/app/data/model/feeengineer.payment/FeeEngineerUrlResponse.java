package in.etuwa.app.data.model.feeengineer.payment;

import com.google.firebase.messaging.Constants;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeEngineerUrlResponse.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lin/etuwa/app/data/model/feeengineer/payment/FeeEngineerUrlResponse;", "", "url", "", "fine", "subtotal", FeeConfirmDialogKt.ARG_TOTAL, Constants.IPC_BUNDLE_KEY_SEND_ERROR, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getFine", "getSubtotal", "getTotal", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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