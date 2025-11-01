package in.etuwa.app.data.model.examregister;

import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RevaluationReceiptResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/data/model/examregister/RevaluationReceiptResponse;", "", "receipt", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/examregister/RevaluationReceipt;", "Lkotlin/collections/ArrayList;", FeeConfirmDialogKt.ARG_TOTAL, "", FeeConfirmDialogKt.ARG_SUB_TOTAL, "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "getReceipt", "()Ljava/util/ArrayList;", "getSub_total", "()Ljava/lang/String;", "getTotal", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RevaluationReceiptResponse {
    private final ArrayList<RevaluationReceipt> receipt;
    private final String sub_total;
    private final String total;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RevaluationReceiptResponse copy$default(RevaluationReceiptResponse revaluationReceiptResponse, ArrayList arrayList, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = revaluationReceiptResponse.receipt;
        }
        if ((i & 2) != 0) {
            str = revaluationReceiptResponse.total;
        }
        if ((i & 4) != 0) {
            str2 = revaluationReceiptResponse.sub_total;
        }
        return revaluationReceiptResponse.copy(arrayList, str, str2);
    }

    public final ArrayList<RevaluationReceipt> component1() {
        return this.receipt;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTotal() {
        return this.total;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSub_total() {
        return this.sub_total;
    }

    public final RevaluationReceiptResponse copy(ArrayList<RevaluationReceipt> receipt, String total, String sub_total) {
        Intrinsics.checkNotNullParameter(receipt, "receipt");
        Intrinsics.checkNotNullParameter(total, "total");
        Intrinsics.checkNotNullParameter(sub_total, "sub_total");
        return new RevaluationReceiptResponse(receipt, total, sub_total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RevaluationReceiptResponse)) {
            return false;
        }
        RevaluationReceiptResponse revaluationReceiptResponse = (RevaluationReceiptResponse) other;
        return Intrinsics.areEqual(this.receipt, revaluationReceiptResponse.receipt) && Intrinsics.areEqual(this.total, revaluationReceiptResponse.total) && Intrinsics.areEqual(this.sub_total, revaluationReceiptResponse.sub_total);
    }

    public int hashCode() {
        return (((this.receipt.hashCode() * 31) + this.total.hashCode()) * 31) + this.sub_total.hashCode();
    }

    public String toString() {
        return "RevaluationReceiptResponse(receipt=" + this.receipt + ", total=" + this.total + ", sub_total=" + this.sub_total + ")";
    }

    public RevaluationReceiptResponse(ArrayList<RevaluationReceipt> receipt, String total, String sub_total) {
        Intrinsics.checkNotNullParameter(receipt, "receipt");
        Intrinsics.checkNotNullParameter(total, "total");
        Intrinsics.checkNotNullParameter(sub_total, "sub_total");
        this.receipt = receipt;
        this.total = total;
        this.sub_total = sub_total;
    }

    public final ArrayList<RevaluationReceipt> getReceipt() {
        return this.receipt;
    }

    public final String getTotal() {
        return this.total;
    }

    public final String getSub_total() {
        return this.sub_total;
    }
}