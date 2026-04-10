package in.etuwa.app.data.model.store;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemesterListRequest.kt */
/* loaded from: classes3.dex */
public final /* data */ class SemesterListRequest {

    @SerializedName("dept_id")
    @Expose
    private final String deptId;

    public static /* synthetic */ SemesterListRequest copy$default(SemesterListRequest semesterListRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = semesterListRequest.deptId;
        }
        return semesterListRequest.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDeptId() {
        return this.deptId;
    }

    public final SemesterListRequest copy(String deptId) {
        Intrinsics.checkNotNullParameter(deptId, "deptId");
        return new SemesterListRequest(deptId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SemesterListRequest) && Intrinsics.areEqual(this.deptId, ((SemesterListRequest) other).deptId);
    }

    public int hashCode() {
        return this.deptId.hashCode();
    }

    public String toString() {
        return "SemesterListRequest(deptId=" + this.deptId + ")";
    }

    public SemesterListRequest(String deptId) {
        Intrinsics.checkNotNullParameter(deptId, "deptId");
        this.deptId = deptId;
    }

    public final String getDeptId() {
        return this.deptId;
    }
}