package in.etuwa.app.data.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogoutRequest.kt */
/* loaded from: classes3.dex */
public final /* data */ class LogoutRequest {

    @SerializedName("push_token")
    @Expose
    private final String token;

    public static /* synthetic */ LogoutRequest copy$default(LogoutRequest logoutRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = logoutRequest.token;
        }
        return logoutRequest.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final LogoutRequest copy(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return new LogoutRequest(token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LogoutRequest) && Intrinsics.areEqual(this.token, ((LogoutRequest) other).token);
    }

    public int hashCode() {
        return this.token.hashCode();
    }

    public String toString() {
        return "LogoutRequest(token=" + this.token + ")";
    }

    public LogoutRequest(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.token = token;
    }

    public final String getToken() {
        return this.token;
    }
}