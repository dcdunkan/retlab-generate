package in.etuwa.app.data.model.store.departmentlist;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DepartmentListResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class DepartmentListResponse {
    private final ArrayList<DepartmentList> data;
    private final boolean login;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DepartmentListResponse copy$default(DepartmentListResponse departmentListResponse, boolean z, boolean z2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = departmentListResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = departmentListResponse.success;
        }
        if ((i & 4) != 0) {
            arrayList = departmentListResponse.data;
        }
        return departmentListResponse.copy(z, z2, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<DepartmentList> component3() {
        return this.data;
    }

    public final DepartmentListResponse copy(boolean login, boolean success, ArrayList<DepartmentList> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new DepartmentListResponse(login, success, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DepartmentListResponse)) {
            return false;
        }
        DepartmentListResponse departmentListResponse = (DepartmentListResponse) other;
        return this.login == departmentListResponse.login && this.success == departmentListResponse.success && Intrinsics.areEqual(this.data, departmentListResponse.data);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "DepartmentListResponse(login=" + this.login + ", success=" + this.success + ", data=" + this.data + ")";
    }

    public DepartmentListResponse(boolean z, boolean z2, ArrayList<DepartmentList> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.login = z;
        this.success = z2;
        this.data = data;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<DepartmentList> getData() {
        return this.data;
    }
}