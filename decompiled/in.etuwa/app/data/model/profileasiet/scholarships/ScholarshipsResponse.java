package in.etuwa.app.data.model.profileasiet.scholarships;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScholarshipsResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ScholarshipsResponse {
    private final boolean login;
    private final ArrayList<Scholarships> scholarship;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScholarshipsResponse copy$default(ScholarshipsResponse scholarshipsResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = scholarshipsResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = scholarshipsResponse.scholarship;
        }
        return scholarshipsResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Scholarships> component2() {
        return this.scholarship;
    }

    public final ScholarshipsResponse copy(boolean login, ArrayList<Scholarships> scholarship) {
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        return new ScholarshipsResponse(login, scholarship);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScholarshipsResponse)) {
            return false;
        }
        ScholarshipsResponse scholarshipsResponse = (ScholarshipsResponse) other;
        return this.login == scholarshipsResponse.login && Intrinsics.areEqual(this.scholarship, scholarshipsResponse.scholarship);
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
        return (r0 * 31) + this.scholarship.hashCode();
    }

    public String toString() {
        return "ScholarshipsResponse(login=" + this.login + ", scholarship=" + this.scholarship + ")";
    }

    public ScholarshipsResponse(boolean z, ArrayList<Scholarships> scholarship) {
        Intrinsics.checkNotNullParameter(scholarship, "scholarship");
        this.login = z;
        this.scholarship = scholarship;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Scholarships> getScholarship() {
        return this.scholarship;
    }
}