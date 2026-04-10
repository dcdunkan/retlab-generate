package in.etuwa.app.data.model.examregister;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamReceiptResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class ExamReceiptResponse {
    private final boolean login;
    private final ArrayList<ExamReceipt> receipts;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExamReceiptResponse copy$default(ExamReceiptResponse examReceiptResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = examReceiptResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = examReceiptResponse.receipts;
        }
        return examReceiptResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ExamReceipt> component2() {
        return this.receipts;
    }

    public final ExamReceiptResponse copy(boolean login, ArrayList<ExamReceipt> receipts) {
        Intrinsics.checkNotNullParameter(receipts, "receipts");
        return new ExamReceiptResponse(login, receipts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamReceiptResponse)) {
            return false;
        }
        ExamReceiptResponse examReceiptResponse = (ExamReceiptResponse) other;
        return this.login == examReceiptResponse.login && Intrinsics.areEqual(this.receipts, examReceiptResponse.receipts);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.receipts.hashCode();
    }

    public String toString() {
        return "ExamReceiptResponse(login=" + this.login + ", receipts=" + this.receipts + ")";
    }

    public ExamReceiptResponse(boolean z, ArrayList<ExamReceipt> receipts) {
        Intrinsics.checkNotNullParameter(receipts, "receipts");
        this.login = z;
        this.receipts = receipts;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ExamReceipt> getReceipts() {
        return this.receipts;
    }
}