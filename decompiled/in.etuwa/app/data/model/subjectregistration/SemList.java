package in.etuwa.app.data.model.subjectregistration;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemList.kt */
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