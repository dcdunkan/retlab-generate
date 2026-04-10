package in.etuwa.app.data.model.transport;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import in.etuwa.app.data.model.transportpalai.registration.Boardings;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransportFeeResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class TransportFeeResponse {
    private final String boarding_point;
    private final String error;
    private final ArrayList<TransportInstallments> installments;
    private final boolean login;
    private final String student_id;
    private final ArrayList<Boardings> years;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransportFeeResponse copy$default(TransportFeeResponse transportFeeResponse, boolean z, ArrayList arrayList, String str, ArrayList arrayList2, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = transportFeeResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = transportFeeResponse.years;
        }
        ArrayList arrayList3 = arrayList;
        if ((i & 4) != 0) {
            str = transportFeeResponse.boarding_point;
        }
        String str4 = str;
        if ((i & 8) != 0) {
            arrayList2 = transportFeeResponse.installments;
        }
        ArrayList arrayList4 = arrayList2;
        if ((i & 16) != 0) {
            str2 = transportFeeResponse.student_id;
        }
        String str5 = str2;
        if ((i & 32) != 0) {
            str3 = transportFeeResponse.error;
        }
        return transportFeeResponse.copy(z, arrayList3, str4, arrayList4, str5, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Boardings> component2() {
        return this.years;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBoarding_point() {
        return this.boarding_point;
    }

    public final ArrayList<TransportInstallments> component4() {
        return this.installments;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStudent_id() {
        return this.student_id;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final TransportFeeResponse copy(boolean login, ArrayList<Boardings> years, String boarding_point, ArrayList<TransportInstallments> installments, String student_id, String error) {
        Intrinsics.checkNotNullParameter(years, "years");
        Intrinsics.checkNotNullParameter(boarding_point, "boarding_point");
        Intrinsics.checkNotNullParameter(installments, "installments");
        Intrinsics.checkNotNullParameter(student_id, "student_id");
        Intrinsics.checkNotNullParameter(error, "error");
        return new TransportFeeResponse(login, years, boarding_point, installments, student_id, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportFeeResponse)) {
            return false;
        }
        TransportFeeResponse transportFeeResponse = (TransportFeeResponse) other;
        return this.login == transportFeeResponse.login && Intrinsics.areEqual(this.years, transportFeeResponse.years) && Intrinsics.areEqual(this.boarding_point, transportFeeResponse.boarding_point) && Intrinsics.areEqual(this.installments, transportFeeResponse.installments) && Intrinsics.areEqual(this.student_id, transportFeeResponse.student_id) && Intrinsics.areEqual(this.error, transportFeeResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((r0 * 31) + this.years.hashCode()) * 31) + this.boarding_point.hashCode()) * 31) + this.installments.hashCode()) * 31) + this.student_id.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "TransportFeeResponse(login=" + this.login + ", years=" + this.years + ", boarding_point=" + this.boarding_point + ", installments=" + this.installments + ", student_id=" + this.student_id + ", error=" + this.error + ")";
    }

    public TransportFeeResponse(boolean z, ArrayList<Boardings> years, String boarding_point, ArrayList<TransportInstallments> installments, String student_id, String error) {
        Intrinsics.checkNotNullParameter(years, "years");
        Intrinsics.checkNotNullParameter(boarding_point, "boarding_point");
        Intrinsics.checkNotNullParameter(installments, "installments");
        Intrinsics.checkNotNullParameter(student_id, "student_id");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.years = years;
        this.boarding_point = boarding_point;
        this.installments = installments;
        this.student_id = student_id;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Boardings> getYears() {
        return this.years;
    }

    public final String getBoarding_point() {
        return this.boarding_point;
    }

    public final ArrayList<TransportInstallments> getInstallments() {
        return this.installments;
    }

    public final String getStudent_id() {
        return this.student_id;
    }

    public final String getError() {
        return this.error;
    }
}