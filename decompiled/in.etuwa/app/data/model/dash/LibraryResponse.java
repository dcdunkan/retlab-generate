package in.etuwa.app.data.model.dash;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LibraryResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class LibraryResponse {
    private final boolean login;
    private final String url;

    public static /* synthetic */ LibraryResponse copy$default(LibraryResponse libraryResponse, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = libraryResponse.login;
        }
        if ((i & 2) != 0) {
            str = libraryResponse.url;
        }
        return libraryResponse.copy(z, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final LibraryResponse copy(boolean login, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new LibraryResponse(login, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LibraryResponse)) {
            return false;
        }
        LibraryResponse libraryResponse = (LibraryResponse) other;
        return this.login == libraryResponse.login && Intrinsics.areEqual(this.url, libraryResponse.url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.url.hashCode();
    }

    public String toString() {
        return "LibraryResponse(login=" + this.login + ", url=" + this.url + ")";
    }

    public LibraryResponse(boolean z, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.login = z;
        this.url = url;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getUrl() {
        return this.url;
    }
}