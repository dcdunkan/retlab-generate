package in.etuwa.app.data.model.grievance.type;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GrievanceTypeResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class GrievanceTypeResponse {

    @SerializedName("g_types")
    private final ArrayList<GrievanceType> gTypes;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GrievanceTypeResponse copy$default(GrievanceTypeResponse grievanceTypeResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = grievanceTypeResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = grievanceTypeResponse.gTypes;
        }
        return grievanceTypeResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<GrievanceType> component2() {
        return this.gTypes;
    }

    public final GrievanceTypeResponse copy(boolean login, ArrayList<GrievanceType> gTypes) {
        Intrinsics.checkNotNullParameter(gTypes, "gTypes");
        return new GrievanceTypeResponse(login, gTypes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GrievanceTypeResponse)) {
            return false;
        }
        GrievanceTypeResponse grievanceTypeResponse = (GrievanceTypeResponse) other;
        return this.login == grievanceTypeResponse.login && Intrinsics.areEqual(this.gTypes, grievanceTypeResponse.gTypes);
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
        return (r0 * 31) + this.gTypes.hashCode();
    }

    public String toString() {
        return "GrievanceTypeResponse(login=" + this.login + ", gTypes=" + this.gTypes + ")";
    }

    public GrievanceTypeResponse(boolean z, ArrayList<GrievanceType> gTypes) {
        Intrinsics.checkNotNullParameter(gTypes, "gTypes");
        this.login = z;
        this.gTypes = gTypes;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<GrievanceType> getGTypes() {
        return this.gTypes;
    }
}