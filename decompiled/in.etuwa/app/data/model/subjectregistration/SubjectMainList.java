package in.etuwa.app.data.model.subjectregistration;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubjectMainList.kt */
/* loaded from: classes3.dex */
public final /* data */ class SubjectMainList {
    private String ans;
    private String mark;
    private final String name;
    private final int sem_id;
    private final ArrayList<SemSubList> subjects;

    public static /* synthetic */ SubjectMainList copy$default(SubjectMainList subjectMainList, String str, int i, String str2, String str3, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = subjectMainList.name;
        }
        if ((i2 & 2) != 0) {
            i = subjectMainList.sem_id;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = subjectMainList.mark;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            str3 = subjectMainList.ans;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            arrayList = subjectMainList.subjects;
        }
        return subjectMainList.copy(str, i3, str4, str5, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSem_id() {
        return this.sem_id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMark() {
        return this.mark;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAns() {
        return this.ans;
    }

    public final ArrayList<SemSubList> component5() {
        return this.subjects;
    }

    public final SubjectMainList copy(String name, int sem_id, String mark, String ans, ArrayList<SemSubList> subjects) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mark, "mark");
        Intrinsics.checkNotNullParameter(ans, "ans");
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        return new SubjectMainList(name, sem_id, mark, ans, subjects);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubjectMainList)) {
            return false;
        }
        SubjectMainList subjectMainList = (SubjectMainList) other;
        return Intrinsics.areEqual(this.name, subjectMainList.name) && this.sem_id == subjectMainList.sem_id && Intrinsics.areEqual(this.mark, subjectMainList.mark) && Intrinsics.areEqual(this.ans, subjectMainList.ans) && Intrinsics.areEqual(this.subjects, subjectMainList.subjects);
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + this.sem_id) * 31) + this.mark.hashCode()) * 31) + this.ans.hashCode()) * 31) + this.subjects.hashCode();
    }

    public String toString() {
        return "SubjectMainList(name=" + this.name + ", sem_id=" + this.sem_id + ", mark=" + this.mark + ", ans=" + this.ans + ", subjects=" + this.subjects + ")";
    }

    public SubjectMainList(String name, int i, String mark, String ans, ArrayList<SemSubList> subjects) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mark, "mark");
        Intrinsics.checkNotNullParameter(ans, "ans");
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        this.name = name;
        this.sem_id = i;
        this.mark = mark;
        this.ans = ans;
        this.subjects = subjects;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSem_id() {
        return this.sem_id;
    }

    public final String getMark() {
        return this.mark;
    }

    public final void setMark(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mark = str;
    }

    public final String getAns() {
        return this.ans;
    }

    public final void setAns(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ans = str;
    }

    public final ArrayList<SemSubList> getSubjects() {
        return this.subjects;
    }
}