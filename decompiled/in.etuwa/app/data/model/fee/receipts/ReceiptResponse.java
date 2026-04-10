package in.etuwa.app.data.model.fee.receipts;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReceiptResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class ReceiptResponse {

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("message")
    @Expose
    private final String message;

    @SerializedName("receipts")
    @Expose
    private final ArrayList<Receipt> receipts;

    @SerializedName("success")
    @Expose
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReceiptResponse copy$default(ReceiptResponse receiptResponse, boolean z, boolean z2, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = receiptResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = receiptResponse.success;
        }
        if ((i & 4) != 0) {
            arrayList = receiptResponse.receipts;
        }
        if ((i & 8) != 0) {
            str = receiptResponse.message;
        }
        return receiptResponse.copy(z, z2, arrayList, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<Receipt> component3() {
        return this.receipts;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final ReceiptResponse copy(boolean login, boolean success, ArrayList<Receipt> receipts, String message) {
        Intrinsics.checkNotNullParameter(receipts, "receipts");
        Intrinsics.checkNotNullParameter(message, "message");
        return new ReceiptResponse(login, success, receipts, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReceiptResponse)) {
            return false;
        }
        ReceiptResponse receiptResponse = (ReceiptResponse) other;
        return this.login == receiptResponse.login && this.success == receiptResponse.success && Intrinsics.areEqual(this.receipts, receiptResponse.receipts) && Intrinsics.areEqual(this.message, receiptResponse.message);
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
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.receipts.hashCode()) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "ReceiptResponse(login=" + this.login + ", success=" + this.success + ", receipts=" + this.receipts + ", message=" + this.message + ")";
    }

    public ReceiptResponse(boolean z, boolean z2, ArrayList<Receipt> receipts, String message) {
        Intrinsics.checkNotNullParameter(receipts, "receipts");
        Intrinsics.checkNotNullParameter(message, "message");
        this.login = z;
        this.success = z2;
        this.receipts = receipts;
        this.message = message;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<Receipt> getReceipts() {
        return this.receipts;
    }

    public final String getMessage() {
        return this.message;
    }
}