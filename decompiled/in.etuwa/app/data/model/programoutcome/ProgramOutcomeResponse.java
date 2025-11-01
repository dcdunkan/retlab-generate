package in.etuwa.app.data.model.programoutcome;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgramOutcomeResponse.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003Ja\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/data/model/programoutcome/ProgramOutcomeResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "pgm_outcomes", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/programoutcome/ProgramOutcome;", "Lkotlin/collections/ArrayList;", "pgm_educational", "pgm_specific", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getLogin", "()Z", "getPgm_educational", "()Ljava/util/ArrayList;", "getPgm_outcomes", "getPgm_specific", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
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