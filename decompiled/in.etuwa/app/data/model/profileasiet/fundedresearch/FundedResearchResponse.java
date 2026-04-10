package in.etuwa.app.data.model.profileasiet.fundedresearch;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FundedResearchResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class FundedResearchResponse {
    private final ArrayList<FundedResearch> funded;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FundedResearchResponse copy$default(FundedResearchResponse fundedResearchResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fundedResearchResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = fundedResearchResponse.funded;
        }
        return fundedResearchResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<FundedResearch> component2() {
        return this.funded;
    }

    public final FundedResearchResponse copy(boolean login, ArrayList<FundedResearch> funded) {
        Intrinsics.checkNotNullParameter(funded, "funded");
        return new FundedResearchResponse(login, funded);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FundedResearchResponse)) {
            return false;
        }
        FundedResearchResponse fundedResearchResponse = (FundedResearchResponse) other;
        return this.login == fundedResearchResponse.login && Intrinsics.areEqual(this.funded, fundedResearchResponse.funded);
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
        return (r0 * 31) + this.funded.hashCode();
    }

    public String toString() {
        return "FundedResearchResponse(login=" + this.login + ", funded=" + this.funded + ")";
    }

    public FundedResearchResponse(boolean z, ArrayList<FundedResearch> funded) {
        Intrinsics.checkNotNullParameter(funded, "funded");
        this.login = z;
        this.funded = funded;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<FundedResearch> getFunded() {
        return this.funded;
    }
}