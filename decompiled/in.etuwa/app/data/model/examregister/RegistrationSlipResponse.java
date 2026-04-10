package in.etuwa.app.data.model.examregister;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RegistrationSlipResponse.kt */
/* loaded from: classes3.dex */
public final /* data */ class RegistrationSlipResponse {
    private final String file_url;
    private final boolean login;

    public static /* synthetic */ RegistrationSlipResponse copy$default(RegistrationSlipResponse registrationSlipResponse, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = registrationSlipResponse.login;
        }
        if ((i & 2) != 0) {
            str = registrationSlipResponse.file_url;
        }
        return registrationSlipResponse.copy(z, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFile_url() {
        return this.file_url;
    }

    public final RegistrationSlipResponse copy(boolean login, String file_url) {
        Intrinsics.checkNotNullParameter(file_url, "file_url");
        return new RegistrationSlipResponse(login, file_url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegistrationSlipResponse)) {
            return false;
        }
        RegistrationSlipResponse registrationSlipResponse = (RegistrationSlipResponse) other;
        return this.login == registrationSlipResponse.login && Intrinsics.areEqual(this.file_url, registrationSlipResponse.file_url);
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
        return (r0 * 31) + this.file_url.hashCode();
    }

    public String toString() {
        return "RegistrationSlipResponse(login=" + this.login + ", file_url=" + this.file_url + ")";
    }

    public RegistrationSlipResponse(boolean z, String file_url) {
        Intrinsics.checkNotNullParameter(file_url, "file_url");
        this.login = z;
        this.file_url = file_url;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getFile_url() {
        return this.file_url;
    }
}