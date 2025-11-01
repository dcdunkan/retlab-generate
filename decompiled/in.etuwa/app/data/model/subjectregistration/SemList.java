package in.etuwa.app.data.model.subjectregistration;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemList.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/data/model/subjectregistration/SemList;", "", "sem_pos", "", "subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subjectregistration/SubjectMainList;", "Lkotlin/collections/ArrayList;", "(ILjava/util/ArrayList;)V", "getSem_pos", "()I", "getSubjects", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SemList {
    private final int sem_pos;
    private final ArrayList<SubjectMainList> subjects;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SemList copy$default(SemList semList, int i, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = semList.sem_pos;
        }
        if ((i2 & 2) != 0) {
            arrayList = semList.subjects;
        }
        return semList.copy(i, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final int getSem_pos() {
        return this.sem_pos;
    }

    public final ArrayList<SubjectMainList> component2() {
        return this.subjects;
    }

    public final SemList copy(int sem_pos, ArrayList<SubjectMainList> subjects) {
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        return new SemList(sem_pos, subjects);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemList)) {
            return false;
        }
        SemList semList = (SemList) other;
        return this.sem_pos == semList.sem_pos && Intrinsics.areEqual(this.subjects, semList.subjects);
    }

    public int hashCode() {
        return (this.sem_pos * 31) + this.subjects.hashCode();
    }

    public String toString() {
        return "SemList(sem_pos=" + this.sem_pos + ", subjects=" + this.subjects + ")";
    }

    public SemList(int i, ArrayList<SubjectMainList> subjects) {
        Intrinsics.checkNotNullParameter(subjects, "subjects");
        this.sem_pos = i;
        this.subjects = subjects;
    }

    public final int getSem_pos() {
        return this.sem_pos;
    }

    public final ArrayList<SubjectMainList> getSubjects() {
        return this.subjects;
    }
}