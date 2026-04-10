package in.etuwa.app.data.model.quiz.list;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuizResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class QuizResponse {
    private final ArrayList<Quiz> quizes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuizResponse copy$default(QuizResponse quizResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = quizResponse.quizes;
        }
        return quizResponse.copy(arrayList);
    }

    public final ArrayList<Quiz> component1() {
        return this.quizes;
    }

    public final QuizResponse copy(ArrayList<Quiz> quizes) {
        Intrinsics.checkNotNullParameter(quizes, "quizes");
        return new QuizResponse(quizes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof QuizResponse) && Intrinsics.areEqual(this.quizes, ((QuizResponse) other).quizes);
    }

    public int hashCode() {
        return this.quizes.hashCode();
    }

    public String toString() {
        return "QuizResponse(quizes=" + this.quizes + ")";
    }

    public QuizResponse(ArrayList<Quiz> quizes) {
        Intrinsics.checkNotNullParameter(quizes, "quizes");
        this.quizes = quizes;
    }

    public final ArrayList<Quiz> getQuizes() {
        return this.quizes;
    }
}