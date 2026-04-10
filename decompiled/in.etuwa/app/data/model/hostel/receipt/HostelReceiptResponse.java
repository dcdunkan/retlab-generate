package in.etuwa.app.data.model.hostel.receipt;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelReceiptResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class HostelReceiptResponse {
    private final ArrayList<HostelReceipt> receipts;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostelReceiptResponse copy$default(HostelReceiptResponse hostelReceiptResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = hostelReceiptResponse.receipts;
        }
        return hostelReceiptResponse.copy(arrayList);
    }

    public final ArrayList<HostelReceipt> component1() {
        return this.receipts;
    }

    public final HostelReceiptResponse copy(ArrayList<HostelReceipt> receipts) {
        Intrinsics.checkNotNullParameter(receipts, "receipts");
        return new HostelReceiptResponse(receipts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HostelReceiptResponse) && Intrinsics.areEqual(this.receipts, ((HostelReceiptResponse) other).receipts);
    }

    public int hashCode() {
        return this.receipts.hashCode();
    }

    public String toString() {
        return "HostelReceiptResponse(receipts=" + this.receipts + ")";
    }

    public HostelReceiptResponse(ArrayList<HostelReceipt> receipts) {
        Intrinsics.checkNotNullParameter(receipts, "receipts");
        this.receipts = receipts;
    }

    public final ArrayList<HostelReceipt> getReceipts() {
        return this.receipts;
    }
}