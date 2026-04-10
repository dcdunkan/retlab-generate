package in.etuwa.app.data.model.hostel;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostelPalaiTypesResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class HostelPalaiTypesResponse {
    private final boolean login;
    private final ArrayList<HostelFeeTypes> types;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostelPalaiTypesResponse copy$default(HostelPalaiTypesResponse hostelPalaiTypesResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hostelPalaiTypesResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = hostelPalaiTypesResponse.types;
        }
        return hostelPalaiTypesResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelFeeTypes> component2() {
        return this.types;
    }

    public final HostelPalaiTypesResponse copy(boolean login, ArrayList<HostelFeeTypes> types) {
        Intrinsics.checkNotNullParameter(types, "types");
        return new HostelPalaiTypesResponse(login, types);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelPalaiTypesResponse)) {
            return false;
        }
        HostelPalaiTypesResponse hostelPalaiTypesResponse = (HostelPalaiTypesResponse) other;
        return this.login == hostelPalaiTypesResponse.login && Intrinsics.areEqual(this.types, hostelPalaiTypesResponse.types);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.types.hashCode();
    }

    public String toString() {
        return "HostelPalaiTypesResponse(login=" + this.login + ", types=" + this.types + ")";
    }

    public HostelPalaiTypesResponse(boolean z, ArrayList<HostelFeeTypes> types) {
        Intrinsics.checkNotNullParameter(types, "types");
        this.login = z;
        this.types = types;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<HostelFeeTypes> getTypes() {
        return this.types;
    }
}