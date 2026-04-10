package in.etuwa.app.data.model.certificaterequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CertificateType.kt */
/* loaded from: classes3.dex */
public final class CertificateType {

    @SerializedName("id")
    @Expose
    private final String id;

    @SerializedName("type")
    @Expose
    private final String type;

    public CertificateType(String id, String type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }
}