package in.etuwa.app.data.model.examregister;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamMessageResponse.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fHÆ\u0003JU\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006\""}, d2 = {"Lin/etuwa/app/data/model/examregister/ExamMessageResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "is_registered", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "success", "message", "exam", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/examregister/ExamMessage;", "Lkotlin/collections/ArrayList;", "(ZZLjava/lang/String;ZLjava/lang/String;Ljava/util/ArrayList;)V", "getError", "()Ljava/lang/String;", "getExam", "()Ljava/util/ArrayList;", "()Z", "getLogin", "getMessage", "getSuccess", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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