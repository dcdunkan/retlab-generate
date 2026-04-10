package in.etuwa.app.data.model.examregister;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamRegisterResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class ExamRegisterResponse {
    private final ArrayList<ExamRegister> exam;
    private final boolean login;
    private final ArrayList<ExamRegister> notregexam;
    private final ArrayList<ExamRegister> regexam;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExamRegisterResponse copy$default(ExamRegisterResponse examRegisterResponse, boolean z, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = examRegisterResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = examRegisterResponse.exam;
        }
        if ((i & 4) != 0) {
            arrayList2 = examRegisterResponse.regexam;
        }
        if ((i & 8) != 0) {
            arrayList3 = examRegisterResponse.notregexam;
        }
        return examRegisterResponse.copy(z, arrayList, arrayList2, arrayList3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ExamRegister> component2() {
        return this.exam;
    }

    public final ArrayList<ExamRegister> component3() {
        return this.regexam;
    }

    public final ArrayList<ExamRegister> component4() {
        return this.notregexam;
    }

    public final ExamRegisterResponse copy(boolean login, ArrayList<ExamRegister> exam, ArrayList<ExamRegister> regexam, ArrayList<ExamRegister> notregexam) {
        Intrinsics.checkNotNullParameter(exam, "exam");
        Intrinsics.checkNotNullParameter(regexam, "regexam");
        Intrinsics.checkNotNullParameter(notregexam, "notregexam");
        return new ExamRegisterResponse(login, exam, regexam, notregexam);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamRegisterResponse)) {
            return false;
        }
        ExamRegisterResponse examRegisterResponse = (ExamRegisterResponse) other;
        return this.login == examRegisterResponse.login && Intrinsics.areEqual(this.exam, examRegisterResponse.exam) && Intrinsics.areEqual(this.regexam, examRegisterResponse.regexam) && Intrinsics.areEqual(this.notregexam, examRegisterResponse.notregexam);
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
        return (((((r0 * 31) + this.exam.hashCode()) * 31) + this.regexam.hashCode()) * 31) + this.notregexam.hashCode();
    }

    public String toString() {
        return "ExamRegisterResponse(login=" + this.login + ", exam=" + this.exam + ", regexam=" + this.regexam + ", notregexam=" + this.notregexam + ")";
    }

    public ExamRegisterResponse(boolean z, ArrayList<ExamRegister> exam, ArrayList<ExamRegister> regexam, ArrayList<ExamRegister> notregexam) {
        Intrinsics.checkNotNullParameter(exam, "exam");
        Intrinsics.checkNotNullParameter(regexam, "regexam");
        Intrinsics.checkNotNullParameter(notregexam, "notregexam");
        this.login = z;
        this.exam = exam;
        this.regexam = regexam;
        this.notregexam = notregexam;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ExamRegister> getExam() {
        return this.exam;
    }

    public final ArrayList<ExamRegister> getRegexam() {
        return this.regexam;
    }

    public final ArrayList<ExamRegister> getNotregexam() {
        return this.notregexam;
    }
}