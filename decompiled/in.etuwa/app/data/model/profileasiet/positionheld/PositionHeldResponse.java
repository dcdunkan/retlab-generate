package in.etuwa.app.data.model.profileasiet.positionheld;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PositionHeldResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class PositionHeldResponse {
    private final boolean login;
    private final ArrayList<PositionHeld> positions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PositionHeldResponse copy$default(PositionHeldResponse positionHeldResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = positionHeldResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = positionHeldResponse.positions;
        }
        return positionHeldResponse.copy(z, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<PositionHeld> component2() {
        return this.positions;
    }

    public final PositionHeldResponse copy(boolean login, ArrayList<PositionHeld> positions) {
        Intrinsics.checkNotNullParameter(positions, "positions");
        return new PositionHeldResponse(login, positions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PositionHeldResponse)) {
            return false;
        }
        PositionHeldResponse positionHeldResponse = (PositionHeldResponse) other;
        return this.login == positionHeldResponse.login && Intrinsics.areEqual(this.positions, positionHeldResponse.positions);
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
        return (r0 * 31) + this.positions.hashCode();
    }

    public String toString() {
        return "PositionHeldResponse(login=" + this.login + ", positions=" + this.positions + ")";
    }

    public PositionHeldResponse(boolean z, ArrayList<PositionHeld> positions) {
        Intrinsics.checkNotNullParameter(positions, "positions");
        this.login = z;
        this.positions = positions;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<PositionHeld> getPositions() {
        return this.positions;
    }
}