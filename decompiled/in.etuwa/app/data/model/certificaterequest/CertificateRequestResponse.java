package in.etuwa.app.data.model.certificaterequest;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CertificateRequestResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CertificateRequestResponse {

    @SerializedName("history")
    @Expose
    private final ArrayList<CertificateRequest> certificateRequests;

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    public CertificateRequestResponse(boolean z, ArrayList<CertificateRequest> certificateRequests, String error) {
        Intrinsics.checkNotNullParameter(certificateRequests, "certificateRequests");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.certificateRequests = certificateRequests;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CertificateRequest> getCertificateRequests() {
        return this.certificateRequests;
    }

    public final String getError() {
        return this.error;
    }
}