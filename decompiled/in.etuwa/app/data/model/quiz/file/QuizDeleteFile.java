package in.etuwa.app.data.model.quiz.file;

import androidx.core.provider.FontsContractCompat;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuizDeleteFile.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class QuizDeleteFile {

    @SerializedName(FontsContractCompat.Columns.FILE_ID)
    private final String id;

    public static /* synthetic */ QuizDeleteFile copy$default(QuizDeleteFile quizDeleteFile, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quizDeleteFile.id;
        }
        return quizDeleteFile.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final QuizDeleteFile copy(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new QuizDeleteFile(id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof QuizDeleteFile) && Intrinsics.areEqual(this.id, ((QuizDeleteFile) other).id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return "QuizDeleteFile(id=" + this.id + ")";
    }

    public QuizDeleteFile(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
    }

    public final String getId() {
        return this.id;
    }
}