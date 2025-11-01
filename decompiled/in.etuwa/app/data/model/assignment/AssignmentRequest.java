package in.etuwa.app.data.model.assignment;

import com.itextpdf.svg.SvgConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssignmentRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/assignment/AssignmentRequest;", "", SvgConstants.Tags.FILTER, "", "sort", "sem_id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFilter", "()Ljava/lang/String;", "getSem_id", "getSort", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getFilter() {
        return this.filter;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSort() {
        return this.sort;
    }

    /* renamed from: component3, reason: from getter */
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