package in.etuwa.app.data.model.quiz.submit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: QuizSubmitResponse.kt */
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getIsStarted() {
        return this.isStarted;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsOngoing() {
        return this.isOngoing;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component4, reason: from getter */
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
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    public int hashCode() {
        boolean z = this.isStarted;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.isOngoing;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.success;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z2 = this.is_finished;
        return i5 + (z2 ? 1 : z2 ? 1 : 0);
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