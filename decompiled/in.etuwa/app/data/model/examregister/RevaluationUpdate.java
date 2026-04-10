package in.etuwa.app.data.model.examregister;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RevaluationUpdate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class RevaluationUpdate {
    private final String answer_script;
    private final String course;
    private final String grade;
    private final String revaluation;
    private final String status;
    private final String type;

    public static /* synthetic */ RevaluationUpdate copy$default(RevaluationUpdate revaluationUpdate, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = revaluationUpdate.course;
        }
        if ((i & 2) != 0) {
            str2 = revaluationUpdate.type;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = revaluationUpdate.grade;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = revaluationUpdate.revaluation;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = revaluationUpdate.answer_script;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = revaluationUpdate.status;
        }
        return revaluationUpdate.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCourse() {
        return this.course;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGrade() {
        return this.grade;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRevaluation() {
        return this.revaluation;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAnswer_script() {
        return this.answer_script;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final RevaluationUpdate copy(String course, String type, String grade, String revaluation, String answer_script, String status) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(grade, "grade");
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        Intrinsics.checkNotNullParameter(answer_script, "answer_script");
        Intrinsics.checkNotNullParameter(status, "status");
        return new RevaluationUpdate(course, type, grade, revaluation, answer_script, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RevaluationUpdate)) {
            return false;
        }
        RevaluationUpdate revaluationUpdate = (RevaluationUpdate) other;
        return Intrinsics.areEqual(this.course, revaluationUpdate.course) && Intrinsics.areEqual(this.type, revaluationUpdate.type) && Intrinsics.areEqual(this.grade, revaluationUpdate.grade) && Intrinsics.areEqual(this.revaluation, revaluationUpdate.revaluation) && Intrinsics.areEqual(this.answer_script, revaluationUpdate.answer_script) && Intrinsics.areEqual(this.status, revaluationUpdate.status);
    }

    public int hashCode() {
        return (((((((((this.course.hashCode() * 31) + this.type.hashCode()) * 31) + this.grade.hashCode()) * 31) + this.revaluation.hashCode()) * 31) + this.answer_script.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "RevaluationUpdate(course=" + this.course + ", type=" + this.type + ", grade=" + this.grade + ", revaluation=" + this.revaluation + ", answer_script=" + this.answer_script + ", status=" + this.status + ")";
    }

    public RevaluationUpdate(String course, String type, String grade, String revaluation, String answer_script, String status) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(grade, "grade");
        Intrinsics.checkNotNullParameter(revaluation, "revaluation");
        Intrinsics.checkNotNullParameter(answer_script, "answer_script");
        Intrinsics.checkNotNullParameter(status, "status");
        this.course = course;
        this.type = type;
        this.grade = grade;
        this.revaluation = revaluation;
        this.answer_script = answer_script;
        this.status = status;
    }

    public final String getCourse() {
        return this.course;
    }

    public final String getType() {
        return this.type;
    }

    public final String getGrade() {
        return this.grade;
    }

    public final String getRevaluation() {
        return this.revaluation;
    }

    public final String getAnswer_script() {
        return this.answer_script;
    }

    public final String getStatus() {
        return this.status;
    }
}