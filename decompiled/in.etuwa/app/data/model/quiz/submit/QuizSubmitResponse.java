package in.etuwa.app.data.model.quiz.submit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: compiled from: QuizSubmitResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class QuizSubmitResponse {

    @SerializedName("is_ongoing")
    @Expose
    private final boolean isOngoing;

    @SerializedName("is_started")
    @Expose
    private final boolean isStarted;
    private final boolean is_finished;
    private final boolean success;

    public static /* synthetic */ QuizSubmitResponse copy$default(QuizSubmitResponse quizSubmitResponse, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = quizSubmitResponse.isStarted;
        }
        if ((i & 2) != 0) {
            z2 = quizSubmitResponse.isOngoing;
        }
        if ((i & 4) != 0) {
            z3 = quizSubmitResponse.success;
        }
        if ((i & 8) != 0) {
            z4 = quizSubmitResponse.is_finished;
        }
        return quizSubmitResponse.copy(z, z2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsStarted() {
        return this.isStarted;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsOngoing() {
        return this.isOngoing;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIs_finished() {
        return this.is_finished;
    }

    public final QuizSubmitResponse copy(boolean isStarted, boolean isOngoing, boolean success, boolean is_finished) {
        return new QuizSubmitResponse(isStarted, isOngoing, success, is_finished);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizSubmitResponse)) {
            return false;
        }
        QuizSubmitResponse quizSubmitResponse = (QuizSubmitResponse) other;
        return this.isStarted == quizSubmitResponse.isStarted && this.isOngoing == quizSubmitResponse.isOngoing && this.success == quizSubmitResponse.success && this.is_finished == quizSubmitResponse.is_finished;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        boolean z = this.isStarted;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.isOngoing;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.success;
        ?? r22 = z3;
        if (z3) {
            r22 = 1;
        }
        int i3 = (i2 + r22) * 31;
        boolean z4 = this.is_finished;
        return i3 + (z4 ? 1 : z4);
    }

    public String toString() {
        return "QuizSubmitResponse(isStarted=" + this.isStarted + ", isOngoing=" + this.isOngoing + ", success=" + this.success + ", is_finished=" + this.is_finished + ")";
    }

    public QuizSubmitResponse(boolean z, boolean z2, boolean z3, boolean z4) {
        this.isStarted = z;
        this.isOngoing = z2;
        this.success = z3;
        this.is_finished = z4;
    }

    public final boolean isStarted() {
        return this.isStarted;
    }

    public final boolean isOngoing() {
        return this.isOngoing;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final boolean is_finished() {
        return this.is_finished;
    }
}