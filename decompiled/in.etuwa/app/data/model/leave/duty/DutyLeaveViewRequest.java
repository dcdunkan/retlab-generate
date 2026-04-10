package in.etuwa.app.data.model.leave.duty;

import com.itextpdf.svg.SvgConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DutyLeaveViewRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class DutyLeaveViewRequest {
    private final String filter;

    public static /* synthetic */ DutyLeaveViewRequest copy$default(DutyLeaveViewRequest dutyLeaveViewRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dutyLeaveViewRequest.filter;
        }
        return dutyLeaveViewRequest.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFilter() {
        return this.filter;
    }

    public final DutyLeaveViewRequest copy(String filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        return new DutyLeaveViewRequest(filter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DutyLeaveViewRequest) && Intrinsics.areEqual(this.filter, ((DutyLeaveViewRequest) other).filter);
    }

    public int hashCode() {
        return this.filter.hashCode();
    }

    public String toString() {
        return "DutyLeaveViewRequest(filter=" + this.filter + ")";
    }

    public DutyLeaveViewRequest(String filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.filter = filter;
    }

    public final String getFilter() {
        return this.filter;
    }
}