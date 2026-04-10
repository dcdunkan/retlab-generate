package in.etuwa.app.data.model.grievance;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GrievanceResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class GrievanceResponse {
    private final ArrayList<Grievance> grievance;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GrievanceResponse copy$default(GrievanceResponse grievanceResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = grievanceResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = grievanceResponse.grievance;
        }
        return grievanceResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Grievance> component2() {
        return this.grievance;
    }

    public final GrievanceResponse copy(boolean login, ArrayList<Grievance> grievance) {
        Intrinsics.checkNotNullParameter(grievance, "grievance");
        return new GrievanceResponse(login, grievance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GrievanceResponse)) {
            return false;
        }
        GrievanceResponse grievanceResponse = (GrievanceResponse) other;
        return this.login == grievanceResponse.login && Intrinsics.areEqual(this.grievance, grievanceResponse.grievance);
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
        return (r0 * 31) + this.grievance.hashCode();
    }

    public String toString() {
        return "GrievanceResponse(login=" + this.login + ", grievance=" + this.grievance + ")";
    }

    public GrievanceResponse(boolean z, ArrayList<Grievance> grievance) {
        Intrinsics.checkNotNullParameter(grievance, "grievance");
        this.login = z;
        this.grievance = grievance;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Grievance> getGrievance() {
        return this.grievance;
    }
}