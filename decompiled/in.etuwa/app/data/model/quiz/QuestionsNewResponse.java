package in.etuwa.app.data.model.quiz;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuestionsNewResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class QuestionsNewResponse {
    private final ArrayList<QuestionsNew> questions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuestionsNewResponse copy$default(QuestionsNewResponse questionsNewResponse, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = questionsNewResponse.questions;
        }
        return questionsNewResponse.copy(arrayList);
    }

    public final ArrayList<QuestionsNew> component1() {
        return this.questions;
    }

    public final QuestionsNewResponse copy(ArrayList<QuestionsNew> questions) {
        Intrinsics.checkNotNullParameter(questions, "questions");
        return new QuestionsNewResponse(questions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof QuestionsNewResponse) && Intrinsics.areEqual(this.questions, ((QuestionsNewResponse) other).questions);
    }

    public int hashCode() {
        return this.questions.hashCode();
    }

    public String toString() {
        return "QuestionsNewResponse(questions=" + this.questions + ")";
    }

    public QuestionsNewResponse(ArrayList<QuestionsNew> questions) {
        Intrinsics.checkNotNullParameter(questions, "questions");
        this.questions = questions;
    }

    public final ArrayList<QuestionsNew> getQuestions() {
        return this.questions;
    }
}