package in.etuwa.app.data.model.examregister;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RevaluationUpdate.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/data/model/examregister/RevaluationUpdate;", "", "course", "", "type", "grade", "revaluation", "answer_script", NotificationCompat.CATEGORY_STATUS, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnswer_script", "()Ljava/lang/String;", "getCourse", "getGrade", "getRevaluation", "getStatus", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getCourse() {
        return this.course;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getGrade() {
        return this.grade;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRevaluation() {
        return this.revaluation;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAnswer_script() {
        return this.answer_script;
    }

    /* renamed from: component6, reason: from getter */
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