package in.etuwa.app.data.model.examregister;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamUpdateResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/data/model/examregister/ExamUpdateResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "batch_id", "", "admission_no", "exam", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/examregister/ExamUpdate;", "Lkotlin/collections/ArrayList;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getAdmission_no", "()Ljava/lang/String;", "getBatch_id", "getExam", "()Ljava/util/ArrayList;", "getLogin", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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