package in.etuwa.app.data.model.fee;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GatewayDetailsResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lin/etuwa/app/data/model/fee/GatewayDetailsResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "merchant", "", "address", "phone", "ipg", FirebaseAnalytics.Event.REFUND, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getIpg", "getLogin", "()Z", "getMerchant", "getPhone", "getRefund", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GatewayDetailsResponse {
    private final String address;
    private final String ipg;
    private final boolean login;
    private final String merchant;
    private final String phone;
    private final String refund;

    public static /* synthetic */ GatewayDetailsResponse copy$default(GatewayDetailsResponse gatewayDetailsResponse, boolean z, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = gatewayDetailsResponse.login;
        }
        if ((i & 2) != 0) {
            str = gatewayDetailsResponse.merchant;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = gatewayDetailsResponse.address;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = gatewayDetailsResponse.phone;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = gatewayDetailsResponse.ipg;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = gatewayDetailsResponse.refund;
        }
        return gatewayDetailsResponse.copy(z, str6, str7, str8, str9, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMerchant() {
        return this.merchant;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component5, reason: from getter */
    public final String getIpg() {
        return this.ipg;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRefund() {
        return this.refund;
    }

    public final GatewayDetailsResponse copy(boolean login, String merchant, String address, String phone, String ipg, String refund) {
        Intrinsics.checkNotNullParameter(merchant, "merchant");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(ipg, "ipg");
        Intrinsics.checkNotNullParameter(refund, "refund");
        return new GatewayDetailsResponse(login, merchant, address, phone, ipg, refund);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GatewayDetailsResponse)) {
            return false;
        }
        GatewayDetailsResponse gatewayDetailsResponse = (GatewayDetailsResponse) other;
        return this.login == gatewayDetailsResponse.login && Intrinsics.areEqual(this.merchant, gatewayDetailsResponse.merchant) && Intrinsics.areEqual(this.address, gatewayDetailsResponse.address) && Intrinsics.areEqual(this.phone, gatewayDetailsResponse.phone) && Intrinsics.areEqual(this.ipg, gatewayDetailsResponse.ipg) && Intrinsics.areEqual(this.refund, gatewayDetailsResponse.refund);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((r0 * 31) + this.merchant.hashCode()) * 31) + this.address.hashCode()) * 31) + this.phone.hashCode()) * 31) + this.ipg.hashCode()) * 31) + this.refund.hashCode();
    }

    public String toString() {
        return "GatewayDetailsResponse(login=" + this.login + ", merchant=" + this.merchant + ", address=" + this.address + ", phone=" + this.phone + ", ipg=" + this.ipg + ", refund=" + this.refund + ")";
    }

    public GatewayDetailsResponse(boolean z, String merchant, String address, String phone, String ipg, String refund) {
        Intrinsics.checkNotNullParameter(merchant, "merchant");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(ipg, "ipg");
        Intrinsics.checkNotNullParameter(refund, "refund");
        this.login = z;
        this.merchant = merchant;
        this.address = address;
        this.phone = phone;
        this.ipg = ipg;
        this.refund = refund;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getMerchant() {
        return this.merchant;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getIpg() {
        return this.ipg;
    }

    public final String getRefund() {
        return this.refund;
    }
}