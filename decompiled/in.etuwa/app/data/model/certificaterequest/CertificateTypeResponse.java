package in.etuwa.app.data.model.certificaterequest;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CertificateTypeResponse.kt */
/* loaded from: classes3.dex */
public final class CertificateTypeResponse {

    @SerializedName("certificate_type")
    @Expose
    private final ArrayList<CertificateType> certificateType;

    @SerializedName("class_selected")
    @Expose
    private final ArrayList<CertificateType2> classSelected;

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("request_for")
    @Expose
    private final ArrayList<CertificateType2> requestFor;

    @SerializedName("request_opted")
    @Expose
    private final ArrayList<CertificateType2> requestOpted;

    public CertificateTypeResponse(boolean z, ArrayList<CertificateType> certificateType, ArrayList<CertificateType2> requestOpted, ArrayList<CertificateType2> classSelected, ArrayList<CertificateType2> requestFor, String error) {
        Intrinsics.checkNotNullParameter(certificateType, "certificateType");
        Intrinsics.checkNotNullParameter(requestOpted, "requestOpted");
        Intrinsics.checkNotNullParameter(classSelected, "classSelected");
        Intrinsics.checkNotNullParameter(requestFor, "requestFor");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.certificateType = certificateType;
        this.requestOpted = requestOpted;
        this.classSelected = classSelected;
        this.requestFor = requestFor;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CertificateType> getCertificateType() {
        return this.certificateType;
    }

    public final ArrayList<CertificateType2> getRequestOpted() {
        return this.requestOpted;
    }

    public final ArrayList<CertificateType2> getClassSelected() {
        return this.classSelected;
    }

    public final ArrayList<CertificateType2> getRequestFor() {
        return this.requestFor;
    }

    public final String getError() {
        return this.error;
    }
}