package in.etuwa.app.data.model.examregister;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamPayResponse.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u001f"}, d2 = {"Lin/etuwa/app/data/model/examregister/ExamPayResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "is_registered", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "url", "exam", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/examregister/ExamPay;", "Lkotlin/collections/ArrayList;", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getError", "()Ljava/lang/String;", "getExam", "()Ljava/util/ArrayList;", "()Z", "getLogin", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ExamPayResponse {
    private final String error;
    private final ArrayList<ExamPay> exam;
    private final boolean is_registered;
    private final boolean login;
    private final String url;

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

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIs_registered() {
        return this.is_registered;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component4, reason: from getter */
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
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.is_registered;
        return ((((((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.error.hashCode()) * 31) + this.url.hashCode()) * 31) + this.exam.hashCode();
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