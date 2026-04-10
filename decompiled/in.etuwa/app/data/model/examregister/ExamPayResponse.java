package in.etuwa.app.data.model.examregister;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamPayResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ExamPayResponse {
    private final String error;
    private final ArrayList<ExamPay> exam;
    private final boolean is_registered;
    private final boolean login;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExamPayResponse copy$default(ExamPayResponse examPayResponse, boolean z, boolean z2, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = examPayResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = examPayResponse.is_registered;
        }
        boolean z3 = z2;
        if ((i & 4) != 0) {
            str = examPayResponse.error;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            str2 = examPayResponse.url;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            arrayList = examPayResponse.exam;
        }
        return examPayResponse.copy(z, z3, str3, str4, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIs_registered() {
        return this.is_registered;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final ArrayList<ExamPay> component5() {
        return this.exam;
    }

    public final ExamPayResponse copy(boolean login, boolean is_registered, String error, String url, ArrayList<ExamPay> exam) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(exam, "exam");
        return new ExamPayResponse(login, is_registered, error, url, exam);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamPayResponse)) {
            return false;
        }
        ExamPayResponse examPayResponse = (ExamPayResponse) other;
        return this.login == examPayResponse.login && this.is_registered == examPayResponse.is_registered && Intrinsics.areEqual(this.error, examPayResponse.error) && Intrinsics.areEqual(this.url, examPayResponse.url) && Intrinsics.areEqual(this.exam, examPayResponse.exam);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.is_registered;
        return ((((((i + (z2 ? 1 : z2)) * 31) + this.error.hashCode()) * 31) + this.url.hashCode()) * 31) + this.exam.hashCode();
    }

    public String toString() {
        return "ExamPayResponse(login=" + this.login + ", is_registered=" + this.is_registered + ", error=" + this.error + ", url=" + this.url + ", exam=" + this.exam + ")";
    }

    public ExamPayResponse(boolean z, boolean z2, String error, String url, ArrayList<ExamPay> exam) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(exam, "exam");
        this.login = z;
        this.is_registered = z2;
        this.error = error;
        this.url = url;
        this.exam = exam;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean is_registered() {
        return this.is_registered;
    }

    public final String getError() {
        return this.error;
    }

    public final String getUrl() {
        return this.url;
    }

    public final ArrayList<ExamPay> getExam() {
        return this.exam;
    }
}