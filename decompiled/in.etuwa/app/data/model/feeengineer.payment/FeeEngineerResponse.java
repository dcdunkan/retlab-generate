package in.etuwa.app.data.model.feeengineer.payment;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeEngineerResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/data/model/feeengineer/payment/FeeEngineerResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "success", "message", "", "fees", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/feeengineer/payment/FeeEngineer;", "Lkotlin/collections/ArrayList;", "(ZZLjava/lang/String;Ljava/util/ArrayList;)V", "getFees", "()Ljava/util/ArrayList;", "getLogin", "()Z", "getMessage", "()Ljava/lang/String;", "getSuccess", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component3, reason: from getter */
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
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.message.hashCode()) * 31) + this.fees.hashCode();
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