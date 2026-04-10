package in.etuwa.app.data.model.subject.coverage;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.kernel.xmp.PdfConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubCoverageResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SubCoverageResponse {
    private final ArrayList<SubCoverage> coverage;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubCoverageResponse copy$default(SubCoverageResponse subCoverageResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = subCoverageResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = subCoverageResponse.coverage;
        }
        return subCoverageResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<SubCoverage> component2() {
        return this.coverage;
    }

    public final SubCoverageResponse copy(boolean login, ArrayList<SubCoverage> coverage) {
        Intrinsics.checkNotNullParameter(coverage, "coverage");
        return new SubCoverageResponse(login, coverage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubCoverageResponse)) {
            return false;
        }
        SubCoverageResponse subCoverageResponse = (SubCoverageResponse) other;
        return this.login == subCoverageResponse.login && Intrinsics.areEqual(this.coverage, subCoverageResponse.coverage);
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
        return (r0 * 31) + this.coverage.hashCode();
    }

    public String toString() {
        return "SubCoverageResponse(login=" + this.login + ", coverage=" + this.coverage + ")";
    }

    public SubCoverageResponse(boolean z, ArrayList<SubCoverage> coverage) {
        Intrinsics.checkNotNullParameter(coverage, "coverage");
        this.login = z;
        this.coverage = coverage;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<SubCoverage> getCoverage() {
        return this.coverage;
    }
}