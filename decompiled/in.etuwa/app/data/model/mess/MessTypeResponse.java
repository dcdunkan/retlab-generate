package in.etuwa.app.data.model.mess;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessTypeResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class MessTypeResponse {
    private final ArrayList<MessData> data;
    private final boolean login;
    private final ArrayList<MessType> type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessTypeResponse copy$default(MessTypeResponse messTypeResponse, boolean z, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = messTypeResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = messTypeResponse.data;
        }
        if ((i & 4) != 0) {
            arrayList2 = messTypeResponse.type;
        }
        return messTypeResponse.copy(z, arrayList, arrayList2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<MessData> component2() {
        return this.data;
    }

    public final ArrayList<MessType> component3() {
        return this.type;
    }

    public final MessTypeResponse copy(boolean login, ArrayList<MessData> data, ArrayList<MessType> type) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(type, "type");
        return new MessTypeResponse(login, data, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessTypeResponse)) {
            return false;
        }
        MessTypeResponse messTypeResponse = (MessTypeResponse) other;
        return this.login == messTypeResponse.login && Intrinsics.areEqual(this.data, messTypeResponse.data) && Intrinsics.areEqual(this.type, messTypeResponse.type);
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
        return (((r0 * 31) + this.data.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "MessTypeResponse(login=" + this.login + ", data=" + this.data + ", type=" + this.type + ")";
    }

    public MessTypeResponse(boolean z, ArrayList<MessData> data, ArrayList<MessType> type) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(type, "type");
        this.login = z;
        this.data = data;
        this.type = type;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<MessData> getData() {
        return this.data;
    }

    public final ArrayList<MessType> getType() {
        return this.type;
    }
}