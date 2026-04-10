package in.etuwa.app.data.model.quiz.questions;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuestionResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class QuestionResponse {
    private final ArrayList<Questions> questions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuestionResponse copy$default(QuestionResponse questionResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = questionResponse.questions;
        }
        return questionResponse.copy(arrayList);
    }

    public final ArrayList<Questions> component1() {
        return this.questions;
    }

    public final QuestionResponse copy(ArrayList<Questions> questions) {
        Intrinsics.checkNotNullParameter(questions, "questions");
        return new QuestionResponse(questions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof QuestionResponse) && Intrinsics.areEqual(this.questions, ((QuestionResponse) other).questions);
    }

    public int hashCode() {
        return this.questions.hashCode();
    }

    public String toString() {
        return "QuestionResponse(questions=" + this.questions + ")";
    }

    public QuestionResponse(ArrayList<Questions> questions) {
        Intrinsics.checkNotNullParameter(questions, "questions");
        this.questions = questions;
    }

    public final ArrayList<Questions> getQuestions() {
        return this.questions;
    }
}