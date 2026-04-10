package in.etuwa.app.data.model.assignment;

import com.itextpdf.svg.SvgConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AssignmentRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class AssignmentRequest {
    private final String filter;
    private final String sem_id;
    private final String sort;

    public static /* synthetic */ AssignmentRequest copy$default(AssignmentRequest assignmentRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = assignmentRequest.filter;
        }
        if ((i & 2) != 0) {
            str2 = assignmentRequest.sort;
        }
        if ((i & 4) != 0) {
            str3 = assignmentRequest.sem_id;
        }
        return assignmentRequest.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFilter() {
        return this.filter;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSort() {
        return this.sort;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSem_id() {
        return this.sem_id;
    }

    public final AssignmentRequest copy(String filter, String sort, String sem_id) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(sort, "sort");
        Intrinsics.checkNotNullParameter(sem_id, "sem_id");
        return new AssignmentRequest(filter, sort, sem_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AssignmentRequest)) {
            return false;
        }
        AssignmentRequest assignmentRequest = (AssignmentRequest) other;
        return Intrinsics.areEqual(this.filter, assignmentRequest.filter) && Intrinsics.areEqual(this.sort, assignmentRequest.sort) && Intrinsics.areEqual(this.sem_id, assignmentRequest.sem_id);
    }

    public int hashCode() {
        return (((this.filter.hashCode() * 31) + this.sort.hashCode()) * 31) + this.sem_id.hashCode();
    }

    public String toString() {
        return "AssignmentRequest(filter=" + this.filter + ", sort=" + this.sort + ", sem_id=" + this.sem_id + ")";
    }

    public AssignmentRequest(String filter, String sort, String sem_id) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(sort, "sort");
        Intrinsics.checkNotNullParameter(sem_id, "sem_id");
        this.filter = filter;
        this.sort = sort;
        this.sem_id = sem_id;
    }

    public final String getFilter() {
        return this.filter;
    }

    public final String getSort() {
        return this.sort;
    }

    public final String getSem_id() {
        return this.sem_id;
    }
}