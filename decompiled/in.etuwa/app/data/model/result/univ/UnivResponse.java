package in.etuwa.app.data.model.result.univ;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: UnivResponse.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\rHÆ\u0003J[\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006#"}, d2 = {"Lin/etuwa/app/data/model/result/univ/UnivResponse;", "", FirebaseAnalytics.Event.LOGIN, "", ErrorBundle.DETAIL_ENTRY, "Lin/etuwa/app/data/model/result/univ/UnivDetails;", "subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/result/univ/UnivSubjects;", "Lkotlin/collections/ArrayList;", "univExams", "Lin/etuwa/app/data/model/result/univ/UnivExams;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "(ZLin/etuwa/app/data/model/result/univ/UnivDetails;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;)V", "getDetails", "()Lin/etuwa/app/data/model/result/univ/UnivDetails;", "getError", "()Ljava/lang/String;", "getLogin", "()Z", "getSubjects", "()Ljava/util/ArrayList;", "getUnivExams", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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