package in.etuwa.app.data.model.fee.receipts;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReceiptResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\nHÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/data/model/fee/receipts/ReceiptResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "success", "receipts", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/fee/receipts/Receipt;", "Lkotlin/collections/ArrayList;", "message", "", "(ZZLjava/util/ArrayList;Ljava/lang/String;)V", "getLogin", "()Z", "getMessage", "()Ljava/lang/String;", "getReceipts", "()Ljava/util/ArrayList;", "getSuccess", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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