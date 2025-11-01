package in.etuwa.app.data.model.result.univ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnivExams.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/data/model/result/univ/UnivExams;", "", "examName", "", "subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/result/univ/UnivExamSubjects;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getExamName", "()Ljava/lang/String;", "getSubjects", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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