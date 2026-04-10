package in.etuwa.app.data.model.internship;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InternshipResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class InternshipResponse {
    private final ArrayList<Internship> data;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InternshipResponse copy$default(InternshipResponse internshipResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = internshipResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = internshipResponse.data;
        }
        return internshipResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Internship> component2() {
        return this.data;
    }

    public final InternshipResponse copy(boolean login, ArrayList<Internship> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new InternshipResponse(login, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InternshipResponse)) {
            return false;
        }
        InternshipResponse internshipResponse = (InternshipResponse) other;
        return this.login == internshipResponse.login && Intrinsics.areEqual(this.data, internshipResponse.data);
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
        return (r0 * 31) + this.data.hashCode();
    }

    public String toString() {
        return "InternshipResponse(login=" + this.login + ", data=" + this.data + ")";
    }

    public InternshipResponse(boolean z, ArrayList<Internship> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.login = z;
        this.data = data;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Internship> getData() {
        return this.data;
    }
}