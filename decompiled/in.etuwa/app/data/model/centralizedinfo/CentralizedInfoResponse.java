package in.etuwa.app.data.model.centralizedinfo;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CentralizedInfoResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class CentralizedInfoResponse {
    private final ArrayList<CentralizedInfo> info;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CentralizedInfoResponse copy$default(CentralizedInfoResponse centralizedInfoResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = centralizedInfoResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = centralizedInfoResponse.info;
        }
        return centralizedInfoResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CentralizedInfo> component2() {
        return this.info;
    }

    public final CentralizedInfoResponse copy(boolean login, ArrayList<CentralizedInfo> info) {
        Intrinsics.checkNotNullParameter(info, "info");
        return new CentralizedInfoResponse(login, info);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CentralizedInfoResponse)) {
            return false;
        }
        CentralizedInfoResponse centralizedInfoResponse = (CentralizedInfoResponse) other;
        return this.login == centralizedInfoResponse.login && Intrinsics.areEqual(this.info, centralizedInfoResponse.info);
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
        return (r0 * 31) + this.info.hashCode();
    }

    public String toString() {
        return "CentralizedInfoResponse(login=" + this.login + ", info=" + this.info + ")";
    }

    public CentralizedInfoResponse(boolean z, ArrayList<CentralizedInfo> info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.login = z;
        this.info = info;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CentralizedInfo> getInfo() {
        return this.info;
    }
}