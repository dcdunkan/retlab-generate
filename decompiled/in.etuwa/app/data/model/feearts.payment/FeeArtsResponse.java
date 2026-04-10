package in.etuwa.app.data.model.feearts.payment;

import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeArtsResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class FeeArtsResponse {
    private final String bal;
    private final String date;
    private final ArrayList<FeeArts> fee_groups;
    private final String fine;
    private final boolean login;
    private final String student_id;
    private final boolean success;
    private final String total;

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<FeeArts> component3() {
        return this.fee_groups;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStudent_id() {
        return this.student_id;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBal() {
        return this.bal;
    }

    /* renamed from: component7, reason: from getter */
    public final String getFine() {
        return this.fine;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTotal() {
        return this.total;
    }

    public final FeeArtsResponse copy(boolean login, boolean success, ArrayList<FeeArts> fee_groups, String student_id, String date, String bal, String fine, String total) {
        Intrinsics.checkNotNullParameter(fee_groups, "fee_groups");
        Intrinsics.checkNotNullParameter(student_id, "student_id");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(bal, "bal");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(total, "total");
        return new FeeArtsResponse(login, success, fee_groups, student_id, date, bal, fine, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeeArtsResponse)) {
            return false;
        }
        FeeArtsResponse feeArtsResponse = (FeeArtsResponse) other;
        return this.login == feeArtsResponse.login && this.success == feeArtsResponse.success && Intrinsics.areEqual(this.fee_groups, feeArtsResponse.fee_groups) && Intrinsics.areEqual(this.student_id, feeArtsResponse.student_id) && Intrinsics.areEqual(this.date, feeArtsResponse.date) && Intrinsics.areEqual(this.bal, feeArtsResponse.bal) && Intrinsics.areEqual(this.fine, feeArtsResponse.fine) && Intrinsics.areEqual(this.total, feeArtsResponse.total);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((((((((((((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.fee_groups.hashCode()) * 31) + this.student_id.hashCode()) * 31) + this.date.hashCode()) * 31) + this.bal.hashCode()) * 31) + this.fine.hashCode()) * 31) + this.total.hashCode();
    }

    public String toString() {
        return "FeeArtsResponse(login=" + this.login + ", success=" + this.success + ", fee_groups=" + this.fee_groups + ", student_id=" + this.student_id + ", date=" + this.date + ", bal=" + this.bal + ", fine=" + this.fine + ", total=" + this.total + ")";
    }

    public FeeArtsResponse(boolean z, boolean z2, ArrayList<FeeArts> fee_groups, String student_id, String date, String bal, String fine, String total) {
        Intrinsics.checkNotNullParameter(fee_groups, "fee_groups");
        Intrinsics.checkNotNullParameter(student_id, "student_id");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(bal, "bal");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(total, "total");
        this.login = z;
        this.success = z2;
        this.fee_groups = fee_groups;
        this.student_id = student_id;
        this.date = date;
        this.bal = bal;
        this.fine = fine;
        this.total = total;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<FeeArts> getFee_groups() {
        return this.fee_groups;
    }

    public final String getStudent_id() {
        return this.student_id;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getBal() {
        return this.bal;
    }

    public final String getFine() {
        return this.fine;
    }

    public final String getTotal() {
        return this.total;
    }
}