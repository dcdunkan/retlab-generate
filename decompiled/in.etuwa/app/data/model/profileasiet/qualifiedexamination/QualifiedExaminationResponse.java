package in.etuwa.app.data.model.profileasiet.qualifiedexamination;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QualifiedExaminationResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class QualifiedExaminationResponse {
    private final ArrayList<QualifiedExamination> examination;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QualifiedExaminationResponse copy$default(QualifiedExaminationResponse qualifiedExaminationResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = qualifiedExaminationResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = qualifiedExaminationResponse.examination;
        }
        return qualifiedExaminationResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<QualifiedExamination> component2() {
        return this.examination;
    }

    public final QualifiedExaminationResponse copy(boolean login, ArrayList<QualifiedExamination> examination) {
        Intrinsics.checkNotNullParameter(examination, "examination");
        return new QualifiedExaminationResponse(login, examination);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QualifiedExaminationResponse)) {
            return false;
        }
        QualifiedExaminationResponse qualifiedExaminationResponse = (QualifiedExaminationResponse) other;
        return this.login == qualifiedExaminationResponse.login && Intrinsics.areEqual(this.examination, qualifiedExaminationResponse.examination);
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
        return (r0 * 31) + this.examination.hashCode();
    }

    public String toString() {
        return "QualifiedExaminationResponse(login=" + this.login + ", examination=" + this.examination + ")";
    }

    public QualifiedExaminationResponse(boolean z, ArrayList<QualifiedExamination> examination) {
        Intrinsics.checkNotNullParameter(examination, "examination");
        this.login = z;
        this.examination = examination;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<QualifiedExamination> getExamination() {
        return this.examination;
    }
}