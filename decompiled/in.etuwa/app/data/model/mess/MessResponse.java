package in.etuwa.app.data.model.mess;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class MessResponse {
    private final ArrayList<Mess> data;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessResponse copy$default(MessResponse messResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = messResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = messResponse.data;
        }
        return messResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Mess> component2() {
        return this.data;
    }

    public final MessResponse copy(boolean login, ArrayList<Mess> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new MessResponse(login, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessResponse)) {
            return false;
        }
        MessResponse messResponse = (MessResponse) other;
        return this.login == messResponse.login && Intrinsics.areEqual(this.data, messResponse.data);
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
        return "MessResponse(login=" + this.login + ", data=" + this.data + ")";
    }

    public MessResponse(boolean z, ArrayList<Mess> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.login = z;
        this.data = data;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Mess> getData() {
        return this.data;
    }
}