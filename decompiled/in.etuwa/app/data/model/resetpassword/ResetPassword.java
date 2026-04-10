package in.etuwa.app.data.model.resetpassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResetPassword.kt */
/* loaded from: classes3.dex */
public final /* data */ class ResetPassword {

    @SerializedName("url")
    @Expose
    private final String url;

    public static /* synthetic */ ResetPassword copy$default(ResetPassword resetPassword, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resetPassword.url;
        }
        return resetPassword.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final ResetPassword copy(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new ResetPassword(url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ResetPassword) && Intrinsics.areEqual(this.url, ((ResetPassword) other).url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "ResetPassword(url=" + this.url + ")";
    }

    public ResetPassword(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }

    public final String getUrl() {
        return this.url;
    }
}