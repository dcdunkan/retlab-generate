package in.etuwa.app.data.model.subjectregistration;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubjectMainList.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lin/etuwa/app/data/model/subjectregistration/SubjectMainList;", "", "name", "", "sem_id", "", "mark", "ans", "subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subjectregistration/SemSubList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getAns", "()Ljava/lang/String;", "setAns", "(Ljava/lang/String;)V", "getMark", "setMark", "getName", "getSem_id", "()I", "getSubjects", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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