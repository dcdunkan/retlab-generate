package in.etuwa.app.data.model.subjectregistration;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubjectsListResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class SubjectsListResponse {
    private final ArrayList<PathWay> category;
    private final ArrayList<PathWay> pathway;
    private final ArrayList<SemList> sem_list;
    private final ArrayList<SubjectsList> subject_list;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubjectsListResponse copy$default(SubjectsListResponse subjectsListResponse, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = subjectsListResponse.subject_list;
        }
        if ((i & 2) != 0) {
            arrayList2 = subjectsListResponse.pathway;
        }
        if ((i & 4) != 0) {
            arrayList3 = subjectsListResponse.sem_list;
        }
        if ((i & 8) != 0) {
            arrayList4 = subjectsListResponse.category;
        }
        return subjectsListResponse.copy(arrayList, arrayList2, arrayList3, arrayList4);
    }

    public final ArrayList<SubjectsList> component1() {
        return this.subject_list;
    }

    public final ArrayList<PathWay> component2() {
        return this.pathway;
    }

    public final ArrayList<SemList> component3() {
        return this.sem_list;
    }

    public final ArrayList<PathWay> component4() {
        return this.category;
    }

    public final SubjectsListResponse copy(ArrayList<SubjectsList> subject_list, ArrayList<PathWay> pathway, ArrayList<SemList> sem_list, ArrayList<PathWay> category) {
        Intrinsics.checkNotNullParameter(subject_list, "subject_list");
        Intrinsics.checkNotNullParameter(pathway, "pathway");
        Intrinsics.checkNotNullParameter(sem_list, "sem_list");
        Intrinsics.checkNotNullParameter(category, "category");
        return new SubjectsListResponse(subject_list, pathway, sem_list, category);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubjectsListResponse)) {
            return false;
        }
        SubjectsListResponse subjectsListResponse = (SubjectsListResponse) other;
        return Intrinsics.areEqual(this.subject_list, subjectsListResponse.subject_list) && Intrinsics.areEqual(this.pathway, subjectsListResponse.pathway) && Intrinsics.areEqual(this.sem_list, subjectsListResponse.sem_list) && Intrinsics.areEqual(this.category, subjectsListResponse.category);
    }

    public int hashCode() {
        return (((((this.subject_list.hashCode() * 31) + this.pathway.hashCode()) * 31) + this.sem_list.hashCode()) * 31) + this.category.hashCode();
    }

    public String toString() {
        return "SubjectsListResponse(subject_list=" + this.subject_list + ", pathway=" + this.pathway + ", sem_list=" + this.sem_list + ", category=" + this.category + ")";
    }

    public SubjectsListResponse(ArrayList<SubjectsList> subject_list, ArrayList<PathWay> pathway, ArrayList<SemList> sem_list, ArrayList<PathWay> category) {
        Intrinsics.checkNotNullParameter(subject_list, "subject_list");
        Intrinsics.checkNotNullParameter(pathway, "pathway");
        Intrinsics.checkNotNullParameter(sem_list, "sem_list");
        Intrinsics.checkNotNullParameter(category, "category");
        this.subject_list = subject_list;
        this.pathway = pathway;
        this.sem_list = sem_list;
        this.category = category;
    }

    public final ArrayList<SubjectsList> getSubject_list() {
        return this.subject_list;
    }

    public final ArrayList<PathWay> getPathway() {
        return this.pathway;
    }

    public final ArrayList<SemList> getSem_list() {
        return this.sem_list;
    }

    public final ArrayList<PathWay> getCategory() {
        return this.category;
    }
}