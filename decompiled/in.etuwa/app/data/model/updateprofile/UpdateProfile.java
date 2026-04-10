package in.etuwa.app.data.model.updateprofile;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateProfile.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class UpdateProfile {
    private final boolean login;
    private final boolean success;
    private final String url;

    public static /* synthetic */ UpdateProfile copy$default(UpdateProfile updateProfile, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = updateProfile.login;
        }
        if ((i & 2) != 0) {
            z2 = updateProfile.success;
        }
        if ((i & 4) != 0) {
            str = updateProfile.url;
        }
        return updateProfile.copy(z, z2, str);
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
    public final String getUrl() {
        return this.url;
    }

    public final UpdateProfile copy(boolean login, boolean success, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new UpdateProfile(login, success, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateProfile)) {
            return false;
        }
        UpdateProfile updateProfile = (UpdateProfile) other;
        return this.login == updateProfile.login && this.success == updateProfile.success && Intrinsics.areEqual(this.url, updateProfile.url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        return ((i + (z2 ? 1 : z2)) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "UpdateProfile(login=" + this.login + ", success=" + this.success + ", url=" + this.url + ")";
    }

    public UpdateProfile(boolean z, boolean z2, String url) {
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