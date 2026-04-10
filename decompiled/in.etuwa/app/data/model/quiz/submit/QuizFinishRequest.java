package in.etuwa.app.data.model.quiz.submit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuizFinishRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getQno() {
        return this.qno;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOption() {
        return this.option;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
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
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.option;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.final_submit.hashCode();
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