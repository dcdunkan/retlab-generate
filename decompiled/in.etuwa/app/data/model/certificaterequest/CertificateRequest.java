package in.etuwa.app.data.model.certificaterequest;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CertificateRequest.kt */
/* loaded from: classes3.dex */
public final class CertificateRequest {

    @SerializedName("certificate_type")
    @Expose
    private final String certificateType;

    @SerializedName("date_of_application")
    @Expose
    private final String dateOfApplication;
    private final String status;

    public CertificateRequest(String certificateType, String dateOfApplication, String status) {
        Intrinsics.checkNotNullParameter(certificateType, "certificateType");
        Intrinsics.checkNotNullParameter(dateOfApplication, "dateOfApplication");
        Intrinsics.checkNotNullParameter(status, "status");
        this.certificateType = certificateType;
        this.dateOfApplication = dateOfApplication;
        this.status = status;
    }

    public final String getCertificateType() {
        return this.certificateType;
    }

    public final String getDateOfApplication() {
        return this.dateOfApplication;
    }

    public final String getStatus() {
        return this.status;
    }
}