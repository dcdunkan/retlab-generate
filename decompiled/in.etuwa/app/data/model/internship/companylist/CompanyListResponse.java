package in.etuwa.app.data.model.internship.companylist;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompanyListResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class CompanyListResponse {

    @SerializedName("companies")
    private final ArrayList<CompanyList> cList;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CompanyListResponse copy$default(CompanyListResponse companyListResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = companyListResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = companyListResponse.cList;
        }
        return companyListResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CompanyList> component2() {
        return this.cList;
    }

    public final CompanyListResponse copy(boolean login, ArrayList<CompanyList> cList) {
        Intrinsics.checkNotNullParameter(cList, "cList");
        return new CompanyListResponse(login, cList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompanyListResponse)) {
            return false;
        }
        CompanyListResponse companyListResponse = (CompanyListResponse) other;
        return this.login == companyListResponse.login && Intrinsics.areEqual(this.cList, companyListResponse.cList);
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
        return (r0 * 31) + this.cList.hashCode();
    }

    public String toString() {
        return "CompanyListResponse(login=" + this.login + ", cList=" + this.cList + ")";
    }

    public CompanyListResponse(boolean z, ArrayList<CompanyList> cList) {
        Intrinsics.checkNotNullParameter(cList, "cList");
        this.login = z;
        this.cList = cList;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CompanyList> getCList() {
        return this.cList;
    }
}