package in.etuwa.app.data.model.hostel.partial.admission;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelPartialAdmission.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lin/etuwa/app/data/model/hostel/partial/admission/HostelPartialAdmission;", "", FirebaseAnalytics.Event.LOGIN, "", "date", "", "fine", "payment", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/partial/admission/HostelPartialPayment;", "Lkotlin/collections/ArrayList;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getDate", "()Ljava/lang/String;", "getFine", "getLogin", "()Z", "setLogin", "(Z)V", "getPayment", "()Ljava/util/ArrayList;", "setPayment", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class HostelPartialAdmission {
    private final String date;
    private final String fine;
    private boolean login;
    private ArrayList<HostelPartialPayment> payment;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostelPartialAdmission copy$default(HostelPartialAdmission hostelPartialAdmission, boolean z, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hostelPartialAdmission.login;
        }
        if ((i & 2) != 0) {
            str = hostelPartialAdmission.date;
        }
        if ((i & 4) != 0) {
            str2 = hostelPartialAdmission.fine;
        }
        if ((i & 8) != 0) {
            arrayList = hostelPartialAdmission.payment;
        }
        return hostelPartialAdmission.copy(z, str, str2, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFine() {
        return this.fine;
    }

    public final ArrayList<HostelPartialPayment> component4() {
        return this.payment;
    }

    public final HostelPartialAdmission copy(boolean login, String date, String fine, ArrayList<HostelPartialPayment> payment) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(payment, "payment");
        return new HostelPartialAdmission(login, date, fine, payment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelPartialAdmission)) {
            return false;
        }
        HostelPartialAdmission hostelPartialAdmission = (HostelPartialAdmission) other;
        return this.login == hostelPartialAdmission.login && Intrinsics.areEqual(this.date, hostelPartialAdmission.date) && Intrinsics.areEqual(this.fine, hostelPartialAdmission.fine) && Intrinsics.areEqual(this.payment, hostelPartialAdmission.payment);
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
        return (((((r0 * 31) + this.date.hashCode()) * 31) + this.fine.hashCode()) * 31) + this.payment.hashCode();
    }

    public String toString() {
        return "HostelPartialAdmission(login=" + this.login + ", date=" + this.date + ", fine=" + this.fine + ", payment=" + this.payment + ")";
    }

    public HostelPartialAdmission(boolean z, String date, String fine, ArrayList<HostelPartialPayment> payment) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(fine, "fine");
        Intrinsics.checkNotNullParameter(payment, "payment");
        this.login = z;
        this.date = date;
        this.fine = fine;
        this.payment = payment;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final void setLogin(boolean z) {
        this.login = z;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getFine() {
        return this.fine;
    }

    public final ArrayList<HostelPartialPayment> getPayment() {
        return this.payment;
    }

    public final void setPayment(ArrayList<HostelPartialPayment> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.payment = arrayList;
    }
}