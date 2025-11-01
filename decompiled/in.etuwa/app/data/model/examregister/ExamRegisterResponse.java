package in.etuwa.app.data.model.examregister;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamRegisterResponse.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003Ja\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/data/model/examregister/ExamRegisterResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "exam", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/examregister/ExamRegister;", "Lkotlin/collections/ArrayList;", "regexam", "notregexam", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getExam", "()Ljava/util/ArrayList;", "getLogin", "()Z", "getNotregexam", "getRegexam", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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