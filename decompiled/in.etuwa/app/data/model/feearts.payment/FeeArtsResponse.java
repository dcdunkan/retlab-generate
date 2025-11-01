package in.etuwa.app.data.model.feearts.payment;

import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeArtsResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003Ji\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\nHÖ\u0001R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006)"}, d2 = {"Lin/etuwa/app/data/model/feearts/payment/FeeArtsResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "success", "fee_groups", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/feearts/payment/FeeArts;", "Lkotlin/collections/ArrayList;", "student_id", "", "date", "bal", "fine", FeeConfirmDialogKt.ARG_TOTAL, "(ZZLjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBal", "()Ljava/lang/String;", "getDate", "getFee_groups", "()Ljava/util/ArrayList;", "getFine", "getLogin", "()Z", "getStudent_id", "getSuccess", "getTotal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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