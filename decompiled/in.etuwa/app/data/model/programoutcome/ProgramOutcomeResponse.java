package in.etuwa.app.data.model.programoutcome;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgramOutcomeResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ProgramOutcomeResponse {
    private final boolean login;
    private final ArrayList<ProgramOutcome> pgm_educational;
    private final ArrayList<ProgramOutcome> pgm_outcomes;
    private final ArrayList<ProgramOutcome> pgm_specific;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProgramOutcomeResponse copy$default(ProgramOutcomeResponse programOutcomeResponse, boolean z, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = programOutcomeResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = programOutcomeResponse.pgm_outcomes;
        }
        if ((i & 4) != 0) {
            arrayList2 = programOutcomeResponse.pgm_educational;
        }
        if ((i & 8) != 0) {
            arrayList3 = programOutcomeResponse.pgm_specific;
        }
        return programOutcomeResponse.copy(z, arrayList, arrayList2, arrayList3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ProgramOutcome> component2() {
        return this.pgm_outcomes;
    }

    public final ArrayList<ProgramOutcome> component3() {
        return this.pgm_educational;
    }

    public final ArrayList<ProgramOutcome> component4() {
        return this.pgm_specific;
    }

    public final ProgramOutcomeResponse copy(boolean login, ArrayList<ProgramOutcome> pgm_outcomes, ArrayList<ProgramOutcome> pgm_educational, ArrayList<ProgramOutcome> pgm_specific) {
        Intrinsics.checkNotNullParameter(pgm_outcomes, "pgm_outcomes");
        Intrinsics.checkNotNullParameter(pgm_educational, "pgm_educational");
        Intrinsics.checkNotNullParameter(pgm_specific, "pgm_specific");
        return new ProgramOutcomeResponse(login, pgm_outcomes, pgm_educational, pgm_specific);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProgramOutcomeResponse)) {
            return false;
        }
        ProgramOutcomeResponse programOutcomeResponse = (ProgramOutcomeResponse) other;
        return this.login == programOutcomeResponse.login && Intrinsics.areEqual(this.pgm_outcomes, programOutcomeResponse.pgm_outcomes) && Intrinsics.areEqual(this.pgm_educational, programOutcomeResponse.pgm_educational) && Intrinsics.areEqual(this.pgm_specific, programOutcomeResponse.pgm_specific);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + this.pgm_outcomes.hashCode()) * 31) + this.pgm_educational.hashCode()) * 31) + this.pgm_specific.hashCode();
    }

    public String toString() {
        return "ProgramOutcomeResponse(login=" + this.login + ", pgm_outcomes=" + this.pgm_outcomes + ", pgm_educational=" + this.pgm_educational + ", pgm_specific=" + this.pgm_specific + ")";
    }

    public ProgramOutcomeResponse(boolean z, ArrayList<ProgramOutcome> pgm_outcomes, ArrayList<ProgramOutcome> pgm_educational, ArrayList<ProgramOutcome> pgm_specific) {
        Intrinsics.checkNotNullParameter(pgm_outcomes, "pgm_outcomes");
        Intrinsics.checkNotNullParameter(pgm_educational, "pgm_educational");
        Intrinsics.checkNotNullParameter(pgm_specific, "pgm_specific");
        this.login = z;
        this.pgm_outcomes = pgm_outcomes;
        this.pgm_educational = pgm_educational;
        this.pgm_specific = pgm_specific;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ProgramOutcome> getPgm_outcomes() {
        return this.pgm_outcomes;
    }

    public final ArrayList<ProgramOutcome> getPgm_educational() {
        return this.pgm_educational;
    }

    public final ArrayList<ProgramOutcome> getPgm_specific() {
        return this.pgm_specific;
    }
}