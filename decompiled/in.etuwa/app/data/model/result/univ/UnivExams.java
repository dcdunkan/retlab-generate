package in.etuwa.app.data.model.result.univ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnivExams.kt */
/* loaded from: classes3.dex */
public final /* data */ class UnivExams {

    @SerializedName("exam_name")
    private final String examName;
    private final ArrayList<UnivExamSubjects> subjects;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UnivExams copy$default(UnivExams univExams, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = univExams.examName;
        }
        if ((i & 2) != 0) {
            arrayList = univExams.subjects;
        }
        return univExams.copy(str, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final String getExamName() {
        return this.examName;
    }

    public final ArrayList<UnivExamSubjects> component2() {
        return this.subjects;
    }

    public final UnivExams copy(String examName, ArrayList<UnivExamSubjects> subjects) {
        Intrinsics.checkNotNullParameter(examName, "examName");
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        return new UnivExams(examName, subjects);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnivExams)) {
            return false;
        }
        UnivExams univExams = (UnivExams) other;
        return Intrinsics.areEqual(this.examName, univExams.examName) && Intrinsics.areEqual(this.subjects, univExams.subjects);
    }

    public int hashCode() {
        return (this.examName.hashCode() * 31) + this.subjects.hashCode();
    }

    public String toString() {
        return "UnivExams(examName=" + this.examName + ", subjects=" + this.subjects + ")";
    }

    public UnivExams(String examName, ArrayList<UnivExamSubjects> subjects) {
        Intrinsics.checkNotNullParameter(examName, "examName");
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        this.examName = examName;
        this.subjects = subjects;
    }

    public final String getExamName() {
        return this.examName;
    }

    public final ArrayList<UnivExamSubjects> getSubjects() {
        return this.subjects;
    }
}