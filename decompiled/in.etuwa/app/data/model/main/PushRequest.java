package in.etuwa.app.data.model.main;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushRequest.kt */
/* loaded from: classes3.dex */
public final /* data */ class PushRequest {
    private final String platform;
    private final String token;

    public static /* synthetic */ PushRequest copy$default(PushRequest pushRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pushRequest.token;
        }
        if ((i & 2) != 0) {
            str2 = pushRequest.platform;
        }
        return pushRequest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    public final PushRequest copy(String token, String platform) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(platform, "platform");
        return new PushRequest(token, platform);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PushRequest)) {
            return false;
        }
        PushRequest pushRequest = (PushRequest) other;
        return Intrinsics.areEqual(this.token, pushRequest.token) && Intrinsics.areEqual(this.platform, pushRequest.platform);
    }

    public int hashCode() {
        return (this.token.hashCode() * 31) + this.platform.hashCode();
    }

    public String toString() {
        return "PushRequest(token=" + this.token + ", platform=" + this.platform + ")";
    }

    public PushRequest(String token, String platform) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(platform, "platform");
        this.token = token;
        this.platform = platform;
    }

    public /* synthetic */ PushRequest(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "android" : str2);
    }

    public final String getToken() {
        return this.token;
    }

    public final String getPlatform() {
        return this.platform;
    }
}