package in.etuwa.app.data.model.result;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SeasonRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/result/SeasonRequest;", "", "sem_id", "", "session", "(Ljava/lang/String;Ljava/lang/String;)V", "getSem_id", "()Ljava/lang/String;", "getSession", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getSem_id() {
        return this.sem_id;
    }

    /* renamed from: component2, reason: from getter */
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