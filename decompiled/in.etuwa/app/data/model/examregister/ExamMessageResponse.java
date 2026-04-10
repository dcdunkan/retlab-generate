package in.etuwa.app.data.model.examregister;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamMessageResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class ExamMessageResponse {
    private final String error;
    private final ArrayList<ExamMessage> exam;
    private final boolean is_registered;
    private final boolean login;
    private final String message;
    private final boolean success;

    public static /* synthetic */ ExamMessageResponse copy$default(ExamMessageResponse examMessageResponse, boolean z, boolean z2, String str, boolean z3, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = examMessageResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = examMessageResponse.is_registered;
        }
        boolean z4 = z2;
        if ((i & 4) != 0) {
            str = examMessageResponse.error;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            z3 = examMessageResponse.success;
        }
        boolean z5 = z3;
        if ((i & 16) != 0) {
            str2 = examMessageResponse.message;
        }
        String str4 = str2;
        if ((i & 32) != 0) {
            arrayList = examMessageResponse.exam;
        }
        return examMessageResponse.copy(z, z4, str3, z5, str4, arrayList);
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
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final ArrayList<ExamMessage> component6() {
        return this.exam;
    }

    public final ExamMessageResponse copy(boolean login, boolean is_registered, String error, boolean success, String message, ArrayList<ExamMessage> exam) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(exam, "exam");
        return new ExamMessageResponse(login, is_registered, error, success, message, exam);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamMessageResponse)) {
            return false;
        }
        ExamMessageResponse examMessageResponse = (ExamMessageResponse) other;
        return this.login == examMessageResponse.login && this.is_registered == examMessageResponse.is_registered && Intrinsics.areEqual(this.error, examMessageResponse.error) && this.success == examMessageResponse.success && Intrinsics.areEqual(this.message, examMessageResponse.message) && Intrinsics.areEqual(this.exam, examMessageResponse.exam);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.is_registered;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int hashCode = (((i + i2) * 31) + this.error.hashCode()) * 31;
        boolean z2 = this.success;
        return ((((hashCode + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.message.hashCode()) * 31) + this.exam.hashCode();
    }

    public String toString() {
        return "ExamMessageResponse(login=" + this.login + ", is_registered=" + this.is_registered + ", error=" + this.error + ", success=" + this.success + ", message=" + this.message + ", exam=" + this.exam + ")";
    }

    public ExamMessageResponse(boolean z, boolean z2, String error, boolean z3, String message, ArrayList<ExamMessage> exam) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(exam, "exam");
        this.login = z;
        this.is_registered = z2;
        this.error = error;
        this.success = z3;
        this.message = message;
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

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ArrayList<ExamMessage> getExam() {
        return this.exam;
    }
}