package in.etuwa.app.data.model.result.univ;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: UnivResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class UnivResponse {
    private final UnivDetails details;
    private final String error;
    private final boolean login;
    private final ArrayList<UnivSubjects> subjects;

    @SerializedName("univ_exams")
    private final ArrayList<UnivExams> univExams;

    public static /* synthetic */ UnivResponse copy$default(UnivResponse univResponse, boolean z, UnivDetails univDetails, ArrayList arrayList, ArrayList arrayList2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = univResponse.login;
        }
        if ((i & 2) != 0) {
            univDetails = univResponse.details;
        }
        UnivDetails univDetails2 = univDetails;
        if ((i & 4) != 0) {
            arrayList = univResponse.subjects;
        }
        ArrayList arrayList3 = arrayList;
        if ((i & 8) != 0) {
            arrayList2 = univResponse.univExams;
        }
        ArrayList arrayList4 = arrayList2;
        if ((i & 16) != 0) {
            str = univResponse.error;
        }
        return univResponse.copy(z, univDetails2, arrayList3, arrayList4, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final UnivDetails getDetails() {
        return this.details;
    }

    public final ArrayList<UnivSubjects> component3() {
        return this.subjects;
    }

    public final ArrayList<UnivExams> component4() {
        return this.univExams;
    }

    /* renamed from: component5, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final UnivResponse copy(boolean login, UnivDetails details, ArrayList<UnivSubjects> subjects, ArrayList<UnivExams> univExams, String error) {
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        Intrinsics.checkNotNullParameter(univExams, "univExams");
        Intrinsics.checkNotNullParameter(error, "error");
        return new UnivResponse(login, details, subjects, univExams, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnivResponse)) {
            return false;
        }
        UnivResponse univResponse = (UnivResponse) other;
        return this.login == univResponse.login && Intrinsics.areEqual(this.details, univResponse.details) && Intrinsics.areEqual(this.subjects, univResponse.subjects) && Intrinsics.areEqual(this.univExams, univResponse.univExams) && Intrinsics.areEqual(this.error, univResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((r0 * 31) + this.details.hashCode()) * 31) + this.subjects.hashCode()) * 31) + this.univExams.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "UnivResponse(login=" + this.login + ", details=" + this.details + ", subjects=" + this.subjects + ", univExams=" + this.univExams + ", error=" + this.error + ")";
    }

    public UnivResponse(boolean z, UnivDetails details, ArrayList<UnivSubjects> subjects, ArrayList<UnivExams> univExams, String error) {
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        Intrinsics.checkNotNullParameter(univExams, "univExams");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.details = details;
        this.subjects = subjects;
        this.univExams = univExams;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final UnivDetails getDetails() {
        return this.details;
    }

    public final ArrayList<UnivSubjects> getSubjects() {
        return this.subjects;
    }

    public final ArrayList<UnivExams> getUnivExams() {
        return this.univExams;
    }

    public final String getError() {
        return this.error;
    }
}