package in.etuwa.app.data.model.profileasiet.sport;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SportResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SportResponse {
    private final boolean login;
    private final ArrayList<Sport> participation;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SportResponse copy$default(SportResponse sportResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = sportResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = sportResponse.participation;
        }
        return sportResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Sport> component2() {
        return this.participation;
    }

    public final SportResponse copy(boolean login, ArrayList<Sport> participation) {
        Intrinsics.checkNotNullParameter(participation, "participation");
        return new SportResponse(login, participation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportResponse)) {
            return false;
        }
        SportResponse sportResponse = (SportResponse) other;
        return this.login == sportResponse.login && Intrinsics.areEqual(this.participation, sportResponse.participation);
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
        return (r0 * 31) + this.participation.hashCode();
    }

    public String toString() {
        return "SportResponse(login=" + this.login + ", participation=" + this.participation + ")";
    }

    public SportResponse(boolean z, ArrayList<Sport> participation) {
        Intrinsics.checkNotNullParameter(participation, "participation");
        this.login = z;
        this.participation = participation;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<Sport> getParticipation() {
        return this.participation;
    }
}