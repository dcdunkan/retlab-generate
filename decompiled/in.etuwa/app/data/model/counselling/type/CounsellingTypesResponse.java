package in.etuwa.app.data.model.counselling.type;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CounsellingTypesResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class CounsellingTypesResponse {

    @SerializedName("c_types")
    private final ArrayList<CounsellingTypes> cTypes;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CounsellingTypesResponse copy$default(CounsellingTypesResponse counsellingTypesResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = counsellingTypesResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = counsellingTypesResponse.cTypes;
        }
        return counsellingTypesResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CounsellingTypes> component2() {
        return this.cTypes;
    }

    public final CounsellingTypesResponse copy(boolean login, ArrayList<CounsellingTypes> cTypes) {
        Intrinsics.checkNotNullParameter(cTypes, "cTypes");
        return new CounsellingTypesResponse(login, cTypes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CounsellingTypesResponse)) {
            return false;
        }
        CounsellingTypesResponse counsellingTypesResponse = (CounsellingTypesResponse) other;
        return this.login == counsellingTypesResponse.login && Intrinsics.areEqual(this.cTypes, counsellingTypesResponse.cTypes);
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
        return (r0 * 31) + this.cTypes.hashCode();
    }

    public String toString() {
        return "CounsellingTypesResponse(login=" + this.login + ", cTypes=" + this.cTypes + ")";
    }

    public CounsellingTypesResponse(boolean z, ArrayList<CounsellingTypes> cTypes) {
        Intrinsics.checkNotNullParameter(cTypes, "cTypes");
        this.login = z;
        this.cTypes = cTypes;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CounsellingTypes> getCTypes() {
        return this.cTypes;
    }
}