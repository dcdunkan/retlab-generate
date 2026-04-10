package in.etuwa.app.data.model.examregister;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Revaluation.kt */
/* loaded from: classes3.dex */
public final /* data */ class Revaluation {
    private final String course;
    private final String grade;
    private final String status;
    private final String type;

    public static /* synthetic */ Revaluation copy$default(Revaluation revaluation, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = revaluation.course;
        }
        if ((i & 2) != 0) {
            str2 = revaluation.type;
        }
        if ((i & 4) != 0) {
            str3 = revaluation.grade;
        }
        if ((i & 8) != 0) {
            str4 = revaluation.status;
        }
        return revaluation.copy(str, str2, str3, str4);
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
    public final String getStatus() {
        return this.status;
    }

    public final Revaluation copy(String course, String type, String grade, String status) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(grade, "grade");
        Intrinsics.checkNotNullParameter(status, "status");
        return new Revaluation(course, type, grade, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Revaluation)) {
            return false;
        }
        Revaluation revaluation = (Revaluation) other;
        return Intrinsics.areEqual(this.course, revaluation.course) && Intrinsics.areEqual(this.type, revaluation.type) && Intrinsics.areEqual(this.grade, revaluation.grade) && Intrinsics.areEqual(this.status, revaluation.status);
    }

    public int hashCode() {
        return (((((this.course.hashCode() * 31) + this.type.hashCode()) * 31) + this.grade.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "Revaluation(course=" + this.course + ", type=" + this.type + ", grade=" + this.grade + ", status=" + this.status + ")";
    }

    public Revaluation(String course, String type, String grade, String status) {
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(grade, "grade");
        Intrinsics.checkNotNullParameter(status, "status");
        this.course = course;
        this.type = type;
        this.grade = grade;
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

    public final String getStatus() {
        return this.status;
    }
}