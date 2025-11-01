package in.etuwa.app.data.model.certificaterequest;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CertificateRequest.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/data/model/certificaterequest/CertificateRequest;", "", "certificateType", "", "dateOfApplication", NotificationCompat.CATEGORY_STATUS, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCertificateType", "()Ljava/lang/String;", "getDateOfApplication", "getStatus", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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