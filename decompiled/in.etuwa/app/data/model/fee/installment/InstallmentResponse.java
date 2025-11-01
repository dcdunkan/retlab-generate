package in.etuwa.app.data.model.fee.installment;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InstallmentResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\nHÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\nHÖ\u0001R&\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/data/model/fee/installment/InstallmentResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "success", "installments", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/fee/installment/Installments;", "Lkotlin/collections/ArrayList;", "message", "", "(ZZLjava/util/ArrayList;Ljava/lang/String;)V", "getInstallments", "()Ljava/util/ArrayList;", "getLogin", "()Z", "getMessage", "()Ljava/lang/String;", "getSuccess", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InstallmentResponse {

    @SerializedName("installments")
    @Expose
    private final ArrayList<Installments> installments;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("message")
    @Expose
    private final String message;

    @SerializedName("success")
    @Expose
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InstallmentResponse copy$default(InstallmentResponse installmentResponse, boolean z, boolean z2, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = installmentResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = installmentResponse.success;
        }
        if ((i & 4) != 0) {
            arrayList = installmentResponse.installments;
        }
        if ((i & 8) != 0) {
            str = installmentResponse.message;
        }
        return installmentResponse.copy(z, z2, arrayList, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<Installments> component3() {
        return this.installments;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final InstallmentResponse copy(boolean login, boolean success, ArrayList<Installments> installments, String message) {
        Intrinsics.checkNotNullParameter(installments, "installments");
        Intrinsics.checkNotNullParameter(message, "message");
        return new InstallmentResponse(login, success, installments, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstallmentResponse)) {
            return false;
        }
        InstallmentResponse installmentResponse = (InstallmentResponse) other;
        return this.login == installmentResponse.login && this.success == installmentResponse.success && Intrinsics.areEqual(this.installments, installmentResponse.installments) && Intrinsics.areEqual(this.message, installmentResponse.message);
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
        return ((((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.installments.hashCode()) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "InstallmentResponse(login=" + this.login + ", success=" + this.success + ", installments=" + this.installments + ", message=" + this.message + ")";
    }

    public InstallmentResponse(boolean z, boolean z2, ArrayList<Installments> installments, String message) {
        Intrinsics.checkNotNullParameter(installments, "installments");
        Intrinsics.checkNotNullParameter(message, "message");
        this.login = z;
        this.success = z2;
        this.installments = installments;
        this.message = message;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<Installments> getInstallments() {
        return this.installments;
    }

    public final String getMessage() {
        return this.message;
    }
}