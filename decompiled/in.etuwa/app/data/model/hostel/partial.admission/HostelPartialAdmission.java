package in.etuwa.app.data.model.hostel.partial.admission;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelPartialAdmission.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
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