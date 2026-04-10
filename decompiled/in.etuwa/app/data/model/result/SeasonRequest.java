package in.etuwa.app.data.model.result;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SeasonRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class SeasonRequest {
    private final String sem_id;
    private final String session;

    public static /* synthetic */ SeasonRequest copy$default(SeasonRequest seasonRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = seasonRequest.sem_id;
        }
        if ((i & 2) != 0) {
            str2 = seasonRequest.session;
        }
        return seasonRequest.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSem_id() {
        return this.sem_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSession() {
        return this.session;
    }

    public final SeasonRequest copy(String sem_id, String session) {
        Intrinsics.checkNotNullParameter(sem_id, "sem_id");
        Intrinsics.checkNotNullParameter(session, "session");
        return new SeasonRequest(sem_id, session);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SeasonRequest)) {
            return false;
        }
        SeasonRequest seasonRequest = (SeasonRequest) other;
        return Intrinsics.areEqual(this.sem_id, seasonRequest.sem_id) && Intrinsics.areEqual(this.session, seasonRequest.session);
    }

    public int hashCode() {
        return (this.sem_id.hashCode() * 31) + this.session.hashCode();
    }

    public String toString() {
        return "SeasonRequest(sem_id=" + this.sem_id + ", session=" + this.session + ")";
    }

    public SeasonRequest(String sem_id, String session) {
        Intrinsics.checkNotNullParameter(sem_id, "sem_id");
        Intrinsics.checkNotNullParameter(session, "session");
        this.sem_id = sem_id;
        this.session = session;
    }

    public final String getSem_id() {
        return this.sem_id;
    }

    public final String getSession() {
        return this.session;
    }
}