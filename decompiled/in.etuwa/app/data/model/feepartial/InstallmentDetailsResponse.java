package in.etuwa.app.data.model.feepartial;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InstallmentDetailsResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/data/model/feepartial/InstallmentDetailsResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "success", "installments", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/feepartial/InstallmentDetails;", "Lkotlin/collections/ArrayList;", "(ZZLjava/util/ArrayList;)V", "getInstallments", "()Ljava/util/ArrayList;", "getLogin", "()Z", "getSuccess", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InstallmentDetailsResponse {
    private final ArrayList<InstallmentDetails> installments;
    private final boolean login;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InstallmentDetailsResponse copy$default(InstallmentDetailsResponse installmentDetailsResponse, boolean z, boolean z2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = installmentDetailsResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = installmentDetailsResponse.success;
        }
        if ((i & 4) != 0) {
            arrayList = installmentDetailsResponse.installments;
        }
        return installmentDetailsResponse.copy(z, z2, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<InstallmentDetails> component3() {
        return this.installments;
    }

    public final InstallmentDetailsResponse copy(boolean login, boolean success, ArrayList<InstallmentDetails> installments) {
        Intrinsics.checkNotNullParameter(installments, "installments");
        return new InstallmentDetailsResponse(login, success, installments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstallmentDetailsResponse)) {
            return false;
        }
        InstallmentDetailsResponse installmentDetailsResponse = (InstallmentDetailsResponse) other;
        return this.login == installmentDetailsResponse.login && this.success == installmentDetailsResponse.success && Intrinsics.areEqual(this.installments, installmentDetailsResponse.installments);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.installments.hashCode();
    }

    public String toString() {
        return "InstallmentDetailsResponse(login=" + this.login + ", success=" + this.success + ", installments=" + this.installments + ")";
    }

    public InstallmentDetailsResponse(boolean z, boolean z2, ArrayList<InstallmentDetails> installments) {
        Intrinsics.checkNotNullParameter(installments, "installments");
        this.login = z;
        this.success = z2;
        this.installments = installments;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<InstallmentDetails> getInstallments() {
        return this.installments;
    }
}