package in.etuwa.app.data.model.login;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class LoginRequest {
    private final String hostel;
    private final String password;
    private final String username;

    public static /* synthetic */ LoginRequest copy$default(LoginRequest loginRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginRequest.username;
        }
        if ((i & 2) != 0) {
            str2 = loginRequest.password;
        }
        if ((i & 4) != 0) {
            str3 = loginRequest.hostel;
        }
        return loginRequest.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getHostel() {
        return this.hostel;
    }

    public final LoginRequest copy(String username, String password, String hostel) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        return new LoginRequest(username, password, hostel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginRequest)) {
            return false;
        }
        LoginRequest loginRequest = (LoginRequest) other;
        return Intrinsics.areEqual(this.username, loginRequest.username) && Intrinsics.areEqual(this.password, loginRequest.password) && Intrinsics.areEqual(this.hostel, loginRequest.hostel);
    }

    public int hashCode() {
        int iHashCode = ((this.username.hashCode() * 31) + this.password.hashCode()) * 31;
        String str = this.hostel;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LoginRequest(username=" + this.username + ", password=" + this.password + ", hostel=" + this.hostel + ")";
    }

    public LoginRequest(String username, String password, String str) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        this.username = username;
        this.password = password;
        this.hostel = str;
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getHostel() {
        return this.hostel;
    }
}