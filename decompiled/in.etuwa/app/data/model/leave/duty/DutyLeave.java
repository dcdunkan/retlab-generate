package in.etuwa.app.data.model.leave.duty;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.kernel.xmp.PdfConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DutyLeave.kt */
/* loaded from: classes3.dex */
public final /* data */ class DutyLeave {

    @SerializedName("btn_status")
    @Expose
    private final boolean btnStatus;
    private final String description;
    private final String id;

    @SerializedName("l_date")
    @Expose
    private final String lastDate;
    private final String name;

    @SerializedName("proof_status")
    @Expose
    private final boolean proofStatus;

    @SerializedName("proof_url")
    @Expose
    private final String proofUrl;
    private final String status;
    private final String type;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component6, reason: from getter */
    public final String getLastDate() {
        return this.lastDate;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getProofStatus() {
        return this.proofStatus;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getBtnStatus() {
        return this.btnStatus;
    }

    /* renamed from: component9, reason: from getter */
    public final String getProofUrl() {
        return this.proofUrl;
    }

    public final DutyLeave copy(String id, String name, String type, String description, String status, String lastDate, boolean proofStatus, boolean btnStatus, String proofUrl) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(lastDate, "lastDate");
        Intrinsics.checkNotNullParameter(proofUrl, "proofUrl");
        return new DutyLeave(id, name, type, description, status, lastDate, proofStatus, btnStatus, proofUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DutyLeave)) {
            return false;
        }
        DutyLeave dutyLeave = (DutyLeave) other;
        return Intrinsics.areEqual(this.id, dutyLeave.id) && Intrinsics.areEqual(this.name, dutyLeave.name) && Intrinsics.areEqual(this.type, dutyLeave.type) && Intrinsics.areEqual(this.description, dutyLeave.description) && Intrinsics.areEqual(this.status, dutyLeave.status) && Intrinsics.areEqual(this.lastDate, dutyLeave.lastDate) && this.proofStatus == dutyLeave.proofStatus && this.btnStatus == dutyLeave.btnStatus && Intrinsics.areEqual(this.proofUrl, dutyLeave.proofUrl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31) + this.description.hashCode()) * 31) + this.status.hashCode()) * 31) + this.lastDate.hashCode()) * 31;
        boolean z = this.proofStatus;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.btnStatus;
        return ((i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.proofUrl.hashCode();
    }

    public String toString() {
        return "DutyLeave(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", description=" + this.description + ", status=" + this.status + ", lastDate=" + this.lastDate + ", proofStatus=" + this.proofStatus + ", btnStatus=" + this.btnStatus + ", proofUrl=" + this.proofUrl + ")";
    }

    public DutyLeave(String id, String name, String type, String description, String status, String lastDate, boolean z, boolean z2, String proofUrl) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(lastDate, "lastDate");
        Intrinsics.checkNotNullParameter(proofUrl, "proofUrl");
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.status = status;
        this.lastDate = lastDate;
        this.proofStatus = z;
        this.btnStatus = z2;
        this.proofUrl = proofUrl;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getLastDate() {
        return this.lastDate;
    }

    public final boolean getProofStatus() {
        return this.proofStatus;
    }

    public final boolean getBtnStatus() {
        return this.btnStatus;
    }

    public final String getProofUrl() {
        return this.proofUrl;
    }
}