package in.etuwa.app.data.model.stationary;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdvancePaymentResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class AdvancePaymentResponse {
    private final boolean login;
    private final boolean success;
    private final String url;

    public static /* synthetic */ AdvancePaymentResponse copy$default(AdvancePaymentResponse advancePaymentResponse, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = advancePaymentResponse.login;
        }
        if ((i & 2) != 0) {
            z2 = advancePaymentResponse.success;
        }
        if ((i & 4) != 0) {
            str = advancePaymentResponse.url;
        }
        return advancePaymentResponse.copy(z, z2, str);
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
    public final String getUrl() {
        return this.url;
    }

    public final AdvancePaymentResponse copy(boolean login, boolean success, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new AdvancePaymentResponse(login, success, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdvancePaymentResponse)) {
            return false;
        }
        AdvancePaymentResponse advancePaymentResponse = (AdvancePaymentResponse) other;
        return this.login == advancePaymentResponse.login && this.success == advancePaymentResponse.success && Intrinsics.areEqual(this.url, advancePaymentResponse.url);
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
        return ((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "AdvancePaymentResponse(login=" + this.login + ", success=" + this.success + ", url=" + this.url + ")";
    }

    public AdvancePaymentResponse(boolean z, boolean z2, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.login = z;
        this.success = z2;
        this.url = url;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getUrl() {
        return this.url;
    }
}