package in.etuwa.app.data.model.feeengineer.payment;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeeEngineerResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class FeeEngineerResponse {
    private final ArrayList<FeeEngineer> fees;
    private final boolean login;
    private final String message;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeeEngineerResponse copy$default(FeeEngineerResponse feeEngineerResponse, boolean z, boolean z2, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = feeEngineerResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = feeEngineerResponse.success;
        }
        if ((i & 4) != 0) {
            str = feeEngineerResponse.message;
        }
        if ((i & 8) != 0) {
            arrayList = feeEngineerResponse.fees;
        }
        return feeEngineerResponse.copy(z, z2, str, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final ArrayList<FeeEngineer> component4() {
        return this.fees;
    }

    public final FeeEngineerResponse copy(boolean login, boolean success, String message, ArrayList<FeeEngineer> fees) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(fees, "fees");
        return new FeeEngineerResponse(login, success, message, fees);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeeEngineerResponse)) {
            return false;
        }
        FeeEngineerResponse feeEngineerResponse = (FeeEngineerResponse) other;
        return this.login == feeEngineerResponse.login && this.success == feeEngineerResponse.success && Intrinsics.areEqual(this.message, feeEngineerResponse.message) && Intrinsics.areEqual(this.fees, feeEngineerResponse.fees);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((((i + (z2 ? 1 : z2)) * 31) + this.message.hashCode()) * 31) + this.fees.hashCode();
    }

    public String toString() {
        return "FeeEngineerResponse(login=" + this.login + ", success=" + this.success + ", message=" + this.message + ", fees=" + this.fees + ")";
    }

    public FeeEngineerResponse(boolean z, boolean z2, String message, ArrayList<FeeEngineer> fees) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(fees, "fees");
        this.login = z;
        this.success = z2;
        this.message = message;
        this.fees = fees;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ArrayList<FeeEngineer> getFees() {
        return this.fees;
    }
}