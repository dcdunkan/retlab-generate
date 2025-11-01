package in.etuwa.app.data.model.certificaterequest;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CertificateTypeResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R&\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/data/model/certificaterequest/CertificateTypeResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "certificateType", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/certificaterequest/CertificateType;", "Lkotlin/collections/ArrayList;", "requestOpted", "Lin/etuwa/app/data/model/certificaterequest/CertificateType2;", "classSelected", "requestFor", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "(ZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;)V", "getCertificateType", "()Ljava/util/ArrayList;", "getClassSelected", "getError", "()Ljava/lang/String;", "getLogin", "()Z", "getRequestFor", "getRequestOpted", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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