package in.etuwa.app.data.model.examregister;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamUpdateResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class ExamUpdateResponse {
    private final String admission_no;
    private final String batch_id;
    private final ArrayList<ExamUpdate> exam;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExamUpdateResponse copy$default(ExamUpdateResponse examUpdateResponse, boolean z, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = examUpdateResponse.login;
        }
        if ((i & 2) != 0) {
            str = examUpdateResponse.batch_id;
        }
        if ((i & 4) != 0) {
            str2 = examUpdateResponse.admission_no;
        }
        if ((i & 8) != 0) {
            arrayList = examUpdateResponse.exam;
        }
        return examUpdateResponse.copy(z, str, str2, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBatch_id() {
        return this.batch_id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAdmission_no() {
        return this.admission_no;
    }

    public final ArrayList<ExamUpdate> component4() {
        return this.exam;
    }

    public final ExamUpdateResponse copy(boolean login, String batch_id, String admission_no, ArrayList<ExamUpdate> exam) {
        Intrinsics.checkNotNullParameter(batch_id, "batch_id");
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(exam, "exam");
        return new ExamUpdateResponse(login, batch_id, admission_no, exam);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamUpdateResponse)) {
            return false;
        }
        ExamUpdateResponse examUpdateResponse = (ExamUpdateResponse) other;
        return this.login == examUpdateResponse.login && Intrinsics.areEqual(this.batch_id, examUpdateResponse.batch_id) && Intrinsics.areEqual(this.admission_no, examUpdateResponse.admission_no) && Intrinsics.areEqual(this.exam, examUpdateResponse.exam);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + this.batch_id.hashCode()) * 31) + this.admission_no.hashCode()) * 31) + this.exam.hashCode();
    }

    public String toString() {
        return "ExamUpdateResponse(login=" + this.login + ", batch_id=" + this.batch_id + ", admission_no=" + this.admission_no + ", exam=" + this.exam + ")";
    }

    public ExamUpdateResponse(boolean z, String batch_id, String admission_no, ArrayList<ExamUpdate> exam) {
        Intrinsics.checkNotNullParameter(batch_id, "batch_id");
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(exam, "exam");
        this.login = z;
        this.batch_id = batch_id;
        this.admission_no = admission_no;
        this.exam = exam;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getBatch_id() {
        return this.batch_id;
    }

    public final String getAdmission_no() {
        return this.admission_no;
    }

    public final ArrayList<ExamUpdate> getExam() {
        return this.exam;
    }
}