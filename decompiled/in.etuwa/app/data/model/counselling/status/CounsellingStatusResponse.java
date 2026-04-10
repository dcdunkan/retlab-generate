package in.etuwa.app.data.model.counselling.status;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CounsellingStatusResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class CounsellingStatusResponse {

    @SerializedName(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)
    private final ArrayList<CounsellingStatus> data;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CounsellingStatusResponse copy$default(CounsellingStatusResponse counsellingStatusResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = counsellingStatusResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = counsellingStatusResponse.data;
        }
        return counsellingStatusResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CounsellingStatus> component2() {
        return this.data;
    }

    public final CounsellingStatusResponse copy(boolean login, ArrayList<CounsellingStatus> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new CounsellingStatusResponse(login, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CounsellingStatusResponse)) {
            return false;
        }
        CounsellingStatusResponse counsellingStatusResponse = (CounsellingStatusResponse) other;
        return this.login == counsellingStatusResponse.login && Intrinsics.areEqual(this.data, counsellingStatusResponse.data);
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
        return (r0 * 31) + this.data.hashCode();
    }

    public String toString() {
        return "CounsellingStatusResponse(login=" + this.login + ", data=" + this.data + ")";
    }

    public CounsellingStatusResponse(boolean z, ArrayList<CounsellingStatus> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.login = z;
        this.data = data;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CounsellingStatus> getData() {
        return this.data;
    }
}