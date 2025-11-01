package in.etuwa.app.data.model.certificaterequest;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CertificateRequestResponse.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/data/model/certificaterequest/CertificateRequestResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "certificateRequests", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/certificaterequest/CertificateRequest;", "Lkotlin/collections/ArrayList;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "(ZLjava/util/ArrayList;Ljava/lang/String;)V", "getCertificateRequests", "()Ljava/util/ArrayList;", "getError", "()Ljava/lang/String;", "getLogin", "()Z", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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