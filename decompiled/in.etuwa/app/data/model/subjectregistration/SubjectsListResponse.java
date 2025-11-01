package in.etuwa.app.data.model.subjectregistration;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubjectsListResponse.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005¢\u0006\u0002\u0010\u000bJ\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005HÆ\u0003Jq\u0010\u0015\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u00052\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u00052\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/data/model/subjectregistration/SubjectsListResponse;", "", "subject_list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subjectregistration/SubjectsList;", "Lkotlin/collections/ArrayList;", "pathway", "Lin/etuwa/app/data/model/subjectregistration/PathWay;", "sem_list", "Lin/etuwa/app/data/model/subjectregistration/SemList;", "category", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getCategory", "()Ljava/util/ArrayList;", "getPathway", "getSem_list", "getSubject_list", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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