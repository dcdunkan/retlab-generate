package in.etuwa.app.data.model.examregister;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamViewResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ExamViewResponse {
    private final String error;
    private final ArrayList<ExamView> exam;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExamViewResponse copy$default(ExamViewResponse examViewResponse, boolean z, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = examViewResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = examViewResponse.exam;
        }
        if ((i & 4) != 0) {
            str = examViewResponse.error;
        }
        return examViewResponse.copy(z, arrayList, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ExamView> component2() {
        return this.exam;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final ExamViewResponse copy(boolean login, ArrayList<ExamView> exam, String error) {
        Intrinsics.checkNotNullParameter(exam, "exam");
        Intrinsics.checkNotNullParameter(error, "error");
        return new ExamViewResponse(login, exam, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamViewResponse)) {
            return false;
        }
        ExamViewResponse examViewResponse = (ExamViewResponse) other;
        return this.login == examViewResponse.login && Intrinsics.areEqual(this.exam, examViewResponse.exam) && Intrinsics.areEqual(this.error, examViewResponse.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.exam.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "ExamViewResponse(login=" + this.login + ", exam=" + this.exam + ", error=" + this.error + ")";
    }

    public ExamViewResponse(boolean z, ArrayList<ExamView> exam, String error) {
        Intrinsics.checkNotNullParameter(exam, "exam");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.exam = exam;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ExamView> getExam() {
        return this.exam;
    }

    public final String getError() {
        return this.error;
    }
}