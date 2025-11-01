package in.etuwa.app.data.model.quiz.submit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuizFinishRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/quiz/submit/QuizFinishRequest;", "", "qno", "", "option", "final_submit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFinal_submit", "()Ljava/lang/String;", "getOption", "getQno", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class QuizFinishRequest {
    private final String final_submit;
    private final String option;
    private final String qno;

    public static /* synthetic */ QuizFinishRequest copy$default(QuizFinishRequest quizFinishRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quizFinishRequest.qno;
        }
        if ((i & 2) != 0) {
            str2 = quizFinishRequest.option;
        }
        if ((i & 4) != 0) {
            str3 = quizFinishRequest.final_submit;
        }
        return quizFinishRequest.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQno() {
        return this.qno;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOption() {
        return this.option;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFinal_submit() {
        return this.final_submit;
    }

    public final QuizFinishRequest copy(String qno, String option, String final_submit) {
        Intrinsics.checkNotNullParameter(final_submit, "final_submit");
        return new QuizFinishRequest(qno, option, final_submit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizFinishRequest)) {
            return false;
        }
        QuizFinishRequest quizFinishRequest = (QuizFinishRequest) other;
        return Intrinsics.areEqual(this.qno, quizFinishRequest.qno) && Intrinsics.areEqual(this.option, quizFinishRequest.option) && Intrinsics.areEqual(this.final_submit, quizFinishRequest.final_submit);
    }

    public int hashCode() {
        String str = this.qno;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.option;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.final_submit.hashCode();
    }

    public String toString() {
        return "QuizFinishRequest(qno=" + this.qno + ", option=" + this.option + ", final_submit=" + this.final_submit + ")";
    }

    public QuizFinishRequest(String str, String str2, String final_submit) {
        Intrinsics.checkNotNullParameter(final_submit, "final_submit");
        this.qno = str;
        this.option = str2;
        this.final_submit = final_submit;
    }

    public /* synthetic */ QuizFinishRequest(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "1" : str3);
    }

    public final String getQno() {
        return this.qno;
    }

    public final String getOption() {
        return this.option;
    }

    public final String getFinal_submit() {
        return this.final_submit;
    }
}