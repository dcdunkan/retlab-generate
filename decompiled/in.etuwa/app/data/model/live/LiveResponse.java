package in.etuwa.app.data.model.live;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LiveResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class LiveResponse {
    private final ArrayList<Live> live;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveResponse copy$default(LiveResponse liveResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = liveResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = liveResponse.live;
        }
        return liveResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Live> component2() {
        return this.live;
    }

    public final LiveResponse copy(boolean login, ArrayList<Live> live) {
        Intrinsics.checkNotNullParameter(live, "live");
        return new LiveResponse(login, live);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveResponse)) {
            return false;
        }
        LiveResponse liveResponse = (LiveResponse) other;
        return this.login == liveResponse.login && Intrinsics.areEqual(this.live, liveResponse.live);
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
        return (r0 * 31) + this.live.hashCode();
    }

    public String toString() {
        return "LiveResponse(login=" + this.login + ", live=" + this.live + ")";
    }

    public LiveResponse(boolean z, ArrayList<Live> live) {
        Intrinsics.checkNotNullParameter(live, "live");
        this.login = z;
        this.live = live;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Live> getLive() {
        return this.live;
    }
}