package in.etuwa.app.data.model.main;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/data/model/main/PushRequest;", "", "token", "", "platform", "(Ljava/lang/String;Ljava/lang/String;)V", "getPlatform", "()Ljava/lang/String;", "getToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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