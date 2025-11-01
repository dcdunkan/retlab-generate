package in.etuwa.app.data.model.login;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/data/model/login/LoginRequest;", "", "username", "", "password", "hostel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHostel", "()Ljava/lang/String;", "getPassword", "getUsername", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: component1, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    /* renamed from: component3, reason: from getter */
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
        int hashCode = ((this.username.hashCode() * 31) + this.password.hashCode()) * 31;
        String str = this.hostel;
        return hashCode + (str == null ? 0 : str.hashCode());
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